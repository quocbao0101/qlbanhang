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
 * Servlet implementation class ProductListOfCategoryController
 */
@WebServlet(name="ProductListOfCategory",urlPatterns="/product")
public class ProductListOfCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListOfCategoryController() {
        super();

    }

    CategoryDaoImpl categoryDao = new CategoryDaoImpl();
	ProductDaoImpl productDao = new ProductDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idcategory = Integer.parseInt(request.getParameter("id"));
		List<Product> productList = productDao.getProductById(idcategory);
		List<Category> categoryList = categoryDao.getAll();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
