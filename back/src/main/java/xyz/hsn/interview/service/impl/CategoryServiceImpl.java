package xyz.hsn.interview.service.impl;

import xyz.hsn.interview.entity.Category;
import xyz.hsn.interview.mapper.CategoryMapper;
import xyz.hsn.interview.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
