package h_arraylist;

import java.util.ArrayList;

public class J0208_1_dao {	
	
	 public int getKorTotal(ArrayList<J0208_1_dto> arr) {
	      int KorTotal = 0;
	      for(int k=0; k<arr.size(); k++) {
	         KorTotal += arr.get(k).getKor();
	      }
	      return KorTotal;
	 }
	 public int getEngTotal(ArrayList<J0208_1_dto> arr) {
		 int EngTotal = 0;
		 for(int k=0; k<arr.size(); k++) {
			 EngTotal += arr.get(k).getEng();
		 }
		 return EngTotal;
	 }
	 public int getMatTotal(ArrayList<J0208_1_dto> arr) {
		 int MatTotal = 0;
		 for(int k=0; k<arr.size(); k++) {
			 MatTotal += arr.get(k).getEng();
		 }
		 return MatTotal;
	 }
	
}