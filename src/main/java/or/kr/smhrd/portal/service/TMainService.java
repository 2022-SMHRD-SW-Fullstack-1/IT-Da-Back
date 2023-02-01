package or.kr.smhrd.portal.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.mapper.TMainMapper;
import or.kr.smhrd.portal.domain.Board;
import or.kr.smhrd.portal.domain.Course;
import or.kr.smhrd.portal.domain.Extend;
import or.kr.smhrd.portal.domain.Schedule;

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

   public void addArchive(Map<String, String> data) {
      tMainMapper.addArchive(data.get("title"), data.get("content"), data.get("id"), data.get("key"));
   }

   public void editArchive(Map<String, String> data) {
      tMainMapper.editArchive(data.get("title"), data.get("content"), data.get("b_num"));
   }

   public List<Board> getArchive(String course_key) {
      return tMainMapper.getArchive(course_key);
   }

   public Board getOneArchive(String key) {
      return tMainMapper.getOneArchive(key);
   }

   public void deleteArchive(String key) {
      tMainMapper.deleteArchive(key);
   }

   public String getCourseInfo(String key) {
      Course course = tMainMapper.getCourseInfo(key);
      return "[" + course.getCourse_subject() + "] " + course.getCourse_name() + " ("
            + course.getCourse_s_dt().substring(2, 4) + "." + course.getCourse_s_dt().substring(4, 6) + "."
            + course.getCourse_s_dt().substring(6) + " ~ " + course.getCourse_e_dt().substring(2, 4) + "."
            + course.getCourse_e_dt().substring(4, 6) + "." + course.getCourse_e_dt().substring(6) + " / "
            + course.getCourse_teacher() + " 연구원)";
   }

   // 전체공지
   public void managerAnnouncementWrite(Board board) {
      tMainMapper.managerAnnouncementWrite(board);
   }

   public List<Board> getManagerPost(String key) {
      return tMainMapper.getManagerPost(key);
   }

   // 연장사용
   public void writeExtend(Map<String, String> data) {
      tMainMapper.writeExtend(data.get("b_title"), data.get("b_content"), data.get("mb_id"), data.get("course_key"));
   }

   public List<Board> getExtend(String key) {
      return tMainMapper.getExtend(key);
   }

   public Board getOneExtend(String key) {
      return tMainMapper.getOneExtend(key);
   }

   // 일정 관련
   public void addSchedule(Map<String, String> data) {
      tMainMapper.addSchedule(data);
   }

   public List<Schedule> getSchedule(Map<String, String> data) {
      return tMainMapper.getSchedule(data.get("course_key"));
   }

   public void deleteSchedule(String sche_num) {
      tMainMapper.deleteSchedule(sche_num);
   }
}
