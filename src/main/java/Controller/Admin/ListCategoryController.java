package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Impl.CategoryDaoImpl;
import Model.Category;

/**
 * Servlet implementation class ListCategoryController
 */
@WebServlet("/ListCategoryController")
public class ListCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

    CategoryDaoImpl categoryDAO = new CategoryDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categorys = categoryDAO.getAll();
		request.setAttribute("categoryList", categorys);
		request.getRequestDispatcher("/admin/category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
