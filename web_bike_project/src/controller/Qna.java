package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.qna.QnaDelete;
import command.qna.QnaDeleteAnswer;
import command.qna.QnaList;
import command.qna.QnaReply;
import command.qna.QnaReplyForm;
import command.qna.QnaSave;
import command.qna.QnaUpdate;
import command.qna.QnaUpdateAnswer;
import command.qna.QnaUpdateAnswerForm;
import command.qna.QnaUpdateForm;
import command.qna.QnaView;
import common.CommonExecute;
import common.CommonToday;

/**
 * Servlet implementation class Qna
 */
@WebServlet("/Qna")
public class Qna extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qna() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun = "list";
		String viewPage="common_alert.jsp";
		
		request.setAttribute("t_nowPage", "qna");
		
		//목록
		if(gubun.equals("list")) {
			CommonExecute qna = new QnaList();
			qna.execute(request);
			viewPage ="qna/qna_list.jsp";
		//글쓰기폼	
		} else if(gubun.equals("writeForm")) {
			CommonExecute common = new CommonToday();
			common.execute(request);
			viewPage ="qna/qna_write.jsp";
		//등록	
		} else if (gubun.equals("save")) {
			CommonExecute qna = new QnaSave();
			qna.execute(request);
		//상세보기	
		} else if (gubun.equals("view")) {
			CommonExecute qna = new QnaView();
			qna.execute(request);
			viewPage = "qna/qna_view.jsp";
		//답변입력폼
		}else if (gubun.equals("replyForm")) {
			CommonExecute qna = new QnaReplyForm();
			qna.execute(request);
			viewPage ="qna/qna_replyForm.jsp";
		//답변입력	
		}else if(gubun.equals("reply")) {
			CommonExecute qna = new QnaReply();
			qna.execute(request);
		//질문 수정폼	
		}else if(gubun.equals("updateForm")){
			CommonExecute qna = new QnaUpdateForm();
			qna.execute(request);
			viewPage = "qna/qna_updateForm.jsp";
		//질문수정	
		}else if(gubun.equals("update")) {
			CommonExecute qna = new QnaUpdate();
			qna.execute(request);
		//질문삭제	
		}else if(gubun.equals("delete")) {
			CommonExecute qna = new QnaDelete();
			qna.execute(request);
		//답변삭제	
		}else if(gubun.equals("deleteAnswer")) {
			CommonExecute qna = new QnaDeleteAnswer();
			qna.execute(request);
		//답변수정폼
		}else if(gubun.equals("updateAnswerForm")) {
			CommonExecute qna = new QnaUpdateAnswerForm();
			qna.execute(request);
			viewPage = "qna/qna_updateAnswerForm.jsp";
		//답변수정	
		}else if(gubun.equals("updateAnswer")){
			CommonExecute qna = new QnaUpdateAnswer();
			qna.execute(request);
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
