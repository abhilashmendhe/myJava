package com.abhitrio.spring.data.jpa.repository;

import com.abhitrio.spring.data.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
