package com.example.mysite.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name="CONTENT")
@Getter
@Setter
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
    private Timestamp create_date;
    @Transient
    private SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");

    public Content(String category,String title,String description) {
        this.category=category;
        this.title=title;
        this.description=description;
        this.create_date=Timestamp.valueOf(LocalDateTime.now());
        this.picurl="sample.png";
    }

    public Content() {
    }

    @Override
    public String toString() {
        return "BasicEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
