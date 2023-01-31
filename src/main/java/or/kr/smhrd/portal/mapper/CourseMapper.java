package or.kr.smhrd.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import or.kr.smhrd.portal.domain.Course;

@Mapper
public interface CourseMapper {

    // 과정생성
    @Insert("insert into t_course values(default, #{course_subject}, #{course_name}, #{course_campus}, #{course_s_dt}, #{course_e_dt}, #{course_teacher}, #{course_limit})")
    public void makeCourse(Course course);

    // 담임생성
    @Insert("insert into t_member values(#{mb_id} ,'1234', #{mb_name}, 't', 'birth', 'phone', 'address', 'n', '20991231', UNHEX(concat(#{course_key},'000000000000000000000000')), now())")
    public void makeTeacher(String mb_id, String mb_name, String course_key);

    // 과정찾기
    @Select("select LEFT(HEX(course_key),8) as course_key from t_course where course_teacher=#{course_teacher} and course_s_dt=#{course_s_dt}")
    public String selectCourse(Course course);

    // 전체과정
    @Select("select course_subject, course_name, course_campus, course_s_dt, course_e_dt, course_teacher, course_limit,  LEFT(HEX(course_key),8) as course_key from t_course")
    public List<Course> selectAllCourse();

    // 진행중인과정
    @Select("select course_subject, course_name, course_campus, course_s_dt, course_e_dt, course_teacher, course_limit,  LEFT(HEX(course_key),8) as course_key from t_course where course_e_dt>DATE_FORMAT(now(), '%Y%m%d')")
    public List<Course> selectOnCourse();

    // 전체과정주제리스트
    @Select("select course_subject from t_course")
    public List<String> selectCourseSubject();

    // 과정수정
    @Update("update t_course set course_subject=#{course_subject}, course_name=#{course_name}, course_campus=#{course_campus}, course_s_dt=#{course_s_dt}, course_e_dt=#{course_e_dt}, course_limit=#{course_limit} where course_key= UNHEX(concat(#{course_key},'000000000000000000000000'))")
    public void editCourse(Course course);
}
