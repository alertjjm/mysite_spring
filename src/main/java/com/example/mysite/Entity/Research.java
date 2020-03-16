package com.example.mysite.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="research")
public class Research extends BasicEntity{
    @Column(name="startdate")
    private String startdate;
    @Column(name="enddate")
    private String enddate;
    @Column(name="organization")
    @NotEmpty
    private String organizaiton;

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getOrganizaiton() {
        return organizaiton;
    }

    public void setOrganizaiton(String organizaiton) {
        this.organizaiton = organizaiton;
    }

}
