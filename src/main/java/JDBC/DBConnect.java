package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public DBConnect(){
		super();
	}
	public static Connection getConnect(){
		Connection connection = null;
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/qlbanhang","root","");  
            System.out.println("Kết nối thành công!");
        }catch(Exception e){System.out.println("Kết nối thất bại!"+e.getMessage());;}  
        return connection;  
	}
	public static void main(String[] args) {
		System.out.println(getConnect());
	}

}
