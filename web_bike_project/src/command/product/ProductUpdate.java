package command.product;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class ProductUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String productDir = CommonUtil.getFile_dir_product();
		int maxSize = 1024 * 1024 * 5;
		String msg ="수정 되었습니다.";
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, productDir, maxSize,"utf-8", new DefaultFileRenamePolicy());
			
			String no = mpr.getParameter("t_no");
			String photos 	  = mpr.getFilesystemName("t_photos");
			String serial_no  = mpr.getParameter("t_serial_no");
			String name  = mpr.getParameter("t_name");
			String content     = mpr.getParameter("t_content");
			String ori_photos = mpr.getParameter("t_ori_photos");
			if(photos == null) {
				photos = ori_photos;
			} else {
				File file = new File(productDir, ori_photos);
				file.delete();
			}
			String priority = mpr.getParameter("t_priority");
			String huge   = mpr.getParameter("t_huge");
			String price   = mpr.getParameter("t_price");
			
			
			ProductDto dto = new ProductDto(no, serial_no, name, photos, content, priority, huge, price);
			
			int result = dao.productUpdate(dto);
			if(result != 1) msg = "수정 실패!";
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Product");
	}

}
