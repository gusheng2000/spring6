package com.shichong.bank.mapper;

import com.shichong.bank.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AccountMapper {
    /**
     * 插入账户
     * @param act
     * @return
     */
    int insert(Account act);

    /**
     *  更新账户
     * @param act
     * @return
     */
    int update(Account act);

    /**
     * 根据账户编号删除账户
     * @param actno
     * @return
     */
    int deleteByAct(String actno);

    /**
     *  根据账户编号查询账户
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 查询所有账户
     * @return
     */
    List<Account> selectAll();

}
