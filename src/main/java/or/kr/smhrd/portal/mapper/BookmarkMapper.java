package or.kr.smhrd.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import or.kr.smhrd.portal.domain.Bookmark;
import or.kr.smhrd.portal.domain.Bookmark_company;

@Mapper
public interface BookmarkMapper {

    // 기업의 수강생 북마크 하기
    @Insert("insert into t_bookmark values(default, #{enter_id}, #{mb_id})")
    public void addBookmark(Bookmark bookmark);

    // 기업이 북마크한 수강생 불러오기
    @Select("select mb_id from t_bookmark where enter_id=#{enter_id}")
    public List<String> selectBookmark(String enter_id);

    // 기업의 수강생북마크 해제
    @Delete("delete from t_bookmark where enter_id=#{enter_id} and mb_id=#{mb_id}")
    public void deleteBookmark(Bookmark bookmark);
    
    // 수강생의 기업공고 북마크
    @Insert("insert into t_bookmark_company values(default, #{company_num}, #{mb_id})")
    public void addBookmarkCompany(Bookmark_company bookmark_company);

    // 기업공고가 북마크 된 수
    @Select("select company_num from t_bookmark_company where mb_id=#{mb_id}")
    public List<String> selectBookmarkCompany(String mb_id);

    // 수강생의 기업공구 북마크 해제
    @Delete("delete from t_bookmark_company where company_num=#{company_num} and mb_id=#{mb_id}")
    public void deleteBookmarkCompany(Bookmark_company bookmark_company);
    
    @Select("select tc.company_name, COUNT(tb.company_num) from t_company tc left outer join t_bookmark_company tb on tb.company_num = tc.company_num group by tc.company_num , tb.company_num")
    public List<Bookmark_company> bookmarkCount();
}
