package com.secondcourswork.controllers;

import com.secondcourswork.entities.JavaQuestion;
import com.secondcourswork.exceptions.OverAmountException;
import com.secondcourswork.services.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    ExaminerServiceImpl service;

    public ExamController(ExaminerServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/exam/java/get")
    public Collection<JavaQuestion> getQuestions(@RequestParam int amount) {
        try {
            return service.getQuestions(amount);
        } catch (OverAmountException e) {
            e.printStackTrace();
        }
        return null;
    }
}
