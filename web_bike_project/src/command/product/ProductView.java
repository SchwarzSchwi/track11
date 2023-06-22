package command.product;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.ProductDao;
import dto.ProductDto;

public class ProductView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String no = request.getParameter("t_no");
		
		dao.setHitCount(no);
		ProductDto dto = dao.getProductView(no);
		
		request.setAttribute("t_dto", dto);
	}

}
