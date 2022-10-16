package com.example.LMS.controller;

import com.example.LMS.model.*;
import com.example.LMS.response.StudentMarksResponse;
import com.example.LMS.service.LecturerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturer")
@RequiredArgsConstructor
public class LecturerController {

    private final LecturerServiceImpl lecturerService;

    @GetMapping("/{lecturerId}")
    Lecturer getLecturer(@PathVariable Integer lecturerId){
        return lecturerService.getLecturer(lecturerId);
    }

    @GetMapping("/{courseId}/students")
    List<Student> getEnrolledStudents(@PathVariable Integer courseId){
        return lecturerService.getEnrolledStudents(courseId);
    }

    @GetMapping("/{courseId}/students/marks")
    List<StudentMarksResponse> getEnrolledStudentsMarks(@PathVariable Integer courseId){
        return lecturerService.getEnrolledStudentsMarks(courseId);
    }

    @PostMapping("/{courseId}/student/{studentId}/mark/{marks}")
    CourseRegistration assignMarks(@PathVariable Integer courseId, @PathVariable Integer studentId, @PathVariable Float marks){
        return lecturerService.assignMarks(courseId, studentId, marks);
    }

    @GetMapping("/{lecturerId}/courses")
    List<Course> getConductingCourses(@PathVariable Integer lecturerId){
        return lecturerService.getConductingCourses(lecturerId);
    }
}

