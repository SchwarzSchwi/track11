package command.order;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.OrderDao;

public class OrderCancel implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		OrderDao dao = new OrderDao();
		String no = request.getParameter("t_no");
		
		int result = dao.orderCancel(no);	
		
		String msg="취소실패!";
		if(result ==1) msg = "취소되었습니다.";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Order");
	}

}
