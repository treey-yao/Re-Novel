package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

/**
 * Created by ccy on 2017/7/20.
 */

@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(MultipartException.class)
    public String sizeError(){
        return "errors/errorPictureSize";
    }
}
