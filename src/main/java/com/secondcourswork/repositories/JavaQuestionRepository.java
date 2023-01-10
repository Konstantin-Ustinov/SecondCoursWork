package com.secondcourswork.repositories;

import com.secondcourswork.entities.JavaQuestion;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Scope("singleton")
public class JavaQuestionRepository {

    private Set<JavaQuestion> javaQuestions;

    public JavaQuestionRepository() {
        this.javaQuestions = new HashSet<>();
    }

    public boolean add(JavaQuestion newItem) {
        return this.javaQuestions.add(newItem);
    }

    public boolean remove(JavaQuestion item) {
        return javaQuestions.remove(item);
    }

    public Set<JavaQuestion> getAll() {
        return Set.copyOf(javaQuestions);
    }

}
