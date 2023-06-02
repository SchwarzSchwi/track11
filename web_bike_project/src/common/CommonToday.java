package common;

import javax.servlet.http.HttpServletRequest;

public class CommonToday implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		String toDay = CommonUtil.getToday();
		String toDayTime = CommonUtil.getTodayTime();
		request.setAttribute("t_today",toDay);
		request.setAttribute("t_todayTime",toDayTime);
	}

}
