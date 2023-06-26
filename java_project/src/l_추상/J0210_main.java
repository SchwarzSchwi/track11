package l_추상;

public class J0210_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		String voice = cat.getVoice();
		String height = cat.getHeight();
		System.out.println("소리:"+voice);
		
		Animal cat2 = new Cat();
		Animal dog2 = new Dog();
		
		Cat	   cat3 = new Cat();
//		Cat cat3 = new Animal();
//		Animal ani = new Animal();
		
		Dog dog = new Dog();
		voice = dog.getVoice();
		System.out.println("소리:"+voice);
	}

}
