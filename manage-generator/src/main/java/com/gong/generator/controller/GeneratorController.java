package com.gong.generator.controller;

import com.gong.generator.entity.GenTable;
import com.gong.generator.service.GenTableColumnService;
import com.gong.generator.service.GenTableService;
import com.gong.vo.Pages;
import com.gong.vo.Result;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/tool/generator")
public class GeneratorController {

    @Autowired
    private GenTableService genTableService;

    @Autowired
    private GenTableColumnService genTableColumnService;

    /**
     * 查询没有导入的表
     * @param genTable
     * @return
     */
    @GetMapping("/db/list")
    public Result<Pages<GenTable>> DbTablePages(GenTable genTable) {
        List<GenTable> list = genTableService.getTableList(genTable);
        return Result.success(Pages.createPage(list));
    }

    /**
     * 获取已经导入的表
     * @return
     */
    @GetMapping("/table/list")
    public Result<Pages<GenTable>> genTablePages(GenTable genTable) {
        List<GenTable> list = genTableService.getGenTableList(genTable);
        return Result.success(Pages.createPage(list));
    }

    /**
     * 根据id获取表的详细信息
     * @param tbId
     * @return
     */
    @GetMapping("/table/{tbId}")
    public Result<Map> getInfo(@PathVariable("tbId") Long tbId) {
        Map<String, Object> map = new TreeMap<>();
        map.put("genTable", genTableService.getGenTable(tbId));
        map.put("rows", genTableColumnService.getTableColumnListByTableId(tbId));
        return Result.success(map);
    }

    /**
     * 导入数据库表
     * @param tableNames
     * @return
     */
    @GetMapping("/table/imp")
    public Result<String> importGenTable(@RequestParam("tableNames") List<String> tableNames) {
        genTableService.importTable(tableNames);
        return Result.success("导入成功！");
    }

    /**
     * 预览生成代码
     * @param tableId
     * @return
     */
    @GetMapping("/gen/preview/{tableId}")
    public Result<Map> previewCode(@PathVariable("tableId")Long tableId) {
        Map<String, String> res = genTableService.previewCode(tableId);
        return Result.success(res);
    }

    @DeleteMapping("/table/{ids}")
    public Result<String> removeTables(@PathVariable("ids") Long[] ids) {
        genTableService.removeGenTableByIds(ids);
        return Result.success("删除成功");
    }

    @PutMapping
    public Result<String> edit(@RequestBody GenTable genTable) {
        genTableService.updateGenTable(genTable);
        return Result.success("修改成功");
    }

    /**
     * 生成代码（下载）
     */
//    @PreAuthorize("@s.hasPermi('tool:gen:code')")
//    @Log(title = "代码生成", businessType = BusinessType.GENCODE)
    @GetMapping("/download/{tableId}")
    public Result<String> download(@PathVariable("tableId")Long tableId, HttpServletResponse response) throws IOException {
        byte[] data = genTableService.downloadCode(tableId);
        response.reset();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
        return Result.success("");
    }

}
