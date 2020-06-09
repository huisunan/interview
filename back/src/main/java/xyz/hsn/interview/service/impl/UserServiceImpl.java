package xyz.hsn.interview.service.impl;

import xyz.hsn.interview.entity.User;
import xyz.hsn.interview.mapper.UserMapper;
import xyz.hsn.interview.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
