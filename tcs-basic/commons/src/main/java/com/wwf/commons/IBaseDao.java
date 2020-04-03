package com.wwf.commons;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author WangWeifeng
 * @date 2020-3-2 下午 3:51
 */
public interface IBaseDao<T> {

    /**
     * 添加
     * @param t 目标对象
     * @return
     */
    int insertSelective(T t);

    /**
     * 更新
     * @param t 目标对象
     * @return
     */
    int updateByPrimaryKeySelective(T t);

    /**
     * 删除
     * @param id 目标id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *查询
     * @param id 查询条件
     * @return
     */
    T selectByPrimaryKey(int id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDel(Integer[] ids);

    /**
     * 遍历，获取集合
     * @return
     */
    List<T> list();


}
