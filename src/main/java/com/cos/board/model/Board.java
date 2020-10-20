package com.cos.board.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data // -> Getter, Setter 합쳐져 있음. + toString() 구현되어 있음.
//@Getter
//@Setter
@AllArgsConstructor // 전체 파라메터를 가진 생성자
@NoArgsConstructor // 파라메터가 없는 default 생성자
@Builder // 빌더 패턴
@Entity // ORM 기본키가 있어야 함
public class Board {
	@Id // 기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 데이터베이스 번호증가 전략을 따라 가기 
	private  int id;
	private String title;
	private String content;
	private int readCount;
	@CreationTimestamp // 자동으로 날짜를 넣어줌.
	private Timestamp createDate; // java.sql로 import
	
	
//	//날짜 형식 바꾸기
//	public Timestamp getCreateDate() {
//		String temp= createDate.toString().substring(0,10);
//		return Timestamp.valueOf(temp);
//	}
}
