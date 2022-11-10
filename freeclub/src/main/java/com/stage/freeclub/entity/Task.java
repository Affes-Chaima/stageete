package com.stage.freeclub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="Tasks")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_start")
    private Date start;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_end")
    private Date end;
private String assignedTo;
    private Long userId;
    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean status;


   @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activities_id",  nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Activity activity;

}
