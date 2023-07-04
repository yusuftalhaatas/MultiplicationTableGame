
public class Question {
	private int number1,number2,result;
	public Question(int number1,int number2) {
		this.number1=number1;
		this.number2=number2;
		this.result=number1*number2;
	}
	
	public int getResult() {
		return result;
	}
	public int getNumber1() {
		return number1;
	}
	
	public int getNumber2() {
		return number2;
	}
}
