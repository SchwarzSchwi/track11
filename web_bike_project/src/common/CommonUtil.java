package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
	//자료실 첨부경로
		public static String getFile_dir_pds() {
			String pdsDir ="D:/track11_csw/work_project/web_bike_project/WebContent/attach/pds/";
			return pdsDir;
		}
	//news 첨부경로
	public static String getFile_dir_news() {
		String newsDir ="C:/Users/Choi/Desktop/it/work_project/track11/web_bike_project/WebContent/attach/news";
		return newsDir;
	}
	//공지사항 첨부경로
	public static String getFile_dir_notice() {
		String noticeDir ="C:/Users/Choi/Desktop/it/work_project/track11/web_bike_project/WebContent/attach/notice";
		return noticeDir;
	}
	//제품 첨부경로
		public static String getFile_dir_product() {
			String productDir ="C:/Users/Choi/Desktop/it/work_project/track11/web_bike_project/WebContent/attach/product";
			return productDir;
		}
	//qna 첨부경로
			public static String getFile_dir_qna() {
				String qnaDir ="C:/Users/Choi/Desktop/it/work_project/track11/web_bike_project/WebContent/attach/qna";
				return qnaDir;
			}	
	//freeboard 첨부경로		
			public static String getFile_dir_freeboard() {
				String freeboard = "C:/Users/Choi/Desktop/it/work_project/track11/web_bike_project/WebContent/attach/freeboard";
				return freeboard;
			}
			public static final int SEC = 60;
			public static final int MIN = 60;
			public static final int HOUR = 24;
			public static final int DAY = 30;
			public static final int MONTH = 12;

			public static String convertDate(String date) {
				String result = null;
				
				SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date_date = new Date();
				try {
					date_date = fm.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long curTime = System.currentTimeMillis();
				long regTime = date_date.getTime();
				long diffTime = (curTime - regTime) / 1000;

				if (diffTime < CommonUtil.SEC) {
					// sec
					result = "방금 전";
				} else if ((diffTime /= CommonUtil.SEC) < CommonUtil.MIN) {
					// min
					result = diffTime + "분 전";
				} else if ((diffTime /= CommonUtil.MIN) < CommonUtil.HOUR) {
					// hour
					result = (diffTime) + "시간 전";
				} else if ((diffTime /= CommonUtil.HOUR) < CommonUtil.DAY) {
					// day
					result = (diffTime) + "일 전";
				} else if ((diffTime /= CommonUtil.DAY) < CommonUtil.MONTH) {
					// day
					result = (diffTime) + "달 전";
				} else {
					result = (diffTime) + "년 전";
				}
				return result;
			}
//오늘날짜
	public static String getToday(){
	   Date time = new Date();
	   SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	   String today = format1.format(time);
	   return today;
	}
	//오늘날짜 시분초
	
	public static String getTodayTime(){
	   Date time = new Date();
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String today = format.format(time);
	   return today; 
	}	   

//페이지 설정
	public static String pageListPost(int current_page,int total_page, int pageNumber_count){
		int pagenumber;    //화면에 보여질 페이지 인덱스수
		int startpage;     //화면에 보여질 시작 페이지 번호
		int endpage;       //화면에 보여질 마지막 페이지 번호
		int curpage;       //이동하고자 하는 페이지 번호
		
		String strList=""; //리턴될 페이지 인덱스 리스트

		pagenumber = pageNumber_count;   //한 화면의 페이지 인덱스수
		
		//시작 페이지 번호 구하기
		startpage = ((current_page - 1)/ pagenumber) * pagenumber + 1;
		//마지막 페이지 번호 구하기
		endpage = (((startpage -1) + pagenumber) / pagenumber)*pagenumber;
		//총페이지수가 계산된 마지막 페이지 번호보다 작을 경우
		//총페이지수가 마지막 페이지 번호가 됨
		
		if(total_page <= endpage)  endpage = total_page;
					
		//첫번째 페이지 인덱스 화면이 아닌경우
		if(current_page > pagenumber){
			curpage = startpage -1;  //시작페이지 번호보다 1적은 페이지로 이동
			strList = strList +"<a href=javascript:goPage('"+curpage+"') ><i class='fa fa-angle-double-left'></i></a>";
		}
						
		//시작페이지 번호부터 마지막 페이지 번호까지 화면에 표시
		curpage = startpage;
		while(curpage <= endpage){
			if(curpage == current_page){
				strList = strList +"<a class='active'>"+current_page+"</a>";
			} else {
				strList = strList +"<a href=javascript:goPage('"+curpage+"')>"+curpage+"</a>";
			}
			curpage++;
		}
		//뒤에 페이지가 더 있는 경우
		if(total_page > endpage){
			curpage = endpage+1;
			strList = strList + "<a href=javascript:goPage('"+curpage+"') ><i class='fa fa-angle-double-right'></i></a>";
		}
		return strList;
	}	
	
}