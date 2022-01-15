package Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Impl.UserDaoImpl;
import Model.User;

/**
 * Servlet implementation class AddUserController
 */
@WebServlet(name= "AddUserController", urlPatterns= {"/adduser"})
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private UserDaoImpl userDAO = new UserDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String err = "";
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("sdt");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String url = "";
		int status = userDAO.checkUser(username);
		if(username.equals("") || password.equals("") || name.equals("") || phone.equals("") ||email.equals(""))
		{
			err+= "Phải nhập đầy đủ thông tin";
		}

		else if(status >=1)
		{
			err+= "Tài khoản này đã có người đăng ký";
		}
		else if(phone.length()!=10)
		{
			err+="Số điện thoại phải là 10 số";
		}
		if (err.length() > 0) {
			request.setAttribute("err", err);
		}

		try
		{
			if(err.length()==0)
			{
				userDAO.addUser(new User(username,password,name,phone,email));
	            response.sendRedirect("users");
			}
			else
			{
				url = "/admin/adduser.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/admin/adduser");
		}
	}

}
