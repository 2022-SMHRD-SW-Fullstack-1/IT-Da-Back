package or.kr.smhrd.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.resume.Resume;
import or.kr.smhrd.portal.mapper.StudentMapper;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentMapper studentMapper;

    /** 학생 전체 이력서 조회 */
    public List<Resume> selectAllResume() {
        // HashMap<String, Object> resumeAll = new HashMap<String, Object>();
        // resumeAll.put("resume", studentMapper.selectAllResume());
        // resumeAll.put("graduation", studentMapper.selectAllGraduation());
        // resumeAll.put("career", studentMapper.selectAllCareer());
        // resumeAll.put("certification", studentMapper.selectAllCertification());
        // resumeAll.put("prize", studentMapper.selectAllPrize());
        // resumeAll.put("military", studentMapper.selectAllMilitary());

        return studentMapper.selectAllResume();
    }

    /** 특정 학생 이력서 조회 */
    public List<Object> selectResume(String id) {
        // System.out.println("서비스에 온 아이디"+id);
        List<Object> resume = new ArrayList<Object>();
        resume.add(studentMapper.selectResume(id));
        // System.out.println("select resume 값"+studentMapper.selectResume(id));
        // System.out.println("select실행 후 resume 값"+resume);
        resume.add(studentMapper.selectGraduation(id));
        // System.out.println(studentMapper.selectGraduation(id));
        resume.add(studentMapper.selectCareer(id));
        resume.add(studentMapper.selectCertification(id));
        resume.add(studentMapper.selectPrize(id));
        resume.add(studentMapper.selectMilitary(id));
        // System.out.println("프론트에 보내줄 값"+resume);
        return resume;
    }

    /**
     * 이력서 업데이트
     * resume만 update,
     * 나머지는 delete 후 insert
     */
    public void updateResume(HashMap<String, Object> params) {
        String id = (String) params.get("id");
        // System.out.println(params.get("resume").getClass().getName());

        // 인적사항
        studentMapper.updateResume(params.get("resume"), id);

        // 학력정보
        studentMapper.deleteGraduation(id);
        ArrayList<Object> graduation = (ArrayList<Object>) params.get("graduation");
        // System.out.println(graduation.size());
        for (int i = 0; i < graduation.size(); i++) {
            // System.out.println(graduation.get(i) + " " + " " + id);
            studentMapper.insertGraduation(graduation.get(i), id);
        }

        // 경력
        studentMapper.deleteCareer(id);
        ArrayList<Object> career = (ArrayList<Object>) params.get("career");
        // System.out.println(career.size());
        for (int i = 0; i < career.size(); i++) {
            // System.out.println(career.get(i) + " " + " " + id);
            studentMapper.insertCareer(career.get(i), id);
        }

        // 자격증
        studentMapper.deleteCertification(id);
        ArrayList<Object> certification = (ArrayList<Object>) params.get("certification");
        // System.out.println(certification.size());
        for (int i = 0; i < certification.size(); i++) {
            // System.out.println(certification.get(i) + " " + " " + id);
            studentMapper.insertCertification(certification.get(i), id);
        }

        // 수상
        studentMapper.deletePrize(id);
        ArrayList<Object> prize = (ArrayList<Object>) params.get("prize");
        // System.out.println(prize.size());
        for (int i = 0; i < prize.size(); i++) {
            // System.out.println(prize.get(i) + " " + " " + id);
            studentMapper.insertPrize(prize.get(i), id);
        }
        // 병역
        studentMapper.deleteMilitary(id);
        ArrayList<Object> military = (ArrayList<Object>) params.get("military");
        // System.out.println(military.size());
        for (int i = 0; i < military.size(); i++) {
            studentMapper.insertMilitary(military.get(i), id);
        }

        // 날짜 업데이트
        studentMapper.updateUpdate(id);

    }
}
