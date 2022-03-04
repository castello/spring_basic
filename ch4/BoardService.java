package com.fastcampus.ch4.service;

import com.fastcampus.ch4.domain.*;

import java.util.*;

public interface BoardService {
    int getCount() throws Exception;
    int remove(Integer bno, String writer) throws Exception;
    int write(BoardDto boardDto) throws Exception;
    List<BoardDto> getList() throws Exception;
    BoardDto read(Integer bno) throws Exception;
    List<BoardDto> getPage(Map map) throws Exception;
    int modify(BoardDto boardDto) throws Exception;

    int getSearchResultCnt(SearchCondition sc) throws Exception;
    List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception;
}
