package xyz.hsn.interview.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.hsn.interview.bean.DataResult;
import xyz.hsn.interview.entity.Question;
import xyz.hsn.interview.enums.QuestionStatusEnum;
import xyz.hsn.interview.service.IQuestionService;

@RestController
@RequestMapping("question")
public class WebQuestionController {
    @Autowired
    IQuestionService questionService;

    @PostMapping("list")
    public Page<Question> list(@RequestBody Page<Question> search){
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Question::getStatus, QuestionStatusEnum.SUCCESS);
        queryWrapper.select("id","name","author","create_time");
        return questionService.page(search,queryWrapper);
    }

    @GetMapping("{id}")
    public DataResult getQuestion(@PathVariable Long id){
        return DataResult.ok(questionService.getById(id));
    }
}
