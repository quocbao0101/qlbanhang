package Controller.Admin;


import java.io.File;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.Impl.ProductDaoImpl;
import Model.Product;


@WebServlet("/AdminAddProductController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminAddProductController extends HttpServlet {

       
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductDaoImpl productDao = new ProductDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/addproduct.jsp"); 
		dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String catalog_id =request.getParameter("catalog_id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int status = Integer.parseInt(request.getParameter("status"));
		String description = request.getParameter("description");
		String image_link = request.getParameter("file");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Product product = new Product(catalog_id,name,price,status,description,image_link,quantity);

		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			// refines the fileName in case it is an absolute path
			fileName = new File(fileName).getName();

			part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
		}
		productDao.add(product);
	    String url = "product";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
	}




	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
	
	public File getFolderUpload() {
		File folderUpload = new File(System.getProperty("user.home") + "/eclipse-workspace/qlbanhang/src/main/webapp/assets/images");
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}


}