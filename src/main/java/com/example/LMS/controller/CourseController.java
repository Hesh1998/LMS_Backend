package com.example.LMS.controller;

import com.example.LMS.model.Announcement;
import com.example.LMS.model.Course;
import com.example.LMS.service.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceImpl courseService;

    @GetMapping("/all")
    ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok().body(courseService.getAll());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourse(@PathVariable Integer courseId){
        return ResponseEntity.ok().body(courseService.getInfo(courseId));
    }

    // todo
    @PostMapping("/add")
    ResponseEntity<?> addNewCourse(
            @RequestBody Course course, @CurrentSecurityContext(expression="authentication?.name") String email){
        return ResponseEntity.ok().body(courseService.saveCourse(course, email));
    }

    @GetMapping("/{courseId}/announcements")
    List<Announcement> getAnnouncements(@PathVariable Integer courseId){
        return courseService.getAnnouncements(courseId);
    }

}
