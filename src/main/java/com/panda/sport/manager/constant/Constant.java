package com.panda.sport.manager.constant;


import org.assertj.core.util.Lists;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 熊猫体育常量
 *
 * @author gasol
 * modify  Who    When    What
 * </p>
 * @date 2019-08-06 19:19
 * --------  ---------  --------------------------
 */
public final class Constant {

    /**
     * 公共值
     */
    public static final Integer MINUS_ONE = -1;
    public static final Integer MINUS_NINE = -9;
    public static final Integer FIFTY = 50;
    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;
    public static final Integer TWO = 2;
    public static final Integer THREE = 3;
    public static final Integer FIVE = 5;
    public static final Integer TEN = 10;
    public static final Integer THREE_HUNDRED = 300;
    public static final Integer YEAR = 365;
    public static final Long NINENINENINE = 999L;
    public static final Long MINUS_TWO = -2L;

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    /**区域下足蓝等电竞赛事不显示 中立场*/
    public static final List<Long> regionIds = Lists.newArrayList(343L,344L,345L,346L,347L,348L,349L,350L,351L,352L,353L,354L,355L,356L,357L,358L,359L,360L);

    /**  主客队标识*/
    public static final String HOME = "home";
    public static final String AWAY = "away";
    public static final String VS = " .vs ";

    /** 日志换行符 */
    public static final String TURN_OFF = "<br>";

    /**
     * 过滤融合redis的盘口多语言
     */
    public static final String MERGE_MARKET_CACHE_PRE = "panda-merge::StandardSportMarket:";

    /**
     * 模糊搜索的联赛列表查询
     */
    public static final String SEARCH_TOURNAMENT_LIST = "panda-manager::search:tournaments:";

    /**
     * 模糊搜索的球队列表查询
     */
    public static final String SEARCH_TEAM_LIST = "panda-manager::search:teamsList:";

    /**
     * 赛程后台操作日志类型列表
     */
    public static final String LOG_OPERATE_LIST = "panda-manager::log:operateall";

    /**
     * 赛事阶段在字典索引表中的code值
     */
    public static String MATCHPERIOD = "matchPeriod";

    /**
     * 赛事阶段编码
     */
    public static String PERIOD_CODE = "match_status";

    /**
     * 数据来源选项：SportRadar
     */
    public static String DATA_SOURCE_SR = "SR";
    /**
     * 数据来源选项：BC BetConstruct
     **/
    public static String DATA_SOURCE_BC = "BC";
    /**
     * 熊猫数据源编码
     */
    public static String DATA_SOURCE_PANDA = "PA";

    public static String DATA_SOURCE_PANDA2 = "PD";

    /**
     * 球探数据源编码
     */
    public static String DATA_SOURCE_QT = "QT";

    /**
     * 数据来源选项：188
     **/
    public static String DATA_SOURCE_188 = "188";
    /**
     * 中文繁体
     */
    public static String LANGUAGE_CHINESE_TRADITION = "zh";

    /**
     * 中文简体
     */
    public static String LANGUAGE_CHINESE_SIMPLIFIED = "zs";
    /**
     * 英文
     */
    public static String LANGUAGE_ENGLISH = "en";

    /**
     * 简称
     **/
    public static String LANGUAGE_ABBREVIATION = "jc";

    /**
     * 数据来源选项：已匹配
     **/
    public static String DATA_SOURCE_MA = "MA";
    /**
     * 数据来源选项：未匹配
     **/
    public static String DATA_SOURCE_UM = "UMA";

    /**
     * 足球运动中的主场队关键字
     */
    public static String FOOTBALL_HOME = "home";

    /**
     * 足球运动中的客场队关键字
     */
    public static String FOOTBALL_AWAY = "away";


    /**
     * 比赛未结束(彻底结束，无需再比)的标识值
     */
    public static Integer MATCH_NOT_OVER = ZERO;

    /**
     * 比赛开盘标识
     */
    public static Integer MATCH_START_ODDS_MARK = ONE;

    /**
     * 比赛是否激活
     */
    public static final Integer ACTIVE_TRUE = ONE;
    /**
     * 比分校验配置bean
     */
    public static final String CHECK_SCORE = "checkScore";

    /**
     * 实时事件校验配置bean
     */
    public static final String CHECK_REAL = "checkReal";

    /**
     * 盘口校验配置bean
     */
    public static final String CHECK_DISH = "checkDish";
    /**
     * 赛前盘/滚球盘下注状态：可下注
     */
    public static Integer MATCH_BET_STATUS_CAN_BET = ONE;
    /**
     * 赛前盘/滚球盘下注状态：不可下注
     */
    public static Integer MATCH_BET_STATUS_CANNOT_BET = ZERO;

    /**
     * 1分钟的毫秒数。 60： 一分钟的秒数； 1000：一秒包含的毫秒数
     */
    public static Long LIVE_ODDS_LIMIT_BEFORE_START_MATCH_ODDS = 60 * 1000L;

    /**
     * 数据表中数字型变量的默认值
     */
    public static Long DB_DEFAULT_LONG_VALUE = 0L;
    public static Long MINUS_NINENINENINE = -9999L;
    public static Long LONG_ONE = 1L;
    public static Integer DB_DEFAULT_INTEGER_VALUE = ZERO;

    /**
     * 数据源属于商业数据的标识
     */
    public static final Integer DATA_SOURCE_IS_COMMERCIAL = 1;
    /**
     * 数据源属于标准数据源的标识
     */
    public static final Integer DATA_SOURCE_STANDARD = 1;
    /**
     * 数据源不属于标准数据源的标识
     */
    public static final Integer DATA_SOURCE_NOT_STANDARD = 0;

    /**
     * 数据源不属于商业数据的标识
     */
    public static final Integer DATA_SOURCE_NOT_COMMERCIAL = 0;

    /**
     * 玩法状态。0已关闭；1已创建；2待二次校验；3已开启
     */
    public static Integer PLAY_STATUS_OPEN = THREE;

    /**
     * 是否为历史赛程 1：是， 0：不是
     */
    public static final Integer IS_HISTORY_FLAG = 1;
    public static final Integer IS_NOT_HISTORY_FLAG = 0;

    /**
     * 是否仅查询标准赛事的默认值
     */
    public static Integer DEFAULT_VALUE_ONLY_QUERY = 1;
    /**
     * 数据库中int  和  long 的默认值
     **/
    public static Integer DEFAULT_VALUE_INT = 0;

    /**
     * 是否仅查询历史赛程
     */
    public static Integer DEFAULT_VALUE_HISTORY_FLAG = 1;

    /**
     * 是否为其它早盘 1：是， 0：不是
     */
    public static final Integer IS_EARLY_TRADING = 1;
    public static final Integer IS_NOT_EARLY_TRADING = 0;

    /**
     * 一天多少毫秒
     */
    public static final Long millSecondDay = 86400000L;

    /**
     * 四小时毫秒
     */
    public static final Long fourHoursmillSecondDay = 14400000L;


    /**
     * 联赛状态：有联赛ID
     **/
    public static Integer TOUR_ID_STATUS_YES = 1;

    /**
     * 联赛状态：无联赛ID
     **/
    public static Integer TOUR_ID_STATUS_NO = 0;
    /**
     * Redis获取锁等待时间
     */
    public final static Integer REDIS_WAIT_MILLIS_PER = 50;

    /**
     * Redis获取锁时间
     */
    public final static Long REDIS_WAIT_MILLIS_PER_LONG = 50L;

    /**
     * 赛事是否支持滚球 1：支持 0：不支持
     */
    public static final Integer MATCH_LIVE_ODD_SUPPORT_FALSE = ZERO;
    public static final Integer MATCH_LIVE_ODD_SUPPORT_TRUE = ONE;

    /**
     * 当前登录用户的key键
     */
    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";

    /**
     * 逗号字符
     */
    public static final String COMMA_STR = ",";
    /**
     * 逗号字符
     */
    public static final String SEMICOLON_STR = "；";

    public static final String SPECIAL_STR = "##";

    /**
     * 系统名
     */
    public static final String SYSTEM_STR = "sys";


    /**
     * 空字符
     */
    public static final String EMPTY_STRING = "";

    /**
     * 分隔符
     */
    public static final String SEPARATOR = "\\|";

    /**
     * 横杠符
     */
    public static final String HYPHEN = "-";

    /**
     * 横杠符
     */
    public static final String BR = "</br>";

    /**
     * 左括号
     */
    public static final String LEFT_BRACKET = "[";

    /**
     * 右括号
     */
    public static final String RIGHT_BRACKET = "]";

    /**
     * 空格占位符
     */
    public static final String EMPTY_SPACE = " ";

    /**
     *  冒号
     */
    public static final String COLON = ":";

    /**
     * 字符串-true
     */
    public static final String STRING_TRUE = "true";

    /**
     * 字符串-false
     */
    public static final String STRING_FALSE = "false";

    /**
     * 字符串-0
     */
    public static final String STRING_ZERO = "0";

    /**
     * 字符串-4
     */
    public static final String STR_FOUR = "4";

    /**
     * 字符串18
     */
    public static final String STR_18 = "18";

    public static final String STR_NULL = "null";

    /**
     * 字符串18
     */
    public static final String STR_34 = "34";
    public static final String STR_38 = "38";
    public static final String STR_40 = "40";
    public static final String STR_41 = "41";
    public static final String STR_42 = "42";
    public static final String STR_43 = "43";
    public static final String STR_44 = "44";
    public static final String STR_45 = "45";
    public static final String STR_47 = "47";
    public static final String STR_48 = "48";
    public static final String STR_57 = "57";
    public static final String STR_59 = "59";
    public static final String STR_61 = "61";
    public static final String STR_62 = "62";
    public static final String STR_63 = "63";
    public static final String STR_64 = "64";
    public static final String STR_66 = "66";
    public static final String STR_67 = "67";
    public static final String STR_68 = "68";
    public static final String STR_70 = "70";
    public static final String STR_71 = "71";
    public static final String STR_74 = "74";
    public static final String STR_75 = "75";
    public static final String STR_76 = "76";
    public static final String STR_77 = "77";
    public static final String STR_84 = "84";
    public static final String STR_100 = "100";

    public static final String NONE = "none";
    public static final String BOTH = "both";
    public static final String EQUAL = "Equal";

    /**
     * 字符串"set_score"
     */
    public static final String SET_SCORE = "set_score";

    /**
     * 字符串"corner_score"
     */
    public static final String CORNER_SCORE = "corner_score";

    /**
     * 字符串"match_score"
     */
    public static final String MATCH_SCORE = "match_score";

    /**
     * 字符串red_card
     */
    public static final String RED_CARD = "red_card";

    /**
     * 字符串yellow_card
     */
    public static final String YELLOW_CARD = "yellow_card";

    /**
     * 字符串yellow_red_card
     */
    public static final String YEL_RED_CARD = "yellow_red_card";
    /**
     * 字符串yellow_red_card
     */
    public static final String FA_CARD = "fa_card";

    public static final String BOOKING = "Booking";
    /**
     * 字符串goal
     */
    public static final String GOAL = "goal";
    /**
     * 字符串extra_point
     */
    public static final String EXTRA_POINT = "extra_point";
    /**
     * 字符串yellow_red_card
     */
    public static final String KICK_OFFTEAM = "kick_off_team";
    /**
     * 字符串penalty_missed
     */
    public static final String PENALTY_MISSED = "penalty_missed";
    /**
     * 字符串video_assistant_referee
     */
    public static final String VIDEO_ASSISTANT_REFEREE = "video_assistant_referee";
    /**
     * 字符串possible_video_assistant_referee
     */
    public static final String POSSIBLE_VIDEO_ASSISTANT_REFEREE = "possible_video_assistant_referee";
    /**
     * tennis_score_change
     */
    public static final String TENNIS_SCORE_CHANGE = "tennis_score_change";
    /**
     * tennis_score_change
     */
    public static final String TABLE_TENNIS_SCORE_CHANGE = "table_tennis_score_change";
    /**
     * badminton_score_change
     */
    public static final String BADMINTON_SCORE_CHANGE = "badminton_score_change";
    /**
     * run_scored
     */
    public static final String RUN_SCORED = "run_scored";
    /**
     * snooker_foul
     */
    public static final String SNOOKER_SCORE_CHANGE = "snooker_score_change";
    /**
     * snooker_foul
     */
    public static final String SNOOKER_FOUL = "snooker_foul";
    /**
     * snooker_foul
     */
    public static final String BALL_POT = "ball_pot";
    /**
     * score_correction
     */
    public static final String SCORE_CORRECTION = "score_correction";
    /**
     * volleyball_score_change
     */
    public static final String VOLLEYBALL_CODE = "volleyball_score_change";

    /**
     * volleyball_score_change
     */
    public static final String BEACH_VOLLEYBALL_CODE = "score_change";
    /**
     * 一小时的毫秒值
     */
    public static final Long millHour = 3600000L;

    /**
     * 72小时的毫秒值
     */
    public static final Long MILL_HOUR_72 = 259200000L;


    /**
     * Integer-0
     */
    public static final Integer NUM_INT_ZERO = 0;

    /**
     * Integer-1
     */
    public static final Integer NUM_INT_ONE = 1;

    /**
     * String-1
     */
    public static final String MINUS_ONE_STR = "-1";

    /**
     * String-1
     */
    public static final String ONE_STR = "1";

    /**
     * String-2
     */
    public static final String TWO_STR = "2";

    /**
     * redis 发布订阅topic
     */
    public static final String REDIS_PUB_TOPIC_NEWALERT = "/redis/newalert";

    /**
     * redis 发布订阅赛果修正二次确认
     */
    public static final String REDIS_PUB_TOPIC_AMENDCONFIRM = "/redis/amendconfirm";

    /**
     *  redis 冠军赛事 相关的缓存
     */
    public static final String REDIS_PUB_OUTRIGHT = "PUB_OUTRIGHT";

    public static final String MSG_STR = "赛事  %s VS %s 收到事件修正的确认消息，请及时确认！";
    public static final String MSG_STREN = "Match  %s VS %s Receive event correction confirmation message,Please confirm in time！";

    public static final String MSG_TITLE_STR = "事件修正";
    public static final String MSG_TITLE_STREN = "Event Correction";

    public static final String MATCH_OVER_TIME=":MATCH_OVER_TIME";
    // 棒球AB玩法
    public static Set<Long> abmcIds = new HashSet<>(Arrays.asList(274L, 277L, 278L, 279L));

    public static String STANDARD_MATCH_RESULT_SCORES="STANDARD_MATCH_RESULT_SCORES:";
}
