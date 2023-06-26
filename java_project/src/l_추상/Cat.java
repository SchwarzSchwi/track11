package l_추상;

public class Cat extends Animal{
	String getHeight() {
		return "25cm";
	}
	
	@Override
	String getVoice() {
		return "meaw~";
	}
	@Override
	int getWeight() {
		return 3;
	}
}	
