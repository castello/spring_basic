package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.*;
import com.fastcampus.ch4.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Repository
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDao;

    @Override
    public BoardDto read(Integer bno) throws Exception { // @Transactional붙여야 하나... 이거 없이 rollback잘되는지 볼 것.
        BoardDto boardDto = boardDao.select(bno);
        boardDao.increaseViewCnt(bno); // bno가 유효하지 않으면? 결과가 0. 아무 변화 없으니 괜춘. 나중에 댓글에서나 주의

        return boardDto;
    }

    @Override
    public int modify(BoardDto boardDto) throws Exception {
//        throw new Exception("error in purpose");
        return boardDao.update(boardDto);
    }

    @Override
    public int write(BoardDto boardDto) throws Exception {
//        throw new Exception("error in purpose");
        return boardDao.insert(boardDto);
    }

    @Override
    public int remove(Integer bno, String writer) throws Exception {
        // 삭제할 때 권한 체크하고, 삭제 실패시 메시지 보여줄 방법. 어디로 이동?
        // 일단 기본 작업만 처리하고 나머지 부분은 보완하는 식으로
        BoardDto boardDto = boardDao.select(bno);
        if(pemissionCheck(writer, boardDto))
            return boardDao.delete(bno);
        return 0;
    }

    private boolean pemissionCheck(String writer, BoardDto boardDto) {
        // 작성자 또는 관리자인 경우만
        return boardDto.getWriter().equals(writer);
    }

    @Override
    public List<BoardDto> getPage(Page page) {
        try {
            return boardDao.selectPage(page);
        } catch(Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<BoardDto> getList() {
        try {
            return boardDao.selectAll();
        } catch(Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public int getCount() {
        try {
            return boardDao.count();
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
