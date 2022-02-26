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
    public BoardDto read(Integer bno) throws Exception { 
        BoardDto boardDto = boardDao.select(bno);
        boardDao.increaseViewCnt(bno); 

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
        return boardDao.delete(bno, writer);
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
