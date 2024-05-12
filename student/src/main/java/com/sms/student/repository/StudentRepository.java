package com.sms.student.repository;

import com.sms.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository <Student, Long>{

    @Query("SELECT u FROM Student u WHERE u.name = ?1")
    Student findStudentByName(String name);
}
