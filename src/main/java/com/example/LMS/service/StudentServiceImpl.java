package com.example.LMS.service;

import com.example.LMS.model.Course;
import com.example.LMS.model.CourseRegistration;
import com.example.LMS.model.Student;
import com.example.LMS.repository.CourseRegistrationRepository;
import com.example.LMS.repository.CourseRepository;
import com.example.LMS.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentServiceImpl {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;

    public Student getStudent(Integer studentId) {
        log.info("Fetching Student {}", studentId);
        return studentRepository.findById(studentId).orElseThrow();
    }
    public List<Course> getEnrolledCourses(Integer studentId){
        log.info("Fetching all enrolled courses for student {}", studentId);
        return courseRegistrationRepository.getEnrolledCourses(studentId);
    }

    public void addStudentToCourse(Integer studentId, Integer courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        log.info("Adding course {} to student {}", course.getCourse_code(), student.getName());

        CourseRegistration courseRegistration = new CourseRegistration(null, course, student, null);
        courseRegistrationRepository.save(courseRegistration);

        student.setCourseRegistration(courseRegistration);
        course.setCourseRegistration(courseRegistration);

    }

    public void removeStudentFromCourse(Integer studentId, Integer courseId) {
        CourseRegistration courseRegistration = courseRegistrationRepository.getCourseRegistration(studentId, courseId);

        log.info("Removing course {} from student {}", courseRegistration.getCourse().getCourse_code(), courseRegistration.getStudent().getName());

        courseRegistrationRepository.delete(courseRegistration);

        courseRegistration.getStudent().getCourseRegistrations().remove(courseRegistration);
        courseRegistration.getCourse().getCourseRegistrations().remove(courseRegistration);
    }
}
