package com.backend.FAMS.entity.Syllabus;

import com.backend.FAMS.entity.LearningObjective.LearningObjective;
import com.backend.FAMS.entity.TrainingProgram.TrainingProgramSyllabus;
import com.backend.FAMS.entity.TrainingUnit.TrainingUnit;
import com.backend.FAMS.entity.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tblSyllabus")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Syllabus implements Serializable {
    @Id
    @Column(name = "topic_code", nullable = false, unique = true)
    private String topicCode;

    @Column(name = "topic_name", nullable = false, unique = true)
    private String topicName;

    @Column(name = "technical_group", nullable = false)
    private String technicalGroup;

    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "training_audience", nullable = false)
    private String trainingAudience;

    @Column(name = "topic_outline", nullable = false)
    private String topicOutline;

    @Column(name = "training_material", nullable = false)
    private String trainingMaterial;

    @Column(name = "training_principal", nullable = false)
    private String trainingPrincipal;

    @Column(name = "priority", nullable = false)
    private String priority;

    @Column(name = "public_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private SyllabusStatus syllabusStatus;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "modified_by", nullable = true)
    private String modifiedBy;

    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    // --- relationship----

    // tao quan he 1-n to SyllabusObjective
    @OneToMany(mappedBy = "syllabus")
//    @JsonManagedReference
    @JsonIgnore
    private Set<SyllabusObjective> syllabusObjectives;

    // 1-n to TrainingUnit
    @OneToMany(mappedBy = "syllabus")
//    @JsonManagedReference
    @JsonIgnore
    private Set<TrainingUnit> trainingUnits;

    //  1-n to TrainingProgramSyllabus
    @OneToMany(mappedBy = "syllabus")
//    @JsonManagedReference
    @JsonIgnore
    private Set<TrainingProgramSyllabus> trainingProgramSyllabusSet;

    // n-1 to User
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "userId", insertable = false, updatable = false)
//    @JsonBackReference
    @JsonIgnore
    private User user;




}
