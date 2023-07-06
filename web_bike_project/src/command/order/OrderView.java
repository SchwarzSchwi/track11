package command.order;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.OrderDao;
import dto.OrderDto;

public class OrderView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		OrderDao dao = new OrderDao();
		String order_no = request.getParameter("t_no");
		
		OrderDto dto = dao.getOrderView(order_no);
		
		request.setAttribute("t_dto", dto);
	}


}
