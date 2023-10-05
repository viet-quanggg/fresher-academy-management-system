package com.backend.FAMS.entity.TrainingProgram;

import com.backend.FAMS.entity.Syllabus.Syllabus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblTrainingProgramSyllabus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgramSyllabus {
    @EmbeddedId
    private TrainingProgramSyllabusId trainingProgramSyllabusId;

    @Column(name = "sequence")
    private int sequence;

    // --- relationship----

    // n-1 to TrainingProgram
    @ManyToOne
    @MapsId("trainingProgramCode")
    @JoinColumn(name = "training_program_code", insertable = false, updatable = false)
    private TrainingProgram trainingProgram;

    // n-1 to Syllabus
    @ManyToOne
    @MapsId("topicCode")
    @JoinColumn(name = "topic_code", insertable = false, updatable = false)
    private Syllabus syllabus;



}
