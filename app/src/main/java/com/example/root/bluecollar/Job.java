package com.example.root.bluecollar;

/**
 * Created by root on 9/27/17.
 */

public class Job {
    private String name;
    private String category;
    private int payment;
    private String duration;
    private boolean urgency;
    private int labour;
    private String requirements;

    public Job(String name,String category,int payment,String duration,boolean urgency,int labour,String requirements){
        this.name=name;
        this.category=category;
        this.payment=payment;
        this.duration=duration;
        this.urgency=urgency;
        this.labour=labour;
        this.requirements=requirements;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPayment() {
        return payment;
    }

    public String getDuration() {
        return duration;
    }

    public boolean isUrgency() {
        return urgency;
    }

    public int getLabour() {
        return labour;
    }

    public String getRequirements() {
        return requirements;
    }
}
