package common;

import org.springframework.jdbc.core.JdbcTemplate;

public class CommonTemplate {
	public static JdbcTemplate template;
	
	public static JdbcTemplate getTemplate() {
		return template;
	}
	
	public static void setTemplate(JdbcTemplate template) {
		CommonTemplate.template = template;
	}
}
