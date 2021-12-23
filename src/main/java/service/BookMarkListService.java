package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookMarkDAO;
import vo.BoardVO;

@Service
public class BookMarkListService {
	@Autowired
	private BookMarkDAO bookMarkDAO;
	
	//list조회
	public List<BoardVO> getBookMarkList() {
		List<BoardVO> bookMarkList = bookMarkDAO.selectBookMarkList();

		return bookMarkList;
	}
	
	//삭제
		public void deleteBookmark(int num) {
			bookMarkDAO.deleteBookmark(num);
		}

		public List<BoardVO> getArticleList(int startRow, int pageSize) {
			List<BoardVO> articleList = bookMarkDAO.selectArticleList(startRow, pageSize);
			return articleList;
		}

		public void registBookmark(String user_id, String name, String addr, String tel) {
	         bookMarkDAO.registBookMark(user_id, name, addr, tel);
	      }
	
}
