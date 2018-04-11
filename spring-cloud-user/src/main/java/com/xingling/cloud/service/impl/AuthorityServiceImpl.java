package com.xingling.cloud.service.impl;

import com.xingling.cloud.mapper.AuthorityMapper;
import com.xingling.cloud.model.domain.Authority;
import com.xingling.cloud.service.AuthorityService;
import com.xingling.service.mybatis.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Title:	  AuthorityServiceImpl <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2018/1/16 14:45
 */
@Service
public class AuthorityServiceImpl extends BaseServiceImpl<Authority> implements AuthorityService{

    @Resource
    private AuthorityMapper authorityMapper;

    @Override
    public List<Authority> getOwnAuthority(String userId) {
        return authorityMapper.getOwnAuthority(userId);
    }
}
