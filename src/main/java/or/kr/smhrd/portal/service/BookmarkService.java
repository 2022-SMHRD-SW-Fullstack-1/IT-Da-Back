package or.kr.smhrd.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import or.kr.smhrd.portal.domain.Bookmark;
import or.kr.smhrd.portal.mapper.BookmarkMapper;

@Service
public class BookmarkService {
    
    @Autowired
    BookmarkMapper bookmarkMapper;

    public void addBookmark(Bookmark bookmark){
        System.out.println(bookmark);
        bookmarkMapper.addBookmark(bookmark);
    }

    public List<String> selectBookmark(String enter_id){
        return bookmarkMapper.selectBookmark(enter_id);
    }

    public void deleteBookmark(Bookmark bookmark){
        bookmarkMapper.deleteBookmark(bookmark);
    }
}
