package com.backend.FAMS.entity.Class;

import com.backend.FAMS.entity.TrainingProgram.TrainingProgram;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tblClass")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", nullable = false, unique = true)
    private Long classId;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "class_code", nullable = false)
    private String classCode;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClassStatus status;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "fsu", nullable = false)
    private int fsu;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "modified_by", nullable = true)
    private String modifiedBy;

    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    // --- relationship----

    // n -1 to TrainingProgram
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_program_code", nullable = false)
    private TrainingProgram trainingProgram;

    // 1-n to ClassUser
    @OneToMany(mappedBy = "aClass")
    private Set<ClassUser> classUsers;
}
