package com.shichong.bank.service.impl;

import com.shichong.bank.pojo.Account;
import com.shichong.bank.mapper.AccountMapper;
import com.shichong.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int save(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int modify(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public int delete(String actno) {
        return accountMapper.deleteByAct(actno);
    }

    @Override
    public Account getByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, double money) throws Exception {
        Account fromAct = accountMapper.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new Exception("余额不足");
        }

        Account toAct = accountMapper.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        // 更新转出账户余额
        int update = accountMapper.update(fromAct);
        // 更新转入账户余额
        String s=null;
        s.toString();
        update += accountMapper.update(toAct);
        if (update != 2){
            throw new Exception("账户更新失败");
        }
    }
}
