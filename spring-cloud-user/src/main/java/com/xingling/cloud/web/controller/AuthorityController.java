package com.xingling.cloud.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingling.cloud.model.domain.Authority;
import com.xingling.cloud.model.dto.CheckAuthorityCodeDto;
import com.xingling.cloud.service.AuthorityService;
import com.xingling.controller.BaseController;
import com.xingling.dto.AuthUserDto;
import com.xingling.wrap.WrapMapper;
import com.xingling.wrap.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Title:      AuthorityController. </p>
 * <p>Description TODO </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @author <a href="190332447@qq.com"/>杨文生</a>
 * @since 2018 /4/27 9:57
 */
@RestController
@RequestMapping(value = "/authority", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "AuthorityController", tags = "AuthorityController", description = "权限controller", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthorityController extends BaseController {

    @Resource
    private AuthorityService authorityService;

    /**
     * <p>Title:	  listPage. </p>
     * <p>Description 分页查询权限列表</p>
     *
     * @param authority the authority
     * @return the wrapper
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @CreateDate 2017 /8/17 19:04
     */
    @PostMapping(value = "/listPage")
    @ApiOperation(httpMethod = "POST", value = "分页查询权限列表")
    public Wrapper<PageInfo<Authority>> listPage(@ApiParam(name = "authority", value = "权限信息") @RequestBody Authority authority) {
        PageHelper.startPage(authority.getPageNum(), authority.getPageSize());
        List<Authority> listPage = authorityService.queryListPage(authority);
        PageInfo<Authority> pageInfo = new PageInfo<>(listPage);
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, pageInfo);
    }


    /**
     * <p>Title:      delete. </p>
     * <p>Description 根据id删除权限</p>
     *
     * @param id the id
     * @return wrapper wrapper
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2018 /2/20 14:14
     */
    @PostMapping(value = "/delete/{id}")
    @ApiOperation(httpMethod = "POST", value = "根据id删除权限")
    public Wrapper<Integer> delete(@PathVariable String id) {
        AuthUserDto authUserDto = getLoginAuthDto();
        int result = authorityService.deleteAuthorityById(id, authUserDto);
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, result);
    }

    /**
     * <p>Title:      enable. </p>
     * <p>Description 启用权限</p>
     *
     * @param id the id
     * @return wrapper wrapper
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2018 /2/20 14:14
     */
    @PostMapping(value = "/enable/{id}")
    @ApiOperation(httpMethod = "POST", value = "启用权限")
    public Wrapper<Integer> enable(@PathVariable String id) {
        AuthUserDto authUserDto = getLoginAuthDto();
        int result = authorityService.enableAuthorityById(id, authUserDto);
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, result);
    }

    /**
     * <p>Title:      disable. </p>
     * <p>Description 禁用权限</p>
     *
     * @param id the id
     * @return wrapper wrapper
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2018 /2/20 14:14
     */
    @PostMapping(value = "/disable/{id}")
    @ApiOperation(httpMethod = "POST", value = "禁用权限")
    public Wrapper<Integer> disable(@PathVariable String id) {
        AuthUserDto authUserDto = getLoginAuthDto();
        int result = authorityService.disableAuthorityById(id, authUserDto);
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, result);
    }

    /**
     * <p>Title:      modifyUser. </p>
     * <p>Description 修改权限信息</p>
     *
     * @param authority the authority
     * @return wrapper wrapper
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2018 /2/20 15:38
     */
    @PostMapping(value = "/modifyAuthority")
    @ApiOperation(httpMethod = "POST", value = "修改权限信息")
    public Wrapper<Integer> modifyAuthority(@ApiParam(name = "authority", value = "用户信息") @RequestBody Authority authority) {
        AuthUserDto authUserDto = getLoginAuthDto();
        int result = authorityService.modifyAuthority(authority, authUserDto);
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, result);
    }

    /**
     * <p>Title:      saveAuthorityInfo. </p>
     * <p>Description 保存权限信息</p>
     *
     * @param authority the authority
     * @return wrapper wrapper
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2018 /2/22 17:24
     */
    @PostMapping(value = "/saveAuthorityInfo")
    @ApiOperation(httpMethod = "POST", value = "保存权限信息")
    public Wrapper<Integer> saveAuthorityInfo(@ApiParam(name = "authority", value = "权限信息") @RequestBody Authority authority) {
        AuthUserDto authUserDto = getLoginAuthDto();
        int result = authorityService.saveAuthorityInfo(authority, authUserDto);
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, result);
    }

    /**
     * <p>Title:      checkAuthorityCode. </p>
     * <p>Description 校验权限编码唯一性</p>
     *
     * @param checkAuthorityCodeDto the check authority code dto
     * @return wrapper wrapper
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2018 /2/24 17:08
     */
    @PostMapping(value = "/checkAuthorityCode")
    @ApiOperation(httpMethod = "POST", value = "校验权限编码唯一性")
    public Wrapper<Boolean> checkAuthorityCode(@ApiParam(name = "checkAuthorityCodeDto", value = "权限编码dto") @RequestBody CheckAuthorityCodeDto checkAuthorityCodeDto) {
        boolean flag = false;
        String authorityId = checkAuthorityCodeDto.getAuthorityId();
        String authorityCode = checkAuthorityCodeDto.getAuthorityCode();
        Example example = new Example(Authority.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("authorityCode", authorityCode);
        if (StringUtils.isNotEmpty(authorityId)) {
            criteria.andNotEqualTo("id", authorityId);
        }
        int result = authorityService.selectCountByExample(example);
        if (result > 0) {
            flag = true;
        }
        return WrapMapper.ok(flag);
    }
}
