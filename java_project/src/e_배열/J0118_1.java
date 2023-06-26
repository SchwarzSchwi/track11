package e_배열;

public class J0118_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] aa = {"홍길동", "대전", "25"};
		String[][] str={
							{"홍길동","대전","25"},
							{"이상화","서울","30"}
						};
		int[][] score= {{10,20,30,40,50},
						{100,200,300,400,0}};
		for(int k=0; k<score.length; k++) {
			int total = 0;
			for(int j=0; j<score[k].length; j++){
				total = total + score[k][j];
				System.out.print(score[k][j]+"\t");
			}
			System.out.print(total);
			System.out.print("\n");
		}
	}

}
