package or.kr.smhrd.portal.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.mapper.TMainMapper;
import or.kr.smhrd.portal.domain.Board;

@RequiredArgsConstructor
@Service
public class TMainService {

   private final TMainMapper tMainMapper;
   
   public void addPost(Map<String, String> data) {
      tMainMapper.addPost(data.get("title"), data.get("content"), data.get("id"), data.get("key"));
   }

   public void editPost(Map<String, String> data) {
      tMainMapper.editPost(data.get("title"), data.get("content"), data.get("b_num"));
   }

   public List<Board> getPost(String course_key) {
      return tMainMapper.getPost(course_key);
   }

   public Board getOnePost(String key) {
      return tMainMapper.getOnePost(key);
   }

   public void deletePost(String key) {
      tMainMapper.deletePost(key);
   }

}
