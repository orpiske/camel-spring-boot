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
package org.apache.camel.component.fury.springboot;

import org.apache.camel.spring.boot.DataFormatConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Serialize and deserialize messages using Apache Fury
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.dataformat.fury")
public class FuryDataFormatConfiguration
        extends
            DataFormatConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the fury data format. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * Class of the java type to use when unmarshalling
     */
    private String unmarshalType;
    /**
     * Whether to require register classes
     */
    private Boolean requireClassRegistration = true;
    /**
     * Whether to use the threadsafe fury
     */
    private Boolean threadSafe = true;
    /**
     * Whether to auto-discover Fury from the registry
     */
    private Boolean allowAutoWiredFury = true;

    public String getUnmarshalType() {
        return unmarshalType;
    }

    public void setUnmarshalType(String unmarshalType) {
        this.unmarshalType = unmarshalType;
    }

    public Boolean getRequireClassRegistration() {
        return requireClassRegistration;
    }

    public void setRequireClassRegistration(Boolean requireClassRegistration) {
        this.requireClassRegistration = requireClassRegistration;
    }

    public Boolean getThreadSafe() {
        return threadSafe;
    }

    public void setThreadSafe(Boolean threadSafe) {
        this.threadSafe = threadSafe;
    }

    public Boolean getAllowAutoWiredFury() {
        return allowAutoWiredFury;
    }

    public void setAllowAutoWiredFury(Boolean allowAutoWiredFury) {
        this.allowAutoWiredFury = allowAutoWiredFury;
    }
}