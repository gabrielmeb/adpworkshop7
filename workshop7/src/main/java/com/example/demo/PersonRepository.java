package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}
