package com.secondcourswork.repositories;

import com.secondcourswork.entities.JavaQuestion;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Repository
@Scope("singleton")
public class JavaQuestionRepository {

    private List<JavaQuestion> javaQuestions;

    public JavaQuestionRepository() {
        this.javaQuestions = new ArrayList<>();
    }

    public boolean add(JavaQuestion newItem) {
        return this.javaQuestions.add(newItem);
    }

    public boolean remove(JavaQuestion item) {
        return javaQuestions.remove(item);
    }

    public Collection<JavaQuestion> getAll() {
        return List.copyOf(javaQuestions);
    }

    public JavaQuestion getQuestion(int index) {
        return javaQuestions.get(index);
    }

    public Collection<JavaQuestion> getRandomQuestions(int amount) {
        Collection<JavaQuestion> questions = new ArrayList<>();
        Random random = new Random();
        while (questions.size() < amount) {
            JavaQuestion question = getQuestion(random.nextInt(javaQuestions.size()));
            if (!questions.contains(question)) {
                questions.add(question);
            }
        }
        return questions;
    }
}
