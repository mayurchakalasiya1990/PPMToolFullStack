package com.org.PPMtool.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Backlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer PTSequence=0;
    private String projectIdentifier;

    // OneToOne with Project
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id",nullable = false)
    private Project project;
    //OneToMany projectTask
}
