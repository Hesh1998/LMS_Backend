package com.example.LMS.controller;

import com.example.LMS.model.Course;
import com.example.LMS.model.Student;
import com.example.LMS.repository.CourseRegistrationRepository;
import com.example.LMS.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;
    private final CourseRegistrationRepository courseRegistrationRepository;

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer studentId){
        return ResponseEntity.ok().body(studentService.getStudent(studentId));
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<?> enrollStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        studentService.addStudentToCourse(studentId, courseId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{studentId}/unenroll/{courseId}")
    public ResponseEntity<?> unEnrollStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        studentService.removeStudentFromCourse(studentId, courseId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<Course>> getEnrolledCourses(@PathVariable Integer studentId){
        return ResponseEntity.ok().body(studentService.getEnrolledCourses(studentId));
    }

    @GetMapping("/{studentId}/course/{courseId}")
    public ResponseEntity<Float> getMarksForCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){
        return ResponseEntity.ok().body(courseRegistrationRepository.getMarks(studentId, courseId));
    }
}

