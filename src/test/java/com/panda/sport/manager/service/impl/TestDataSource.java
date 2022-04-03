package com.panda.sport.manager.service.impl;

import com.panda.sport.manager.basicservice.vo.PandaPage;
import com.panda.sport.manager.db.entity.DataSource;
import com.panda.sport.manager.vo.match.MatchQueryVo;
import com.panda.sport.manager.vo.match.MatchVO;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//指定启动类，如果测试类与启动类是同一级目录或者是属于启动类的子包，可以不指定
//@SpringBootTest(classes = MyBatisApplication.class )
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDataSource {

    @Autowired
    IDataSourceServiceImpl iDataSourceService;

    @Autowired
    MatchInfoServiceImpl matchInfoService;

    @Test
    public void test1(){
        List<DataSource> initial = iDataSourceService.initial();
        initial.forEach(dataSource -> {
            log.info("datasource:{}",dataSource);
            System.out.println("===hehe");
        });
    }

    /*
    booked: 1
    canMoveIntoPreSale: 0
    dataSourceCode: ["SR", "BC", "BG", "TX", "PI", "RB", "PD", "AO", "TS", "V2"]
    endTimeFrom: 0
    historyFlag: 0
    isEarlyTrading: 0
    leagueLevel: []
    matchList: ["MA", "UMA"]
    matchManageId: "4929859806463143430"
    oneHourMatch: 0
    page: 1
    size: 200
    sportId: 1
    startTimeFrom: 1648180800000
     */
    @Test
    public void  test2(){
        MatchQueryVo matchQueryVo = new MatchQueryVo();
        matchQueryVo.setBooked(1);
        matchQueryVo.setCanMoveIntoPreSale(0);
        matchQueryVo.setDataSourceCode(Lists.newArrayList("SR", "BC", "BG", "TX", "PI", "RB", "PD", "AO", "TS", "V2"));
        matchQueryVo.setEndTimeFrom(0L);
        matchQueryVo.setHistoryFlag(0);
        matchQueryVo.setIsEarlyTrading(0);
        matchQueryVo.setLeagueLevel(new ArrayList<>());
        matchQueryVo.setMatchList(Lists.newArrayList("MA", "UMA"));
        matchQueryVo.setMatchManageId("4208570481083150973");
        matchQueryVo.setOneHourMatch(0);
        matchQueryVo.setPage(1);
        matchQueryVo.setSize(100);
        matchQueryVo.setSportId(1L);
        matchQueryVo.setStartTimeFrom(1648353600000L);
        //matchQueryVo.setThirdMatchSourceId("32460271");

        PandaPage<MatchVO> matchVOPandaPage = matchInfoService.queryMatchByCondition(matchQueryVo);

        System.out.println("===matchVOPandaPage");

    }
}
