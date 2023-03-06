package or.kr.smhrd.portal.controller;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import or.kr.smhrd.portal.service.FileService;

@RestController
@RequestMapping("/file")
public class FileRestContoller {
    
    @Autowired
    FileService fileService;

    /**이력서 사진 업로드 */
    @PostMapping("/upload")
    public void uploadResume(
        @RequestParam("file") MultipartFile file,
        @RequestParam("id") String id
    ){
        String path = "src/main/resources/file/"+id+"/resume/photo";
        File targetFile = new File(path);
        try {
            InputStream fileStream = file.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
            fileService.uploadResume(id, path);
        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            e.printStackTrace();
        }
    }

    /**이력서 사진 삭제 */
    @PostMapping("/delete")
    public void deleteResume(
        @RequestParam("id") String id
    ){
        String path = "src/main/resources/file/resume/"+id+"/photo";
        File targetFile = new File(path);
        if(targetFile.exists()){
        targetFile.delete();
        fileService.deleteResume(id, path);
        }
    }

    /**포트폴리오 파일 업로드 */
    @PostMapping("/upload/portfolio")
    public void uploadPortfolio(
        @RequestParam("file") MultipartFile file,
        @RequestParam("id") String id,
        @RequestParam("num") String num,
        @RequestParam("idx") String idx
    ){
        String path = "src/main/resources/file/portfolio/"+id+"/"+num+"/"+idx;
        File targetFile = new File(path);
        try {
            InputStream fileStream = file.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
            fileService.uploadPortfolio(id, path, idx);
        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            e.printStackTrace();
        }
    }
    /**포트폴리오 파일 삭제 */
    @PostMapping("/delete/portfolio")
    public void deletePortfolio(
        @RequestParam("id") String id,
        @RequestParam("num") String num,
        @RequestParam("idx") String idx
    ){
        String path = "src/main/resources/file/portfolio/"+id+"/"+num+"/"+idx;
        File targetFile = new File(path);
        if(targetFile.exists()){
            targetFile.delete();
            fileService.deletePortfolio(id, path);
        }
    }

    /**게시판 파일 업로드 */
    @PostMapping("/upload/board")
    public void uploadBoard(
        @RequestParam("file") MultipartFile file,
        @RequestParam("id") String id,
        @RequestParam("num") String num
    ){
        String path = "src/main/resources/file/board/"+id+"/"+num;
        File targetFile = new File(path);
        try {
            InputStream fileStream = file.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
            fileService.uploadBoard(id, path, num);
        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            e.printStackTrace();
        }
    }
    /**게시판 파일 삭제 */
    @PostMapping("/delete/board")
    public void deleteBoard(
        @RequestParam("id") String id,
        @RequestParam("num") String num,
        @RequestParam("idx") String idx
    ){
        String path = "src/main/resources/file/board/"+id+"/"+num+"/"+idx;
        File targetFile = new File(path);
        if(targetFile.exists()){
            targetFile.delete();
            fileService.deleteBoard(id, path);
        }
    }
}
