package com.practice.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Store {
    private int id;

    private String category;

    private String name;

    private String latitude;

    private String longitude;

    private String address;

    private String elevator;

    private String toilet;

    private String parking;

    private String phoneNumber;

    private String heightDifferent;

    private String approach;
    

}

