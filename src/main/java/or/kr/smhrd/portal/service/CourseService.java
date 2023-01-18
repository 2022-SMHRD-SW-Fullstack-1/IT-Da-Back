package or.kr.smhrd.portal.service;

import java.util.HashMap;
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
        String id = course.getCourse_s_dt().substring(2) + course.getCourse_teacher();
        courseMapper.makeTeacher(id, course.getCourse_teacher());
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
        courseMapper.editCourse(course);
    }

   
}
