package com.text.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.parser.AstIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.text.entities.Student;
import com.text.service.Shopservice;

import  com.text.repository.StudentRepo;

@RestController
@RequestMapping("/student")
public class Shopcontroller {
	List<Student>ls=new ArrayList<Student>();
    @Autowired
    StudentRepo studentrepo;
//    @GetMapping("/student")
//    Student getstudent() {
//    	
//    	return service.getstudeStudent();
//    	
//    }
//    @GetMapping("/studentname")
//    String getname() {
//    	return service.getname();
//    }
//    @PostMapping("/addstudent")
//    String addstudent(@RequestBody Student obj) {
//    	ls.add(obj);
//    	return obj.getName();
//    }
//    @GetMapping("/studentbyage/{age}")
//    Student getstudentbyage(@PathVariable int age) {
//    	for(Student s:ls) {
//    		if(s.getAge()==age) {
//    			return s;
//    		}
//    	}
//    	return null;
//    }
    @PostMapping("/addstudent")
    Student addstudent(@RequestBody Student obj) {
    	studentrepo.save(obj);
    	return obj;
    }
    @GetMapping("/allstudent")
    List<Student>getall(){
    	return studentrepo.findAll();
    }
    @DeleteMapping("/delete")
    public void  delete() {
    	 studentrepo.deleteAll();
    }
    @GetMapping("/getbyid/{id}")
    public Student getById(@PathVariable int id) {
        return studentrepo.findById(id).orElse(null);
    }
    @DeleteMapping("/delete/{id}")
    public void deletebyid(@PathVariable int id) {
        studentrepo.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student newdata) {
        Student old = studentrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        old.setName(newdata.getName());
        old.setAge(newdata.getAge());
        return studentrepo.save(old);
    }
    @PatchMapping("/update/{id}")
    public Student patch(@PathVariable int id, @RequestBody Student newdata) {

        Student old = studentrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (newdata.getName() != null) {
            old.setName(newdata.getName());
        }

        if (newdata.getAge() != 0) {
            old.setAge(newdata.getAge());
        }

        return studentrepo.save(old);
    }

    
    
}
