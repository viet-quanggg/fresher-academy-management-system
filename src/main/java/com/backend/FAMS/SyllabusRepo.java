package com.backend.FAMS;

import com.backend.FAMS.entity.Syllabus.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusRepo extends JpaRepository<Syllabus, String> {
}
