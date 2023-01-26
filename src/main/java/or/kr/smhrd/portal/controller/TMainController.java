package or.kr.smhrd.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.service.TMainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import or.kr.smhrd.portal.domain.Board;


@RequiredArgsConstructor
@RequestMapping("/announcement")
@RestController
public class TMainController {

   private final TMainService tMainService;

   // 공지사항 관련
   @PostMapping("/addPost")
   public void addPost(@RequestBody Map<String, String> data) {
      tMainService.addPost(data);
   }

   @PostMapping("/editPost")
   public void editPost(@RequestBody Map<String, String> data) {
      tMainService.editPost(data);
   }

   @GetMapping("/getPost")
   public List<Board> getPost(@RequestParam String key) {
       return tMainService.getPost(key);
   }

   @GetMapping("/getOnePost")
   public Board getOnePost(@RequestParam String key) {
      return tMainService.getOnePost(key);
   }

   @GetMapping("/deletePost")
   public void deletePost(@RequestParam String key) {
      tMainService.deletePost(key);
   }


   // 공유자료실 관련
   @PostMapping("/addArchive")
   public void addArchive(@RequestBody Map<String, String> data) {
      tMainService.addArchive(data);
   }

   @PostMapping("/editArchive")
   public void editArchive(@RequestBody Map<String, String> data) {
      tMainService.editArchive(data);
   }

   @GetMapping("/getArchive")
   public List<Board> getArchive(@RequestParam String key) {
       return tMainService.getArchive(key);
   }

   @GetMapping("/getOneArchive")
   public Board getOneArchive(@RequestParam String key) {
      return tMainService.getOneArchive(key);
   }

   @GetMapping("/deleteArchive")
   public void deleteArchive(@RequestParam String key) {
      tMainService.deleteArchive(key);
   }


   // 학생 정보 관련
   @GetMapping("/getCourseInfo")
   public String getCourseInfo(@RequestParam String key) {
      return tMainService.getCourseInfo(key);
   }
}
