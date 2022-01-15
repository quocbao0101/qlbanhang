package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Impl.CartDaoImpl;
import DAO.Impl.ProductDaoImpl;

/**
 * Servlet implementation class UpdateCartController
 */
@WebServlet("/UpdateCartController")
public class UpdateCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/cart");
		rd.forward(request, response);
	}
	ProductDaoImpl productDAO = new ProductDaoImpl();
	CartDaoImpl cartDAO = new CartDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String err = "";
		String url = "/cart";
		String id_product = request.getParameter("id");
		request.setAttribute("idproduct", id_product);
		int qty = Integer.parseInt(request.getParameter("qty"));
		String username = (String) session.getAttribute("username");
		int qty_get = productDAO.getsp(id_product);
		if(qty <= 0)
		{
			err += "Bạn không thể làm điều này";
			request.setAttribute("alert", "danger");				
		}
		else if(qty > qty_get)
		{
			err += "Sản phẩm bạn vừa chỉnh sửa đã vượt giới hạn của kho";
			request.setAttribute("alert", "danger");	
		}
		if(err.length() > 0)
		{
			request.setAttribute("err", err);
		}
		try {
			if(err.length() ==0)
			{
				cartDAO.updateCart(qty, username, id_product);
				request.setAttribute("alert", "success");
				request.setAttribute("success", "Cập nhật giỏ hàng thành công");
				url = "/cart";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
			else 
			{	
				url = "/cart";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("cart");
		}
	}

}
