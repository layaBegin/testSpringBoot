package com.panda.sport.manager.basicservice.vo;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author :  dorich
 * @Project Name :  panda_data_service
 * @Package Name :  com.panda.sports.manager.vo
 * @Description :   查询返回的分页数据
 * @Date: 2019-08-02 14:09
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
@Data
public class PandaPage<T> {

    /**
     * 数据总量
     */
    private int total;

    /**
     * 每页显示条数，默认 20
     */
    private int size = 20;

    /**
     * 当前页。从0 开始。
     */
    private int page = 0;
    /**
     * 查询到的数据
     */
    private List<T> records = Collections.emptyList();

    public PandaPage(int total, int size, int page) {
        this.total = total;
        this.size = size;
        this.page = page;
    }

    public PandaPage() {
        this.total = 1;
        this.size = 1;
        this.page = 1;
    }

    public PandaPage(List list) {
        this();
        this.records = list;
    }

    @Override
    public String toString() {
        return "{\"total\":" + this.total + ",\"size\":" + this.size + ",\"page\":" + this.page + ",\"records\":" + (records == null ? 0 : records.size()) + "}";
    }

    /**
     * 根据查询结果和分页数据生成返回对象
     *
     * @param data      本次差查询结果
     * @param dataSize  一页存放多少数据；
     * @param pageStart 从第几页开始
     * @return PandaPage
     * @des
     * @author dorich
     * @date 2019/8/9
     **/
    public static PandaPage getResultPage(List data, Integer dataSize, Integer pageStart) {

        PandaPage page = new PandaPage(data.size(), dataSize, pageStart);
        if (dataSize == 0) {
            return page;
        }
        // 总页数
        int totalPage = (page.getTotal() + dataSize - 1) / dataSize;
        // 当前页数大于总页数
        if (pageStart > totalPage) {
            return page;
        }
        // 计算显示 result 列表中的那些数据. page 页面序号，每个页面展示数据个数
        int startIndex = (page.getPage() - 1) * page.getSize();
        if (startIndex < 0) {
            startIndex = 0;
        }
        int endIndex = startIndex + page.getSize();
        // 如果数据返回起始索引 加 返回数据个数 大于 总数
        if (data.size() < page.getSize() + startIndex) {
            endIndex = data.size();
        }
        page.setRecords(data.subList(startIndex, endIndex));
        return page;
    }
}
