package com.jason.integrationweb.fileUpload;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * 上传文件接口
 */
@Logger
@RestController
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("\\yyyy\\MM\\dd");
    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest req){
        //以日期做文件夹分类
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("\\img")+format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
        try {
            //将收到的文件指定传输到目标文件夹下
            file.transferTo(new File(folder,newName));
            log.println(newName);

            String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"\\img"+format+newName;
            return url;


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    public static void main(String[] args) {
        welcome(1024);

    }

    public static void  welcome(int num){
        if (num == 1024){
            System.out.println("Happy developers' Day！");
        }
    }

    public void test(){
        String a = "Happy";
        if (a!=null){
            a += " developers";
        }
        String b = a+"'";
        System.out.println(b+"Day");
    }





}
