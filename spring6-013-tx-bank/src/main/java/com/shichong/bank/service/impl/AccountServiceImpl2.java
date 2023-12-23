package com.shichong.bank.service.impl;

import com.shichong.bank.dao.AccountDao;
import com.shichong.bank.pojo.Account;
import com.shichong.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author sc
 * @ClassName AccountServiceImpl2
 * @Description class function:
 * @Date 2023/12/22 21:17:08
 **/
@Service("accountService2")

public class AccountServiceImpl2 implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Override
    //如果是REQUIRES_NEW 就变成了连个事务
    //003 可以保存 004不行
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_UNCOMMITTED)
    public void save(Account account) {
        List<Account> accounts = accountDao.selectAll();
        accountDao.insert(account);
        String s = null;
        s.toString();

        //这里的save 方法已经加入事务管理出现异常后全部回滚
    }
}
