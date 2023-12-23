package com.shichong.bank.dao.impl;

import com.shichong.bank.dao.AccountDao;
import com.shichong.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author sc
 * @ClassName AccountDaoImpl
 * @Description class function:
 * @Date 2023/12/21 20:41:22
 **/
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Resource
    public JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {
        String sql = "select * from t_act  where actno = ?";
        Account query = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
        return query;
    }

    @Override
    public List<Account> selectAll() {
        String sql = "select * from t_act";
        List<Account> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
        return query;
    }

    @Override
    public int insert(Account act) {
        String sql ="insert into t_act values(?,?)";
        return jdbcTemplate.update(sql, act.getActno(), act.getBalance());
    }

    @Override
    public int update(Account account) {
        String sql = "update t_act  set balance = ? where actno = ?";
        return jdbcTemplate.update(sql, account.getBalance(), account.getActno());
    }
}
