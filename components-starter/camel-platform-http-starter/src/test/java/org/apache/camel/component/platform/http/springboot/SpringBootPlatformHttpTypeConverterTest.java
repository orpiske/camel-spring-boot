package org.apache.camel.component.platform.http.springboot;

import io.restassured.RestAssured;
import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@EnableAutoConfiguration(exclude = {OAuth2ClientAutoConfiguration.class, SecurityAutoConfiguration.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@CamelSpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { CamelAutoConfiguration.class,
        SpringBootPlatformHttpTypeConverterTest.class, SpringBootPlatformHttpTypeConverterTest.TestConfiguration.class,
        PlatformHttpComponentAutoConfiguration.class, SpringBootPlatformHttpAutoConfiguration.class, })
public class SpringBootPlatformHttpTypeConverterTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    CamelContext camelContext;

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Configuration
    public static class TestConfiguration {

        @Bean
        public RouteBuilder springBootPlatformHttpRestDSLRouteBuilder() {
            return new RouteBuilder() {
                @Override
                public void configure() {
                    getContext().getTypeConverterRegistry().addTypeConverter(InputStream.class,
                            Map.class,
                            new InputStreamTypeConverter());

                    from("platform-http:/inputstream")
                            .routeId("inputstream")
                            .setBody().constant(Collections.singletonMap("is", "my-test"));
                }
            };
        }
    }

    @Test
    public void customTypeConverter() {
        given()
                .when()
                .get("/inputstream")
                .then()
                .statusCode(200)
                .body(equalTo("InputStream:my-test"));
    }

    static class InputStreamTypeConverter implements TypeConverter {
        @Override
        public boolean allowNull() {
            return false;
        }

        @Override
        public <T> T convertTo(Class<T> type, Object value) throws TypeConversionException {
            return null;
        }

        @Override
        public <T> T convertTo(Class<T> type, Exchange exchange, Object value) throws TypeConversionException {
            byte[] out = ("InputStream:" + ((Map) value).get("is")).getBytes(StandardCharsets.UTF_8);
            return type.cast(new ByteArrayInputStream(out));
        }

        @Override
        public <T> T mandatoryConvertTo(Class<T> type, Object value) throws TypeConversionException, NoTypeConversionAvailableException {
            return null;
        }

        @Override
        public <T> T mandatoryConvertTo(Class<T> type, Exchange exchange, Object value) throws TypeConversionException, NoTypeConversionAvailableException {
            return null;
        }

        @Override
        public <T> T tryConvertTo(Class<T> type, Object value) {
            return null;
        }

        @Override
        public <T> T tryConvertTo(Class<T> type, Exchange exchange, Object value) {
            return null;
        }
    }
}