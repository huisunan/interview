package xyz.hsn.interview.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import xyz.hsn.interview.entity.Manager;
import xyz.hsn.interview.mapper.ManagerMapper;
import xyz.hsn.interview.service.IManagerService;
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
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

    @Override
    public Manager getByUsername(String username) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Manager::getUsername,username);
        return getOne(queryWrapper);
    }

    @Override
    public Manager getUserInfo(String username) {
        QueryWrapper<Manager> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().eq(Manager::getUsername,username);
        queryWrapper.select("username","avatar");
        return getOne(queryWrapper);
    }
}
