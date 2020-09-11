package com.example.demo;

import org.springframework.stereotype.Service;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class GiftsService {
    
    private Region region = Region.US_WEST_2;
    private DynamoDbClient ddb = DynamoDbClient.builder().region(region).build();
    private DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder().dynamoDbClient(ddb).build();
    

    public ArrayList<Gift> getAllGifts() {
        
        ArrayList<Gift> giftsList = new ArrayList<>();
        
        try {
            DynamoDbTable<Gift> giftTable = enhancedClient.table("gifts", TableSchema.fromBean(Gift.class));
            Iterator<Gift> results = giftTable.scan().items().iterator();
            
            while (results.hasNext()) {
                giftsList.add(results.next());
            }
            
        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);            
        }
        
        return giftsList;
    }
}