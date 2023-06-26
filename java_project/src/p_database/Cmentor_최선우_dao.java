package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Cmentor_최선우_dao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<Cmentor_최선우_dto> getSearchList(String gubun, String search) {
		ArrayList<Cmentor_최선우_dto> dtos = new ArrayList<>();
		String query = "SELECT ID, NAME\r\n" + "FROM E_최선우_MENTOR\r\n" + "WHERE " + gubun + " LIKE '%" + search
				+ "%'\r\n" + "ORDER BY ID DESC";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				Cmentor_최선우_dto dto = new Cmentor_최선우_dto(id, name);
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

	// 출력
	public void print(ArrayList<Cmentor_최선우_dto> dtos) {
		System.out.println("===================");
		System.out.println("ID\t성명\t");
		System.out.println("-------------------");

		if (dtos.size() == 0)
			System.out.println("\t내용없음");

		for (int k = 0; k < dtos.size(); k++) {
			System.out.print(dtos.get(k).getId() + "\t");
			System.out.print(dtos.get(k).getName() + "\n");
		}
	}

	// 등록
	public int studentSave(Cmentor_최선우_dto dto) {
		int result = 0;
		String query = "insert into E_최선우_MENTOR\r\n" + "(id, name)\r\n" + "values\r\n" + "('" + dto.getId() + "','"
				+ dto.getName() + "')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("studentSave() 오류 : " + query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	// 상세조회
	public Cmentor_최선우_dto getMentorInfo(String id) {
		Cmentor_최선우_dto dto = null;
		String query = "SELECT ID,NAME\r\n" + "FROM E_최선우_MENTOR\r\n" + "WHERE ID = '" + id + "'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				dto = new Cmentor_최선우_dto(id, name);
			}
		} catch (Exception e) {
			System.out.println("getMentorInfo() 오류 : " + query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}

		return dto;
	}

	// 개인정보 출력
	public void printInfo(Cmentor_최선우_dto dto) {
		System.out.println("===================");
		System.out.println("ID\t성명\t");
		System.out.println("-------------------");
		System.out.print(dto.getId() + "\t");
		System.out.print(dto.getName() + "\n");
		System.out.println("-------------------");
	}

	// 수정
	public int mentorUpdate(Cmentor_최선우_dto updateDto) {
		int result = 0;
		String query = "UPDATE E_최선우_MENTOR\r\n" + "SET NAME = '" + updateDto.getName() + "'\r\n" + "WHERE ID = '"
				+ updateDto.getId() + "'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("mentorUpdate() 오류 : " + query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}

	// 삭제
	public int mentorDelete(String id) {
		int result = 0;
		String query = "DELETE FROM E_최선우_MENTOR\r\n" + "WHERE ID = '" + id + "'";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("mentorDelete() 오류 : " + query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
}