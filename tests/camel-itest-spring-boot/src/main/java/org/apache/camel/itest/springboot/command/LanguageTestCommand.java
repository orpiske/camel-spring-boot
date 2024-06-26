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
package org.apache.camel.itest.springboot.command;

import org.apache.camel.CamelContext;
import org.apache.camel.itest.springboot.Command;
import org.apache.camel.itest.springboot.ITestConfig;
import org.apache.camel.spi.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * A command that tries to lookup a camel language.
 */
@Component("language")
public class LanguageTestCommand extends AbstractTestCommand implements Command {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CamelContext context;

    @Override
    public Boolean executeTest(ITestConfig config, String language) throws Exception {

        logger.info("Getting Camel language: {}", language);

        Language lan = context.resolveLanguage(language);
        assertNotNull(lan, "Cannot get language with name: " + language);

        logger.info("Found Camel language: {} instance: {} with className: {}", language, lan, lan.getClass());
        return true;
    }

}
