package or.kr.smhrd.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import or.kr.smhrd.portal.domain.Board;

@Mapper
public interface TMainMapper {
   
   @Insert("insert into t_board values(default, #{title}, #{content}, '', now(), #{id}, '공지사항', UNHEX(concat(#{key},'000000000000000000000000')))")
   public void addPost(String title, String content, String id, String key);

   @Update("update t_board set b_title = #{title}, b_content = #{content} where b_num = UNHEX(concat(#{b_num},'000000000000000000000000'))")
   public void editPost(String title, String content, String b_num);

   @Select("select LEFT(HEX(b_num),8) as b_num, b_title, b_content, b_file, DATE_FORMAT(b_dt,'%Y-%m-%d'), mb_id from t_board where course_key = UNHEX(concat(#{key},'000000000000000000000000')) order by b_dt desc")
   public List<Board> getPost(String key);

   @Select("select LEFT(HEX(b_num),8) as b_num, b_title, b_content, b_file, DATE_FORMAT(b_dt,'%Y-%m-%d'), mb_id from t_board where b_num = UNHEX(concat(#{key},'000000000000000000000000'))")
   public Board getOnePost(String key);

   @Delete("delete from t_board where b_num = UNHEX(concat(#{b_num},'000000000000000000000000'))")
   public void deletePost(String key);
}
