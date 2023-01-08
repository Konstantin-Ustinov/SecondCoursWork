package com.secondcourswork.services;

import com.secondcourswork.entities.JavaQuestion;
import com.secondcourswork.repositories.JavaQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class JavaQuestionServiceImpl implements JavaQuestionService {
    JavaQuestionRepository repository;

    public JavaQuestionServiceImpl(JavaQuestionRepository repository) {
        this.repository = repository;
    }

    public void firstFillingQuestions(int count) {
        for (int i = 0; i < count; i++) {
            repository.add(new JavaQuestion("Question " + i, "Answer " + i));
        }
    }

    @Override
    public boolean add(String question, String answer) {
        return repository.add(new JavaQuestion(question, answer));
    }

    @Override
    public boolean remove(String question, String answer) {
        return repository.remove(new JavaQuestion(question, answer));
    }

    @Override
    public Collection<JavaQuestion> getAll() {
        return repository.getAll();
    }

}
