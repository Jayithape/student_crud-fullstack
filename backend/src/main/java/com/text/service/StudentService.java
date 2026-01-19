package com.text.service;

import org.springframework.stereotype.Service;

import com.text.entities.Student;

@Service
public class Shopservice {
       public Student getstudeStudent() {
    	   return new Student(25,"yash");
       }
       public String getname() {
    	   return "jay";
       }
       
}
