package com.shichong.bank.service.impl;

import com.shichong.bank.dao.AccountDao;
import com.shichong.bank.pojo.Account;
import com.shichong.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author sc
 * @ClassName AccountServiceImpl
 * @Description class function:
 * @Date 2023/12/21 20:50:56
 **/
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;
    @Resource(name = "accountService2")
    private AccountService accountService2;


//    @Resource
//    public TransactionTemplate transactionTemplate;


    /*
        * 事务传播行为：
        REQUIRED: 默认如果存在事务，则加入事务，如果当前没有事务，则创建一个新的事务。

        REQUIRES_NEW: 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
        SUPPORTS: 如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
        MANDATORY:必须在同一个事务内,没有就抛异常
        NOT_SUPPORTED: 存在就挂起当前事务 不支持事务
        NEVER:  以非事务的方式运行,如果有事务就就抛异常
        NESTED: 有事务的话，就在这个事务里再嵌套一个完全独立的事务,嵌套的事务可以独立的提交和回滚。没有事务就和REQUIRED一样。】
        * */
    @Override
    public void transfer(String fromActno, String toActno, double money) {

        Account fromAccount = accountDao.selectByActno(fromActno);
        if (fromAccount.getBalance() < money) {
            //余额不足
            throw new RuntimeException("余额不足");
        }
        //余额充足
        Account toAccount = accountDao.selectByActno(toActno);
        toAccount.setBalance(toAccount.getBalance() + money);
        fromAccount.setBalance(fromAccount.getBalance() - money);

        int update = accountDao.update(fromAccount);
        //模拟异常
//        String s = null;
//        s.toString();
        update += accountDao.update(toAccount);
        if (update != 2) {
            throw new RuntimeException("转账失败");
        }
        System.out.println("转账完成");
    }

    @Transactional
    public void withdraw(String actno, double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT)
    public void save(Account account) {
        accountDao.insert(account);

        Account act2 = new Account("004", 10000.00);
        accountService2.save(act2);
    }
}
