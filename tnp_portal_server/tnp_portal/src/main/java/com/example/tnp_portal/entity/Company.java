package com.example.tnp_portal.entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


@Document(collection = "company")
public class Company implements Serializable {

    @Id
    @Field("_id")
    private ObjectId id;

    private String name;
    private String email;
    private String url;
    private String address;

    public Company() {
    }

    public Company(String name, String email, String url, String address) {
        this.name = name;
        this.email = email;
        this.url = url;
        this.address = address;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
