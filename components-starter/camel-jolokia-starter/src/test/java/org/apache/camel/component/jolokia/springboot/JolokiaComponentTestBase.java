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
package org.apache.camel.component.jolokia.springboot;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.jolokia.server.core.config.ConfigKey;
import org.jolokia.support.spring.SpringJolokiaAgent;
import org.springframework.beans.factory.annotation.Autowired;

class JolokiaComponentTestBase {

	@Autowired(required = false)
	protected SpringJolokiaAgent agent;

	@BeforeEach
	void checkAgentIsAutoWired() {
		assertThat(agent).isNotNull();
	}

	protected void assertDiscoveryEnabled(boolean value) {
		Assertions.assertThat(agent).as("check Discovery feature configuration")
				.extracting("serviceManager")
				.extracting("configuration")
				.extracting("configMap")
				.asInstanceOf(InstanceOfAssertFactories.map(ConfigKey.class, String.class))
				.extractingByKey(ConfigKey.DISCOVERY_ENABLED)
				.isNotNull()
				.isEqualTo(String.valueOf(value));
	}
}
