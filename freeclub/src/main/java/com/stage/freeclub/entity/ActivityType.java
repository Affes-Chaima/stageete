package com.stage.freeclub.entity;

import lombok.Data;

import javax.persistence.Entity;


public enum ActivityType {
    leisureandsport ("leisureandsport"),
    culture ("culture"),
    social ("social"),
    scientific ("scientific");

    private final String name;

    ActivityType(String name){
        this.name=name;
    }
}
