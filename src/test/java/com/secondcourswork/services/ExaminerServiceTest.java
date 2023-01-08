package com.secondcourswork.services;

import com.secondcourswork.entities.JavaQuestion;
import com.secondcourswork.exceptions.OverAmountException;
import com.secondcourswork.repositories.JavaQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceTest {

    @Mock
    private JavaQuestionRepository repositoryMock;
    @InjectMocks
    private ExaminerServiceImpl out;

    private final List<JavaQuestion> questionCollection = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 5; i++) {
            questionCollection.add(new JavaQuestion("Question " + i, "Answer " + i));
        }
    }

    @Test
    void getQuestions() throws OverAmountException {
        when(repositoryMock.getRandomQuestions(1)).thenReturn(questionCollection);
        when(repositoryMock.getAll()).thenReturn(questionCollection);
        assertEquals(out.getQuestions(1), questionCollection);
        assertThrows(OverAmountException.class, () -> out.getQuestions(10));
    }
}