package command.product;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ProductSaleDao;
import dto.ProductSaleDto;

public class ProductPurchase implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductSaleDao dao = new ProductSaleDao();
		String msg ="구매되었습니다!";
		
	
			
			String order_no       = dao.getMaxNo();
			
			String serial_no      = request.getParameter("t_serial_no");
			String consumer_id    = request.getParameter("t_consumer_id");
			String payment        = request.getParameter("t_payment");
			String now_status     = "입금확인중";
			if(payment.equals("카드")) now_status = "배송준비중";
			String purchase_date  = request.getParameter("t_purchase_date");
			String post_no		  = request.getParameter("t_post_no");
			String address        = request.getParameter("t_address");
			String detail_address = request.getParameter("t_detail_address");
			int price          = Integer.parseInt(request.getParameter("t_price"));
			
			
			ProductSaleDto dto = new ProductSaleDto(order_no, now_status, serial_no, consumer_id, payment,
					purchase_date, post_no, address, detail_address, price);
			
			int result = dao.Purchase(dto);
			if(result != 1) msg = "구매 오류!";
			
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Product");

	}

}
