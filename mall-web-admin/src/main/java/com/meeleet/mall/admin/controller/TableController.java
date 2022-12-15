package com.meeleet.mall.admin.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.meeleet.cloud.common.result.R;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/table")
public class TableController {


    @Operation(description = "Table列表(仅用于vue admin template调试用)")
    @GetMapping("/list")
    public R<List<Map<String, Object>>> list() {
        String[] statusArray = new String[]{"published", "draft", "deleted"};
        List<Map<String, Object>> tableList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
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
}
