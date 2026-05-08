/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rfidabsensiperpus.Objects;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author acer
 */
public class MongoManager {
    private static MongoClient mongoClient;
    private static final String Database_Name = "absensi_perpus";
    
    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );
            
            mongoClient = MongoClients.create("mongodb://localhost:27017");
            return mongoClient.getDatabase(Database_Name).withCodecRegistry(pojoCodecRegistry);
        }
        return mongoClient.getDatabase(Database_Name);
    }
    
}
