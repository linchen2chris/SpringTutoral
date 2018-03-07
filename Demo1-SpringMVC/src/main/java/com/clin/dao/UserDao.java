package com.clin.dao;

import com.clin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    private static final String MATCH_COUNT_SQL = "SELECT count(*) " +
            "FROM t_user " +
            "WHERE user_name =? and password=?";
    private static final String UPDATE_LOGIN_INFO_SQL = "UPDATE t_user " +
            "SET last_visit=?,last_ip=?,credits=? " +
            "WHERE user_id=?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String userName, String password) {
        return jdbcTemplate.queryForList(MATCH_COUNT_SQL, new Object[]{userName, password}).size();
    }

    public User findUserByUserName(final String userName) {
        final User user = new User();
        String sqlStr = " SELECT user_id,user_name,credits "
                + " FROM t_user WHERE user_name =? ";
        jdbcTemplate.query(sqlStr, new Object[]{userName},
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setUserId(rs.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredit(rs.getInt("credits"));
                    }
                });
        return user;
    }

    public void updateLoginInfo(User user) {
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredit(), user.getUserId()});
    }

}
