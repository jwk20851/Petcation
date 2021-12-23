package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardListService;
import vo.ActionForward;
import vo.BoardVO;
import vo.PageVO;

public class ViewReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageSize = 10; 		//���������� ��µǴ� ���� ����
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {			//QnA�������϶� �ȳѾ� ���⶧���� ������ ��ȣ �ҿ����.
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		//�ϴܿ��� ��������ȣ�� �����ؼ� ����¡ó���� �Ҷ�
		//������ ����� �ǵ��� ���� Ÿ������ ����
		int startRow = (currentPage - 1) * pageSize + 1;
		//�ش� �������� ��µǴ� ù��° ���ڵ��� ��ȣ
		//���������� : 1
		//startRow : (1 - 1) * 10 + 1 ===> 1
		//���������� : 2
		//startRow : (2 - 1) * 10 + 1 ===> 11
		
		int count = 0;		//�� ���� ����
		int number = 0;		//�ش� �������� ù��°�� ��µǴ� ���� ��ȣ
		
		BoardListService boardListService = new BoardListService();			// controller ���� �Ѿ�� 2. �����ڵ� �ۼ��� BoardListService �����. service�� �̵�
		List<BoardVO> articleList = null;
		count = boardListService.getArticleCount();		//4.�ۼ��� BoardListService�� �̵�.
		
		if(count > 0) {
			articleList = boardListService.getArticleList(startRow, pageSize);			//7.getArticleList���鷯 BoardListService ���� �̵�
		}
		
		
		number = count - (currentPage - 1) * pageSize;				//10. DAO���� �Ѿ�� ������ �ۼ�.
		//��ü���� ���� : 132
		//���� ������ : 1
		//ù��°���� ��ȣ : 132 - (1 - 1) * 10 : 132
		//��ü���� ���� : 132
		//���� ������ : 2
		//ù��°���� ��ȣ : 132 - (2 - 1) * 10 : 122
		
		//����¡ó��
		int pageCount = 0;		//�� �������� ����
		int startPage = 0;		//���� ������ �׷쿡�� ù ������ ��ȣ
		int endPage = 0;
		
		if(count > 0) {
			pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			//�� : 132
			
			startPage = (int)((currentPage - 1)/ 10) * 10 + 1;
			//���� ������ 1 (1 - 1) / 10 * 10 + 1 : 1
			//���� ������ 7 (7 - 1) / 10 * 10 + 1 : 1
			
			endPage = startPage + 9;
			
			//������ ������ �׷��϶�
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		request.setAttribute("articleList", articleList);
		PageVO pageVO = new PageVO();			//11.vo�� �ۼ��Ϸ� ��.
		
		pageVO.setCount(count);					//13. vo���� ������ �� ����.
		pageVO.setCurrentPage(currentPage);
		pageVO.setEndPage(endPage);
		pageVO.setNumber(number);
		pageVO.setPageCount(pageCount);
		pageVO.setStartPage(startPage);
		
		request.setAttribute("pageVO", pageVO);
		ActionForward forward = new ActionForward();
		forward.setUrl("board/viewReseveList.jsp");		//14. �������� ������ jsp���� �ۼ��ϱ�.
		
		return forward;
	}

}
