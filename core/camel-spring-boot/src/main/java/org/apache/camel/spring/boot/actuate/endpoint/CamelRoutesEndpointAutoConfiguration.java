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
package org.apache.camel.spring.boot.actuate.endpoint;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Auto configuration for the {@link CamelRoutesEndpoint}.
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({ CamelRoutesEndpointProperties.class })
@ConditionalOnAvailableEndpoint(endpoint = CamelRoutesEndpoint.class)
@ConditionalOnBean(CamelAutoConfiguration.class)
@AutoConfigureAfter(CamelAutoConfiguration.class)
public class CamelRoutesEndpointAutoConfiguration {

    @Bean
    @ConditionalOnClass(CamelContext.class)
    @ConditionalOnMissingBean
    public CamelRoutesEndpoint camelEndpoint(CamelContext camelContext, CamelRoutesEndpointProperties properties) {
        return new CamelRoutesEndpoint(camelContext, properties);
    }

}
