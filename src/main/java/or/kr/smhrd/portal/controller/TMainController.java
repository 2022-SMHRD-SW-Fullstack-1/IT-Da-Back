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
import or.kr.smhrd.portal.domain.Schedule;

@RequiredArgsConstructor
@RequestMapping("/announcement")
@RestController
public class TMainController {

   private final TMainService tMainService;

   // 공지사항 추가
   @PostMapping("/addPost")
   public void addPost(@RequestBody Map<String, String> data) {
      tMainService.addPost(data);
   }

   // 공지사항 수정
   @PostMapping("/editPost")
   public void editPost(@RequestBody Map<String, String> data) {
      tMainService.editPost(data);
   }

   // 공지사항 불러오기
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
   public void addArchive(@RequestBody Map<String, Object> data) {
      tMainService.addArchive(data);
   }

   @PostMapping("/editArchive")
   public void editArchive(@RequestBody Map<String, Object> data) {
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

   // 전체공지 작성
   @PostMapping("/manager_write")
   public void managerAnnouncementWrite(@RequestBody Board board) {
      tMainService.managerAnnouncementWrite(board);
   }

   // 전체공지 불러오기
   @GetMapping("/get_manager_post")
   public List<Board> getManagerPost(@RequestParam String key) {
      return tMainService.getManagerPost(key);
   }

   // 연장사용
   @PostMapping("/write_extend")
   public void writeExtend(@RequestBody Map<String, String> data) {
      tMainService.writeExtend(data);
   }

   @GetMapping("/get_extend")
   public List<Board> getExtend(@RequestParam String key) {
      return tMainService.getExtend(key);
   }

   @GetMapping("/get_one_extend")
   public Board getOneExtend(@RequestParam String key){
      return tMainService.getOneExtend(key);
   }

   // 일정 관련
   @PostMapping("/addSchedule")
   public void addSchedule(@RequestBody Map<String, String> data) {
      tMainService.addSchedule(data);
   }

   @PostMapping("/getSchedule")
   public List<Schedule> getSchedule(@RequestBody Map<String, String> data) {
      return tMainService.getSchedule(data);
   }

   @GetMapping("/deleteSchedule")
   public void deleteSchedule(@RequestParam String sche_num) {
      tMainService.deleteSchedule(sche_num);
   }
}
