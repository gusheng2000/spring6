package com.shichong.spring6.web;

import com.shichong.spring6.service.UserService;
import com.shichong.spring6.service.impl.UserServiceImpl;

/**表示层
 * @Author sc
 * @ClassName UserAction
 * @Description class function:
 * @Date 2023/12/12 22:31:20
 **/
public class UserAction {
    private UserService userService = new UserServiceImpl();

    /**
     * 删除用户信息
     */
    public void deleteRequest() {
        userService.delete();
    }

}
