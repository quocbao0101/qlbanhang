 package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Impl.ProductDaoImpl;

import Model.Product;

/**
 * Servlet implementation class AdminProductListController
 */
@WebServlet("/AdminProductListController")
public class AdminProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDaoImpl adminDAO = new ProductDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> productList = adminDAO.getAll();
		request.setAttribute("productlist", productList); 
		request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
