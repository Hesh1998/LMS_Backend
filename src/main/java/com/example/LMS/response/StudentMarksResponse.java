package com.example.LMS.response;



import com.example.LMS.model.Student;



public class StudentMarksResponse extends Student {


    public Float marks;

    public StudentMarksResponse(Student student, Float marks){

        super(student);
        this.marks = marks;

    }
}

