package com.corn.vsound.web.erro;

import com.corn.boot.base.HttpBase;
import com.corn.boot.base.JsonResult;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yyc
 * @apiNote 全局异常捕捉
 */
@RestControllerAdvice
public class BaseControllerErrorAdvice  {

    private static final Logger log = LoggerFactory.getLogger(BaseControllerErrorAdvice.class);

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public JsonResult ExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e){
        BindingResult bindResult = e.getBindingResult();
        String errorMsg = bindResult.getFieldError().getDefaultMessage();
        log.info("接口{}参数校验失败:原因{}",request.getRequestURI(),errorMsg);
        return new JsonResult(errorMsg,false, HttpBase.HTTP_RESPONSE_PARAM_ERROR_CODE);
    }
}
