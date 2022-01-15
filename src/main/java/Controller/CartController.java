package Controller;

import java.io.IOException;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Impl.CartDaoImpl;
import Model.Cart;


@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartController() {
        super();

    }
    CartDaoImpl cartDAO = new CartDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		int sumPrice = cartDAO.sumPrice(username);
		
		List<Cart> cartList = cartDAO.getCart(username);
		request.setAttribute("sumPrice",sumPrice);
		request.setAttribute("listCart", cartList);
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
