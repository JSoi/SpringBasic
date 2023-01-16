package com.practice.demo.reflection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Goat extends Animal implements Locomotion {
    public String privateName;
    public Goat(String name){
        this.privateName = name;
    }
    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }
    public String getPrivateName(){
        return this.privateName;
    }
    @Override
    protected String getSound() {
        return "bleat";
    }
    
    @Override
    public String eats() {
        return "grass";
    }
    
    @Override
    public String getLocomotion() {
        return "walks";
    }
}
