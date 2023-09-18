package com.gong.controller;

import com.gong.common.BaseContent;
import com.gong.common.ResponseStatus;
import com.gong.entity.*;
import com.gong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * user/space
     * 更新用户个人信息
     *
     * @param from
     * @return
     */
    @PutMapping("/space")
    public Result<String> updateSpace(@RequestBody BaseUserInfo from) {
        from.setId(BaseContent.getId());  // 确保修改的时当前的用户
        if (userService.updateBaseUserInfoById(from) != 0) {
            return Result.success("更新成功");
        }
        return Result.error(ResponseStatus.NOT_MODIFY, "更新失败!");
    }

    /**
     * 根据id修改用户的信息(需要权限)
     * @param user
     * @return
     */
    @PutMapping
    public Result<String> update(@RequestBody User user) {
        if (user.getId() != null && userService.updateUserById(user) != 0 ) {
            return Result.success("更新成功");
        }
        return Result.error(ResponseStatus.NOT_MODIFY, "更新失败!");
    }

    /**
     * user/space
     * 个人中心的数据
     *
     * @return
     */
    @GetMapping("/space")
    public Result<User> getInfo() {
        User user = userService.getById(BaseContent.getId());
        return Result.success(user);
    }

    /**
     * /system/user/updatePwd 修改密码
     *
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

    /**
     * 用户分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public Result<Pages> page(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(userService.pages(page, pageSize));
    }

}
