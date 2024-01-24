package com.abhi.spr.service;

import com.abhi.spr.exception.StudentAlreadyExistsException;
import com.abhi.spr.model.Student;

import java.util.List;

public interface IStudentService {

    Student addStudent(Student student) throws StudentAlreadyExistsException;
    List<Student> getStudents();
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);

    void deleteStudent(Long id);
}
