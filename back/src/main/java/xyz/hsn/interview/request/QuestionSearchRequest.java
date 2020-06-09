package xyz.hsn.interview.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.hsn.interview.entity.Question;
import xyz.hsn.interview.enums.QuestionStatusEnum;

@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionSearchRequest extends Page<Question> {
    private Integer status;
    private String name;
    public QuestionStatusEnum getStatus(){
        return QuestionStatusEnum.getByStatus(status);
    }
}
