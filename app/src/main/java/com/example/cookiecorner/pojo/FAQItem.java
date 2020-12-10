package com.example.cookiecorner.pojo;

/**
 * Represents a pretty ordinary java object -- a FAQ menu item that has its set of information
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 28th 2020
 */
public class FAQItem {
    // properties
    private String question;
    private String answer;

    /**
     * constructor.
     * @param question the frequently asked question
     * @param answer the answer
     */
    public FAQItem(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Getter for question
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Setter for question
     * @param question the frequently asked question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Getter for answer
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Setter for answer
     * @param answer the answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
