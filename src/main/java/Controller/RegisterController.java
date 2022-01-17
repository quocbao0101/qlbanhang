package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.Impl.UserDaoImpl;
import Model.User;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDAO = new UserDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		int status = userDAO.checkUser(username);
		String err = "";
		String url = "/register.jsp";
		if(username.equals("") || password.equals("") || name.equals("") || phone.equals("") ||email.equals(""))
		{
			err+= "Phải nhập đầy đủ thông tin";
		}
		else if(!password.equals(confirm))
		{
			err+= "Mật khẩu không trùng khớp với nhau";
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
	            response.sendRedirect("login.jsp");
			}
			else
			{
				url = "/register.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/register.jsp");
		}
	}

}
