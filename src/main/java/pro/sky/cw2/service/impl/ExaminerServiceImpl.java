package pro.sky.cw2.service.impl;

import lombok.AllArgsConstructor;
import pro.sky.cw2.exception.BadAmountException;
import pro.sky.cw2.model.Question;
import pro.sky.cw2.service.ExaminerService;
import pro.sky.cw2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 0 || amount > questionService.getAll().size()) {
            throw new BadAmountException();
        }
        Set<Question> questionSet = new HashSet<>(amount);

        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
