package com.secondcourswork.services;

import com.secondcourswork.entities.JavaQuestion;
import com.secondcourswork.exceptions.OverAmountException;
import com.secondcourswork.repositories.JavaQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    JavaQuestionRepository repository;

    public ExaminerServiceImpl(JavaQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<JavaQuestion> getQuestions(int amount) throws OverAmountException {

        Collection<JavaQuestion> collection = repository.getAll();
        int countQuestions = collection.size();

        if (countQuestions >= amount) {
            return repository.getRandomQuestions(amount);
        } else {
            throw new OverAmountException("BAD_REQUEST");
        }

    }
}
