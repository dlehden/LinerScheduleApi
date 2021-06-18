package com.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*ControllerAdvice 어노테이션을 붙인 클래스들은 추후 생기는 Exception을 catch하는 기능을 가지고 있다
 * ControllerAdvice를 사용하는 이유는 2가지 라고 생각한다.

		예외처리를 한곳에 묶어서 편하게 가능하다.
		특정한 경우 예외처리를 담당하는 클래스를 생성하고 그 클래스를 ExceptionHandler에 등록해준다면
		이곳에서 특정 예외처리를 모두 담당할수있다.
		
		예외가 발생했을때 stack Message를 노출하지 않기 위해서이다.
		개발도중에 stack Message는 오히려 예외를 처리할수 있는 좋은 예시가 되지만
		운영도중에 stack Message를 그대로 노출하는것은 치명적인 단점이고 보안에도 취약할수있다.
		그렇기 때문에 ControllerAdvice를 사용해 예측하지 못한 상황에서 모든 예외상황을
		처리하는 것이다.
 */
@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ScheduleNotFoundException.class)
	public ResponseEntity<ApiErrorResponse>handleException(ScheduleNotFoundException ex){
		System.out.println(ex.getYyyymm()+"0------------------여기 실행");
		ApiErrorResponse response =
					new ApiErrorResponse("error-0001","No Schedule Data: " + ex.getYyyymm());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}

}
