package cafe.exception;

//Menu, Ingredient가 존재하지 않을 경우 예외 발생을 위한 사용자 정의 예외 처리 
public class NotExistException  extends Exception{
	public NotExistException(){}
	public NotExistException(String message){
		super(message);
	}
}
