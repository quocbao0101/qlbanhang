package Controller.Admin;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.Impl.CategoryDaoImpl;
import DAO.Impl.ProductDaoImpl;
import Model.Category;
import Model.Product;


@WebServlet("/AdminAddProductController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminAddProductController extends HttpServlet {

    public static final String UPLOAD_DIR = "images";
    public String dbFileName = "";       
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductDaoImpl productDao = new ProductDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDaoImpl cateDao = new CategoryDaoImpl();
		List<Category> cate = cateDao.getAll();
		request.setAttribute("categoryList", cate);
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
		String description = request.getParameter("description");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

        Part part = request.getPart("file");//
        String fileName = extractFileName(part);//file name

        /**
         * *** Get The Absolute Path Of The Web Application ****
         */
        String applicationPath = getServletContext().getRealPath("");
        String uploadPath = "C:\\Users\\ASUS\\eclipse-workspace\\qlbanhang\\src\\main\\webapp\\assets\\" + File.separator + UPLOAD_DIR;
        System.out.println("applicationPath:" + applicationPath);
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        String savePath = uploadPath + File.separator + fileName;
        System.out.println("savePath: " + savePath);
        String sRootPath = new File(savePath).getAbsolutePath();
        System.out.println("sRootPath: " + sRootPath);
        part.write(savePath + File.separator);
        File fileSaveDir1 = new File(savePath);
        /*if you may have more than one files with same name then you can calculate some random characters
         and append that characters in fileName so that it will  make your each image name identical.*/
        dbFileName = fileName;
        part.write(savePath + File.separator);
        
        
		Product product = new Product(catalog_id,name,price,description,dbFileName,quantity);
		productDao.add(product);
	    String url = "/admin/product";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
	}


    private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }


}