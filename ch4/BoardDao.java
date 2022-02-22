package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;

import java.util.*;

public interface BoardDao {
    BoardDto select(Integer bno) throws Exception;
    int delete(Integer bno) throws Exception;
    int insert(BoardDto dto) throws Exception;
    int update(BoardDto dto) throws Exception;
    int increaseViewCnt(Integer bno) throws Exception;
    
    List<BoardDto> selectPage(Map map) throws Exception;
    List<BoardDto> selectAll() throws Exception;
    int deleteAll() throws Exception;
    int count() throws Exception;
}
