package com.example.mysite.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name="CONTENT")
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="category")
    @NotEmpty
    private String category;

    @Column(name="title")
    @NotEmpty
    private String title;

    @Column(name="description")
    @NotEmpty
    private String description;

    @Column(name="picurl")
    private String picurl;
    @Column(name="create_date")
    private Date create_date;
    @Transient
    private SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicurl() {
        return picurl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    @Override
    public String toString() {
        return "BasicEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Date getCreate_date() {
        return create_date;
    }
    public String getCreatedAsShort(){
        return format.format(create_date);
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }


}
