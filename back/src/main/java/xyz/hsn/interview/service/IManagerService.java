package xyz.hsn.interview.service;

import xyz.hsn.interview.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author prince
 * @since 2020-06-06
 */
public interface IManagerService extends IService<Manager> {

    Manager getByUsername(String username);

    Manager getUserInfo(String username);
}
