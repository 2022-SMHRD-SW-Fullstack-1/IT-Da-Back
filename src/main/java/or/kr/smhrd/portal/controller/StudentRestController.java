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
    
    // 이미지 추가 삭제
    @PostMapping("/student/photo/update")
    public void updatePhoto(@RequestBody Map<String, String> data){
        System.out.println(data);
        studentService.updatePhoto(data);
    }
    @PostMapping("/student/photo/delete")
    public void deletePhoto(@RequestBody Map<String, String> data){
        System.out.println(data);
        studentService.deletePhoto(data);
    }

    // 추가
    /** 학력 추가 */
    @PostMapping("/graduation/add")
    public void addGraduation(@RequestBody Map<String, String> data) {
        System.out.println(data);
        studentService.addGraduation(data);
    }

    /** 경력 추가 */
    @PostMapping("/career/add")
    public void addCareer(@RequestBody Map<String, String> data) {
        studentService.addCareer(data);
    }

    /** 자격증 추가 */
    @PostMapping("/certification/add")
    public void addCertification(@RequestBody Map<String, String> data) {
        studentService.addCertification(data);
    }

    /** 수상 추가 */
    @PostMapping("/prize/add")
    public void addPrize(@RequestBody Map<String, String> data) {
        studentService.addPrize(data);
    }

    /** 병역 추가 */
    @PostMapping("/military/add")
    public void addMilitary(@RequestBody Map<String, String> data) {
        studentService.addMilitary(data);
    }

    // 삭제
    /** 학력 제거 */
    @PostMapping("/graduation/delete")
    public void deleteGraduation(@RequestBody Map<String, String> data) {
        System.out.println("제거");
        System.out.println("내용" + data);
        studentService.deleteGraduation(data);
    }

    /** 경력 제거 */
    @PostMapping("/career/delete")
    public void deleteCareer(@RequestBody Map<String, String> data) {
        System.out.println("제거");
        System.out.println("내용" + data);
        studentService.deleteCareer(data);
    }

    /** 자격증 제거 */
    @PostMapping("/certification/delete")
    public void deleteCertification(@RequestBody Map<String, String> data) {
        System.out.println("제거");
        System.out.println("내용" + data);
        studentService.deleteCertification(data);
    }

    /** 수상 제거 */
    @PostMapping("/prize/delete")
    public void deletePrize(@RequestBody Map<String, String> data) {
        System.out.println("제거");
        System.out.println("내용" + data);
        studentService.deletePrize(data);
    }

    /** 병역 제거 */
    @PostMapping("/military/delete")
    public void deleteMilitary(@RequestBody Map<String, String> data) {
        System.out.println("제거");
        System.out.println("내용" + data);
        studentService.deleteMilitary(data);
    }

}
