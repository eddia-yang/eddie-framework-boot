package com.mybatis.commom.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.commom.base.IBaseService;
import com.mybatis.commom.page.PageQuery;

public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements IBaseService<T>  {

    @Override
    public IPage<T> selectPage(PageQuery pageQuery) {
        return null;
    }

    @Override
    public IPage<T> selectPage(PageQuery pageQuery, LambdaQueryWrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public QueryWrapper<T> pageQueryCondtion(PageQuery pageQuery) {
        return null;
    }

    /**
     * 获取LambdaQueryWrapper对象
     *
     * @return
     */
    public <E> LambdaQueryWrapper<E> lambda(Class<E> clazz) {
        QueryWrapper<E> queryWrapper = new QueryWrapper<E>();
        return queryWrapper.lambda();
    }

    /**
     * 获取LambdaQueryWrapper对象
     *
     * @return
     */
    public <E> LambdaQueryWrapper<E> lambda() {
        QueryWrapper<E> queryWrapper = new QueryWrapper<E>();
        return queryWrapper.lambda();
    }



//    /**
//     * 获取分页信息
//     */
//    @Override
//    public IPage<T> selectPage(PageQuery pageQuery) {
//        return baseMapper.selectPage(pageQuery.toPage(), null);
//    }
//
//    /**
//     * 获取分页信息
//     */
//    @Override
//    public IPage<T> selectPage(PageQuery pageQuery, LambdaQueryWrapper<T> queryWrapper) {
//        return baseMapper.selectPage(pageQuery.toPage(), queryWrapper);
//    }

}


