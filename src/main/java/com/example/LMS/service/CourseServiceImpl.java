package com.example.LMS.service;

import com.example.LMS.model.Announcement;
import com.example.LMS.model.Course;
import com.example.LMS.model.Lecturer;
import com.example.LMS.repository.AnnouncementRepository;
import com.example.LMS.repository.CourseRepository;
import com.example.LMS.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CourseServiceImpl {
    private final CourseRepository courseRepository;
    private final LecturerRepository lecturerRepository;
    private final AnnouncementRepository announcementRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course getInfo(Integer courseId){
        return courseRepository.findById(courseId).orElseThrow();
    }

    public Course saveCourse(Course course, String email) {
        log.info("Saving new Course {}", course.getName());
        Lecturer lecturer = lecturerRepository.findLecturerByEmail(email);
        course.setLecturer(lecturer);
        lecturer.getConductingCourses().add(course);
        return courseRepository.save(course);
    }

    public List<Announcement> getAnnouncements(Integer courseId){
        return announcementRepository.findAnnouncementsByCourseId(courseId);
    }
}

