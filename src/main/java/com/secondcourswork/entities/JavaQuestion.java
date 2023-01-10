package com.secondcourswork.entities;

import java.util.Objects;

public class JavaQuestion {
    private String question;
    private String answer;

    public JavaQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "JavaQuestion{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaQuestion that = (JavaQuestion) o;
        return question.equals(that.question) && answer.equals(that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }
}
