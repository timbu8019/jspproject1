package com.insurance.register;

public class Underwriter {
    private int underwriterId;
    private String underwriterPassword;
    private String name;
    private String dob;
    private String doj;

    public Underwriter() {
        // Default constructor
    }

    public int getUnderwriterId() {
        return underwriterId;
    }

    public void setUnderwriterId(int underwriterId) {
        this.underwriterId = underwriterId;
    }

    public String getUnderwriterPassword() {
        return underwriterPassword;
    }

    public void setUnderwriterPassword(String underwriterPassword) {
        this.underwriterPassword = underwriterPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }
}
