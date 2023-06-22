package command.product;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class ProductSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String productDir = CommonUtil.getFile_dir_product();
		int maxSize = 1024 * 1024 * 5;
		String msg ="등록 되었습니다.";
		
		MultipartRequest mpr = null;
		try {
			mpr = new MultipartRequest(request, productDir,
										maxSize,"utf-8",
										new DefaultFileRenamePolicy());
			String no 		= dao.getMaxNo();
			String photos 	= mpr.getFilesystemName("t_photos");
			String serial_no 	= mpr.getParameter("t_serial_no");
			String content  = mpr.getParameter("t_content");
			String priority = mpr.getParameter("t_priority");
			String name  = mpr.getParameter("t_name");
			String huge   = mpr.getParameter("t_huge");
			String price   = mpr.getParameter("t_price");
			String reg_date = CommonUtil.getToday();
			HttpSession session = request.getSession();
			String registrant   = (String)session.getAttribute("sessionId");
			
			ProductDto dto = new ProductDto(no, serial_no, name, photos, content, priority, huge, price, reg_date, registrant);
			int result = dao.productSave(dto);
			if(result != 1) msg ="등록 실패!";		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Product");

	}

}
