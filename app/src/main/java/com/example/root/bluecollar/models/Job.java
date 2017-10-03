package com.example.root.bluecollar.models;

/**
 * Created by root on 9/27/17.
 */

public class Job {
    private String name;
    private String category;
    private String payment;
    private String duration;
    private boolean urgency;

    private String description;

    public Job(String name,String category,String payment,String duration,boolean urgency,String description){
        this.name=name;
        this.category=category;
        this.payment=payment;
        this.duration=duration;
        this.urgency=urgency;

        this.description=description;
    }
    public Job(){}

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPayment() {
        return payment;
    }

    public String getDuration() {
        return duration;
    }

    public boolean isUrgency() {
        return urgency;
    }



    public String getDescription() {
        return description ;
    }
}
