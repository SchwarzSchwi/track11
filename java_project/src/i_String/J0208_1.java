package i_String;

public class J0208_1 {

	public static void main(String[] args) {
		String str = "가나다라마바";
		int len = str.length();
		System.out.print(len);
		
		String a = str.substring(6);
		System.out.print(a);
		
		String b = str.substring(2,5);
		System.out.print(b);
		
		int position = str.indexOf("가");
		System.out.println("position"+ position);
		if(position != 1) {
			String c = str.substring(position, position +3);
			System.out.println(c);
		}
		if(len > 3) {
			String d = str.substring(0, 3);
			d = d + "...";
			System.out.println(d);
		}
	}

}
