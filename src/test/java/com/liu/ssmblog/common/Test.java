package com.liu.ssmblog.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 一些Api的测试
 */
public class Test {

    @org.junit.Test
    public void testPageInfo(){
        List<Integer> integers = List.of(1,2,3);
        PageInfo<Integer> pageInfo = new PageInfo<>(integers);
        System.out.println("pageInfo.getSize() --> "+pageInfo.getSize());
        System.out.println("pageInfo.getList().size() -->"+pageInfo.getList().size());
    }
}
