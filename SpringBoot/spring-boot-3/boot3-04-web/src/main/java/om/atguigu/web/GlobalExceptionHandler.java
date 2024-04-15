package om.atguigu.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice //这个类是集中处理所有 @Copntroller发生的错误
public class GlobalExceptionHandler {
    @ResponseBody
//    @ExceptionHandler(Exception.class)
    public String handlExcption(Exception e){
        return "Ohhp~~~统一处理，原因："+e.getMessage();
    }
}
