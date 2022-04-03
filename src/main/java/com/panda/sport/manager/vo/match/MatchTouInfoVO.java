package com.panda.sport.manager.vo.match;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author : nonhung
 * @project Name : panda_data_service
 * @package Name : com.panda.sport.manager.vo.match
 * @description : TODO
 * @date: 2020-06-24 14:46
 * @modificationHistory Who When What
 * -------- --------- --------------------------
 */
@Data
public class MatchTouInfoVO implements Serializable {

    private static final long serialVersionUID = 5457349200091520959L;
    /**
     * 体育种类id
     */
    //@ApiModelProperty(name = "联赛ids信息")
    private Long touIds;

    //@ApiModelProperty(name = "比赛开始时间上限参数", notes = "时间戳精确到毫秒，UTC时间")
    private Map<String, String> lnguage;

    //@ApiModelProperty(name = "类型", notes = "1:standard 标准  0:third 三方")
    private Integer type;
}
