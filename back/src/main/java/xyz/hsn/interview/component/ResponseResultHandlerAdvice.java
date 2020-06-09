package xyz.hsn.interview.component;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import sun.font.BidiUtils;
import xyz.hsn.interview.bean.PageResult;
import xyz.hsn.interview.constant.Constants;

/**
 * response增强
 * @author huisunan
 * @date 2020/1/14 14:26
 */
@RestControllerAdvice
@Slf4j
public class ResponseResultHandlerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 判断响应的Content-Type为JSON格式的body
        if(MediaType.APPLICATION_JSON.equals(mediaType) && o instanceof Page){
            // 如果响应返回的对象为统一响应体，则直接返回body
            PageResult<?> result = new PageResult<>();
            BeanUtils.copyProperties(o,result);
            result.setCode(Constants.SUCCESS);
            return result;
        }
        return o;
    }
}
