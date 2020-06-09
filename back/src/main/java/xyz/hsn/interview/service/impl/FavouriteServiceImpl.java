package xyz.hsn.interview.service.impl;

import xyz.hsn.interview.entity.Favourite;
import xyz.hsn.interview.mapper.FavouriteMapper;
import xyz.hsn.interview.service.IFavouriteService;
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
public class FavouriteServiceImpl extends ServiceImpl<FavouriteMapper, Favourite> implements IFavouriteService {

}
