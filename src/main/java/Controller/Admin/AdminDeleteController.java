package Controller.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AdminDAO.Impl.AdminDaoImpl;

/**
 * Servlet implementation class AdminDeleteController
 */
@WebServlet("/AdminDeleteController")
public class AdminDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDaoImpl adminDao = new AdminDaoImpl();
    public AdminDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int admin_id = Integer.parseInt(request.getParameter("id"));
		adminDao.delete(admin_id);
		response.sendRedirect(request.getContextPath() + "/admin/admin");
	}


}
