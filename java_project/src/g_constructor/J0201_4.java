package g_constructor;

import java.util.Scanner;

public class J0201_4 {

	public static void main(String[] args) {
		String str[] = new String[3];
		Scanner sc = new Scanner(System.in);
		for(int k=0; k<str.length; k++) {
			System.out.print("input?");
			String val = sc.next();
			str[k]=val;
		}
		for(int k=0; k<str.length; k++) {
			System.out.println("str : "+str[k]);
		}
	}

}
