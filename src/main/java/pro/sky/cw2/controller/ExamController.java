package pro.sky.cw2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.cw2.model.Question;
import pro.sky.cw2.service.ExaminerService;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class ExamController {
    private final ExaminerService examinerService;

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
