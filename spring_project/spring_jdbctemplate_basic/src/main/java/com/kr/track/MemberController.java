package com.kr.track;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	MemberDto memDto;
	
	@Autowired
	JdbcTemplate template;
	
	@RequestMapping("Member")
	public String member() {
			
//		String query="select id,name,age,\r\n" + 
//				"    to_char (reg_date,'yyyy-mm-dd') as reg_date\r\n" + 
//				"from H_최선우_MEMBER\r\n" + 
//				"where id = '101'";
//		
//		RowMapper<MemberDto> memDto = new BeanPropertyRowMapper<>(MemberDto.class);
//		MemberDto dto = template.queryForObject(query, memDto);
//		
//		System.out.println("ID:"+dto.getId());
//		System.out.println("name:"+dto.getName());
//		System.out.println("age:"+dto.getAge());
//		System.out.println("reg_date:"+dto.getReg_date());
		
		String query ="select id,name,age,\r\n" + 
				"    to_char (reg_date,'yyyy-mm-dd') as reg_date\r\n" + 
				" from H_최선우_MEMBER\r\n" + 
				" order by id desc";
		RowMapper<MemberDto> memDtoList = new BeanPropertyRowMapper<>(MemberDto.class);
		ArrayList<MemberDto>dtos = (ArrayList<MemberDto>) template.query(query, memDtoList);
		
		System.out.println("회원수:"+dtos.size());
		
		return "home";
	}
	
}
