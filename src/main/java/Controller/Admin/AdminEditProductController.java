package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Impl.ProductDaoImpl;

import Model.Product;


@WebServlet("/AdminEditProductController")
public class AdminEditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */

    public AdminEditProductController() {
        super();
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    ProductDaoImpl productDAO = new ProductDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Product product =  productDAO.get(id);
		request.setAttribute("products", product);
		request.getRequestDispatcher("/admin/editproduct.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String product_id = request.getParameter("id_product");
		String catalog_id = request.getParameter("catalog_id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int status = Integer.parseInt(request.getParameter("status"));
		String description = request.getParameter("description");
		String image_link = request.getParameter("image_link");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Product product = new Product();
		product.setId(product_id);
		product.setCatalog_id(catalog_id);
		product.setName(name);
		product.setPrice(price);
		
		product.setStatus(status);
		product.setDescription(description);
		product.setImage_link(image_link);
		product.setQuantity(quantity);
		productDAO.edit(product);
		response.sendRedirect("product");
	}

}
