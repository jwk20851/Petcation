package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;
import vo.ReplyVO;

public class BoardWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//���� �ۼ��ϴ� ȭ�鿡���� ������ �ۼ��� ���� �ְ�, �亯���� �ۼ��� ���� �ִ�.
		//�ۼ��ϴ� ���� �亯���϶��� �亯�ۿ� �ʿ��� ������ �Ķ���� ������ �Ѿ��
		
		int num = 0;
		if(request.getParameter("num") != null) {
			//�亯���̸� ... 	�Ѿ�´�.
			num = Integer.parseInt(request.getParameter("num"));

		}
		
		//������
		//�ۼ��ұ��� �亯������ ������ �����ϰ� ������
		ReplyVO replyVO = new ReplyVO();		//vo�� ���� class����
		replyVO.setNum(num);

		
		request.setAttribute("replyVO", replyVO);
				
		ActionForward forward = new ActionForward();
		forward.setUrl("board/writeForm.jsp");
		
		return forward;
	}

}
