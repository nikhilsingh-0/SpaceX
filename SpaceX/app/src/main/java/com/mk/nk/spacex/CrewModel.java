package com.mk.nk.spacex;

public class CrewModel {

    String name, agency,image,status,id,wikipedia;
    String launches[]=new String[1];

    public CrewModel(String name, String agency, String image, String[] launches, String status, String id, String wikipedia) {
        this.name = name;
        this.agency = agency;
        this.image = image;
        this.launches = launches;
        this.status = status;
        this.id = id;
        this.wikipedia = wikipedia;
    }

    public String[] getLaunches() {
        return launches;
    }

    public void setLaunches(String[] launches) {
        this.launches = launches;
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
