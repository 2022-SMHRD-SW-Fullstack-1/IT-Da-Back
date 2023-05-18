package or.kr.smhrd.portal.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import or.kr.smhrd.portal.domain.Attendance;
import or.kr.smhrd.portal.domain.Consulting;
import or.kr.smhrd.portal.domain.Course;
import or.kr.smhrd.portal.domain.Member;

@Mapper
public interface TeacherMapper {

    @Select("select * from t_member where course_key = UNHEX(concat(#{key},'000000000000000000000000')) and mb_job = 's'")
    public List<Member> getStdList(String course_key);

    @Select("select * from t_consulting where student = #{mb_id}")
    public List<Consulting> getConsultingList(String mb_id);

    @Update("update t_consulting set title = #{title}, content = #{content}, date = #{date} where seq = #{seq}")
    public void updateConsulting(Consulting data);

    @Insert("insert into t_consulting values(default, #{teacher}, #{student}, #{content}, #{title}, #{date})")
    public void addConsulting(Map<String, String> data);

    @Select("select seq from t_consulting where teacher = #{teacher} and student = #{student} and content = #{content} and title = #{title} and date = #{date}")
    public String getSeq(Map<String, String> data);

    @Delete("delete from t_consulting where seq = #{seq}")
    public void deleteConsulting(String seq);

    @Select("select tc.course_subject as course_subject, tc.course_name as course_name, tc.course_campus as course_campus, tc.course_s_dt as course_s_dt, tc.course_e_dt as course_e_dt, tc.course_limit as course_limit,  LEFT(HEX(tc.course_key),8) as course_key from t_teacher_course ttc left join t_course tc on ttc.course_key = tc.course_key where mb_id = #{mb_id}")
    public List<Course> getCourse(String mb_id);

    //
    @Select("select mb_name from t_member where mb_job = #{job}")
    public List<String> getTeacherList(String job);

    @Select("select ta.seq as seq, ta.mb_id as mb_id, tm.mb_name as mb_name, tm.mb_birthdate as mb_birthdate, tm.mb_gender as mb_gender, ta.att_check as att_check from t_attendance ta left join t_member tm on ta.mb_id = tm.mb_id where ta.course_key = UNHEX(concat(#{course_key},'000000000000000000000000')) and ta.att_dt = #{date}")
    public List<Attendance> getAttendance(String course_key, String date);

    @Select("select count(*) from t_attendance where course_key = UNHEX(concat(#{course_key},'000000000000000000000000')) and att_dt = #{date}")
    public int isValueExist(String course_key, String date);

    @Insert("insert into t_attendance values(null, #{mb_id}, UNHEX(concat(#{course_key},'000000000000000000000000')), 'n', #{date})")
    public void setAttendance(String mb_id, String course_key, String date);

    @Update("update t_attendance set att_check = #{att_check} where seq = #{seq}")
    public void updateAttendance(int seq, String att_check);

    @Select("select mb_id from t_member where course_key = UNHEX(concat(#{course_key},'000000000000000000000000'))")
    public List<String> getStudentList(String course_key);
}
