package dao;

import java.util.ArrayList;

import dto.TestDto;

public class TestDao {
	public int getTotal(int a, int b) {
		return a + b;
	}
	public ArrayList<TestDto> getList(){
		ArrayList<TestDto> dtos = new ArrayList<>();
		TestDto dto1= new TestDto("배정열","서울",60);
		TestDto dto2= new TestDto("정향재","서울",54);
		dtos.add(dto1);
		dtos.add(dto2);
		return dtos;
	}
}
