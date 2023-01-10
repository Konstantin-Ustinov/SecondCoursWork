package com.secondcourswork.services;

import com.secondcourswork.entities.JavaQuestion;
import com.secondcourswork.exceptions.OverAmountException;
import com.secondcourswork.repositories.JavaQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private JavaQuestionRepository repository;

    public ExaminerServiceImpl(JavaQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<JavaQuestion> getQuestions(int amount) throws OverAmountException {
        Set<JavaQuestion> set = repository.getAll();
        if (set.size() >= amount) {
            Collection<JavaQuestion> questions = new HashSet<>();
                while (questions.size() < amount) {
                    questions.add(getRandomQuestion());
                }
            return questions;
        } else {
            throw new OverAmountException("BAD_REQUEST");
        }
    }

    JavaQuestion getRandomQuestion() {
        Set<JavaQuestion> set = repository.getAll();
        JavaQuestion[] javaQuestionsArray = set.toArray(new JavaQuestion[set.size()]);
        Random random = new Random();
        return javaQuestionsArray[random.nextInt(javaQuestionsArray.length)];
    }
}
