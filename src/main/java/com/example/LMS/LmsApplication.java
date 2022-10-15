package com.example.LMS;

import com.example.LMS.model.Course;
import com.example.LMS.model.User;
import com.example.LMS.service.CourseServiceImpl;
import com.example.LMS.service.LecturerServiceImpl;
import com.example.LMS.service.StudentServiceImpl;
import com.example.LMS.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {

		SpringApplication.run(LmsApplication.class, args);
		System.out.println("LMS Backend is up & running");
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(StudentServiceImpl studentService, UserServiceImpl userService,
						  CourseServiceImpl courseService, LecturerServiceImpl lecturerService){
		return args -> {

			userService.saveUser(new User(null, "Lihini Jayasinghe", "lihinidananjana@gmail.com", "444", "STUDENT"));
			userService.saveUser(new User(null, "Sashini Wanigasekara", "sashini@gmail.com", "444", "STUDENT"));
			userService.saveUser(new User(null, "Heshan Nanayakkara", "heshan@gmail.com", "444", "STUDENT"));

			userService.saveUser(new User(null, "Mrs. Vinu Perera", "vinu@gmail.com", "444", "LECTURER"));
			userService.saveUser(new User(null, "Mr. Madura Gunasekara", "madura@gmail.com", "444", "LECTURER"));
			userService.saveUser(new User(null, "Ms. Shanudri Priyasad", "shanudri97@gmail.com", "444", "LECTURER"));

			userService.saveUser(new User(null, "Admin", "admin@admin.com", "444", "ADMIN"));

			courseService.saveCourse(new Course(null, "INTE 31273", "Intregrative Programming and Technologies", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", null, new HashSet<>(), new HashSet<>()), "vinu@gmail.com");
			courseService.saveCourse(new Course(null, "INTE 31253", "Software Engineering Concepts", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", null, new HashSet<>(), new HashSet<>()), "madura@gmail.com");
			courseService.saveCourse(new Course(null, "MGTE 22222", "Managirial Finance", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", null, new HashSet<>(), new HashSet<>()), "shanudri97@gmail.com");
			courseService.saveCourse(new Course(null, "MGTE 31212", "Project Management", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", null, new HashSet<>(), new HashSet<>()), "vinu@gmail.com");

			studentService.addStudentToCourse(1,1);
			studentService.addStudentToCourse(1,2);
			studentService.addStudentToCourse(2,1);
			studentService.addStudentToCourse(3,4);


		};
	}

}


