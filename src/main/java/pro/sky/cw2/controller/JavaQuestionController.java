package pro.sky.cw2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.cw2.model.Question;
import pro.sky.cw2.service.QuestionService;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionService questionService;

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }
    @GetMapping("/java")
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}