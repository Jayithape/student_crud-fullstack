package com.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.text.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}

