package com.xingling.cloud.service.impl;

import com.google.common.collect.Lists;
import com.xingling.cloud.exception.BusinessException;
import com.xingling.cloud.mapper.MenuMapper;
import com.xingling.cloud.model.domain.Menu;
import com.xingling.cloud.model.vo.MenuTreeVo;
import com.xingling.cloud.service.MenuService;
import com.xingling.constant.Constants;
import com.xingling.dto.AuthUserDto;
import com.xingling.service.mybatis.impl.BaseServiceImpl;
import com.xingling.util.TreeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>Title:	  MenuServiceImpl <br/> </p>
 * <p>Description 菜单service实现 <br/> </p>
 * <p>Company:    http://www.hnxianyi.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2018/3/23 16:57
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {
    
    @Resource
    private MenuMapper menuMapper;
    
    @Override
    public int saveMenuInfo(Menu menu, AuthUserDto authUserDto) {
        menu.setCreator(authUserDto.getRealName());
        menu.setCreatorId(authUserDto.getUserId());
        menu.setUpdater(authUserDto.getRealName());
        menu.setUpdaterId(authUserDto.getUserId());
        return menuMapper.insertSelective(menu);
    }

    @Override
    public int modifyMenu(Menu menu, AuthUserDto authUserDto) {
        Menu querMenu = new Menu();
        querMenu.setId(menu.getId());
        querMenu.setDel(Constants.DELETE_NO);
        Menu mn = menuMapper.selectOne(querMenu);
        if (Objects.isNull(mn)) {
            throw new BusinessException("菜单信息不存在");
        }
        querMenu.setCreator(authUserDto.getRealName());
        querMenu.setCreatorId(authUserDto.getUserId());
        querMenu.setUpdater(authUserDto.getRealName());
        querMenu.setUpdaterId(authUserDto.getUserId());
        return menuMapper.updateByPrimaryKeySelective(querMenu);
    }

    @Override
    public int disableMenuById(String id, AuthUserDto authUserDto) {
        Menu querMenu = new Menu();
        querMenu.setId(id);
        querMenu.setDel(Constants.DELETE_NO);
        Menu menu = menuMapper.selectOne(querMenu);
        if (Objects.isNull(menu)) {
            throw new BusinessException("菜单信息不存在");
        }
        if (!Constants.ENABLE.equals(menu.getStatus())) {
            throw new BusinessException("不是启用状态的不能禁用");
        }
        querMenu.setStatus(Constants.DISABLE);
        querMenu.setUpdater(authUserDto.getRealName());
        querMenu.setUpdaterId(authUserDto.getUserId());
        querMenu.setUpdateTime(new Date());
        return menuMapper.updateByPrimaryKeySelective(querMenu);
    }

    @Override
    public int enableMenuById(String id, AuthUserDto authUserDto) {
        Menu querMenu = new Menu();
        querMenu.setId(id);
        querMenu.setDel(Constants.DELETE_NO);
        Menu menu = menuMapper.selectOne(querMenu);
        if (Objects.isNull(menu)) {
            throw new BusinessException("菜单信息不存在");
        }
        if (!Constants.DISABLE.equals(menu.getStatus())) {
            throw new BusinessException("不是禁用状态的不能启用");
        }
        querMenu.setStatus(Constants.ENABLE);
        querMenu.setUpdater(authUserDto.getRealName());
        querMenu.setUpdaterId(authUserDto.getUserId());
        querMenu.setUpdateTime(new Date());
        return menuMapper.updateByPrimaryKeySelective(querMenu);
    }

    @Override
    public int deleteMenuById(String id, AuthUserDto authUserDto) {
        Menu querMenu = new Menu();
        querMenu.setId(id);
        querMenu.setDel(Constants.DELETE_NO);
        Menu menu = menuMapper.selectOne(querMenu);
        if (Objects.isNull(menu)) {
            throw new BusinessException("菜单信息不存在");
        }
        querMenu.setDel(Constants.DELETE_YES);
        querMenu.setUpdater(authUserDto.getRealName());
        querMenu.setUpdaterId(authUserDto.getUserId());
        querMenu.setUpdateTime(new Date());
        return menuMapper.updateByPrimaryKeySelective(querMenu);
    }

    @Override
    public List<MenuTreeVo> getMenuTree() {
        List<Menu> menuList = menuMapper.selectAll();
        List<MenuTreeVo> trees = Lists.newArrayList();
        MenuTreeVo node = null;
        for (Menu menu : menuList) {
            node = new MenuTreeVo();
            BeanUtils.copyProperties(menu, node);
            node.setParentId(menu.getPid());
            trees.add(node);
        }
        return TreeUtil.bulid(trees,Constants.MENU_ROOT) ;
    }

    @Override
    public Menu getMenuById(String menuId) {
        return menuMapper.selectByPrimaryKey(menuId);
    }
}
