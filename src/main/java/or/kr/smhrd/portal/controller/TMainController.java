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
   
}
