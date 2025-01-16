package net.student_management.Student_Management_System.repository;

import net.student_management.Student_Management_System.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
