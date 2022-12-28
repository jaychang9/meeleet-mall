package com.meeleet.mall.admin.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.common.result.R;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author jaychang
 */
@RestController
@RequestMapping("/table")
public class TableController {


    @Operation(description = "Table列表(仅用于vue admin template调试用)")
    @GetMapping("/list")
    public R<List<Map<String, Object>>> list() {
        String[] statusArray = new String[]{"published", "draft", "deleted"};
        List<Map<String, Object>> tableList = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Map<String, Object> t = new HashMap<>();
            t.put("id", i);
            t.put("title", "title" + i);
            t.put("author", "author" + i);
            t.put("pageviews", i + 100);
            t.put("status", statusArray[RandomUtil.randomInt(0, 3)]);
            t.put("displayTime", DateUtil.format(new Date(), DatePattern.NORM_DATETIME_FORMAT));
            tableList.add(t);
        }
        return R.success(tableList);
    }

    @Operation(description = "Table分页列表(仅用于vue admin template调试用)")
    @GetMapping("/page")
    public R<Page<Map<String, Object>>> page(int current, int size) {
        String[] statusArray = new String[]{"published", "draft", "deleted"};
        List<Map<String, Object>> tableList = new ArrayList<>();
        int TOTAL = 2500;
        for (int i = 0; i < TOTAL; i++) {
            Map<String, Object> t = new HashMap<>();
            t.put("id", i);
            t.put("title", "title" + i);
            t.put("author", "author" + i);
            t.put("pageviews", i + 100);
            t.put("status", statusArray[RandomUtil.randomInt(0, 3)]);
            t.put("displayTime", DateUtil.format(new Date(), DatePattern.NORM_DATETIME_FORMAT));
            tableList.add(t);
        }
        Page<Map<String, Object>> page = new Page<>();
        page.setCurrent(current).setSize(size).setTotal(TOTAL);
        page.setRecords(tableList.stream().skip((current - 1) * size).limit(size).collect(Collectors.toList()));
        return R.success(page);
    }
}
