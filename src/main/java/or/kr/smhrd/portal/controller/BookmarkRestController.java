package or.kr.smhrd.portal.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Bookmark;
import or.kr.smhrd.portal.service.BookmarkService;
import or.kr.smhrd.portal.service.StudentService;

@RequiredArgsConstructor
@RequestMapping("bookmark")
@RestController
public class BookmarkRestController {

    @Autowired
    BookmarkService bookmarkService;

    private final StudentService studentService;

    @PostMapping("/add_bookmark")
    public void addCourse(@RequestBody Bookmark bookmark) {
        bookmarkService.addBookmark(bookmark);
    }

    @GetMapping("/select_bookmark")
    public HashMap<String, Object> selectBookmark(@RequestParam String enter_id){
        System.out.println("프론트에서 보내는 값");
        System.out.println(enter_id);
        HashMap<String,Object> result = new HashMap<String, Object>();
        result.put("resume", studentService.selectAllResume());
        result.put("bookmark", bookmarkService.selectBookmark(enter_id));
        return result;
    }

    @PostMapping("/delete_bookmark")
    public void deleteBookmark(@RequestBody Bookmark bookmark){
        bookmarkService.deleteBookmark(bookmark);
    }
    
}
