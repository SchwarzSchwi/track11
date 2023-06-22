package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.product.ProductList;
import command.product.ProductSave;
import common.CommonExecute;
import common.CommonToday;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun ="list";
		String viewPage ="";
		request.setAttribute("t_nowPage", "Product");
		
		if(gubun.equals("list")) {
			CommonExecute product = new ProductList();
			product.execute(request);
			viewPage="product/product_list.jsp";
		}else if(gubun.equals("writeForm")) {
			CommonExecute common = new CommonToday();
			common.execute(request);
			viewPage="product/product_write.jsp";
		}else if(gubun.equals("save")) {
			CommonExecute product = new ProductSave();
			product.execute(request);
			viewPage="common_alert.jsp";
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
