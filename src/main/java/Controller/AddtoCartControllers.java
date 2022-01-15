package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import DAO.Impl.CartDaoImpl;
import DAO.Impl.UserDaoImpl;
import Model.Cart;


@WebServlet("/AddtoCartControllers")
public class AddtoCartControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddtoCartControllers() {
        super();
    }

    UserDaoImpl userDao = new UserDaoImpl();
    CartDaoImpl cartDao = new CartDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		///////////////////////////////////////////////////
		String err = "";
		String url = "/product";
		String product_price = request.getParameter("product_price");
		String id_product = request.getParameter("id");	
		String username = request.getParameter("user");
		int qty = Integer.parseInt(request.getParameter("qty"));
		int status = cartDao.checkCart(username, id_product);
		int qty_get = cartDao.getCart_qty(username, id_product);
		///////////////////////////////////////////////////
		if(qty_get >= qty)
		{
			err += "Sản phẩm bạn vừa thêm đã vượt giới hạn của kho";
			request.setAttribute("alert", "danger");				
		}
		else if(qty<=0)
		{
			err += "Sản phẩm này đã hết hàng";
			request.setAttribute("alert", "danger");			
		}
		else if(username.contains("null"))
		{
			err += "Bạn phải đăng nhập mới có thể thêm vào giỏ hàng";
			request.setAttribute("alert", "danger");
		}
		else if(status == 0)
		{
			request.setAttribute("alert", "danger");
			err += "Mặt hàng này đã có trong giỏ hàng của bạn";		
			cartDao.update(username, id_product);
		}
		if(err.length() > 0)
		{
			request.setAttribute("err", err);
		}
		try {
			

			if(err.length() ==0)
			{
				request.setAttribute("alert", "success");
				request.setAttribute("success", "Thêm vào giỏ hàng thành công");
				cartDao.insert(new Cart(username,id_product,1,product_price));
				url = "/product";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
			else {	
				url = "/product";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("product");
		}


	}

}
