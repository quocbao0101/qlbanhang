package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Impl.OrderManagerImpl;
import Model.DetailsManager;
import Model.DetailsProduct;

/**
 * Servlet implementation class DetailsOrderManagerController
 */
@WebServlet(name="DetailsOrderManagerController", urlPatterns={"/details"})
public class DetailsOrderManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsOrderManagerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	String id = request.getParameter("id");
	OrderManagerImpl dao = new OrderManagerImpl();
	DetailsManager details = dao.getOrderManagerByID(id);
	List<DetailsProduct> product = dao.getByID(id);
	request.setAttribute("dt", details);
	request.setAttribute("pro", product);
	request.getRequestDispatcher("details.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
