package net.student_management.Student_Management_System.controller;


import net.student_management.Student_Management_System.entity.Student;
import net.student_management.Student_Management_System.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    //get all students
    @Autowired
    StudentRepository repo;


    //get all data
    //localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudent()
    {
      List<Student>students=  repo.findAll();
        return students;
    }


      //show a particular student data
    //localhost:8080/1
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student=repo.findById((long) id).get();
        return  student;
    }

        //add new students
      //http://localhost:8080/students/add
       @PostMapping("/students/add")
       @ResponseStatus(code= HttpStatus.CREATED)
      public void createStudent(@RequestBody Student student){

        repo.save(student);
    }
     //http://localhost:8080/students/update/2
    //update student data
    @PutMapping("students/update/{id}")
    public Student updateStudents(@PathVariable int id){
        Student student=repo.findById((long) id).get();
      student.setName("satish");
      student.setAge(22);
      repo.save(student);
      return student;

    }
      //http://localhost:8080/students/delete/2
       //delete student record
   @DeleteMapping("students/delete/{id}")
    public void removeStudent(@PathVariable int id){
       Student student=repo.findById((long) id).get();
       repo.delete(student);
   }

}
