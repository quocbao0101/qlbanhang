package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Impl.CategoryDaoImpl;
import DAO.Impl.ProductDaoImpl;
import Model.Category;
import Model.Product;

/**
 * Servlet implementation class ShowListProductController
 */
@WebServlet(name="productList",urlPatterns="/product")
public class ShowListProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowListProductController() {
        super();
        // TODO Auto-generated constructor stub
    }
	CategoryDaoImpl categoryDao = new CategoryDaoImpl();
    ProductDaoImpl productDao = new ProductDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> productList = productDao.getAll();
		List<Category> categoryList = categoryDao.getAll();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
