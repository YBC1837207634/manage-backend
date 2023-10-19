package com.gong.controller.monitor;

import com.gong.enums.BusinessType;
import com.gong.annotation.Log;
import com.gong.entity.SysLogininfor;
import com.gong.service.SysLogininforService;
import com.gong.vo.Pages;
import com.gong.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor/recordLogin")
public class SysLogininforController {

    private SysLogininforService sysLogininforService;

    @Autowired
    public SysLogininforController(SysLogininforService sysLogininforService) {
        this.sysLogininforService = sysLogininforService;
    }

    /**
     * 查询
     */
    @GetMapping("/list")
    Result<Pages<SysLogininfor>> list(SysLogininfor sysLogininfor) {
        List<SysLogininfor> list = sysLogininforService.getList(sysLogininfor);
        return Result.success(Pages.createPage(list));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    @Log(title = "删除登陆日志", businessType = BusinessType.DELETE)
    Result<String> remove(@PathVariable List<Long> ids) {
        sysLogininforService.removeByIds(ids);
        return Result.success("删除成功");
    }

    @DeleteMapping
    @Log(title = "删除登陆日志", businessType = BusinessType.DELETE)
    Result<String> removeAll() {
        sysLogininforService.removeByIds(null);
        return Result.success("删除成功");
    }
}
