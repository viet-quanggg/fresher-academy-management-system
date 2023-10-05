package com.backend.FAMS.entity.TrainingUnit;

import com.backend.FAMS.entity.Syllabus.Syllabus;
import com.backend.FAMS.entity.TrainingContent.TrainingContent;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tblTrainingUnit")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingUnit implements Serializable {
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
//    @JsonBackReference
    @JsonIgnore
    private Syllabus syllabus;

    // 1-n to TrainingContent
    @OneToMany(mappedBy = "trainingUnit")
//    @JsonManagedReference
    @JsonIgnore
    private Set<TrainingContent> trainingContents;


}
