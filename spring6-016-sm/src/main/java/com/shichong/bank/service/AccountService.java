package com.shichong.bank.service;

import com.shichong.bank.pojo.Account;

import java.util.List;

public interface AccountService {
    /**
     * 开户
     * @param account
     * @return
     */
    int save(Account account);

    /**
     *  修改
     * @param account
     * @return
     */
    int modify(Account account);

    /**
     * 销户
     * @param actno
     * @return
     */

    int delete(String actno);

    /**
     * 根据账号查询
     * @param actno
     * @return
     */
    Account getByActno(String actno);

    /**
     * 查询所有账户
     * @return
     */
    List<Account> getAll();

    /**
     * 转账
     * @param fromActno
     * @param toActno
     * @param money
     * @throws Exception
     */
    void transfer(String fromActno, String toActno, double money) throws Exception;
}
