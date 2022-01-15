package Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AdminDAO.Impl.AdminDaoImpl;

@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDaoImpl adminDAO = new AdminDaoImpl();
    public AdminLoginController() {
        super();    
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/login.jsp");
    	dispatcher.forward(request, response);

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String admin_username = request.getParameter("admin_username");
		String admin_password = request.getParameter("admin_password");
		String err = "";
		String url = "";
		int status = adminDAO.login(admin_username, admin_password);

		if(status <= 0)
		{
			err+= "Tài khoản hoặc mật khẩu không đúng";
		}
		if (err.length() > 0) {
			request.setAttribute("err", err);
		}
		try
		{
			if(err.length()==0)
			{

					HttpSession session = request.getSession();
	                session.setAttribute("admin_username", admin_username);
		            response.sendRedirect("index.jsp");
			}
			else
			{
				url = "/admin/login.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("./admin/login.jsp");
		}
	}

}

