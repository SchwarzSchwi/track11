package m_interface;

public class Cat extends Animal implements InterAA, InterBB{
	@Override
	public String getVoice() {
		return "meaw~";
	}
	@Override
	String getName() {
		return "cat";
	}
	@Override
	public String getColor() {
		return "color";
	}
}
