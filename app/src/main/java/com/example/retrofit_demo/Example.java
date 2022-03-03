package com.example.retrofit_demo;

public class Example {
    private int id;
    private String title;
    private String status;
    private String overview;
    private int budget;

    public Example(int id, String title, String status, String overview, int budget) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.overview = overview;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
