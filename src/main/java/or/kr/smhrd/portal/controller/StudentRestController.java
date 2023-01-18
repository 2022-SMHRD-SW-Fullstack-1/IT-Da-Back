package or.kr.smhrd.portal.controller;

import java.util.ArrayList;
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
import or.kr.smhrd.portal.domain.resume.Resume;
import or.kr.smhrd.portal.service.StudentService;

@RequiredArgsConstructor
@RequestMapping("resume")
@RestController
public class StudentRestController {

    private final StudentService studentService;


    /**학생 전체 이력서 조회 */
    @GetMapping("/all")
    public List<Resume> selectAllResume() {
        return studentService.selectAllResume();
    }
        
    /**특정 학생 이력서 조회 */
    @GetMapping("/one")
    public List<Object> selectResume(@RequestParam HashMap<String, String> params) {
        System.out.println(params);
        String id = params.get("id");
        // System.out.println("받은 id"+id);
        return studentService.selectResume(id);
    }

    /**이력서 수정 */
    @PostMapping("/update")
    public void updateResume(@RequestBody HashMap<String, Object> params){
        studentService.updateResume(params);
    }

}
