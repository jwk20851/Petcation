package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardUpdateFormService;
import vo.ActionForward;
import vo.BoardVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num = Integer.parseInt(request.getParameter("num"));		//num�� string���� �޾� int�� ��ȯ
		String pageNum = request.getParameter("pageNum");
		
		BoardUpdateFormService boardUpdateFormService = new BoardUpdateFormService();
		
		BoardVO article = boardUpdateFormService.getUpdateArticle(num); 		//������ ����� �� ��������. ,num���� �� �����ϱ�. ���ڷ� ����
		request.setAttribute("article", article); //������ �����ϱ�
		request.setAttribute("pageNum", pageNum); //�� ���� ������ ���� �������� �ǵ��� �����ϱ� ������ ������������ȣ ���޿���
		
		ActionForward forward = new ActionForward();
		forward.setUrl("board/updateForm.jsp"); //���������� �������� ��������.
		
		return forward;
	}

}
