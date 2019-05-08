package com.zkp.gank.db;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.zkp.gank.app.GankApplication;
import com.zkp.gank.db.entity.SearchHistory;
import com.zkp.gank.db.greendao.DaoMaster;
import com.zkp.gank.db.greendao.DaoSession;
import com.zkp.gank.http.AppConfig;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.db
 * @time: 2019/5/7 17:21
 * @description:
 */
public class DbHelperImpl implements DbHelper {

    private DaoSession daoSession;
    private String data;
    private List<SearchHistory> searchHistoryList;
    private SearchHistory searchHistory;

    @Inject
    public DbHelperImpl() {
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GankApplication.getContext(), AppConfig.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }

    @Override
    public List<SearchHistory> addSearchHistory(String data) {
        this.data = data;
        getSearchHistoryList();
        createSearchHistory();

        if (searchHistoryForward()) {
            return searchHistoryList;
        }

        if (searchHistoryList.size() < AppConfig.HISTORY_LIST_SIZE) {
            daoSession.getSearchHistoryDao().insert(searchHistory);
        } else {
            searchHistoryList.remove(0);
            searchHistoryList.add(searchHistory);
            daoSession.getSearchHistoryDao().deleteAll();
            daoSession.getSearchHistoryDao().insertInTx(searchHistoryList);
        }
        return searchHistoryList;
    }

    @Override
    public void clearAllSearchHistory() {
        daoSession.getSearchHistoryDao().deleteAll();
    }

    @Override
    public void deleteSearchHistoryById(Long id) {
        daoSession.getSearchHistoryDao().deleteByKey(id);
    }

    @Override
    public List<SearchHistory> loadAllSearchHistory() {
        List<SearchHistory> result = daoSession.getSearchHistoryDao().loadAll();
        Log.d("qwe", result.toString());
        return result;
    }

    private void getSearchHistoryList() {
        searchHistoryList = daoSession.getSearchHistoryDao().loadAll();
    }

    private void createSearchHistory() {
        searchHistory = new SearchHistory();
        searchHistory.setDate(System.currentTimeMillis());
        searchHistory.setData(data);
    }

    /**
     * 历史数据前移
     *
     * @return 返回true表示查询的数据已存在，只需将其前移到第一项历史记录，否则需要增加新的历史记录
     */
    private boolean searchHistoryForward() {
        //重复搜索时进行历史记录前移
        Iterator<SearchHistory> iterator = searchHistoryList.iterator();
        //不要在foreach循环中进行元素的remove、add操作，使用Iterator模式
        while (iterator.hasNext()) {
            SearchHistory searchHistory1 = iterator.next();
            if (searchHistory1.getData().equals(data)) {
                searchHistoryList.remove(searchHistory1);
                searchHistoryList.add(searchHistory);
                daoSession.getSearchHistoryDao().deleteAll();
                daoSession.getSearchHistoryDao().insertInTx(searchHistoryList);
                return true;
            }
        }
        return false;
    }
}