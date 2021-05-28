package com.example.poststatus.model;

public class Status {
    private  int statusId;
    private int avartar;
    private String name;
    private int post;
    private  int noOfComments;

    public Status(int statusId, int avartar, String name, int post, int noOfComments) {
        this.statusId = statusId;
        this.avartar = avartar;
        this.name = name;
        this.post = post;
        this.noOfComments = noOfComments;
    }

    public Status(int statusId, int avartar, String name) {
        this.statusId = statusId;
        this.avartar = avartar;
        this.name = name;
    }

    public Status() { }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getAvartar() {
        return avartar;
    }

    public void setAvartar(int avartar) {
        this.avartar = avartar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public int getNoOfComments() {
        return noOfComments;
    }

    public void setNoOfComments(int noOfComments) {
        this.noOfComments = noOfComments;
    }
}
