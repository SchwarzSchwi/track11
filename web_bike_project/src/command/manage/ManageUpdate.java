package command.manage;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ManageDao;
import dto.ManageDto;

public class ManageUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ManageDao dao = new ManageDao();
		String msg ="수정 되었습니다.";
		
			String order_no = request.getParameter("t_order_no");
			String now_status = request.getParameter("t_now_status");
			
			ManageDto dto = new ManageDto(now_status, order_no);
			
			int result = dao.manageUpdate(dto);
			if(result != 1) msg = "수정 실패!";
			
		request.setAttribute("t_dto", dto);	
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Manage");
	}
}
