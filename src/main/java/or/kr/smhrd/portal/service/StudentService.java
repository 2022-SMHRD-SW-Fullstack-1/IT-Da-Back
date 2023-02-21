package or.kr.smhrd.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Extend;
import or.kr.smhrd.portal.domain.Portfolio;
import or.kr.smhrd.portal.domain.resume.Certification;
import or.kr.smhrd.portal.domain.resume.CoverLetter;
import or.kr.smhrd.portal.domain.resume.Resume;
import or.kr.smhrd.portal.mapper.StudentMapper;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentMapper studentMapper;

    /** 학생 전체 이력서 조회 */
    public List<Resume> selectAllResume() {
        return studentMapper.selectAllResume();
    }

    /** 자격증 가져오기 */
    public List<Certification> selectAllCertification() {
        return studentMapper.selectAllCertification();
    }

    /** 특정 학생 이력서 조회 */
    public List<Object> selectResume(String id) {
        // System.out.println("서비스에 온 아이디"+id);
        List<Object> resume = new ArrayList<Object>();
        resume.add(studentMapper.selectResume(id));
        System.out.println("select resume 값"+studentMapper.selectResume(id));
        // System.out.println("select실행 후 resume 값"+resume);
        resume.add(studentMapper.selectGraduation(id));
        // System.out.println(studentMapper.selectGraduation(id));
        resume.add(studentMapper.selectCareer(id));
        resume.add(studentMapper.selectCertification(id));
        resume.add(studentMapper.selectPrize(id));
        resume.add(studentMapper.selectMilitary(id));
        resume.add(studentMapper.selectSkill(id));
        resume.add(studentMapper.selectCoverLetter(id));
        resume.add(studentMapper.selectWishField(id));
        // System.out.println("프론트에 보내줄 값"+resume);
        return resume;
    }

    /**
     * 이력서 업데이트
     * resume만 update,
     * 나머지는 delete 후 insert
     */
    public void updateResume(Map<String, String> data) {
        studentMapper.updateResume(data);
        // 날짜 업데이트
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));

    }

    /** 학력 추가 */
    public void addGraduation(Map<String, String> data) {
        studentMapper.addGraduation(data);
        // 날짜 업데이트
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    /** 경력추가 */
    public void addCareer(Map<String, String> data) {
        studentMapper.addCareer(data);
        // 날짜 업데이트
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    /** 자격증 추가 */
    public void addCertification(Map<String, String> data) {
        studentMapper.addCertification(data);
        // 날짜 업데이트
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    /** 수상 추가 */
    public void addPrize(Map<String, String> data) {
        studentMapper.addPrize(data);
        System.out.println(data);
        // 날짜 업데이트
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    /** 병역 추가 */
    public void addMilitary(Map<String, String> data) {
        studentMapper.addMilitary(data);
        // 날짜 업데이트
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    /** 학력 제거 */
    public void deleteGraduation(Map<String, String> data) {
        studentMapper.deleteGraduation(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    /** 경력 제거 */
    public void deleteCareer(Map<String, String> data) {
        studentMapper.deleteCareer(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    /** 자격증 제거 */
    public void deleteCertification(Map<String, String> data) {
        studentMapper.deleteCertification(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    /** 수상 제거 */
    public void deletePrize(Map<String, String> data) {
        System.out.println(data);
        studentMapper.deletePrize(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    /** 병역 제거 */
    public void deleteMilitary(Map<String, String> data) {
        studentMapper.deleteMilitary(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    public List<CoverLetter> selectAllCoverLetter() {
        return studentMapper.selectAllCoverLetter();
    }

    public CoverLetter selectCoverLetter(String id) {
        return studentMapper.selectCoverLetter(id);
    }

    public void updateCoverLetter(Map<String, String> data) {
        studentMapper.updateCoverLetter(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    public void updatePhoto(Map<String, String> data) {
        studentMapper.updatePhoto(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    public void deletePhoto(Map<String, String> data) {
        studentMapper.deletePhoto(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }
    public List<Portfolio> selectPortfolio(HashMap<String, String> params) {
        return studentMapper.selectPortfolio(params.get("id"));
    }

    public void addPortfolio(Map<String, String> data) {
        studentMapper.addPortfolio(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    public void editPortfolio(Map<String, String> data) {
        studentMapper.editPortfolio(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    public void deletePortfolio(Map<String, String> data) {
        studentMapper.deletePortfolio(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    public Portfolio selectOnePortfolio(HashMap<String, String> params) {
        return studentMapper.selectOnePortfolio(params.get("portfolio_num"));
    }
    
    public void addExtend(Extend extend) {
        studentMapper.addExtend(extend);
    }

    public List<Extend> selectExtend(String b_num) {
        return studentMapper.selectExtend(b_num);
    }

    public void editExtend(Extend extend) {
        studentMapper.editExtend(extend);
    }

    public void deleteExtend(Extend extend) {
        studentMapper.deleteExtend(extend);
    }

    /**희망 분야 */
    public void addWishField(Map<String, String> data) {
        studentMapper.addWishField(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    public void deleteWishField(Map<String, String> data) {
        studentMapper.deleteWishField(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    /**기술 스택 */
    public void addSkill(Map<String, String> data) {
        studentMapper.addSkill(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    public void deleteSkill(Map<String, String> data) {
        studentMapper.deleteSkill(data);
        studentMapper.updateUpdate(data.get("id"));
        studentMapper.updateUpdateR(data.get("id"));
    }

    public void careerIdx(Map<String, Object> data) {
        ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) data.get("career");
        int idx =0;
        for(Map<String,String> map : list){
            studentMapper.careerIdx(map,idx++,(String)data.get("id"));
        }
    }

    public void certificationIdx(Map<String, Object> data) {
        ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) data.get("certification");
        int idx =0;
        for(Map<String,String> map : list){
            studentMapper.certificationIdx(map,idx++,(String)data.get("id"));
        }
    }

    public void graduationIdx(Map<String, Object> data) {
        ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) data.get("graduation");
        int idx =0;
        for(Map<String,String> map : list){
            studentMapper.graduationIdx(map,idx++,(String)data.get("id"));
        }
    }

    public void militaryIdx(Map<String, Object> data) {
        ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) data.get("military");
        int idx =0;
        for(Map<String,String> map : list){
            studentMapper.militaryIdx(map,idx++,(String)data.get("id"));
        }
    }

    public void prizeIdx(Map<String, Object> data) {
        ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) data.get("prize");
        int idx =0;
        for(Map<String,String> map : list){
            studentMapper.prizeIdx(map,idx++,(String)data.get("id"));
        }
    }

    public void updateSkill(Map<String, Object> data) {
        ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) data.get("skill");
        System.out.println(list);
        String id = (String) data.get("id");
        String skill = "";
        for(Map<String,String> map : list){
            skill+=map.get("skill_name");
            skill+=",";
        }
        studentMapper.updateSkill(id,skill);
        studentMapper.updateUpdate(id);
        studentMapper.updateUpdateR(id);
    }

    public void updateWishField(Map<String, Object> data) {
        ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) data.get("wish_field");
        System.out.println(list);
        String id = (String) data.get("id");
        String wish_field = "";
        for(Map<String,String> map : list){
            // studentMapper.prizeIdx(map,idx++,(String)data.get("id"));
            wish_field+=map.get("wish_field_name");
            wish_field+=",";
        }
        studentMapper.updateWishField(id,wish_field);
        studentMapper.updateUpdate(id);
        studentMapper.updateUpdateR(id);
    }

}
