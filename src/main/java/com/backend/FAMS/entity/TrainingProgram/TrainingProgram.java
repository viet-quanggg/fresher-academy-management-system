package com.backend.FAMS.entity.TrainingProgram;

import com.backend.FAMS.entity.Class.Class;
import com.backend.FAMS.entity.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tblTrainingProgram")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgram {
    @Id
    @Column(name = "training_program_code", nullable = false, unique = true)
    private String trainingProgramCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TrainingProgramStatus status;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "modified_by", nullable = true)
    private String modifiedBy;

    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    // --- relationship----

    // n-1 to User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 1-n to Class
    @OneToMany(mappedBy = "trainingProgram")
    private Set<Class> classes;
}
