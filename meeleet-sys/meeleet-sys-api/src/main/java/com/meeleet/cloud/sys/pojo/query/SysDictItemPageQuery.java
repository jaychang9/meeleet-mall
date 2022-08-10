package com.meeleet.cloud.sys.pojo.query;

import com.meeleet.cloud.common.pojo.query.BasePageQuery;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SysDictItemPageQuery extends BasePageQuery {
    private static final long serialVersionUID = -8240643900758093087L;

    private String nameLike;
}
