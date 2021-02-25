package com.springcourse.springcourse.model;

public class UploadedFileModel {

    private String name;
    private String location;

    public UploadedFileModel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
