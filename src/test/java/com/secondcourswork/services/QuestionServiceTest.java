package com.secondcourswork.services;

import com.secondcourswork.entities.JavaQuestion;
import com.secondcourswork.repositories.JavaQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @Mock
    private JavaQuestionRepository repositoryMock;
    @InjectMocks
    private JavaQuestionService out;

    private Set<JavaQuestion> questionCollection = new HashSet<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 5; i++) {
            questionCollection.add(new JavaQuestion("Question " + i, "Answer " + i));
        }
    }

    @Test
    void shouldReturnTrueIfAddSuccess() {
        when(repositoryMock.add(any())).thenReturn(true);
        assertTrue(out.add("Q1", "A1"));
    }

    @Test
    void shouldReturnTrueIfRemoveSuccess() {
        when(repositoryMock.remove(any())).thenReturn(true);
        assertTrue(out.remove("Q1", "A1"));
    }

    @Test
    void shouldReturnAllQuestionsByCollection() {
        when(repositoryMock.getAll()).thenReturn(questionCollection);
        assertEquals(out.getAll(), questionCollection);
    }
}