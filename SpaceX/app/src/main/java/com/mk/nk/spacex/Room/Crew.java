package com.mk.nk.spacex.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Crew {

    @PrimaryKey (autoGenerate = true)
    int crewId;
    String name;
    String agency;
    String status;
    String wikipedia;
    String image;

    public Crew(String name, String agency, String status, String wikipedia, String image) {
        this.name = name;
        this.agency = agency;
        this.status = status;
        this.wikipedia = wikipedia;
        this.image = image;
    }


    public int getCrewId() {
        return crewId;
    }

    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
