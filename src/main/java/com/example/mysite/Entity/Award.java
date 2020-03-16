package com.example.mysite.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "award")
public class Award extends BasicEntity {

    @Column(name="organization")
    @NotEmpty
    public String organization;

    @Column(name="prize")
    @NotEmpty
    public String prize;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Award{" +
                "organization='" + organization + '\'' +
                ", prize='" + prize + '\'' +
                '}';
    }
}
