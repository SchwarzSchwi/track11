package command.etc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import common.CommonUtil;
import dao.EtcDao;
import dto.EtcDto;

/**
 * Servlet implementation class EtcList
 */
@WebServlet("/EtcList")
public class EtcList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtcList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession ss = request.getSession();
		EtcDao dao = new EtcDao();
		
		JSONObject fobj = new JSONObject();
		
		JSONArray jarr = new JSONArray();
		JSONObject jsub = new JSONObject();
		HashMap<String, Object> hM = new HashMap<String, Object>();
		
		String search = request.getParameter("t_search");
		if(search == null || search.equals("undefined")) search = "";
		
		fobj.put("t_search", search);
		
		int total_count = dao.totalCountDB(search);
		int total_count_viewer = dao.totalCountViewDB(search);
		fobj.put("t_total_count", total_count_viewer);
		int list_setup_count = 500;  //한페이지당 출력 행수 
		int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
		
		int current_page = 0; // 현재페이지 번호
		int total_page = 0;    // 전체 페이지 수
		
		String nowPage = request.getParameter("t_nowPage");
		if(nowPage == null || nowPage.equals("") || nowPage.equals("undefined")) current_page = 1; 
		else current_page = Integer.parseInt(nowPage);
		
		total_page = total_count / list_setup_count;  // 몫 : 2
		int rest = 	total_count % list_setup_count;   // 나머지:1
		if(rest !=0) total_page = total_page + 1;     // 3
		
		int start = (current_page -1) * list_setup_count + 1;
		int end   = current_page * list_setup_count;
		
		String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
		fobj.put("t_paging", paging);
		
		ArrayList<EtcDto> arr = dao.listDB(search,start,end);
		for(int k=0; k<arr.size(); k++) {
			hM = new HashMap<String, Object>();
			String no = arr.get(k).getNo();
			hM.put("no", no);
			String content = arr.get(k).getContent();
			hM.put("content", content);
			String reg_id = arr.get(k).getReg_id();
			hM.put("reg_id", reg_id);
			String reg_name = arr.get(k).getReg_name();
			hM.put("reg_name", reg_name);
			String reg_date = arr.get(k).getReg_date();
			reg_date = CommonUtil.convertDate(reg_date);
			hM.put("reg_date", reg_date);
			String depth = arr.get(k).getDepth();
			int iDepth = Integer.parseInt(depth);
			depth="";
			for(int i=0; i<iDepth; i++) {
				depth+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			}
			hM.put("depth", depth);
			String reply = arr.get(k).getReply();
			hM.put("reply", reply);
			String content_view = "";
			if(content.length()>35-2*iDepth) {
				content_view = content.substring(0, 35-2*iDepth);
			}else content_view = content;
			hM.put("content_view", content_view);
			String arrow = "";
			if(no!=null&&reply!=null) {
				if(no.equals(reply)) arrow = "<i class='fa-solid fa-circle-question'></i>";
				else arrow = "<i class='fa-solid fa-reply fa-rotate-180'></i>";
			}
			hM.put("arrow", arrow);
			String deleteT = "";
			if(reg_id!=null && (String)ss.getAttribute("sessionId")!=null) {
				String sLevel = (String)ss.getAttribute("sLevel");
				int ssLevel = Integer.parseInt(sLevel);
				if(reg_id.equals((String)ss.getAttribute("sessionId")) || ssLevel>1) {
					deleteT = "<a href='javascript:goDelete(&#39;"+no+"&#39;)' class='butt'>삭제</a>";
				}
			}
			hM.put("deleteT",deleteT);
			
			String showtext = "";
			if(ss.getAttribute("sessionId")!=null) {
				showtext = "<textarea style='width:668px;height:100px;margin-bottom:5px;resize:none;' id='"+no+"' onkeypress='WriteReply(&#39;no&#39;)'></textarea>";
			}
			hM.put("showtext", showtext);
			
			jsub = new JSONObject(hM);
			jarr.add(jsub);
		}
		fobj.put("t_arr", jarr);
		
		out.print(fobj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}