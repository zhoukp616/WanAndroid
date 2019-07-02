package com.zkp.androidwan.bean;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.bean
 * @time: 2019/5/7 10:55
 * @description:
 */
public class CollectListBean {


    /**
     * data : {"curPage":1,"datas":[{"author":"承香墨影","chapterId":411,"chapterName":"承香墨影","courseId":13,"desc":"","envelopePic":"","id":56814,"link":"https://mp.weixin.qq.com/s/uFzAMsKk4iIx7cGClLQBVg","niceDate":"2019-04-16","origin":"","originId":7756,"publishTime":1555374155000,"title":"这一年，到底写了多少代码？来张报表看看！","userId":7891,"visible":0,"zan":0},{"author":"奔跑吧焦宇","chapterId":249,"chapterName":"干货资源","courseId":13,"desc":"","envelopePic":"","id":55006,"link":"https://www.jianshu.com/p/06ce7bfab946","niceDate":"2019-03-31","origin":"","originId":8174,"publishTime":1554047294000,"title":"Android开源库分类整理，开发拿来即用","userId":7891,"visible":0,"zan":0},{"author":"liuhe688","chapterId":10,"chapterName":"Activity","courseId":13,"desc":"","envelopePic":"","id":18613,"link":"http://blog.csdn.net/liuhe688/article/details/6733407","niceDate":"2018-07-27","origin":"","originId":2,"publishTime":1532669844000,"title":"基础总结篇之一：Activity生命周期","userId":7891,"visible":0,"zan":0},{"author":"挖掘匠","chapterId":60,"chapterName":"Android Studio相关","courseId":13,"desc":"","envelopePic":"","id":18612,"link":"http://www.jianshu.com/p/9b25087a5d7d","niceDate":"2018-07-27","origin":"","originId":1479,"publishTime":1532669547000,"title":"Android Studio3.0正式版填坑路","userId":7891,"visible":0,"zan":0},{"author":"腾讯移动品质中心TMQ","chapterId":304,"chapterName":"基础源码","courseId":13,"desc":"","envelopePic":"","id":18547,"link":"https://mp.weixin.qq.com/s/5V9VhkfEif22ZvYWeOKWoA","niceDate":"2018-07-26","origin":"","originId":3182,"publishTime":1532608203000,"title":"从Java乱码谈起","userId":7891,"visible":0,"zan":0},{"author":"齐翊","chapterId":185,"chapterName":"组件化","courseId":13,"desc":"","envelopePic":"","id":18519,"link":"https://juejin.im/post/5b255f6ce51d45588f2d1f89","niceDate":"2018-07-26","origin":"","originId":3185,"publishTime":1532596124000,"title":"业内首个支持渐进式组件化的开源框架","userId":7891,"visible":0,"zan":0},{"author":" JerryloveEmily","chapterId":260,"chapterName":"RxJava & Retrofit & MVP","courseId":13,"desc":"","envelopePic":"","id":18483,"link":"https://juejin.im/post/5b5927eae51d4518e311a93f","niceDate":"2018-07-26","origin":"","originId":3186,"publishTime":1532589066000,"title":"RxJava 2.x入门新姿势一","userId":7891,"visible":0,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":7}
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
         * curPage : 1
         * datas : [{"author":"承香墨影","chapterId":411,"chapterName":"承香墨影","courseId":13,"desc":"","envelopePic":"","id":56814,"link":"https://mp.weixin.qq.com/s/uFzAMsKk4iIx7cGClLQBVg","niceDate":"2019-04-16","origin":"","originId":7756,"publishTime":1555374155000,"title":"这一年，到底写了多少代码？来张报表看看！","userId":7891,"visible":0,"zan":0},{"author":"奔跑吧焦宇","chapterId":249,"chapterName":"干货资源","courseId":13,"desc":"","envelopePic":"","id":55006,"link":"https://www.jianshu.com/p/06ce7bfab946","niceDate":"2019-03-31","origin":"","originId":8174,"publishTime":1554047294000,"title":"Android开源库分类整理，开发拿来即用","userId":7891,"visible":0,"zan":0},{"author":"liuhe688","chapterId":10,"chapterName":"Activity","courseId":13,"desc":"","envelopePic":"","id":18613,"link":"http://blog.csdn.net/liuhe688/article/details/6733407","niceDate":"2018-07-27","origin":"","originId":2,"publishTime":1532669844000,"title":"基础总结篇之一：Activity生命周期","userId":7891,"visible":0,"zan":0},{"author":"挖掘匠","chapterId":60,"chapterName":"Android Studio相关","courseId":13,"desc":"","envelopePic":"","id":18612,"link":"http://www.jianshu.com/p/9b25087a5d7d","niceDate":"2018-07-27","origin":"","originId":1479,"publishTime":1532669547000,"title":"Android Studio3.0正式版填坑路","userId":7891,"visible":0,"zan":0},{"author":"腾讯移动品质中心TMQ","chapterId":304,"chapterName":"基础源码","courseId":13,"desc":"","envelopePic":"","id":18547,"link":"https://mp.weixin.qq.com/s/5V9VhkfEif22ZvYWeOKWoA","niceDate":"2018-07-26","origin":"","originId":3182,"publishTime":1532608203000,"title":"从Java乱码谈起","userId":7891,"visible":0,"zan":0},{"author":"齐翊","chapterId":185,"chapterName":"组件化","courseId":13,"desc":"","envelopePic":"","id":18519,"link":"https://juejin.im/post/5b255f6ce51d45588f2d1f89","niceDate":"2018-07-26","origin":"","originId":3185,"publishTime":1532596124000,"title":"业内首个支持渐进式组件化的开源框架","userId":7891,"visible":0,"zan":0},{"author":" JerryloveEmily","chapterId":260,"chapterName":"RxJava & Retrofit & MVP","courseId":13,"desc":"","envelopePic":"","id":18483,"link":"https://juejin.im/post/5b5927eae51d4518e311a93f","niceDate":"2018-07-26","origin":"","originId":3186,"publishTime":1532589066000,"title":"RxJava 2.x入门新姿势一","userId":7891,"visible":0,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 7
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
             * author : 承香墨影
             * chapterId : 411
             * chapterName : 承香墨影
             * courseId : 13
             * desc :
             * envelopePic :
             * id : 56814
             * link : https://mp.weixin.qq.com/s/uFzAMsKk4iIx7cGClLQBVg
             * niceDate : 2019-04-16
             * origin :
             * originId : 7756
             * publishTime : 1555374155000
             * title : 这一年，到底写了多少代码？来张报表看看！
             * userId : 7891
             * visible : 0
             * zan : 0
             */

            private String author;
            private int chapterId;
            private String chapterName;
            private int courseId;
            private String desc;
            private String envelopePic;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private int originId;
            private long publishTime;
            private String title;
            private int userId;
            private int visible;
            private int zan;

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

            public int getOriginId() {
                return originId;
            }

            public void setOriginId(int originId) {
                this.originId = originId;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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
        }
    }
}
