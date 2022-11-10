package com.stage.freeclub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="activities")
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ActivityType type;
    private String place;
    private int cost;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_begin")
    private Date date_begin;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_end")
    private Date date_end;
    @Column(name="rating", columnDefinition = "0")
            private int rating;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activities_id",  nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
    //private byte[] picture;


}
