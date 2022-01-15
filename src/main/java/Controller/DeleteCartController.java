package Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Impl.CartDaoImpl;

@WebServlet("/DeleteCartController")
public class DeleteCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

    CartDaoImpl cartDAO = new CartDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_product = request.getParameter("id");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		cartDAO.xoa(username, id_product);
		String url ="/cart";
		response.sendRedirect(url);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
