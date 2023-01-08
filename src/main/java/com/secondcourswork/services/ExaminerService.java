package com.secondcourswork.services;

import com.secondcourswork.entities.JavaQuestion;
import com.secondcourswork.exceptions.OverAmountException;

import java.util.Collection;

public interface ExaminerService {
    public Collection<JavaQuestion> getQuestions(int amount) throws OverAmountException;
}
