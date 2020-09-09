package com.example.demo;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Gift {
    private String id;
    private long cost;
    private String description;
    private String event;
    private String givenBy;
    private String receivedBy;
    
    
    @DynamoDbPartitionKey
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public long getCost() {
        return this.cost;
    }
    
    public void setCost(long cost) {
        this.cost = cost;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getEvent() {
        return this.event;
    }
    
    public void setEvent(String event) {
        this.event = event;
    }
    
    public String getGivenBy() {
        return this.givenBy;
    }
    
    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }
    
    public String getReceivedBy() {
        return this.receivedBy;
    }
    
    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }
    
}