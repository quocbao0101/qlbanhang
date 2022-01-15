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


@WebServlet(name="editAdmin",urlPatterns="/edit")
public class AdminEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminEditController() {
        super();
    }
    AdminDaoImpl adminDao = new AdminDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int admin_id = Integer.parseInt(request.getParameter("id"));
		Admin admin = adminDao.get(admin_id);
		request.setAttribute("edit_admin", admin);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/editadmin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int admin_id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = new Admin();
		admin.setId(admin_id);
		admin.setName(name);
		admin.setUsername(username);
		admin.setPassword(password);
		adminDao.edit(admin);
		response.sendRedirect(request.getContextPath() + "/admin/admin");
	}

}
