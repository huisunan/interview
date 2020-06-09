package xyz.hsn.interview.service.impl;

import xyz.hsn.interview.entity.QuestionCategory;
import xyz.hsn.interview.mapper.QuestionCategoryMapper;
import xyz.hsn.interview.service.IQuestionCategoryService;
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
public class QuestionCategoryServiceImpl extends ServiceImpl<QuestionCategoryMapper, QuestionCategory> implements IQuestionCategoryService {

}
