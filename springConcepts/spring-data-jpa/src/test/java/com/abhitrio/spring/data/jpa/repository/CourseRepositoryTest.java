package com.abhitrio.spring.data.jpa.repository;

import com.abhitrio.spring.data.jpa.entity.Course;
import com.abhitrio.spring.data.jpa.entity.Student;
import com.abhitrio.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Pri")
                .lastName("Singh")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(4)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElement = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages   = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalElements: "+totalElement);
        System.out.println("totalPages: "+totalPages);
        System.out.println(courses);
//        System.out.println("Course: "+courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("title")
        );
        Pageable sortByCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
        );

    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Student student = Student.builder()
                .firstName("abhishek")
                .lastName("Malhar")
                .emailId("abhihesk@gmail.com")
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Lizzy")
                .lastName("Weber")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}