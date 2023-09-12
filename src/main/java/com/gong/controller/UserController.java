package com.gong.controller;

import com.gong.common.BaseContent;
import com.gong.common.ResponseStatus;
import com.gong.entity.*;
import com.gong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/system/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     *  /system/user/space
     * 更新用户个人信息
     * @param from
     * @return
     */
    @PutMapping("/space")
    public Result<String> update(@RequestBody BaseUserInfo from) {
        from.setId(BaseContent.getId());  // 确保修改的时当前的用户
        if (userService.updateBaseUserInfoById(from) != 0) {
            return Result.success("更新成功");
        }
        return Result.error(ResponseStatus.NOT_MODIFY, "更新失败!");
    }
    /**
     * /system/user/space
     * 个人中心的数据
     * @return
     */
    @GetMapping("/space")
    public Result<User> getInfo() {
        User user = userService.getById(BaseContent.getId());
        return Result.success(user);
    }

    /**
     * /system/user/updatePwd 修改密码
     * @param from
     * @return
     */
    @PutMapping("/updatePwd")
    public Result<String> updatePwd(@RequestBody LoginFrom from) {
        if (userService.updatePwdById(BaseContent.getId(), from.getPassword()) != 0) {
            return Result.success("修改成功");
        }
        return Result.error(ResponseStatus.NOT_MODIFY, "修改失败！请检查格式");
    }

}
