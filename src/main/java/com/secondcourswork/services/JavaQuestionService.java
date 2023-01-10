package com.secondcourswork.services;

import com.secondcourswork.entities.JavaQuestion;
import com.secondcourswork.repositories.JavaQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private JavaQuestionRepository repository;

    public JavaQuestionService(JavaQuestionRepository repository) {
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
    public boolean add(String question) {
        return repository.add(new JavaQuestion(question, "Empty"));
    }

    @Override
    public boolean remove(String question, String answer) {
        return repository.remove(new JavaQuestion(question, answer));
    }

    @Override
    public Set<JavaQuestion> getAll() {
        return repository.getAll();
    }

}
