package or.kr.smhrd.portal.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Consulting;
import or.kr.smhrd.portal.domain.Member;
import or.kr.smhrd.portal.mapper.TeacherMapper;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherMapper teacherMapper;
    
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
}
