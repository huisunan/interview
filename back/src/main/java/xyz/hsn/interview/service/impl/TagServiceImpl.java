package xyz.hsn.interview.service.impl;

import xyz.hsn.interview.entity.Tag;
import xyz.hsn.interview.mapper.TagMapper;
import xyz.hsn.interview.service.ITagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
