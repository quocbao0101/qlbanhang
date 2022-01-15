package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Impl.ContactDaoImpl;
import Model.Contact;

/**
 * Servlet implementation class ContactController
 */
@WebServlet("/ContactController")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	ContactDaoImpl contactDao = new ContactDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String comment = request.getParameter("message");
		String err ="";
		String url = "";
		if(name.isEmpty() && email.isEmpty() && phone.isEmpty() && comment.isEmpty())
		{
			err += "Các trường này không được trống";
		}
		if(phone.length() > 10 && phone.length()< 10)
		{
			err += "Số điện thoại phải là 10 số";
		}
		if(err.length() > 0)
		{
			request.setAttribute("err", err);
		}
		try {
			

			if(err.length() ==0)
			{

				contactDao.addContact(new Contact(name,email,phone,comment));
				url = "/index";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
			else {	
				url = "/contacts";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("contacts.jsp");
		}

	}

}
