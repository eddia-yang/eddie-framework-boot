package com.mybatis.commom.base;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatis.commom.page.PageQuery;

public interface IBaseService<T> extends IService<T> {
    /**
     * 获取分页信息
     *
     * @param pageQuery
     * @return
     */
    IPage<T> selectPage(PageQuery pageQuery);

    /**
     * 获取分页信息
     *
     * @param pageQuery
     * @return
     */
    IPage<T> selectPage(PageQuery pageQuery, LambdaQueryWrapper<T> queryWrapper);

    /**
     * 分页获取query
     *
     * @param pageQuery
     * @return
     */
    QueryWrapper<T> pageQueryCondtion(PageQuery pageQuery);
}
