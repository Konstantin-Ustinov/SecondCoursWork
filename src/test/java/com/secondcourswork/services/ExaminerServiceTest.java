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

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceTest {

    @Mock
    private JavaQuestionRepository repositoryMock;
    @InjectMocks
    private ExaminerServiceImpl out;

    private Set<JavaQuestion> questionCollection = new HashSet<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 5; i++) {
            questionCollection.add(new JavaQuestion("Question " + i, "Answer " + i));
        }
    }

    /*
    * Почему в этом тесте ошибка:
    * org.mockito.exceptions.misusing.WrongTypeOfReturnValue:
    * JavaQuestion cannot be returned by getAll()
    * getAll() should return Set
    */
    @Test
    void getQuestions() throws OverAmountException {
        when(repositoryMock.getAll()).thenReturn(questionCollection);
        when(out.getRandomQuestion()).thenReturn(new JavaQuestion("Question 1", "Answer 1"));
        assertEquals(out.getQuestions(5), questionCollection);
        assertThrows(OverAmountException.class, () -> out.getQuestions(10));
    }
}