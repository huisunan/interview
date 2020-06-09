package xyz.hsn.interview.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.hsn.interview.bean.BaseResult;
import xyz.hsn.interview.constant.Constants;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public BaseResult exception(Exception e){
        log.error(e.getMessage());
        return BaseResult.fail("系统错误!");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult methodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String message = allErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
        return BaseResult.fail(Constants.BAB_PARAM,message);
    }
}
