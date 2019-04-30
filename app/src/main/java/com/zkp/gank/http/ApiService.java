package com.zkp.gank.http;

import com.zkp.gank.bean.ArticleListBean;
import com.zkp.gank.bean.BannerBean;
import com.zkp.gank.bean.HomeArticlesBean;
import com.zkp.gank.bean.NavigationBean;
import com.zkp.gank.bean.ProjectListBean;
import com.zkp.gank.bean.ProjectTreeBean;
import com.zkp.gank.bean.TreeBean;
import com.zkp.gank.bean.WeChatArticleBean;
import com.zkp.gank.bean.WeChatBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.base
 * @time: 2019/4/10 17:13
 * @description:
 */
public interface ApiService {

    //============================================首页相关====================================================

    /**
     * 获取banner
     *
     * @return
     */
    @GET("/banner/json")
    Observable<BannerBean> getBanner();

    /**
     * 获取文章列表
     *
     * @param page int
     * @return
     */
    @GET("/article/list/{page}/json")
    Observable<HomeArticlesBean> getHomeArticles(@Path("page") int page);

    //============================================知识体系相关====================================================

    /**
     * 获取知识体系数据
     *
     * @return
     */
    @GET("/tree/json")
    Observable<TreeBean> getTree();

    /**
     * 获取知识体系下某个分类的文章列表
     *
     * @param page int
     * @param cid  int
     * @return
     */
    @GET("/article/list/{page}/json?")
    Observable<ArticleListBean> getArticleList(@Path("page") int page, @Query("cid") int cid);


    //============================================微信公众号相关====================================================

    /**
     * 获取微信公众号列表
     *
     * @return
     */
    @GET("/wxarticle/chapters/json")
    Observable<WeChatBean> getWeChat();

    /**
     * 获取某个微信公众号下的文章列表
     *
     * @param id   微信公众号ID
     * @param page 页码
     * @return
     */
    @GET("/wxarticle/list/{id}/{page}/json")
    Observable<WeChatArticleBean> getWxArticleList(@Path("id") int id, @Path("page") int page);


    //============================================导航相关====================================================

    /**
     * 获取导航数据
     *
     * @return
     */
    @GET("/navi/json")
    Observable<NavigationBean> getNavigation();

    //============================================项目相关====================================================

    /**
     * 获取项目分类数据
     *
     * @return
     */
    @GET("/project/tree/json")
    Observable<ProjectTreeBean> getProjectTree();

    /**
     * 获取某个项目分类下的文章列表数据
     *
     * @param page 页码
     * @param cid  分类ID
     * @return
     */
    @GET("/project/list/{page}/json?")
    Observable<ProjectListBean> getProjectList(@Path("page") int page, @Query("cid") int cid);
}
