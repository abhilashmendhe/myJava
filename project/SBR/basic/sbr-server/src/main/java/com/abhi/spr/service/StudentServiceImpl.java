package com.abhi.spr.service;

import com.abhi.spr.exception.StudentNotFoundException;
import com.abhi.spr.exception.StudentAlreadyExistsException;
import com.abhi.spr.model.Student;
import com.abhi.spr.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService{

    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) throws StudentAlreadyExistsException {
        if(studentAlreadyExists(student.getEmail())){
            throw new StudentAlreadyExistsException(student.getId()+" already Exists.");
        }
        return studentRepository.save(student);
    }


    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map( st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRepository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student doesn't exists!!"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student "+id+" not found!!"));
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Sorry, student not found!");
        }
        studentRepository.delete(getStudentById(id));
    }


    private boolean studentAlreadyExists(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}
