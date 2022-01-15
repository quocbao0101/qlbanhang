package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Impl.UserDaoImpl;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDAO = new UserDaoImpl();

    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String err = "";
		String url = "/login.jsp";
		int status = userDAO.login(username, password);
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
	                session.setAttribute("username", username);
		            response.sendRedirect("./index");
			}
			else
			{
				url = "/login.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/login.jsp");
		}
	}

}
