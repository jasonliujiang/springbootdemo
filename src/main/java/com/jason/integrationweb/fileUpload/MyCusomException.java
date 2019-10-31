package com.jason.integrationweb.fileUpload;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理全局异常
 * @author liujiang02
 */
@ControllerAdvice
public class MyCusomException {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void myexception(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html:charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("上传文件大小超出限制");
        out.flush();
        out.close();
    }
}
