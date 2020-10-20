package com.cos.board.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.model.Board;
import com.cos.board.repository.BoardRepository;

@Service 
public class BoardService {

	// 의존성 주입 DI
	@Autowired
	private BoardRepository boardRepository;
	
		@Transactional //db에 영향을 주기때문에 사용, 스프링프레임워크 임포트
		public void 글쓰기(BoardSaveRequestDto dto) {
			Board boardEntity = BoardSaveRequestDto.toEntity(dto);
			boardRepository.save(boardEntity);
		}
		
		@Transactional(readOnly = true) // db에 영향은 없지만 걸어놈.
		public Page<Board> 글목록보기(Pageable pageable) {
			 return boardRepository.findAll(pageable); // 5번씩 페이징 함
		}
		
		@Transactional
		public Board 글상세보기(int id){
			Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("id값 잘못들어옴"));
			board.setReadCount(board.getReadCount()+1);
			return board;
		}//RuntimeException하면 try catch없이 롤백처리함.
		
		@Transactional
		public void 글삭제하기(int id) {
			boardRepository.mDeleteById(id);
		}
		
		@Transactional
		public void 글수정하기(int id, BoardSaveRequestDto dto) {
			//더티 체킹
			Board boardEntity = boardRepository.mFindById(id);
			boardEntity.setTitle(dto.getTitle());
			boardEntity.setContent(dto.getContent());
		}
}






