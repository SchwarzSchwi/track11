package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDown
 */
@WebServlet("/FileDown")
public class FileDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDown() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String savePath = request.getParameter("t_fileDir"); // 첨부파일경로
		String fileName = request.getParameter("t_fileName");  // 다운로드 받을 첨부파일명
		
		if(savePath.equals("notice")) savePath = CommonUtil.getFile_dir_notice();
		else if(savePath.equals("news")) savePath = CommonUtil.getFile_dir_news();
		else if(savePath.equals("freeboard")) savePath = CommonUtil.getFile_dir_freeboard();


	 	
	    String orgfilename = fileName ;
	 
	    InputStream in = null;
	    OutputStream os = null; 
	    File file = null;
	    boolean skip = false;
	    String client = "";
	  
	    try{
	        try{
	            file = new File(savePath, fileName);
	            in = new FileInputStream(file);
	        }catch(FileNotFoundException fe){
	            skip = true;
	        }
	         
	        client = request.getHeader("User-Agent");
	        response.reset() ;
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Description", "JSP Generated Data");
	 
	        if(!skip){
	 
	            // IE
	            if(client.indexOf("MSIE") != -1){
	                response.setHeader ("Content-Disposition", "attachment; filename="+orgfilename);
	 
	            }else{
	                // 한글 파일명 처리
	                orgfilename = new String(orgfilename.getBytes("utf-8"),"iso-8859-1");

	                response.setHeader("Content-Disposition", "attachment; filename=\"" + orgfilename + "\"");
	                response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
	            } 
	             
	            response.setHeader ("Content-Length", ""+file.length() );
	            os = response.getOutputStream();
	            byte b[] = new byte[(int)file.length()];
	            int leng = 0;
	             
	            while( (leng = in.read(b)) > 0 ){
	                os.write(b,0,leng);
	            }
	 
	        }else{
	            response.setContentType("text/html;charset=UTF-8");
	    	    PrintWriter out = response.getWriter();
	            out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
	        }
	        in.close();
	        os.close();
	 
	    }catch(Exception e){
	    	System.out.println("첨부 파일 다운 오류~ 파일명:"+fileName);
	    	e.printStackTrace();
	    } 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
