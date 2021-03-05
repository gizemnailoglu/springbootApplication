package com.example.springproject.domainObject;

public class Role {


    private String role;
    public Role(String r)
    {
        this.role = r;
    }

    public void setState(String r)
    {
        this.role = r;
    }

    public String getState()
    {
        return this.role;
    }


}
