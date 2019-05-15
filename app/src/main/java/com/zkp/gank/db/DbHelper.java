package com.zkp.gank.db;

import com.zkp.gank.db.entity.Address;
import com.zkp.gank.db.entity.SearchHistory;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.db
 * @time: 2019/5/7 17:18
 * @description:
 */
public interface DbHelper {

    /**
     * 新增一条搜索纪录到数据库中
     *
     * @param data String(关键词)
     * @return List<SearchHistory>
     */
    List<SearchHistory> addSearchHistory(String data);

    /**
     * 清空所有的搜索纪录
     */
    void clearAllSearchHistory();

    /**
     * 清空某一条搜索记录
     *
     * @param id
     */
    void deleteSearchHistoryById(Long id);

    /**
     * 加载所有的搜索纪录
     *
     * @return List<HistoryData>
     */
    List<SearchHistory> loadAllSearchHistory();

    /**
     * 添加城市/地区
     *
     * @param address
     * @return
     */
    Address addAddress(Address address);

    /**
     * 更新城市/地区
     *
     * @param address
     * @return
     */
    Address updateAddress(Address address);

    /**
     * 获取某个城市/地区
     *
     * @param id
     * @return
     */
    Address getAddressByID(Long id);

    /**
     * 获取所有添加的城市/地区
     *
     * @return
     */
    List<Address> getAllAddress();

    /**
     * 删除城市
     */
    Long deleteAddreessById(Long id);
}
