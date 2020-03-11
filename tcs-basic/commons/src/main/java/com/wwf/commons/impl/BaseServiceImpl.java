package com.wwf.commons.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwf.commons.IBaseDao;
import com.wwf.commons.IBaseService;

import java.util.List;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 5:37
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {
    /**
     * 不同的服务返回自己的mapper
     * @return
     */
    public abstract IBaseDao<T> getDao();
    @Override
    public int insertSelective(T t) {
        return getDao().insertSelective(t);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return getDao().updateByPrimaryKeySelective(t);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return getDao().deleteByPrimaryKey(id);
    }

    @Override
    public int selectByPrimaryKey(int id) {
        return getDao().selectByPrimaryKey(id);
    }

    @Override
    public int batchDel(Integer[] ids) {
        return getDao().batchDel(ids);
    }

    @Override
    public List<T> list() {
        return getDao().list();
    }

    @Override
    public PageInfo<T> getPageInfo(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<T> list = getDao().list();
        PageInfo<T> pageInfo = new PageInfo<>(list,3);
        return pageInfo;
    }
}
