package com.abhitrio.spring.data.jpa.repository;

import com.abhitrio.spring.data.jpa.entity.Course;
import com.abhitrio.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseFDS = Course.builder()
                .title("FDS")
                .credit(8)
                .build();
        Course courseCRDT = Course.builder()
                .title("CRDT")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Erick")
                .lastName("Lavoie")
                .courses(List.of(courseFDS,courseCRDT))
                .build();

        teacherRepository.save(teacher);
    }
}