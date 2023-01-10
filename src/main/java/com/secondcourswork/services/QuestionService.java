package com.secondcourswork.services;

import com.secondcourswork.entities.JavaQuestion;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface QuestionService {

    boolean add(String question, String answer);

    boolean add(String question);

    boolean remove(String question, String answer);

    Collection<JavaQuestion> getAll();

}
