package xyz.hsn.interview.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.hsn.interview.bean.BaseResult;
import xyz.hsn.interview.bean.DataResult;
import xyz.hsn.interview.entity.Question;
import xyz.hsn.interview.enums.QuestionStatusEnum;
import xyz.hsn.interview.request.QuestionSearchRequest;
import xyz.hsn.interview.service.IQuestionService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RequestMapping("/admin/question")
@RestController
public class AdminQuestionController {
    @Autowired
    IQuestionService questionService;

    @GetMapping("{id}")
    public DataResult getDetail(@PathVariable Long id){
        return DataResult.ok(questionService.getById(id));
    }

    /**
     * 创建问题
     */
    @PostMapping("create")
    public BaseResult create(@RequestBody @Valid Question question) {
        question.setId(null);
        question.setStatus(QuestionStatusEnum.INIT);
        return BaseResult.create(questionService.save(question));
    }

    @PostMapping("update/{id}")
    public BaseResult update(@NotBlank(message = "ID不能为空") @PathVariable Long id,
                             @Valid @RequestBody Question question) {
        question.setId(id);
        question.setUpdateTime(null);
        return BaseResult.update(questionService.updateById(question));
    }

    @PostMapping("list")
    public Page<Question> list(@RequestBody QuestionSearchRequest request){
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        QuestionStatusEnum status = request.getStatus();
        LambdaQueryWrapper<Question> lambda = queryWrapper.lambda();
        if (status != null){
            lambda.eq(Question::getStatus,request.getStatus());
        }
        if (StringUtils.isNotBlank(request.getName())){
            lambda.or().like(Question::getName,request.getName());
        }
        queryWrapper.select(Question.class,i->!"content".equals(i.getProperty()));
        return questionService.page(request,queryWrapper);
    }

    @GetMapping("approve/{id}")
    public BaseResult approve(@PathVariable Long id,String reason,Integer status){
        Question question = new Question();
        question.setId(id);
        question.setReason(reason);
        question.setStatus(QuestionStatusEnum.getByStatus(status));
        boolean flag = questionService.updateById(question);
        if (flag){
            return BaseResult.ok("审核成功！");
        }else {
            return BaseResult.fail("审核失败！");
        }

    }

    @DeleteMapping("{id}")
    public BaseResult delete(@PathVariable Long id){
        return BaseResult.delete(questionService.removeById(id));

    }
}
