package com.shichong.bank.dao;

import com.shichong.bank.pojo.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 根据账号查询
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     *更新用户信息
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 保存用户信息
     * @param act
     */
    int insert(Account act);

    List<Account> selectAll();
}
