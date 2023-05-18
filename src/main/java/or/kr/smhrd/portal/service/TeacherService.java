package or.kr.smhrd.portal.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Attendance;
import or.kr.smhrd.portal.domain.Consulting;
import or.kr.smhrd.portal.domain.Course;
import or.kr.smhrd.portal.domain.Member;
import or.kr.smhrd.portal.domain.StudentInfo;
import or.kr.smhrd.portal.mapper.MemberMapper;
import or.kr.smhrd.portal.mapper.TeacherMapper;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherMapper teacherMapper;
    private final MemberMapper memberMapper;

    public List<Member> getStdList(String course_key) {
        return teacherMapper.getStdList(course_key);
    }

    public List<Consulting> getConsultingList(String mb_id) {
        return teacherMapper.getConsultingList(mb_id);
    }

    public void updateConsulting(Consulting data) {
        teacherMapper.updateConsulting(data);
    }

    public String addConsulting(Map<String, String> data) {
        teacherMapper.addConsulting(data);
        return teacherMapper.getSeq(data);
    }

    public void deleteConsulting(String seq) {
        teacherMapper.deleteConsulting(seq);
    }

    public List<Course> getCourse(String mb_id) {
        return teacherMapper.getCourse(mb_id);
    }

    public List<String> getTeacherList(String job) {
        return teacherMapper.getTeacherList(job);
    }

    public List<Attendance> getAttendance(String course_key, String today) {
        // 해당 course의 학생 리스트를 가져옴
        List<StudentInfo> stdList = memberMapper.getStudentInfo(course_key);
        // 해당 날짜의 출석 데이터가 없을 시 생성함
        if (teacherMapper.isValueExist(course_key, today) == 0)
            for (StudentInfo data : stdList)
                teacherMapper.setAttendance(data.getId(), course_key, today);
        // 출석 데이터 가져오기
        return teacherMapper.getAttendance(course_key, today);
    }

    public void setAttendance(List<Attendance> data) {
        for (Attendance tmp : data)
            teacherMapper.updateAttendance(tmp.getSeq(), tmp.getAtt_check());
    }
}
