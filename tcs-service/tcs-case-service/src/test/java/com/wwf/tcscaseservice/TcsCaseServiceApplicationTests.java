package com.wwf.tcscaseservice;

import com.wwf.entity.Case;
import com.wwf.mapper.CaseMapper;
import com.wwf.tcscaseapi.ICaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TcsCaseServiceApplicationTests {

    @Autowired
    private CaseMapper caseMapper;
    @Test
    void contextLoads() {
        Map<String,Object> params = new HashMap<>();
        Date endTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date(endTime.getTime() - 4 * 24 * 60 * 60 * 1000));
        Date startTime = null;
        try {
            startTime =simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        params.put("startTime ", startTime );
        params.put("endTime ", endTime);
        List<Case> list = caseMapper.selectByTime(params);
        System.out.println(list.size());
    }

}
