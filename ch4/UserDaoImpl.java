package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    DataSource ds;

    @Override
    public int deleteUser(String id) throws Exception {
        int rowCnt = 0;
        String sql = "DELETE FROM user_info WHERE id= ? ";

        try (  // try-with-resources - since jdk7
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setString(1, id);
            return pstmt.executeUpdate(); //  insert, delete, update
//      } catch (Exception e) {
//          e.printStackTrace();
//          throw e;
        }
    }

    @Override
    public User selectUser(String id) throws Exception {
        User user = null;
        String sql = "SELECT * FROM user_info WHERE id= ? ";

        try (
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(); //  select
        ){
            pstmt.setString(1, id);

            if (rs.next()) {
                user = new User();
                user.setId(rs.getString(1));
                user.setPwd(rs.getString(2));
                user.setName(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setBirth(new Date(rs.getDate(5).getTime()));
                user.setSns(rs.getString(6));
                user.setReg_date(new Date(rs.getTimestamp(7).getTime()));
            }
        }

        return user;
    }

    // 사용자 정보를 user_info테이블에 저장하는 메서드
    @Override
    public int insertUser(User user) throws Exception {
        int rowCnt = 0;
        String sql = "INSERT INTO user_info VALUES (?,?,?,?,?,?, now()) ";

        try(
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql); // SQL Injection공격, 성능향상
        ){
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPwd());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
            pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
            pstmt.setString(6, user.getSns());

            return pstmt.executeUpdate();
        }
    }

    @Override
    public int updateUser(User user) throws Exception {
        int rowCnt = 0;

        String sql = "UPDATE user_info " +
                     "SET pwd = ?, name=?, email=?, birth =?, sns=?, reg_date=? " +
                     "WHERE id = ? ";

        try (
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setString(1, user.getPwd());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
            pstmt.setString(5, user.getSns());
            pstmt.setTimestamp(6, new java.sql.Timestamp(user.getReg_date().getTime()));
            pstmt.setString(7, user.getId());

            rowCnt = pstmt.executeUpdate();
        }

        return rowCnt;
    }

    @Override
    public int count() throws Exception {
        String sql = "SELECT count(*) FROM user_info ";

        try(
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
        ){
            rs.next();
            int result = rs.getInt(1);

            return result;
        }
    }

    @Override
    public void deleteAll() throws Exception {
        try (Connection conn = ds.getConnection();)
        {
            String sql = "DELETE FROM user_info ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        }
    }
}
