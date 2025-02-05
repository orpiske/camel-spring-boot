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
package org.apache.camel.component.neo4j.springboot;

import org.apache.camel.component.neo4j.Neo4jComponent;
import org.apache.camel.component.neo4j.Neo4jConfiguration;
import org.apache.camel.component.neo4j.Neo4jSimilarityFunction;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.neo4j.driver.Driver;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Perform operations on the Neo4j Graph Database
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.neo4j")
public class Neo4jComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the neo4j component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * Node alias
     */
    private String alias;
    /**
     * The configuration;. The option is a
     * org.apache.camel.component.neo4j.Neo4jConfiguration type.
     */
    private Neo4jConfiguration configuration;
    /**
     * Url for connecting to Neo database
     */
    private String databaseUrl;
    /**
     * Detach a relationship - set true if want to delete a node and detach its
     * relationships to other nodes at same time
     */
    private Boolean detachRelationship = false;
    /**
     * Dimension of Vector Index
     */
    private Integer dimension;
    /**
     * Node Label
     */
    private String label;
    /**
     * Whether the producer should be started lazy (on the first message). By
     * starting lazy you can use this to allow CamelContext and routes to
     * startup in situations where a producer may otherwise fail during starting
     * and cause the route to fail being started. By deferring this startup to
     * be lazy then the startup failure can be handled during routing messages
     * via Camel's routing error handlers. Beware that when the first message is
     * processed then creating and starting the producer may take a little time
     * and prolong the total processing time of the processing.
     */
    private Boolean lazyStartProducer = false;
    /**
     * Maximum results for Vector Similarity search
     */
    private Integer maxResults = 3;
    /**
     * Minimum score for Vector Similarity search
     */
    private Double minScore;
    /**
     * Cypher Query
     */
    private String query;
    /**
     * Similarity Function of Vector Index
     */
    private Neo4jSimilarityFunction similarityFunction = Neo4jSimilarityFunction.cosine;
    /**
     * Vector Index Name
     */
    private String vectorIndexName;
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
     * Advanced - Driver. The option is a org.neo4j.driver.Driver type.
     */
    private Driver driver;
    /**
     * Kerberos Authentication encoded base64 ticket
     */
    private String kerberosAuthTicket;
    /**
     * Basic authentication database password
     */
    private String password;
    /**
     * Basic authentication database realm
     */
    private String realm;
    /**
     * Bearer authentication database realm
     */
    private String token;
    /**
     * Basic authentication database user
     */
    private String username;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Neo4jConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Neo4jConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public Boolean getDetachRelationship() {
        return detachRelationship;
    }

    public void setDetachRelationship(Boolean detachRelationship) {
        this.detachRelationship = detachRelationship;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public Double getMinScore() {
        return minScore;
    }

    public void setMinScore(Double minScore) {
        this.minScore = minScore;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Neo4jSimilarityFunction getSimilarityFunction() {
        return similarityFunction;
    }

    public void setSimilarityFunction(Neo4jSimilarityFunction similarityFunction) {
        this.similarityFunction = similarityFunction;
    }

    public String getVectorIndexName() {
        return vectorIndexName;
    }

    public void setVectorIndexName(String vectorIndexName) {
        this.vectorIndexName = vectorIndexName;
    }

    public Boolean getAutowiredEnabled() {
        return autowiredEnabled;
    }

    public void setAutowiredEnabled(Boolean autowiredEnabled) {
        this.autowiredEnabled = autowiredEnabled;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getKerberosAuthTicket() {
        return kerberosAuthTicket;
    }

    public void setKerberosAuthTicket(String kerberosAuthTicket) {
        this.kerberosAuthTicket = kerberosAuthTicket;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}