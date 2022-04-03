package com.panda.sport.manager.vo;


import com.panda.sport.manager.dbext.entity.MatchQueryExt;
import com.panda.sport.manager.dbext.entity.StandardMatchInfoExt;
import com.panda.sport.manager.dbext.entity.ThirdMatchInfoExt;
import com.panda.sport.manager.vo.match.MatchQueryVo;
import com.panda.sport.manager.vo.match.MatchVO;
import com.panda.sport.manager.vo.match.ThirdMatchVo;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author :  Alair
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.vo
 * @Description :  ext 转换 vo 工具类
 * @Date: 2019-10-05 15:46
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
public class ConvertExt2Vo {



    public static MatchQueryExt convert(MatchQueryVo matchQueryVo) {
        if (matchQueryVo == null) {
            return null;
        }
        MatchQueryExt ext = new MatchQueryExt();
        ext.setThirds(matchQueryVo.getThirds());
        BeanUtils.copyProperties(matchQueryVo, ext);
        return ext;
    }

    public static MatchVO convert(StandardMatchInfoExt ext) {
        if (ext == null) {
            return null;
        }
        MatchVO vo = new MatchVO();
        BeanUtils.copyProperties(ext, vo);
        vo.setThirdMatchId(String.valueOf(ext.getThirdMatchId()));
        vo.setId(String.valueOf(ext.getId()));
        vo.setStandardTournamentId(String.valueOf(ext.getStandardTournamentId()));
        if (!ext.getStandard()) {
            vo.setThirdTournamentId(String.valueOf(ext.getStandardTournamentId()));
        }
        vo.setHomeTeamId(String.valueOf(ext.getHomeTeamId()));
        vo.setAwayTeamId(String.valueOf(ext.getAwayTeamId()));
        vo.setAwayTeamId(String.valueOf(ext.getAwayTeamId()));
        vo.setHomeNameCode(String.valueOf(ext.getHomeNameCode()));
        vo.setAwayNameCode(String.valueOf(ext.getAwayNameCode()));
        return vo;
    }

    public static List<MatchVO> convertMatchVO(List<StandardMatchInfoExt> extList) {
        List<MatchVO> voList = new ArrayList<>();
        for (StandardMatchInfoExt ext : extList) {
            voList.add(convert(ext));
        }
        return voList;
    }


}
