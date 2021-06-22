package com.org.PPMtool.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private String projectSequence;
    @NotBlank(message = "Please include project Summary")
    private String summary;
    private String acceptanceCriteria;
    private String status;
    private Integer priority;
    private Date dueDate;

    //ManyToOne with backLog
    @Column(updatable = false)
    private String projectIdentifier;
    private Date create_At;
    private Date update_At;

    @PrePersist
    protected void onCreate(){
        this.create_At=new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.update_At=new Date();
    }
}
