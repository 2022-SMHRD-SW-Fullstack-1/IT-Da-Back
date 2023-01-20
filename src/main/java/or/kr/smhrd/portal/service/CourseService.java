package or.kr.smhrd.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import or.kr.smhrd.portal.domain.Course;
import or.kr.smhrd.portal.mapper.CourseMapper;

@Service
public class CourseService {

    @Autowired
    public CourseMapper courseMapper;

    public void makeCourse(Course course) {
        courseMapper.makeCourse(course);
    }

    public void makeTeacher(Course course) {
        String mb_id = course.getCourse_s_dt().substring(2) + course.getCourse_teacher();
        courseMapper.makeTeacher(mb_id, course.getCourse_teacher(), course.getCourse_key());
    }

    public String selectCourse(Course course) {
        String key = courseMapper.selectCourse(course);
        System.out.println(key);
        return key;
    }

    public List<Course> selectAllCourse() {
        courseMapper.selectAllCourse();
        return courseMapper.selectAllCourse();
    }

    public List<Course> selectOnCourse() {
        return courseMapper.selectOnCourse();
    }

    public List<String> selectCourseSubject() {
        return courseMapper.selectCourseSubject();
    }

    public void editCourse(Course course) {
        System.out.println("서비스 받아온 값" + course);
        courseMapper.editCourse(course);
    }
}
