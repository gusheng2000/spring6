package com.shichong.bank.service;

import com.shichong.bank.pojo.Account;

/**
 * 业务接口
 * 事务在这里被控制
 */
public interface AccountService {
    /**
     * 从fromActno账户转账money到toActno账户
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno, String toActno, double money) ;

    /**
     * 保存用户信息
     * @param account
     */
    void save(Account account);
}
