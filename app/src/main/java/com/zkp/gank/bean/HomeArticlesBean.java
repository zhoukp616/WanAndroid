package com.zkp.gank.bean;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.bean
 * @time: 2019/4/26 11:22
 * @description:
 */
public class HomeArticlesBean {


    /**
     * data : {"curPage":2,"datas":[{"apkLink":"","author":"KunMinX","chapterId":77,"chapterName":"响应式编程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8274,"link":"https://juejin.im/post/5cb82a42e51d456e62545ac6","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555593395000,"superChapterId":79,"superChapterName":"热门专题","tags":[],"title":"你用不惯 RxJava，只因缺了这把钥匙","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"lulululbj","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"Github 上关于 Wanandroid 的客户端也层出不穷，Java的，Kotlin 的，Flutter 的，Mvp 的，MVMM 的，各种各样，但是还没看到 Kotlin+MVVM+LiveData+协程 版本的，加上最近正在看 MVVM 和 LiveData，就着手把我之前写的 Mvp 版本的 Wanandroid 改造成 MVVM + Kotlin + LiveData + 协程 版本。","envelopePic":"https://wanandroid.com/blogimgs/54f4350f-039d-48b6-a38b-0933e1405004.png","fresh":false,"id":8273,"link":"http://www.wanandroid.com/blog/show/2554","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"https://github.com/lulululbj/wanandroid/tree/mvvm-kotlin","publishTime":1555593015000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"真香！Kotlin+MVVM+LiveData+协程 打造 Wanandroid！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"OnexZgj","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"该应用程序是玩Android部分api和干货网站部分api的flutter版本的技术类文章查看APP。\r\n主要功能包括：首页、项目、公众号、搜索等。","envelopePic":"https://wanandroid.com/blogimgs/4681d6c0-0d76-4c69-a866-7ad66dde10cd.png","fresh":false,"id":8269,"link":"http://www.wanandroid.com/blog/show/2550","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"https://github.com/OnexZgj/flutter_onex","publishTime":1555592366000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"是时候体验一波Flutter啦","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"何时夕","chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8266,"link":"https://www.jianshu.com/p/4cd1dcbd8e8a","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555592085000,"superChapterId":94,"superChapterName":"自定义控件","tags":[],"title":"抖音、ins、微信功能大比拼&mdash;&mdash;Story的贴纸文字","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wbo4958 ","chapterId":432,"chapterName":"UI渲染","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8265,"link":"https://www.jianshu.com/p/7bf306c09c7e","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555591984000,"superChapterId":153,"superChapterName":"framework","tags":[],"title":"Android DisplayList 构建过程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"文艺的程序狗","chapterId":15,"chapterName":"Service","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8264,"link":"https://www.jianshu.com/p/0e161d10ffaa","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555591890000,"superChapterId":10,"superChapterName":"四大组件","tags":[],"title":"Accessibility 源码解析(performAction视角)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"android难民","chapterId":444,"chapterName":"androidx","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8263,"link":"https://www.jianshu.com/p/351e695015d4","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555591029000,"superChapterId":151,"superChapterName":"5.+高新技术","tags":[],"title":"android ViewPager2的使用教程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"rushjs","chapterId":230,"chapterName":"打包","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8262,"link":"https://www.jianshu.com/p/308515c94dc6","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555590594000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"APK签名机制之&mdash;&mdash;V2签名机制详解","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"J__Beyond","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8261,"link":"https://www.jianshu.com/p/e58992439793","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555590520000,"superChapterId":79,"superChapterName":"热门专题","tags":[],"title":"Android UI卡顿监测框架BlockCanary原理分析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 猿湿Xoong","chapterId":329,"chapterName":"Android 8.0","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8260,"link":"https://juejin.im/post/5aefd27f6fb9a07ab45889cc","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555584886000,"superChapterId":151,"superChapterName":"5.+高新技术","tags":[],"title":"咦，Oreo怎么收不到广播了？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"吃猫猫的鱼","chapterId":443,"chapterName":"Android 10.0","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8259,"link":"https://juejin.im/post/5cad5b7ce51d456e5a0728b0","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555552420000,"superChapterId":151,"superChapterName":"5.+高新技术","tags":[],"title":"Android Q 适配指南 让你少走一堆弯路","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8286,"link":"https://mp.weixin.qq.com/s/6djoBUpsao7hq_1LDtHitQ","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555516800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android Q (10) 适配指南 让你少走一堆弯路","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8289,"link":"https://mp.weixin.qq.com/s/vDadE138gcvv-wiNsW8fyw","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555516800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"容器类源码解析系列（二）&mdash;&mdash; LinkedList 集合源码分析(最新版)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8290,"link":"https://mp.weixin.qq.com/s/G0GaRAV6F1qKgbGJbbhWjw","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555516800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"你要的进阶，Jetpack核心组件Lifecycle的使用和源码解析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8291,"link":"https://mp.weixin.qq.com/s/SHJzWpZ0MscuJhPLRwWQxg","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555516800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"面试必问的HashMap，你真的了解吗？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Drummor","chapterId":432,"chapterName":"UI渲染","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8258,"link":"https://juejin.im/post/5cb1bafe6fb9a068a84fda40","niceDate":"2019-04-17","origin":"","prefix":"","projectLink":"","publishTime":1555490164000,"superChapterId":153,"superChapterName":"framework","tags":[],"title":"Android 怎么就不卡了呢之Choreographer","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8285,"link":"https://mp.weixin.qq.com/s/pblXjyCOKlu2VbeQJlg0TA","niceDate":"2019-04-17","origin":"","prefix":"","projectLink":"","publishTime":1555430400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"送个学习Android的技巧给你！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8288,"link":"https://mp.weixin.qq.com/s/ORjWUeyHWXbNZD5AJXrtgg","niceDate":"2019-04-17","origin":"","prefix":"","projectLink":"","publishTime":1555430400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"没看过这篇文章，别说自己懂 Flutter ！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"pengMaster","chapterId":367,"chapterName":"资源聚合类","collect":false,"courseId":13,"desc":"自己总结的比较全面的知识点和面试","envelopePic":"https://www.wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8251,"link":"http://www.wanandroid.com/blog/show/2544","niceDate":"2019-04-15","origin":"","prefix":"","projectLink":"https://github.com/pengMaster/BestNote","publishTime":1555340011000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=367"}],"title":"Java Android学习/面试指南","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"zincPower","chapterId":323,"chapterName":"动画","collect":false,"courseId":13,"desc":"该项目将会集结 &ldquo;Android高级UI&rdquo; 的知识。\r\n目前已有章节：\r\n1、贝塞尔曲线\r\n2、PathMeasure\r\n3、属性动画\r\n4、Xfermode\r\n5、VelocityTracker和Scroller\r\n6、绘制流程\r\n7、svg","envelopePic":"https://www.wanandroid.com/blogimgs/964c0477-3577-4b74-85eb-70077677876d.png","fresh":false,"id":8252,"link":"http://www.wanandroid.com/blog/show/2545","niceDate":"2019-04-15","origin":"","prefix":"","projectLink":"https://github.com/zincPower/UI2018","publishTime":1555340007000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=323"}],"title":"安卓高级UI","type":0,"userId":-1,"visible":1,"zan":0}],"offset":20,"over":false,"pageCount":320,"size":20,"total":6383}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 2
         * datas : [{"apkLink":"","author":"KunMinX","chapterId":77,"chapterName":"响应式编程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8274,"link":"https://juejin.im/post/5cb82a42e51d456e62545ac6","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555593395000,"superChapterId":79,"superChapterName":"热门专题","tags":[],"title":"你用不惯 RxJava，只因缺了这把钥匙","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"lulululbj","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"Github 上关于 Wanandroid 的客户端也层出不穷，Java的，Kotlin 的，Flutter 的，Mvp 的，MVMM 的，各种各样，但是还没看到 Kotlin+MVVM+LiveData+协程 版本的，加上最近正在看 MVVM 和 LiveData，就着手把我之前写的 Mvp 版本的 Wanandroid 改造成 MVVM + Kotlin + LiveData + 协程 版本。","envelopePic":"https://wanandroid.com/blogimgs/54f4350f-039d-48b6-a38b-0933e1405004.png","fresh":false,"id":8273,"link":"http://www.wanandroid.com/blog/show/2554","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"https://github.com/lulululbj/wanandroid/tree/mvvm-kotlin","publishTime":1555593015000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"真香！Kotlin+MVVM+LiveData+协程 打造 Wanandroid！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"OnexZgj","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"该应用程序是玩Android部分api和干货网站部分api的flutter版本的技术类文章查看APP。\r\n主要功能包括：首页、项目、公众号、搜索等。","envelopePic":"https://wanandroid.com/blogimgs/4681d6c0-0d76-4c69-a866-7ad66dde10cd.png","fresh":false,"id":8269,"link":"http://www.wanandroid.com/blog/show/2550","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"https://github.com/OnexZgj/flutter_onex","publishTime":1555592366000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"是时候体验一波Flutter啦","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"何时夕","chapterId":99,"chapterName":"具体案例","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8266,"link":"https://www.jianshu.com/p/4cd1dcbd8e8a","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555592085000,"superChapterId":94,"superChapterName":"自定义控件","tags":[],"title":"抖音、ins、微信功能大比拼&mdash;&mdash;Story的贴纸文字","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wbo4958 ","chapterId":432,"chapterName":"UI渲染","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8265,"link":"https://www.jianshu.com/p/7bf306c09c7e","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555591984000,"superChapterId":153,"superChapterName":"framework","tags":[],"title":"Android DisplayList 构建过程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"文艺的程序狗","chapterId":15,"chapterName":"Service","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8264,"link":"https://www.jianshu.com/p/0e161d10ffaa","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555591890000,"superChapterId":10,"superChapterName":"四大组件","tags":[],"title":"Accessibility 源码解析(performAction视角)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"android难民","chapterId":444,"chapterName":"androidx","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8263,"link":"https://www.jianshu.com/p/351e695015d4","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555591029000,"superChapterId":151,"superChapterName":"5.+高新技术","tags":[],"title":"android ViewPager2的使用教程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"rushjs","chapterId":230,"chapterName":"打包","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8262,"link":"https://www.jianshu.com/p/308515c94dc6","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555590594000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"APK签名机制之&mdash;&mdash;V2签名机制详解","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"J__Beyond","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8261,"link":"https://www.jianshu.com/p/e58992439793","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555590520000,"superChapterId":79,"superChapterName":"热门专题","tags":[],"title":"Android UI卡顿监测框架BlockCanary原理分析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 猿湿Xoong","chapterId":329,"chapterName":"Android 8.0","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8260,"link":"https://juejin.im/post/5aefd27f6fb9a07ab45889cc","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555584886000,"superChapterId":151,"superChapterName":"5.+高新技术","tags":[],"title":"咦，Oreo怎么收不到广播了？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"吃猫猫的鱼","chapterId":443,"chapterName":"Android 10.0","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8259,"link":"https://juejin.im/post/5cad5b7ce51d456e5a0728b0","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555552420000,"superChapterId":151,"superChapterName":"5.+高新技术","tags":[],"title":"Android Q 适配指南 让你少走一堆弯路","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8286,"link":"https://mp.weixin.qq.com/s/6djoBUpsao7hq_1LDtHitQ","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555516800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android Q (10) 适配指南 让你少走一堆弯路","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8289,"link":"https://mp.weixin.qq.com/s/vDadE138gcvv-wiNsW8fyw","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555516800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"容器类源码解析系列（二）&mdash;&mdash; LinkedList 集合源码分析(最新版)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8290,"link":"https://mp.weixin.qq.com/s/G0GaRAV6F1qKgbGJbbhWjw","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555516800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"你要的进阶，Jetpack核心组件Lifecycle的使用和源码解析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8291,"link":"https://mp.weixin.qq.com/s/SHJzWpZ0MscuJhPLRwWQxg","niceDate":"2019-04-18","origin":"","prefix":"","projectLink":"","publishTime":1555516800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"面试必问的HashMap，你真的了解吗？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Drummor","chapterId":432,"chapterName":"UI渲染","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8258,"link":"https://juejin.im/post/5cb1bafe6fb9a068a84fda40","niceDate":"2019-04-17","origin":"","prefix":"","projectLink":"","publishTime":1555490164000,"superChapterId":153,"superChapterName":"framework","tags":[],"title":"Android 怎么就不卡了呢之Choreographer","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8285,"link":"https://mp.weixin.qq.com/s/pblXjyCOKlu2VbeQJlg0TA","niceDate":"2019-04-17","origin":"","prefix":"","projectLink":"","publishTime":1555430400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"送个学习Android的技巧给你！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8288,"link":"https://mp.weixin.qq.com/s/ORjWUeyHWXbNZD5AJXrtgg","niceDate":"2019-04-17","origin":"","prefix":"","projectLink":"","publishTime":1555430400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"没看过这篇文章，别说自己懂 Flutter ！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"pengMaster","chapterId":367,"chapterName":"资源聚合类","collect":false,"courseId":13,"desc":"自己总结的比较全面的知识点和面试","envelopePic":"https://www.wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8251,"link":"http://www.wanandroid.com/blog/show/2544","niceDate":"2019-04-15","origin":"","prefix":"","projectLink":"https://github.com/pengMaster/BestNote","publishTime":1555340011000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=367"}],"title":"Java Android学习/面试指南","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"zincPower","chapterId":323,"chapterName":"动画","collect":false,"courseId":13,"desc":"该项目将会集结 &ldquo;Android高级UI&rdquo; 的知识。\r\n目前已有章节：\r\n1、贝塞尔曲线\r\n2、PathMeasure\r\n3、属性动画\r\n4、Xfermode\r\n5、VelocityTracker和Scroller\r\n6、绘制流程\r\n7、svg","envelopePic":"https://www.wanandroid.com/blogimgs/964c0477-3577-4b74-85eb-70077677876d.png","fresh":false,"id":8252,"link":"http://www.wanandroid.com/blog/show/2545","niceDate":"2019-04-15","origin":"","prefix":"","projectLink":"https://github.com/zincPower/UI2018","publishTime":1555340007000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=323"}],"title":"安卓高级UI","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 20
         * over : false
         * pageCount : 320
         * size : 20
         * total : 6383
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {

            /**
             * apkLink :
             * author : ditclear
             * chapterId : 402
             * chapterName : 跨平台应用
             * collect : false
             * courseId : 13
             * desc : 抖音，英文名TikTok，一款火遍全球的短视频App。在玩抖音的日子里，最令我感到舒服的就是抖音的手势交互，加上近期都在进行Flutter方面的学习，因此就产生了使用Flutter来仿写TikTok手势交互的想法。
             * envelopePic : https://www.wanandroid.com/blogimgs/3d5d3f6e-2c72-4751-90fd-17cb1958739d.png
             * fresh : false
             * id : 8300
             * link : http://www.wanandroid.com/blog/show/2556
             * niceDate : 2019-04-22
             * origin :
             * prefix :
             * projectLink : https://github.com/ditclear/tiktok_gestures
             * publishTime : 1555938213000
             * superChapterId : 294
             * superChapterName : 开源项目主Tab
             * tags : [{"name":"项目","url":"/project/list/1?cid=402"}]
             * title : 使用Flutter仿写TikTok的手势交互效果
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<TagsBean> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean {
                /**
                 * name : 项目
                 * url : /project/list/1?cid=402
                 */

                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
