package com.secondcourswork.controllers;

import com.secondcourswork.entities.JavaQuestion;
import com.secondcourswork.services.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@RestController
public class JavaQuestionController {

    private JavaQuestionService service;

    public JavaQuestionController(JavaQuestionService service) {
        this.service = service;
        service.firstFillingQuestions(15);
    }

    @GetMapping("/exam/java/getAll/")
    public Set<JavaQuestion> getAllQuestions() {
        return service.getAll();
    }

    @GetMapping("/exam/java/add")
    public boolean addQuestion(@RequestParam String question, String answer) {
        return answer != null ? service.add(question, answer) : service.add(question, "Empty");
    }

    @GetMapping("/exam/java/remove")
    public boolean removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(question, answer);
    }

}
