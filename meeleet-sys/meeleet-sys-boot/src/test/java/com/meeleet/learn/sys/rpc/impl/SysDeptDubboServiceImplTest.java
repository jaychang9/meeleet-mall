package com.meeleet.cloud.sys.rpc.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.common.pojo.vo.OptionVO;
import com.meeleet.cloud.sys.pojo.dto.SysDeptDTO;
import com.meeleet.cloud.sys.pojo.vo.DeptVO;
import com.meeleet.cloud.sys.rpc.ISysDeptRpcService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@DisplayName("部门Dubbo服务单元测试")
@SpringBootTest
class SysDeptRpcServiceImplTest {

    @Autowired
    private ISysDeptRpcService sysDeptRpcService;

    @Test
    void findById() {
        SysDeptDTO sysDeptDTO = sysDeptRpcService.findById(1L);
        Assert.notNull(sysDeptDTO);
        System.out.println(sysDeptDTO);
    }

    @Test
    void updateById() {
        SysDeptDTO sysDeptDTO = new SysDeptDTO().setId(1L).setName("单元测试部门");
        boolean flag = sysDeptRpcService.updateById(sysDeptDTO);
        Assert.isTrue(flag);
    }

    @Test
    void save() {
        SysDeptDTO sysDeptDTO = new SysDeptDTO().setName("单元测试部门").setParentId(0L).setSort(99).setStatus(1);
        boolean flag = sysDeptRpcService.save(sysDeptDTO);
        Assert.isTrue(flag);
    }

    @Test
    void saveBatch() {
        SysDeptDTO sysDeptDTO1 = new SysDeptDTO().setName("单元测试部门1").setParentId(0L).setSort(97).setStatus(1);
        SysDeptDTO sysDeptDTO2 = new SysDeptDTO().setName("单元测试部门2").setParentId(0L).setSort(98).setStatus(1);
        SysDeptDTO sysDeptDTO3 = new SysDeptDTO().setName("单元测试部门3").setParentId(0L).setSort(99).setStatus(1);

        boolean saveBatch = sysDeptRpcService.saveBatch(Arrays.asList(sysDeptDTO1, sysDeptDTO2, sysDeptDTO3));
        Assert.isTrue(saveBatch);
    }

    @Test
    void saveOrUpdateBatch() {

        SysDeptDTO sysDeptDTO1 = new SysDeptDTO().setName("单元测试部门1").setParentId(0L).setSort(97).setStatus(1);
        SysDeptDTO sysDeptDTO2 = new SysDeptDTO().setId(2L).setName("单元测试部门2").setParentId(0L).setSort(98).setStatus(1);
        SysDeptDTO sysDeptDTO3 = new SysDeptDTO().setName("单元测试部门3").setParentId(0L).setSort(99).setStatus(1);

        boolean saveOrUpdateBatch = sysDeptRpcService.saveOrUpdateBatch(Arrays.asList(sysDeptDTO1, sysDeptDTO2, sysDeptDTO3));
        Assert.isTrue(saveOrUpdateBatch);
    }

    @Test
    void removeById() {
        boolean flag = sysDeptRpcService.removeById(1L);
        Assert.isTrue(flag);
    }

    @Test
    void removeByIds() {
        boolean flag = sysDeptRpcService.removeByIds(Arrays.asList(1L, 2L, 3L));
        Assert.isTrue(flag);
    }


    @Test
    void updateBatchById() {
        SysDeptDTO sysDeptDTO1 = new SysDeptDTO().setId(1L).setName("单元测试部门1").setParentId(0L).setSort(97).setStatus(1);
        SysDeptDTO sysDeptDTO2 = new SysDeptDTO().setId(2L).setName("单元测试部门2").setParentId(0L).setSort(98).setStatus(1);
        boolean flag = sysDeptRpcService.updateBatchById(Arrays.asList(sysDeptDTO1, sysDeptDTO2));
        Assert.isTrue(flag);
    }

    @Test
    void saveOrUpdate() {
        SysDeptDTO sysDeptDTO2 = new SysDeptDTO().setId(2L).setName("单元测试部门2").setParentId(0L).setSort(98).setStatus(1);
        boolean flag = sysDeptRpcService.saveOrUpdate(sysDeptDTO2);
        Assert.isTrue(flag);
    }

    @Test
    void listByIds() {
        List<SysDeptDTO> sysDeptDTOS = sysDeptRpcService.listByIds(Arrays.asList(1L, 2L, 3L));
        Assert.notEmpty(sysDeptDTOS);
        System.out.println(JSONUtil.toJsonStr(sysDeptDTOS));
    }

    @Test
    void count() {
        int count = sysDeptRpcService.count();
        Assert.isTrue(count > 0);
    }

    @Test
    void list() {
        List<SysDeptDTO> sysDeptDTOS = sysDeptRpcService.list();
        Assert.notEmpty(sysDeptDTOS);
        System.out.println(JSONUtil.toJsonStr(sysDeptDTOS));
    }

    @Test
    void page() {
        IPage<SysDeptDTO> page = sysDeptRpcService.page(2, 1);
        Assert.notNull(page);
        Assert.notEmpty(page.getRecords());
        System.out.println(JSONUtil.toJsonStr(page));
    }

    @Test
    void listTableDepartments() {
        List<DeptVO> deptVOS = sysDeptRpcService.listTableDepartments(1, "部门");
        Assert.notEmpty(deptVOS);
        System.out.println(deptVOS);
    }

    @Test
    void listTreeSelectDepartments() {
        List<OptionVO> optionVOS = sysDeptRpcService.listTreeSelectDepartments();
        Assert.notEmpty(optionVOS);
        System.out.println(JSONUtil.toJsonStr(optionVOS));
    }

    @Test
    void saveDept() {
        SysDeptDTO sysDeptDTO = new SysDeptDTO().setName("单元测试部门").setParentId(3L).setSort(1).setStatus(1);
        Long effected = sysDeptRpcService.saveDept(sysDeptDTO);
        Assert.isTrue(effected > 0L);
    }

    @Test
    void deleteByIds() {
        boolean flag = sysDeptRpcService.deleteByIds("2,3");
        Assert.isTrue(flag);
    }


}