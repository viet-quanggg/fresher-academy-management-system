package com.backend.FAMS.entity.Syllabus;

import com.backend.FAMS.entity.LearningObjective.LearningObjective;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblSyllabusObjective")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SyllabusObjective {
    @EmbeddedId
    private SyllabusObjectiveId syllabusObjectiveId;

    // --- relationship----

    // n-1 to Syllabus
    @ManyToOne
    @MapsId("topicCode")
    @JoinColumn(name = "topic_code", insertable = false, updatable = false)
    private Syllabus syllabus;

    // n-1 to LearningObjective
    @ManyToOne
    @MapsId("objectiveCode")
    @JoinColumn(name = "objective_code", insertable = false, updatable = false)
    private LearningObjective learningObjective;
}