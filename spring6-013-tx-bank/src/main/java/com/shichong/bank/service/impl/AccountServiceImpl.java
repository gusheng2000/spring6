package com.shichong.bank.service.impl;

import com.shichong.bank.dao.AccountDao;
import com.shichong.bank.pojo.Account;
import com.shichong.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

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


//    @Resource
//    public TransactionTemplate transactionTemplate;

    @Override
    @Transactional
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
            String s = null;
            s.toString();
            update += accountDao.update(toAccount);
            if (update != 2) {
                throw new RuntimeException("转账失败");
            }
            System.out.println("转账完成");
        }

   /* @Override
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
        PlatformTransactionManager transactionManager = transactionTemplate.getTransactionManager();
        TransactionStatus transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {

            transaction.createSavepoint();
            int update = accountDao.update(fromAccount);
            //模拟异常
            String s = null;
            s.toString();
            update += accountDao.update(toAccount);
            if (update != 2) {
                throw new RuntimeException("转账失败");
            }
            transactionManager.commit(transaction);
            System.out.println("转账完成");
        }catch (Exception e ){
            transactionManager.rollback(transaction);
            System.out.println("转账失败");
        }
    }*/
}
