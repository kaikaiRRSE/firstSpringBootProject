package com.example.demo.common;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础dao
 *
 * @author xiaobiao
 * @version 1.0.0 on 2017.04.12
 */
public interface IBaseDao<T> {
    Long countByExample(T record);

    int insert(T record);

    int batchInsert(List<T> record);

    int insertSelective(T record);

    int batchInsertSelective(List<T> record);

    int deleteByPrimaryKey(String key);

    int deleteByExample(@Param("example") T record, @Param("all") Boolean deleteAllTable);

    int batchDeleteByPrimaryKey(@Param("items") String[] keys);

    int updateByPrimaryKey(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByExample(@Param("example") T example, @Param("record") T record);

    int updateByExampleSelective(@Param("example") T example, @Param("record") T record);

    int batchUpdateByPrimaryKey(List<T> record);

    int batchUpdateByPrimaryKeySelective(List<T> record);

    T selectByPrimaryKey(String key);

    List<T> selectByExample(@Param("example") T record, @Param("distinct") boolean distinct);

    PageList<T> selectByExampleByPager(@Param("example") T record, @Param("all") Boolean all, @Param("pageBounds") PageBounds pageBounds);

    T fuzzySearch(T record);

    PageList<T> fuzzySearchByPager(@Param("item") T record, @Param("pageBounds") PageBounds pageBounds);

}
