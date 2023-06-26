package command.product;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;

public class ProductDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String no = request.getParameter("t_no");
		String deleteAttach = request.getParameter("t_photos");
		
		int result = dao.productDelete(no);
		if(result == 1) {
			File file = new File(CommonUtil.getFile_dir_product(),deleteAttach);
			boolean tf = file.delete();
			if(!tf) System.out.println("제품 게시글 삭제 첨부파일 삭제 오류~");
		}
		String msg = "삭제되었습니다.";
		if(result != 1)msg = "삭제 실패!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Product");

	}

}
