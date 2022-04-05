/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.kamelet.springboot;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.junit.jupiter.api.Test;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;


@DirtiesContext
@CamelSpringBootTest
@SpringBootTest(
    classes = {
        CamelAutoConfiguration.class,
        KameletEipAggregateGroovyTest.class,
    }
)

public class KameletEipAggregateGroovyTest {

    @Autowired
    ProducerTemplate template;

    @EndpointInject("mock:result")
    MockEndpoint mock;

    @Test
    public void testAggregate() throws Exception {
        mock.expectedBodiesReceived("A,B,C,D,E");

        template.sendBody("direct:start", "A");
        template.sendBody("direct:start", "B");
        template.sendBody("direct:start", "C");
        template.sendBody("direct:start", "D");
        template.sendBody("direct:start", "E");

        mock.assertIsSatisfied();
    }

    // **********************************************
    //
    // test set-up
    //
    // **********************************************

    @Bean
    protected RoutesBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                routeTemplate("my-aggregate")
                        .templateBean("myAgg", "groovy",
                                // for aggregation we need a class that has the method with how to aggregate the messages
                                // the logic can of course be much more than just to append with comma
                                "class MyAgg { String agg(b1, b2) { b1 + ',' + b2 } }; new MyAgg()")
                        // the groovy is evaluated as a script so must return an instance of the class
                        .templateParameter("count")
                        .from("kamelet:source")
                        .aggregate(constant(true))
                            .completionSize("{{count}}")
                            // use the groovy script bean for aggregation
                            .aggregationStrategy("{{myAgg}}")
                            .to("log:aggregate")
                            .to("kamelet:sink")
                        .end();

                from("direct:start")
                        .kamelet("my-aggregate?count=5")
                        .to("log:info")
                        .to("mock:result");
            }
        };
    }
}