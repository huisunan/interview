package xyz.hsn.interview.service.impl;

import xyz.hsn.interview.entity.Question;
import xyz.hsn.interview.mapper.QuestionMapper;
import xyz.hsn.interview.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author prince
 * @since 2020-06-06
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
