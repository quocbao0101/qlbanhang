package Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDAO.Impl.AdminDaoImpl;
import Model.Admin;


@WebServlet(name="addadmin",urlPatterns="/addadmin")
public class AdminAddAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDaoImpl adminDao = new AdminDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/addadmin.jsp"); 
		dispatcher.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		Admin admin = new Admin(username,password,name);
		String err = "";
		String success = "";
		int status = adminDao.addAdmin(admin);
		String url = "/admin/admin";
		if(status <=0)
		{
			err += "Thêm admin thất bại";
			request.setAttribute("err", err);		
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);

		}
		else
		{
			success += "Thêm tài khoản thành công";
			request.setAttribute("success", success);
			response.sendRedirect(request.getContextPath() + "/admin/admin"); 
		}

		
	}

}
