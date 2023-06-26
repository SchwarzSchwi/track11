package p_database;

import java.util.Scanner;

public class J0214_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0214_dao dao = new J0214_dao();
		
		System.out.print("id?");
		String ID = sc.next();
		
		String name = dao.getName("ID");
		System.out.println("name : "+name);
	}
//		Connection con = DBConnection.getConnection();
//		System.out.println(" con : "+con);
//		DBConnection.closeDB(con);
//		
//	}
}
