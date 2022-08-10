package com.meeleet.cloud.sys.rpc.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.convert.SysOauthClientConvert;
import com.meeleet.cloud.sys.pojo.dto.ClientAuthDTO;
import com.meeleet.cloud.sys.pojo.dto.SysOauthClientDTO;
import com.meeleet.cloud.sys.pojo.entity.SysOauthClient;
import com.meeleet.cloud.sys.rpc.ISysOauthClientRpcService;
import com.meeleet.cloud.sys.service.ISysOauthClientService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@DubboService
@AllArgsConstructor
public class SysOauthClientRpcServiceImpl implements ISysOauthClientRpcService {

    private final ISysOauthClientService sysOauthClientService;

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean save(SysOauthClientDTO sysOauthClientDTO) {
        return sysOauthClientService.save(SysOauthClientConvert.INSTANCE.bizDTOToEntity(sysOauthClientDTO));
    }

    @Override
    public boolean saveBatch(Collection<SysOauthClientDTO> sysOauthClientDTOList) {
        return sysOauthClientService.saveBatch(SysOauthClientConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysOauthClientDTOList));
    }

    @Override
    public boolean saveBatch(Collection<SysOauthClientDTO> sysOauthClientDTOList, int batchSize) {
        return sysOauthClientService.saveBatch(SysOauthClientConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysOauthClientDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysOauthClientDTO> sysOauthClientDTOList) {
        return sysOauthClientService.saveOrUpdateBatch(SysOauthClientConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysOauthClientDTOList));
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysOauthClientDTO> sysOauthClientDTOList, int batchSize) {
        return sysOauthClientService.saveOrUpdateBatch(SysOauthClientConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysOauthClientDTOList), batchSize);
    }

    @Override
    public boolean removeById(Long id) {
        return sysOauthClientService.removeById(id);
    }

    @Override
    public boolean removeByIds(Collection<Long> idList) {
        return sysOauthClientService.removeByIds(idList);
    }

    @Override
    public boolean updateById(SysOauthClientDTO sysOauthClientDTO) {
        return sysOauthClientService.updateById(SysOauthClientConvert.INSTANCE.bizDTOToEntity(sysOauthClientDTO));
    }

    @Override
    public boolean updateBatchById(Collection<SysOauthClientDTO> sysOauthClientDTOList) {
        return sysOauthClientService.updateBatchById(SysOauthClientConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysOauthClientDTOList));
    }

    @Override
    public boolean updateBatchById(Collection<SysOauthClientDTO> sysOauthClientDTOList, int batchSize) {
        return sysOauthClientService.updateBatchById(SysOauthClientConvert.INSTANCE.bizDTOCollectionToEntityCollection(sysOauthClientDTOList), batchSize);
    }

    @Override
    public boolean saveOrUpdate(SysOauthClientDTO sysOauthClientDTO) {
        return sysOauthClientService.saveOrUpdate(SysOauthClientConvert.INSTANCE.bizDTOToEntity(sysOauthClientDTO));
    }

    @Override
    public SysOauthClientDTO findById(Long id) {
        return SysOauthClientConvert.INSTANCE.entityToBizDTO(sysOauthClientService.getById(id));
    }

    @Override
    public List<SysOauthClientDTO> listByIds(Collection<Long> idList) {
        return SysOauthClientConvert.INSTANCE.entityListToBizDTOList(sysOauthClientService.listByIds(idList));
    }

    @Override
    public int count() {
        return sysOauthClientService.count();
    }

    @Override
    public List<SysOauthClientDTO> list() {
        return SysOauthClientConvert.INSTANCE.entityListToBizDTOList(sysOauthClientService.list());
    }

    @Override
    public IPage<SysOauthClientDTO> page(int current, int size) {
        IPage<SysOauthClient> page = sysOauthClientService.page(Page.of(current, size));
        return page.convert(SysOauthClientConvert.INSTANCE::entityToBizDTO);
    }

    @Override
    public ClientAuthDTO findOAuth2ClientById(String clientId) {
        SysOauthClient client = sysOauthClientService.getById(clientId);
        if (Objects.isNull(client)) {
            return null;
        }
        ClientAuthDTO clientAuthDTO = new ClientAuthDTO();
        BeanUtil.copyProperties(client, clientAuthDTO);
        return clientAuthDTO;
    }

    /**
     * 清理客户端缓存
     */
    @Override
    public void cleanCache() {
        Set<String> keys = stringRedisTemplate.keys("auth:oauth-client:*");
        if (CollectionUtil.isNotEmpty(keys)) {
            stringRedisTemplate.delete(keys);
        }
    }
}
