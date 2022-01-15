package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Impl.CartDaoImpl;
import DAO.Impl.ProductDaoImpl;
import DAO.Impl.UserDaoImpl;
import Model.Cart;
import Model.Product;

@WebServlet(name="singleProduct",urlPatterns="/single-product")
public class SingleProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public SingleProductController() {
        super();
    }
    ProductDaoImpl productDao = new ProductDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("product"));
		Product productList = productDao.get(id);
		request.setAttribute("product1", productList);
		request.getRequestDispatcher("/single-product.jsp").forward(request, response);
	}
    UserDaoImpl userDao = new UserDaoImpl();
    CartDaoImpl cartDao = new CartDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		///////////////////////////////////////////////////
		String err = "";
		String url = "/product";
		String product_price = request.getParameter("product_price");
		String id_product = request.getParameter("id_product");	
		String username = request.getParameter("user");
		int qty = Integer.parseInt(request.getParameter("quantity"));
		int status = cartDao.checkCart(username, id_product);
		int qty_get = Integer.parseInt(request.getParameter("qty"));
		///////////////////////////////////////////////////
		if(username.isEmpty())
		{
			err += "Bạn phải đăng nhập mới có thể thêm vào giỏ hàng";
			request.setAttribute("alert", "danger");				
		}
		else if(qty <= 0)
		{
			err += "Bạn không thể làm điều này";
			request.setAttribute("alert", "danger");				
		}
		else if(qty_get <= qty)
		{
			err += "Sản phẩm bạn vừa thêm đã vượt giới hạn của kho";
			request.setAttribute("alert", "danger");				
		}
		else if(qty_get<=0)
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
			cartDao.updateplusCart(qty,username, id_product);
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
				cartDao.insert(new Cart(username,id_product,0,product_price));
				cartDao.updateplusCart(qty,username, id_product);
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
			response.sendRedirect("single-product");
		}
	}
}
