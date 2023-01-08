package com.secondcourswork.services;

import com.secondcourswork.entities.JavaQuestion;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface JavaQuestionService {

    boolean add(String question, String answer);

    boolean remove(String question, String answer);

    Collection<JavaQuestion> getAll();

}
