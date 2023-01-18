package or.kr.smhrd.portal.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import or.kr.smhrd.portal.domain.Course;
import or.kr.smhrd.portal.service.CourseService;

@RequestMapping("/")
@RestController
public class CourseRestController {

    @Autowired
    public CourseService courseService;

    @PostMapping("/make_course")
    public void makeCourse(@RequestBody Course course) {
        courseService.makeCourse(course);
    }

    @GetMapping("/select_all_course")
    public List<Course> selectAllCourse() {
        List<Course> courseAllList = courseService.selectAllCourse();
        return courseAllList;
    }

    @GetMapping("/select_on_course")
    public List<Course> selectOnCourse() {
        List<Course> courseOnList = courseService.selectOnCourse();
        return courseOnList;
    }

    @GetMapping("/select_course_subject")
    public List<String> selectCourseSubject() {
        List<String> courseSubjectList = courseService.selectCourseSubject();
        return courseSubjectList;
    }

    @PostMapping("/edit_course")
    public void editCourse(Course course) {
        courseService.editCourse(course);
    }
 
}
