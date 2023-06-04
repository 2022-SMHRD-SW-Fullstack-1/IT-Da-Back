package or.kr.smhrd.portal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Extend;
import or.kr.smhrd.portal.domain.Portfolio;
import or.kr.smhrd.portal.domain.resume.CoverLetter;
import or.kr.smhrd.portal.domain.resume.Resume;
import or.kr.smhrd.portal.service.StudentService;

@RequiredArgsConstructor
@RequestMapping("/student")
@RestController
public class StudentRestController {

    private final StudentService studentService;

    /** 학생 전체 이력서 조회 */
    @GetMapping("/resume/all")
    public List<Resume> selectAllResume() {
        return studentService.selectAllResume();
    }

    /** 특정 학생 이력서 조회 */
    @GetMapping("/resume/one")
    public List<Object> selectResume(@RequestParam HashMap<String, String> params) {
        System.out.println(params);
        String id = params.get("id");
        // System.out.println("받은 id"+id);
        return studentService.selectResume(id);
    }

    /** 학생 전체 자소서 조회 */
    @GetMapping("/cover_letter/all")
    public List<CoverLetter> selectAllCoverLetter() {
        return studentService.selectAllCoverLetter();
    }

    /** 특정 학생 자소서 조회 */
    @GetMapping("/cover_letter/one")
    public CoverLetter selectCoverLetter(@RequestParam HashMap<String, String> params) {
        System.out.println(params);
        String id = params.get("id");
        // System.out.println("받은 id"+id);
        return studentService.selectCoverLetter(id);
    }

    /** 자소서 수정 */
    @PostMapping("/cover_letter/update")
    public void updateCoverLetter(@RequestBody Map<String, String> data) {
        System.out.println(data);
        studentService.updateCoverLetter(data);
    }

    /** 이력서 수정 */
    @PostMapping("/resume/update")
    public void updateResume(@RequestBody Map<String, String> data) {
        System.out.println(data);
        studentService.updateResume(data);
    }

    /** 희망분야 */
    @PostMapping("/wish_field/add")
    public void addWishField(@RequestBody Map<String, String> data) {
        studentService.addWishField(data);
    }

    @PostMapping("/wish_field/delete")
    public void deleteWishField(@RequestBody Map<String, String> data) {
        studentService.deleteWishField(data);
    }

    @PostMapping("/wish_field/update")
    public void updateWishField(@RequestBody Map<String, Object> data) {
        studentService.updateWishField(data);
    }

    /** 보유기술 */
    @PostMapping("/skill/add")
    public void addSkill(@RequestBody Map<String, String> data) {
        studentService.addSkill(data);
    }

    @PostMapping("/skill/delete")
    public void deleteSkill(@RequestBody Map<String, String> data) {
        System.out.println("삭제");
        System.out.println(data);
        studentService.deleteSkill(data);
    }

    @PostMapping("/skill/update")
    public void updateSkill(@RequestBody Map<String, Object> data) {
        studentService.updateSkill(data);
    }

    // 이력서 이미지 추가 삭제
    @PostMapping("/photo/update")
    public void updatePhoto(@RequestBody Map<String, String> data) {
        System.out.println(data);
        studentService.updatePhoto(data);
    }

    @PostMapping("/photo/delete")
    public void deletePhoto(@RequestBody Map<String, String> data) {
        System.out.println(data);
        studentService.deletePhoto(data);
    }

    // 프로젝트 포트폴리오
    // 확인
    @GetMapping("/portfolio")
    public List<Portfolio> selectPortfolio(@RequestParam HashMap<String, String> params) {
        return studentService.selectPortfolio(params);
    }

    @GetMapping("/portfolio/selectOne")
    public Portfolio selectOnePortfolio(@RequestParam HashMap<String, String> params) {
        return studentService.selectOnePortfolio(params);
    }

    // 추가
    @PostMapping("/portfolio/add")
    public void addPortfolio(@RequestBody Map<String, String> data) {
        studentService.addPortfolio(data);
    }

    // 수정
    @PostMapping("/portfolio/edit")
    public void editPortfolio(@RequestBody Map<String, String> data) {
        studentService.editPortfolio(data);
    }

    // 삭제
    @PostMapping("/portfolio/delete")
    public void deletePortfolio(@RequestBody Map<String, String> data) {
        studentService.deletePortfolio(data);
    }

    /** 학력 */
    // 추가
    @PostMapping("/graduation/add")
    public void addGraduation(@RequestBody Map<String, String> data) {
        System.out.println(data);
        studentService.addGraduation(data);
    }

    // 삭제
    @PostMapping("/graduation/delete")
    public void deleteGraduation(@RequestBody Map<String, String> data) {
        System.out.println("제거");
        System.out.println("내용" + data);
        studentService.deleteGraduation(data);
    }

    // 인덱싱 - frontend 드로그앤드롭을 하기 위함
    @PostMapping("/graduation/idx")
    public void graduationIdx(@RequestBody Map<String, Object> data) {
        studentService.graduationIdx(data);
    }

    /** 경력 */
    // 추가
    @PostMapping("/career/add")
    public void addCareer(@RequestBody Map<String, String> data) {
        studentService.addCareer(data);
    }

    // 삭제
    @PostMapping("/career/delete")
    public void deleteCareer(@RequestBody Map<String, String> data) {
        System.out.println("제거");
        System.out.println("내용" + data);
        studentService.deleteCareer(data);
    }

    // 인덱싱 - frontend 드로그앤드롭을 하기 위함
    @PostMapping("/career/idx")
    public void careerIdx(@RequestBody Map<String, Object> data) {
        studentService.careerIdx(data);
    }

    /** 자격증 */
    // 추가
    @PostMapping("/certification/add")
    public void addCertification(@RequestBody Map<String, String> data) {
        studentService.addCertification(data);
    }

    // 삭제
    @PostMapping("/certification/delete")
    public void deleteCertification(@RequestBody Map<String, String> data) {
        System.out.println("제거");
        System.out.println("내용" + data);
        studentService.deleteCertification(data);
    }

    // 인덱싱 - frontend 드로그앤드롭을 하기 위함
    @PostMapping("/certification/idx")
    public void certificationIdx(@RequestBody Map<String, Object> data) {
        studentService.certificationIdx(data);
    }

    /** 수상 */
    // 추가
    @PostMapping("/prize/add")
    public void addPrize(@RequestBody Map<String, String> data) {
        studentService.addPrize(data);
    }

    // 삭제
    @PostMapping("/prize/delete")
    public void deletePrize(@RequestBody Map<String, String> data) {
        System.out.println("제거");
        System.out.println("내용" + data);
        studentService.deletePrize(data);
    }

    // 인덱싱 - frontend 드로그앤드롭을 하기 위함
    @PostMapping("/prize/idx")
    public void prizeIdx(@RequestBody Map<String, Object> data) {
        studentService.prizeIdx(data);
    }

    /** 병역 */
    // 추가
    @PostMapping("/military/add")
    public void addMilitary(@RequestBody Map<String, String> data) {
        studentService.addMilitary(data);
    }

    // 삭제
    @PostMapping("/military/delete")
    public void deleteMilitary(@RequestBody Map<String, String> data) {
        System.out.println("제거");
        System.out.println("내용" + data);
        studentService.deleteMilitary(data);
    }

    // 인덱싱 - frontend 드로그앤드롭을 하기 위함
    @PostMapping("/military/idx")
    public void militaryIdx(@RequestBody Map<String, Object> data) {
        studentService.militaryIdx(data);
    }

    /** 연장사용 신청 */
    // 추가
    @PostMapping("/register_extend")
    public void addExtend(@RequestBody Extend extend) {
        studentService.addExtend(extend);
    }

    // 불러오기
    @GetMapping("/select_extend")
    public List<Extend> selectExtend(@RequestParam String b_num) {
        return studentService.selectExtend(b_num);
    }

    // 수정
    @PostMapping("/edit_extend")
    public void editExtend(@RequestBody Extend extend) {
        studentService.editExtend(extend);
    }

    // 삭제
    @PostMapping("/delete_extend")
    public void deleteExtend(@RequestBody Extend extend) {
        studentService.deleteExtend(extend);
    }
}
