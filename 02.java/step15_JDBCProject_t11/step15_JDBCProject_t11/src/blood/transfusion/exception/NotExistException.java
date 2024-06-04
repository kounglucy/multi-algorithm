package blood.transfusion.exception;

// 프로젝트, 헌혈자, 수혈자 존재하지 않을 경우 예외 발생을 위한 사용자 정의 예외 처리 
public class NotExistException extends Exception{
	public NotExistException(){}
	public NotExistException(String message){
		super(message);
	}
}
