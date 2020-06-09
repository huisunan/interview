package xyz.hsn.interview.service.impl;

import xyz.hsn.interview.entity.Contact;
import xyz.hsn.interview.mapper.ContactMapper;
import xyz.hsn.interview.service.IContactService;
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
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements IContactService {

}
