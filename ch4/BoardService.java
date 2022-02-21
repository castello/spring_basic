package com.fastcampus.ch4.service;

import com.fastcampus.ch4.domain.*;

import java.util.*;

public interface BoardService {
    BoardDto read(Integer bno) throws Exception;
    int modify(BoardDto boardDto) throws Exception;
    int write(BoardDto boardDto) throws Exception;
    int remove(Integer bno, String writer) throws Exception;
    List<BoardDto> getPage(Page page);
    List<BoardDto> getList();
    int getCount();
}
