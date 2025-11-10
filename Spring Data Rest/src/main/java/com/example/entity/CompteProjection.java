package com.example.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "clientDetails", types = Client.class)
public interface CompteProjection {
    public String getNom();
    public String getEmail();
}
