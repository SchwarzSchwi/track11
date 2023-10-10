package e_array;

public class J0117_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"홍길동","50","60","70"};
		//출력 : 홍길동 총점 180
		int total = 0;
		for(int k = 1; k < str.length; k++) {
			total = total + Integer.parseInt(str[k]);
		}
		System.out.println(str[0]+"총점 : "+ total);
		
		String[] score = new String[str.length+1];
		total = 0;
		for(int k=0; k < str.length; k++) {
			score[k] = str[k];
			if(k>0) total = total + Integer.parseInt(str[k]);
		}
		score[str.length] = Integer.toString(total);
		//출력
		for(int k=0; k < score.length; k++) {
			System.out.print(score[k]+"\t");
		}
	}

}
