package com.example.LMS.service;

import com.example.LMS.model.*;
import com.example.LMS.repository.CourseRegistrationRepository;
import com.example.LMS.repository.LecturerRepository;
import com.example.LMS.response.StudentMarksResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LecturerServiceImpl {
    private final LecturerRepository lecturerRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;



    public Lecturer getLecturer(Integer lecturerId) {
        log.info("Fetching Lecturer {}", lecturerId);
        return lecturerRepository.findById(lecturerId).orElseThrow();
    }

    public List<Student> getEnrolledStudents(Integer courseId){
        return courseRegistrationRepository.getEnrolledStudents(courseId);
    }

    public CourseRegistration assignMarks(Integer courseId, Integer studentId, Float marks) {
        courseRegistrationRepository.setMarks(studentId, courseId, marks);
        return courseRegistrationRepository.getCourseRegistration(studentId, courseId);
    }
/*
    @SneakyThrows
    public Announcement postAnnouncement(Integer courseId, Announcement announcement, String email){
    //Sending e-mail function
    // return null;
    }

 */

    public List<StudentMarksResponse> getEnrolledStudentsMarks(Integer courseId) {

        List<Float> marks = courseRegistrationRepository.getStudentsMarks(courseId);
        List<Student> students = courseRegistrationRepository.getEnrolledStudents(courseId);

        List<StudentMarksResponse> studentMarksResponses = new ArrayList<>();

        for (int i=0; i < students.size(); i++) {
            studentMarksResponses.add(new StudentMarksResponse(students.get(i), marks.get(i)));
        }

        return studentMarksResponses;
    }

    public List<Course> getConductingCourses(Integer lecturerId) {
        log.info("Fetching all enrolled courses for student {}", lecturerId);
        Lecturer lecturer = lecturerRepository.findById(lecturerId).orElseThrow();
        return lecturer.getConductingCourses();
    }
}
