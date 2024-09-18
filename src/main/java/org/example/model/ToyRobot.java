package org.example.model;

import java.time.LocalDate;

public class ToyRobot {

    private String name;

    private LocalDate birthDate;

    private int powerLevel;

    public ToyRobot( String name, LocalDate birthDate, int powerLevel ){
        this.name = name;
        this.birthDate = birthDate;
        this.powerLevel = powerLevel;
    }

    public String getName(){
        return name;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public int getPowerLevel(){
        return powerLevel;
    }
}
