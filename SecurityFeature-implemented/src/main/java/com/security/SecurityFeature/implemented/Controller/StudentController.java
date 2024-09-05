package com.security.SecurityFeature.implemented.Controller;

import com.security.SecurityFeature.implemented.Modal.Student;
import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
        new Student(1,"suraj",50),
            new Student(2,"dhiraj",70)
    ));

    @GetMapping("/students")
    public List<Student> getStudentList(){
        System.out.println("in student get mapping method");
        return students;
    }

    @PostMapping("/students")
    public Student setStudentData(@RequestBody Student student){
        students.add(student);
        return student;
    }
//    @GetMapping("/csrf-token")
//    public CsrfToken getCsrfToken(HttpServletRequest req){
//        return (CsrfToken) req.getAttribute("_csrf");
//    }
}
