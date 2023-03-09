package or.kr.smhrd.portal.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Bookmark;
import or.kr.smhrd.portal.domain.Bookmark_company;
import or.kr.smhrd.portal.service.BookmarkService;
import or.kr.smhrd.portal.service.StudentService;

@RequiredArgsConstructor
@RequestMapping("bookmark")
@RestController
public class BookmarkRestController {

    @Autowired
    BookmarkService bookmarkService;

    private final StudentService studentService;
    

    //기업이 인재 북마크
    @PostMapping("/add_bookmark")
    public void addCourse(@RequestBody Bookmark bookmark) {
        bookmarkService.addBookmark(bookmark);
    }

    @GetMapping("/select_bookmark")
    public HashMap<String, Object> selectBookmark(@RequestParam HashMap<String,String> data){
        
        HashMap<String,Object> result = new HashMap<String, Object>();
       
        result.put("resume", studentService.selectAllResume());
        result.put("certification", studentService.selectAllCertification());
        result.put("bookmark", bookmarkService.selectBookmark(data.get("enter_id")));
        // result.put("portfolio",studentService.selectPortfolio(data));
        
        return result;
    }

    @PostMapping("/delete_bookmark")
    public void deleteBookmark(@RequestBody Bookmark bookmark){
        bookmarkService.deleteBookmark(bookmark);
    }

    //수료생이 기업 북마크 
    @PostMapping("/add_bookmark_company")
    public void companyBookmark(@RequestBody Bookmark_company bookmark_company) {
        System.out.println(bookmark_company);
        bookmarkService.addBookmarkCompany(bookmark_company);
    }

    @GetMapping("/select_bookmark_company")
    public HashMap<String, Object> selectBookmarkCompany(@RequestParam String mb_id){
        System.out.println("프론트에서 보내는 값");
        System.out.println(mb_id);
        HashMap<String,Object> result = new HashMap<String, Object>();
       
        result.put("bookmark_company", bookmarkService.selectBookmarkCompany(mb_id));
        
        return result;
    }


    @PostMapping("/delete_bookmark_company")
    public void deleteBookmarkCompany(@RequestBody Bookmark_company bookmark){
        bookmarkService.deleteBookmarkCompany(bookmark);
    }
}
