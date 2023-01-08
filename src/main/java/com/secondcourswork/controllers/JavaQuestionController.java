package com.secondcourswork.controllers;

import com.secondcourswork.entities.JavaQuestion;
import com.secondcourswork.services.JavaQuestionServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class JavaQuestionController {

    JavaQuestionServiceImpl service;

    public JavaQuestionController(JavaQuestionServiceImpl service) {
        this.service = service;
        service.firstFillingQuestions(15);
    }

    @GetMapping("/exam/java/getAll/")
    public Collection<JavaQuestion> getAllQuestions() {
        return service.getAll();
    }

    @GetMapping("/exam/java/add")
    public boolean addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/exam/java/remove")
    public boolean removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(question, answer);
    }

}
