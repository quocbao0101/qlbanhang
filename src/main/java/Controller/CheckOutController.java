package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Impl.CartDaoImpl;
import DAO.Impl.OrderDaoImpl;
import DAO.Impl.TransactionsDaoImpl;
import DAO.Impl.UserDaoImpl;
import Model.Cart;
import Model.Ordered;
import Model.Product;
import Model.Transactions;
import Model.User;

/**
 * Servlet implementation class CheckOutController
 */
@WebServlet("/CheckOutController")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutController() {
        super();
        // TODO Auto-generated constructor stub
    }
    OrderDaoImpl orderDAO = new OrderDaoImpl();
    UserDaoImpl userDAO = new UserDaoImpl();
    CartDaoImpl cartDAO = new CartDaoImpl();
    TransactionsDaoImpl transDAO = new TransactionsDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		
		User users = new User();
		
		users = userDAO.getUser_username(username);
		List<Cart> cartList = cartDAO.getCart(username);
		request.setAttribute("listCart", cartList);
		int sumPrice = cartDAO.sumPrice(username);
		int phiship = 30000;
		int tongtien = sumPrice + phiship;
		request.setAttribute("user", users);
		request.setAttribute("tongtien", tongtien);
		request.setAttribute("sumPrice",sumPrice);




		request.getRequestDispatcher("/checkout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");

		int amount = Integer.parseInt(request.getParameter("sumAmount"));
		
		// trừ sản phẩm từ giỏ hàng vào sản phẩm
		for(String id : request.getParameterValues("id_product"))
		{
				Product product = new Product();
				product.setId(id);
				transDAO.updatesp(product);
		}
		String[]pid = request.getParameterValues("id_product");
		String[]qty = request.getParameterValues("soluong");
		List<Ordered> listOrder = new ArrayList<>();
		transDAO.themhoadon(new Transactions(username,email,address,phone,message,amount));
		int id_trans = orderDAO.getid_Transaction(username, amount);
		for(int i = 0;i<pid.length;i++)
		{
			Ordered order = new Ordered();
			order.setPid(pid[i]);
			order.setQty(qty[i]);
			listOrder.add(order);
		}
		orderDAO.insert(listOrder, id_trans);
		transDAO.xoasp_cart(username);
		String success = "Bạn đã thanh toán thành công , vui lòng đợi từ 5-7 ngày để nhận hàng ";
		request.setAttribute("success", success);
		request.getRequestDispatcher("/checkout.jsp").forward(request, response);
	}
 
}
