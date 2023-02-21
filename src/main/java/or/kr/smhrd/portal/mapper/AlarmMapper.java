package or.kr.smhrd.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import or.kr.smhrd.portal.domain.Alarm;

@Mapper
public interface AlarmMapper {

    @Select("select * from t_alarm where mb_id_to=#{mb_id_to} and alarm_check='N' order by alarm_dt desc")
    public List<Alarm> selectNewAlarm(String mb_id_to);

    @Select("select * from t_alarm where mb_id_to=#{mb_id_to} order by alarm_dt desc")
    public List<Alarm> selectAllAlarm(String mb_id_to);

    @Update("update t_alarm set alarm_check='Y' where alarm_num=#{alarm_num}")
    public void checkAlarm(Alarm alarm_num);

    @Delete("delete from t_alarm where alarm_num=#{alarm_num}")
    public void deleteAlarm(Alarm alarm_num);

    @Select("select count(mb_id_to) as alarm_count from t_alarm where mb_id_to = #{mb_id_to} and alarm_check = 'N' ")
    public String alarmCount(String mb_id_to);

    @Update("update t_alarm set alarm_check='Y' where alarm_check='N' and mb_id_to=#{mb_id_to}")
    public void clearNewAlarm(String mb_id_to);

    // 기업 컨택 시 학생에게 알림 보내기
    @Insert("insert into t_alarm value(null, #{mb_id_from}, #{mb_id_to}, #{alarm_content}, 'N', now())")
    public void addSAlarm(Alarm alarm);

    // 기업 컨택 시 연구원에게 알림 보내기
    @Insert("insert into t_alarm value(null, #{mb_id_from}, (select mb_id from t_member where course_key=(select course_key from t_member where mb_id=#{mb_id_to}) and mb_job='t'), #{alarm_content}, 'N', now())")
    public void addTAlarm(Alarm alarm);

    // 학생회원가입 알림
    @Insert("insert into t_alarm values(null, #{mb_id_from}, (select mb_id from t_member where course_key=UNHEX(concat(#{course_key},'000000000000000000000000')) and mb_job='t'), #{alarm_content}, 'N', now())")
    public void stdAddAlarm(String mb_id_from, String course_key, String alarm_content);

    // 기업가입알림 보내기
    @Insert("insert into t_alarm value(null, #{mb_id_from}, #{mb_id_to}, #{alarm_content}, 'N', now())")
    public void enterAddAlarm(Alarm alarm);

    // 선생님불러오기
    @Select("select mb_id from t_member where course_key = (select course_key from t_member where mb_id=#{mb_id_to}) and mb_job='t'")
    public String selectTeacher(String mb_id_to);

    // 회원가입 연구원불러오기
    @Select("select mb_id from t_member where course_key=UNHEX(concat(#{course_key},'000000000000000000000000')) and mb_job='t'")
    public String selectTeacher2(String course_key);
}
