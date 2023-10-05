package com.backend.FAMS.entity.Class;

import com.backend.FAMS.entity.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tblClassUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassUser {
    @EmbeddedId
    private ClassUserId classUserId;


    @Column(name = "user_type", nullable = false)
    private String userType;

    // --- relationship----

    // n-1 to Class
    @ManyToOne
    @MapsId("classId")
    @JoinColumn(name = "class_id", insertable = false, updatable = false)
    private Class aClass;

    // n-1 to User
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

}
