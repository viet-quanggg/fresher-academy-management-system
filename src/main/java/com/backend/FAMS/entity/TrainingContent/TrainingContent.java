package com.backend.FAMS.entity.TrainingContent;

import com.backend.FAMS.entity.LearningObjective.LearningObjective;
import com.backend.FAMS.entity.TrainingUnit.TrainingUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblTrainingContent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingContent {
    @Id
    @Column(name = "training_content_id", nullable = false, unique = true)
    private Long trainingContentId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "note")
    private String note;

    // --- relationship----

    // n-1 to LearningObjective
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "learning_objective_code", nullable = false)
    private LearningObjective learningObjective;

    // n-1 to TrainingUnit
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_code",nullable = false)
    private TrainingUnit trainingUnit;

}
