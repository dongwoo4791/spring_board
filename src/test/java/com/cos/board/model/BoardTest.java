package com.cos.board.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class BoardTest {

	@Test
	public void 롬북_테스트() {
		System.out.println("=============");
		//1. Board 모델 
		Board board1 = new Board();
		board1.setId(1);
		board1.setTitle("제목");
		System.out.println(board1);
		System.out.println("=============");
		
		Board board2 = new Board(
				2,
				"제목2",
				"내용2",
				0,
				Timestamp.valueOf(LocalDateTime.now()) //현재시간. tiemstamp 타입이 아니라서 변경해줘야 함.
				);
	System.out.println(board2);
	System.out.println("=============");
	
	//경우 : id는 추가 안하고 싶음
	//경우 : 순서가 기억이 안남.
	//해결 : 빌더 패턴
	//set함수를 안쓰고 순서에 상관 없이 한줄에 원하는 데이터만 넣어줌.
	Board board3 = Board.builder().title("제목3").content("내용3").build();
	System.out.println(board3);
	System.out.println("=============");
	
	}
	
//	public void 시간() {
//		Timestamp ts = Timestamp.valueOf(LocalDateTime.now());
//		//localDateTime의 현재시간을 TimeStamp로 변경하여 db에 넣을 수 있게 함	
//	System.out.println(ts);
//	
//	}
}
