package or.kr.smhrd.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Member;
import or.kr.smhrd.portal.domain.Attendance;
import or.kr.smhrd.portal.domain.Consulting;
import or.kr.smhrd.portal.domain.Course;
import or.kr.smhrd.portal.service.TeacherService;

@RequiredArgsConstructor
@RequestMapping("/teacher")
@RestController
public class TeacherRestController {

    private final TeacherService teacherService;

    @PostMapping("/getStdList")
    public List<Member> getStdList(@RequestBody Map<String, String> data) {
        return teacherService.getStdList(data.get("course_key"));
    }

    @GetMapping("/getConsultingList")
    public List<Consulting> getConsultingList(@RequestParam String student) {
        return teacherService.getConsultingList(student);
    }

    @PostMapping("/updateConsulting")
    public void updateConsulting(@RequestBody Consulting data) {
        teacherService.updateConsulting(data);
    }

    @PostMapping("/addConsulting")
    public String addConsulting(@RequestBody Map<String, String> data) {
        return teacherService.addConsulting(data);
    }

    @GetMapping("/deleteConsulting")
    public void deleteConsulting(@RequestParam String seq) {
        teacherService.deleteConsulting(seq);
    }

    @PostMapping("/getCourse")
    public List<Course> getCourse(@RequestBody Map<String, String> data) {
        return teacherService.getCourse(data.get("mb_id"));
    }

    /** 선생님 리스트 반환 */
    @GetMapping("/getTeacherList")
    public List<String> getTeacherList() {
        /** 선생님 권한 */
        String job = "t";
        return teacherService.getTeacherList(job);
    }

    /** 해당 날짜의 학생 출석 정보 가져오기 */
    @PostMapping("/getAttendance")
    public List<Attendance> getAttendance(@RequestBody Map<String, String> data) {
        return teacherService.getAttendance(data.get("course_key"), data.get("today"));
    }

    @PostMapping("/setAttendance")
    public void setAttendance(@RequestBody Map<String, List<Attendance>> data) {
        teacherService.setAttendance(data.get("attInfo"));
    }
}
