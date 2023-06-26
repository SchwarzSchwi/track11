package command.snack;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackList implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = new SnackDao();
		
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		String radio = request.getParameter("t_radio");
		
		System.out.print("select : "+select);		
		if(select == null) {
			select="id";
			search="";
		}
		ArrayList<SnackDto> dtos = dao.getSnackList(select, search, radio);
		
		request.setAttribute("t_dtos", dtos);
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		request.setAttribute("t_radio", radio);
	}

}
