package com.example.root.bluecollar.models;

import org.parceler.Parcel;


@Parcel
public class Job {
    private String name;
    private String category;
    private String payment;
    private String duration;
    private boolean urgency;
    private String contact;

    private String description;

    public Job(String name,String category,String payment,String duration,boolean urgency,String description,String contact){
        this.name=name;
        this.category=category;
        this.payment=payment;
        this.duration=duration;
        this.urgency=urgency;

        this.description=description;
        this.contact=contact;
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
    public String getContact(){
        return contact;
    }
}
