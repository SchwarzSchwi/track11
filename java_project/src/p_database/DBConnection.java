package p_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection(){
		Connection con = null;
		boolean goIng = true;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			goIng = false;
			System.out.println("오라클 드리이버 없음~~");
			e.printStackTrace();
		}
		
		if(goIng){
			String db_url		="jdbc:oracle:thin:@jsl-704:1521/xe";
//			String db_url		="jdbc:oracle:thin:@182.217.138.73:1521/xe";
			String db_user		="track11";
			String db_password	="1234";
			
			try {
				con = DriverManager.getConnection(db_url, db_user, db_password);
			} catch (SQLException e) {
				System.out.println("DB 계정설정 오류~~~");
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeDB(Connection con,
			                   PreparedStatement ps,
			                   ResultSet rs){
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}






















