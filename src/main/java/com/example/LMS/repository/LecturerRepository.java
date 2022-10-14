package com.example.LMS.repository;

import com.example.LMS.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
    Lecturer findLecturerByEmail(String email);

}
