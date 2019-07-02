package com.zkp.androidwan.http;

import com.zkp.androidwan.bean.AddToDoBean;
import com.zkp.androidwan.bean.ArticleListBean;
import com.zkp.androidwan.bean.BannerBean;
import com.zkp.androidwan.bean.CollectListBean;
import com.zkp.androidwan.bean.CurrentWetaherBean;
import com.zkp.androidwan.bean.DailyWeatherBean;
import com.zkp.androidwan.bean.FriendWebBean;
import com.zkp.androidwan.bean.HomeArticlesBean;
import com.zkp.androidwan.bean.HotKeyBean;
import com.zkp.androidwan.bean.HourlyWeatherBean;
import com.zkp.androidwan.bean.LoginBean;
import com.zkp.androidwan.bean.NavigationBean;
import com.zkp.androidwan.bean.ProjectListBean;
import com.zkp.androidwan.bean.ProjectTreeBean;
import com.zkp.androidwan.bean.ToDoListBean;
import com.zkp.androidwan.bean.TreeBean;
import com.zkp.androidwan.bean.WeChatArticleBean;
import com.zkp.androidwan.bean.WeChatBean;
import com.zkp.androidwan.bean.WelFareBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.base
 * @time: 2019/4/10 17:13
 * @description:
 */
public interface ApiService {

    //============================================Main相关====================================================

    /**
     * 获取常用网站列表
     *
     * @return
     */
    @GET("/friend/json")
    Observable<FriendWebBean> getFriendWebs();

    /**
     * 获取当前搜索最多的关键词
     *
     * @return
     */
    @GET("/hotkey/json")
    Observable<HotKeyBean> getHotKeys();

    /**
     * 搜索
     * 页码：拼接在链接上，从0开始
     * k ： 搜索关键词
     *
     * @param page int
     * @param k    String
     * @return
     */
    @POST("/article/query/{page}/json")
    Observable<HomeArticlesBean> searchArticlesByKeyWord(@Path("page") int page, @Query("k") String k);

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


    //============================================登录相关====================================================

    /**
     * 登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @POST("/user/login")
    Observable<LoginBean> login(@Query("username") String userName, @Query("password") String password);

    /**
     * 注册
     *
     * @param userName   用户名
     * @param password   密码
     * @param rePassword 重复密码
     * @return
     */
    @POST("/user/register")
    Observable<LoginBean> register(@Query("username") String userName, @Query("password") String password, @Query("repassword") String rePassword);

    /**
     * 退出登录
     *
     * @return
     */
    @GET("/user/logout/json")
    Observable<LoginBean> logout();

    //============================================福利相关====================================================

    /**
     * 获取福利相关图片列表
     *
     * @param page 页码
     * @return
     */
    @GET("/api/data/福利/10/{page}")
    Observable<WelFareBean> getWelFares(@Path("page") int page);

    //============================================收藏相关====================================================

    /**
     * 获取收藏列表
     *
     * @param page int
     * @return
     */
    @GET("/lg/collect/list/{page}/json")
    Observable<CollectListBean> getCollectList(@Path("page") int page);

    /**
     * 收藏站外文章
     *
     * @param title  标题
     * @param author 作者
     * @param link   连接
     * @return
     */
    @POST("lg/collect/add/json")
    Observable<CollectListBean> collectOutArticle(@Query("title") String title, @Query("author") String author, @Query("link") String link);

    /**
     * 收藏站内文章
     *
     * @param id int
     * @return
     */
    @POST("/lg/collect/{id}/json")
    Observable<HomeArticlesBean> collectArticle(@Path("id") int id);

    /**
     * 取消收藏 --文章列表
     *
     * @param id int
     * @return
     */
    @POST("/lg/uncollect_originId/{id}/json")
    Observable<HomeArticlesBean> unCollectArticle(@Path("id") int id);

    /**
     * 取消收藏
     * id:拼接在链接上
     * originId:列表页下发，无则为-1
     *
     * @param id       int
     * @param originId int
     * @return
     */
    @POST("/lg/uncollect/{id}/json")
    Observable<HomeArticlesBean> unCollectInCollectPage(@Path("id") int id, @Query("originId") int originId);


    //============================================todo相关====================================================

    /**
     * 获取todo列表
     * 页码从1开始，拼接在url 上
     * status 状态， 1-完成；0未完成; 默认全部展示；
     * type 创建时传入的类型, 默认全部展示
     * priority 创建时传入的优先级；默认全部展示
     * orderby 1:完成日期顺序；2.完成日期逆序；3.创建日期顺序；4.创建日期逆序(默认)；（1和2只能获取到已完成的TODO）
     *
     * @param page todo类型 0、1、2、3、4
     * @param map  参数列表
     * @return
     */
    @GET("/lg/todo/v2/list/{page}/json")
    Observable<ToDoListBean> getToDoList(@Path("page") int page, @QueryMap Map<String, Object> map);

    /**
     * 新增一条todo数据
     * title: 新增标题（必须）
     * content: 新增详情（可选）
     * date: 2018-08-01 预定完成时间（不传默认当天，建议传）
     * type: 大于0的整数（可选）；
     * priority 大于0的整数（可选）
     *
     * @param map 参数列表
     * @return
     */
    @POST("lg/todo/add/json")
    @FormUrlEncoded
    Observable<AddToDoBean> addToDo(@FieldMap Map<String, Object> map);

    /**
     * 更新一条todo数据
     * id: 拼接在链接上，为唯一标识
     * title: 更新标题 （必须）
     * content: 新增详情（必须）
     * date: 2018-08-01（必须）
     * status: 0 // 0为未完成，1为完成
     * type: ；
     * priority: ；
     *
     * @param id  todo数据的id
     * @param map 参数列表
     * @return
     */
    @POST("/lg/todo/update/{id}/json")
    @FormUrlEncoded
    Observable<AddToDoBean> updateToDo(@Path("id") int id, @FieldMap Map<String, Object> map);

    /**
     * 删除一条todo数据
     * id: 拼接在链接上，为唯一标识
     *
     * @param id todo数据的id
     * @return
     */
    @POST("/lg/todo/delete/{id}/json")
    Observable<AddToDoBean> deleteTodo(@Path("id") int id);

    /**
     * 更新todo数据的完成状态
     *
     * @param id     todo数据的id
     * @param status 状态 0或1，传1代表未完成到已完成，反之则反之
     * @return
     */
    @POST("/lg/todo/done/{id}/json")
    Observable<AddToDoBean> updateToDoStatus(@Path("id") int id, @Query("status") int status);


    //============================================天气相关====================================================

    /**
     * 获取小时级天气预报
     * &unit=metric:v2
     *
     * @param longitude 经度
     * @param latitude  纬度
     * @return
     */
    @GET("/v2/9shhevvLpHGiolKo/{longitude},{latitude}/hourly.json&unit=metric:v2")
    Observable<HourlyWeatherBean> getHourlyJson(@Path("longitude") String longitude, @Path("latitude") String latitude);

    /**
     * 获取天级天气预报
     * &unit=metric:v2
     *
     * @param longitude 经度
     * @param latitude  纬度
     * @return
     */
    @GET("/v2/9shhevvLpHGiolKo/{longitude},{latitude}/daily.json&unit=metric:v2")
    Observable<DailyWeatherBean> getDailyJson(@Path("longitude") String longitude, @Path("latitude") String latitude);

    /**
     * 获取当前实时天气
     * &unit=metric:v2
     *
     * @param longitude 经度
     * @param latitude  纬度
     * @return
     */
    @GET("/v2/9shhevvLpHGiolKo/{longitude},{latitude}/realtime.json&unit=metric:v2")
    Observable<CurrentWetaherBean> getCurrentJson(@Path("longitude") String longitude, @Path("latitude") String latitude);
}
