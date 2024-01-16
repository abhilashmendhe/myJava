package com.abhitrio.spring.data.jpa.repository;

import com.abhitrio.spring.data.jpa.entity.Guardian;
import com.abhitrio.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("abhilash@gmail.com")
                .firstName("Abhilash")
                .lastName("Mendhe")
//                .guardianName("Chandrashekhar")
//                .guardianEmail("cvm@gmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("nikhil")
                .mobile("1234567891")
                .build();
        Student student = Student.builder()
                .firstName("Shival")
                .emailId("shival@gmail.com")
                .lastName("kumar")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("abhilash");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("sh");
        System.out.println(students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Nikhil");
        System.out.println(students);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress(
                "abhilash@gmail.com"
        );
        System.out.println("student: "+student);
    }

    @Test
    public void printStudentByFirstNameByEmailAddress(){
        String fname = studentRepository.getStudentFirstNameByEmailAddress(
                "abhilash@gmail.com"
        );
        System.out.println("Student: "+fname);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative(
                "abhilash@gmail.com"
        );
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam(
                "abhilash@gmail.com"
        );
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "Abhi",
                "abhilash@gmail.com"
        );
    }
}