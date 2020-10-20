package com.cos.board.cofig;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice // 내프로젝트 전체
@RestController // 데이터를 리턴
public class ExceptionController {
	
	@ExceptionHandler(value = Exception.class) //IllegalArgumentException 터질때
	//내 프로젝트 전체에서 IllegalArgumentException터질때 여기로 옴.
	public String 모든오류(Exception e) {
		return e.getMessage(); // BoardController에 있는 메세지 출력.
	}
	
}
