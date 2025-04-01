package com.gong.manage.web.controller.monitor;

import com.gong.manage.common.annotation.Log;
import com.gong.manage.common.enums.BusinessType;
import com.gong.manage.system.entity.SysOperLog;
import com.gong.manage.system.service.SysOperLogService;
import com.gong.manage.common.result.Pages;
import com.gong.manage.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor/operLog")
public class SysOperLogController {

    private SysOperLogService sysOperLogService;

    @Autowired
    public SysOperLogController(SysOperLogService sysOperLogService) {
        this.sysOperLogService = sysOperLogService;
    }


    /**
     * 查询
     */
    @GetMapping("/list")
    Result<Pages<SysOperLog>> list(SysOperLog sysOperLog) {
        List<SysOperLog> list = sysOperLogService.getList(sysOperLog);
        return Result.success(Pages.createPage(list));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    @Log(title = "删除操作日志", businessType = BusinessType.DELETE)
    Result<String> remove(@PathVariable List<Long> ids) {
        sysOperLogService.removeByIds(ids);
        return Result.success("删除成功");
    }

    @DeleteMapping
    @Log(title = "删除操作日志", businessType = BusinessType.DELETE)
    Result<String> removeAll() {
        sysOperLogService.removeByIds(null);
        return Result.success("删除成功");
    }
}
