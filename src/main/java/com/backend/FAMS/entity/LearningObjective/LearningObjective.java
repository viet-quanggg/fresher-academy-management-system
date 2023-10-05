package com.backend.FAMS.entity.LearningObjective;

import com.backend.FAMS.entity.Syllabus.SyllabusObjective;
import com.backend.FAMS.entity.TrainingContent.TrainingContent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tblLearningObjective")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LearningObjective {
    @Id
    @Column(name = "code", nullable = false, unique = true)
    private String objectiveCode;

    @Column(name = "name", nullable = false)
    private String objectiveName;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    // --- relationship----

    // 1-n to SyllabusObjective
    @OneToMany(mappedBy = "learningObjective")
    private Set<SyllabusObjective> syllabusObjectives;

    // 1-n to TrainingContent
    @OneToMany(mappedBy = "learningObjective")
    private Set<TrainingContent> trainingContent;
}
