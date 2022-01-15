package Controller.Admin;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDAO.Impl.AdminDaoImpl;
import Model.Admin;


@WebServlet(name="adminlist",urlPatterns= {"/admin.jsp"})
public class AdminListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminDaoImpl adminDAO = new AdminDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Admin> adminList = adminDAO.getAll();
		request.setAttribute("adminlist", adminList); 
		request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);

	}


}
