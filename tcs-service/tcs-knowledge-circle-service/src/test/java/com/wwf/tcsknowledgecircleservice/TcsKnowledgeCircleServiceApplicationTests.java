package com.wwf.tcsknowledgecircleservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwf.entity.KnowledgeCircle;
import com.wwf.mapper.KnowledgeCircleMapper;
import com.wwf.tcsknowledgecircleapi.IKnowledgeCircleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TcsKnowledgeCircleServiceApplicationTests {

    @Autowired
    private KnowledgeCircleMapper circleMapper;

    @Autowired
    private IKnowledgeCircleService circleService;
    @Test
    void contextLoads() {
        Integer pageIndex = 1;
        Integer limit = 5;
        List<KnowledgeCircle> knowledgeCircles = circleMapper.listCircle();
        System.out.println(knowledgeCircles.size());
    }
    @Test
    void serviceTest(){
        Integer pageIndex = 1;
        Integer limit = 5;

        PageHelper.startPage(pageIndex,limit);
        List<KnowledgeCircle> list = circleMapper.listCircle();
        /**
         * 获取知识圈集合
         * 获取知识圈类型集合
         * 获取创建者集合----多表联合查询
         */
        PageInfo<KnowledgeCircle> pageInfo = new PageInfo<>(list, limit);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getCategories());
        }
    }

}
