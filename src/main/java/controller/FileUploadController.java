package controller;

import java.io.File;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
	@RequestMapping(value = "/ajaxUpload", method=RequestMethod.GET)
    public void ajaxUpload() {
    }
    @RequestMapping(value = "/fileUpload", method=RequestMethod.POST)
    public String fileUp(MultipartHttpServletRequest multi) {
        // 저장 경로 설정
    	String path="C:\\test";
         
        String newFileName = ""; // 업로드 되는 파일명
         
        File dir = new File(path);
        if(!dir.isDirectory()){
            dir.mkdir();
        }
         
        Iterator<String> files = multi.getFileNames();
        while(files.hasNext()){
            String uploadFile = files.next();
                         
            MultipartFile mFile = multi.getFile(uploadFile);
            String fileName = mFile.getOriginalFilename();
            System.out.println("실제 파일 이름 : " +fileName);
            try {
                mFile.transferTo(new File(path+fileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "ajaxUpload";
    }
	
}