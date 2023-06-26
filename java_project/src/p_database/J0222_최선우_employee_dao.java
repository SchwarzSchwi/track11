package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class J0222_최선우_employee_dao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int employeeSave(J0222_최선우_employee_dto dto) {
		int result = 0;
		String query = "INSERT INTO E_최선우_EMPLOYEE\r\n" + "(ID, NAME, DEPART, RANK, AGE)\r\n" + "VALUES\r\n" + "('"
				+ dto.getId() + "','" + dto.getName() + "','" + dto.getDepart() + "','" + dto.getRank() + "',"
				+ dto.getAge() + ")";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("saveMember() 오류" + query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}

	public int employeeSave(String id, String name, String depart, String rank, int age) {
		int result = 0;
		String query = "INSERT INTO E_최선우_EMPLOYEE\r\n" + "(ID, NAME, DEPART, RANK, AGE)\r\n" + "VALUES\r\n" + "('" + id
				+ "','" + name + "','" + depart + "','" + rank + "'," + age + ")";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("saveMember() 오류" + query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	public ArrayList<J0222_최선우_employee_dto> getSearchList() {
		ArrayList<J0222_최선우_employee_dto> dtos = new ArrayList<>();
		String query = "SELECT ID,NAME,DEPART,RANK,AGE \r\n" + "FROM E_최선우_EMPLOYEE\r\n" + "ORDER BY ID DESC";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String depart = rs.getString("depart");
				String rank = rs.getString("rank");
				int age = rs.getInt("age");
				J0222_최선우_employee_dto dto = new J0222_최선우_employee_dto(id, name, depart, rank, age);
				dtos.add(dto);
			}
		} catch (Exception e) {
			System.out.println("getSearchList() 오류 : " + query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}

	public ArrayList<J0222_최선우_employee_dto> getSearchList(String gubun, String id) {
		ArrayList<J0222_최선우_employee_dto> dtos = new ArrayList<>();
		String query = "SELECT ID,NAME,DEPART,RANK,AGE \r\n" + "FROM E_최선우_EMPLOYEE\r\n" + "WHERE ID LIKE '%2%'"
				+ "ORDER BY ID DESC";
		return dtos;
	}

	public void resultPrint(ArrayList<J0222_최선우_employee_dto> dtos) {
		System.out.println("======================================");
		System.out.println("사번\t성명\t부서\t직위\t나이");
		System.out.println("--------------------------------------");

		if (dtos.size() == 0)
			System.out.println("\t\t정보없음");

		for (int k = 0; k < dtos.size(); k++) {
			System.out.print(dtos.get(k).getId() + "\t");
			System.out.print(dtos.get(k).getName() + "\t");
			System.out.print(dtos.get(k).getDepart() + "\t");
			System.out.print(dtos.get(k).getRank() + "\t");
			System.out.print(dtos.get(k).getAge() + "\n");
		}
		System.out.println("---------------------------------------");
		if (dtos.size() > 0) {
			System.out.println("총 : " + dtos.size() + "명");
			System.out.println("---------------------------------------");
		}
	}

	// id 중복검사
	public int checkId(String id) {
		int count = 0;
		String query = "SELECT COUNT(*) AS COUNT\r\n" + "FROM E_최선우_EMPLOYEE\r\n" + "WHERE ID = '" + id + "'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("");
			}
		} catch (Exception e) {
			System.out.println("checkId() 오류" + query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}

	// 수정
	public J0222_최선우_employee_dto getEmployeeInfo(String id) {
		J0222_최선우_employee_dto dto = null;
		String query = "SELECT ID,NAME,DEPART,RANK,AGE\r\n" + "FROM E_최선우_EMPLOYEE\r\n" + "WHERE ID='" + id + "'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String depart = rs.getString("depart");
				String rank = rs.getString("rank");
				int age = rs.getInt("age");
				dto = new J0222_최선우_employee_dto(id, name, depart, rank, age);
			}
		} catch (Exception e) {
			System.out.println("getEmployeeInfo() 오류: " + query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}

	public void resultPrintDto(J0222_최선우_employee_dto dto) {
		System.out.println("======================================");
		System.out.println("사번\t성명\t부서\t직위\t나이");
		System.out.println("--------------------------------------");
		System.out.print(dto.getId() + "\t");
		System.out.print(dto.getName() + "\t");
		System.out.print(dto.getDepart() + "\t");
		System.out.print(dto.getRank() + "\t");
		System.out.print(dto.getAge() + "\n");
		System.out.println("--------------------------------------");
	}

	public int employeeUpdate(J0222_최선우_employee_dto dto) {
		int result = 0;
		String query = "UPDATE E_최선우_EMPLOYEE\r\n" + "SET NAME ='" + dto.getName() + "',\r\n" + "    DEPART = '"
				+ dto.getDepart() + "',\r\n" + "    RANK = '" + dto.getRank() + "',\r\n" + "    AGE = " + dto.getAge()
				+ "\r\n" + "WHERE ID = '" + dto.getId() + "'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (Exception e) {
			System.out.println("employeeUpdate() 오류: " + query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}

		return result;
	}

	public int employeeDelete(String id) {
		int result = 0;
		String query = "DELETE FROM E_최선우_EMPLOYEE\r\n" + 
				"WHERE ID ='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
		}catch(Exception e) {
			System.out.println("employeeDelete() 오류: " + query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	

}