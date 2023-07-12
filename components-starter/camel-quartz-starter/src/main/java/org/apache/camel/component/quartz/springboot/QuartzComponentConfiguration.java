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
package org.apache.camel.component.quartz.springboot;

import java.util.Map;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Schedule sending of messages using the Quartz 2.x scheduler.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.quartz")
public class QuartzComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the quartz component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * Allows for bridging the consumer to the Camel routing Error Handler,
     * which mean any exceptions occurred while the consumer is trying to pickup
     * incoming messages, or the likes, will now be processed as a message and
     * handled by the routing Error Handler. By default the consumer will use
     * the org.apache.camel.spi.ExceptionHandler to deal with exceptions, that
     * will be logged at WARN or ERROR level and ignored.
     */
    private Boolean bridgeErrorHandler = false;
    /**
     * Whether to enable Quartz JMX which allows to manage the Quartz scheduler
     * from JMX. This options is default true
     */
    private Boolean enableJmx = true;
    /**
     * Whether to prefix the Quartz Scheduler instance name with the
     * CamelContext name. This is enabled by default, to let each CamelContext
     * use its own Quartz scheduler instance by default. You can set this option
     * to false to reuse Quartz scheduler instances between multiple
     * CamelContext's.
     */
    private Boolean prefixInstanceName = true;
    /**
     * Whether to prefix the quartz job with the endpoint id. This option is
     * default false.
     */
    private Boolean prefixJobNameWithEndpointId = false;
    /**
     * Properties to configure the Quartz scheduler.
     */
    private Map properties;
    /**
     * File name of the properties to load from the classpath
     */
    private String propertiesFile;
    /**
     * References to an existing Properties or Map to lookup in the registry to
     * use for configuring quartz.
     */
    private String propertiesRef;
    /**
     * Whether autowiring is enabled. This is used for automatic autowiring
     * options (the option must be marked as autowired) by looking up in the
     * registry to find if there is a single instance of matching type, which
     * then gets configured on the component. This can be used for automatic
     * configuring JDBC data sources, JMS connection factories, AWS Clients,
     * etc.
     */
    private Boolean autowiredEnabled = true;
    /**
     * To use the custom configured Quartz scheduler, instead of creating a new
     * Scheduler. The option is a org.quartz.Scheduler type.
     */
    private Scheduler scheduler;
    /**
     * To use the custom SchedulerFactory which is used to create the Scheduler.
     * The option is a org.quartz.SchedulerFactory type.
     */
    private SchedulerFactory schedulerFactory;
    /**
     * Whether the scheduler should be auto started. This option is default true
     */
    private Boolean autoStartScheduler = true;
    /**
     * Whether to interrupt jobs on shutdown which forces the scheduler to
     * shutdown quicker and attempt to interrupt any running jobs. If this is
     * enabled then any running jobs can fail due to being interrupted. When a
     * job is interrupted then Camel will mark the exchange to stop continue
     * routing and set java.util.concurrent.RejectedExecutionException as caused
     * exception. Therefore use this with care, as its often better to allow
     * Camel jobs to complete and shutdown gracefully.
     */
    private Boolean interruptJobsOnShutdown = false;

    public Boolean getBridgeErrorHandler() {
        return bridgeErrorHandler;
    }

    public void setBridgeErrorHandler(Boolean bridgeErrorHandler) {
        this.bridgeErrorHandler = bridgeErrorHandler;
    }

    public Boolean getEnableJmx() {
        return enableJmx;
    }

    public void setEnableJmx(Boolean enableJmx) {
        this.enableJmx = enableJmx;
    }

    public Boolean getPrefixInstanceName() {
        return prefixInstanceName;
    }

    public void setPrefixInstanceName(Boolean prefixInstanceName) {
        this.prefixInstanceName = prefixInstanceName;
    }

    public Boolean getPrefixJobNameWithEndpointId() {
        return prefixJobNameWithEndpointId;
    }

    public void setPrefixJobNameWithEndpointId(
            Boolean prefixJobNameWithEndpointId) {
        this.prefixJobNameWithEndpointId = prefixJobNameWithEndpointId;
    }

    public Map getProperties() {
        return properties;
    }

    public void setProperties(Map properties) {
        this.properties = properties;
    }

    public String getPropertiesFile() {
        return propertiesFile;
    }

    public void setPropertiesFile(String propertiesFile) {
        this.propertiesFile = propertiesFile;
    }

    public String getPropertiesRef() {
        return propertiesRef;
    }

    public void setPropertiesRef(String propertiesRef) {
        this.propertiesRef = propertiesRef;
    }

    public Boolean getAutowiredEnabled() {
        return autowiredEnabled;
    }

    public void setAutowiredEnabled(Boolean autowiredEnabled) {
        this.autowiredEnabled = autowiredEnabled;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public SchedulerFactory getSchedulerFactory() {
        return schedulerFactory;
    }

    public void setSchedulerFactory(SchedulerFactory schedulerFactory) {
        this.schedulerFactory = schedulerFactory;
    }

    public Boolean getAutoStartScheduler() {
        return autoStartScheduler;
    }

    public void setAutoStartScheduler(Boolean autoStartScheduler) {
        this.autoStartScheduler = autoStartScheduler;
    }

    public Boolean getInterruptJobsOnShutdown() {
        return interruptJobsOnShutdown;
    }

    public void setInterruptJobsOnShutdown(Boolean interruptJobsOnShutdown) {
        this.interruptJobsOnShutdown = interruptJobsOnShutdown;
    }
}