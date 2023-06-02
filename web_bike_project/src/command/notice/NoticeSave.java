package command.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExecute;
import common.CommonUtil;

public class NoticeSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		int maxSize = 1024 * 1024 * 10;
		try {
			MultipartRequest mpr = new MultipartRequest(request,CommonUtil.getFile_dir_notice(), maxSize,
					"utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
