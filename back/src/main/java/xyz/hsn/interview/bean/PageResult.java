package xyz.hsn.interview.bean;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageResult<T> extends Page<T> {
    private Integer code;
    private String msg;
}
