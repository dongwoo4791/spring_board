package com.cos.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.board.model.Board;

// 자동 IOC 등록됨. 어노테이션이 없어도 jpaRepository가 자동으로 들고 있음
public interface BoardRepository extends JpaRepository<Board,	Integer>{
	//public abstract  생략되어 있음
	
	//쿼리를 직접 만듬
	// ? 하지말고 :id해야 순서에 상관없이 바인딩 됨.
	@Query(value = "SELECT * FROM board WHERE id = :id",nativeQuery = true)
	Board mFindById(int id);
	
	@Modifying // 수정, 삭제, 저장(db 변경)할때 걸어 줘야 commit 됨.
	@Query(value = "DELETE FROM board WHERE id = :id",nativeQuery = true)
	int mDeleteById(int id);
	
}
