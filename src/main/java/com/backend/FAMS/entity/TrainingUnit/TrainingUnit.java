package com.backend.FAMS.entity.TrainingUnit;

import com.backend.FAMS.entity.Syllabus.Syllabus;
import com.backend.FAMS.entity.TrainingContent.TrainingContent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tblTrainingUnit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingUnit {
    @Id
    @Column(name = "unit_code", nullable = false, unique = true)
    private String unitCode;

    @Column(name = "unit_name", nullable = false)
    private String unitName;

    @Column(name = "day_number")
    private int dayNumber;

    // --- relationship----

    // n-1 to Syllabus
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_code", nullable = false)
    private Syllabus syllabus;

    // 1-n to TrainingContent
    @OneToMany(mappedBy = "trainingUnit")
    private Set<TrainingContent> trainingContents;


}
