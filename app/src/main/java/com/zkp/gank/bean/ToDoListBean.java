package com.zkp.gank.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.bean
 * @time: 2019/5/6 9:57
 * @description:
 */
public class ToDoListBean {


    /**
     * data : {"curPage":1,"datas":[{"completeDate":null,"completeDateStr":"","content":"2","date":1557072000000,"dateStr":"2019-05-06","id":9894,"priority":0,"status":0,"title":"2","type":1,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"1","date":1557072000000,"dateStr":"2019-05-06","id":9895,"priority":0,"status":0,"title":"1","type":2,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"2","date":1557072000000,"dateStr":"2019-05-06","id":9896,"priority":0,"status":0,"title":"2","type":2,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"1","date":1557072000000,"dateStr":"2019-05-06","id":9898,"priority":0,"status":0,"title":"1","type":3,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"2","date":1557072000000,"dateStr":"2019-05-06","id":9899,"priority":0,"status":0,"title":"2","type":3,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"1","date":1557072000000,"dateStr":"2019-05-06","id":9900,"priority":0,"status":0,"title":"1","type":0,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"2","date":1557072000000,"dateStr":"2019-05-06","id":9901,"priority":0,"status":0,"title":"2","type":0,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"1","date":1557072000000,"dateStr":"2019-05-06","id":9903,"priority":1,"status":0,"title":"1","type":4,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"1","date":1556985600000,"dateStr":"2019-05-05","id":9893,"priority":2,"status":0,"title":"1","type":4,"userId":7891}],"offset":0,"over":true,"pageCount":1,"size":20,"total":9}
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
         * datas : [{"completeDate":null,"completeDateStr":"","content":"2","date":1557072000000,"dateStr":"2019-05-06","id":9894,"priority":0,"status":0,"title":"2","type":1,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"1","date":1557072000000,"dateStr":"2019-05-06","id":9895,"priority":0,"status":0,"title":"1","type":2,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"2","date":1557072000000,"dateStr":"2019-05-06","id":9896,"priority":0,"status":0,"title":"2","type":2,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"1","date":1557072000000,"dateStr":"2019-05-06","id":9898,"priority":0,"status":0,"title":"1","type":3,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"2","date":1557072000000,"dateStr":"2019-05-06","id":9899,"priority":0,"status":0,"title":"2","type":3,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"1","date":1557072000000,"dateStr":"2019-05-06","id":9900,"priority":0,"status":0,"title":"1","type":0,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"2","date":1557072000000,"dateStr":"2019-05-06","id":9901,"priority":0,"status":0,"title":"2","type":0,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"1","date":1557072000000,"dateStr":"2019-05-06","id":9903,"priority":1,"status":0,"title":"1","type":4,"userId":7891},{"completeDate":null,"completeDateStr":"","content":"1","date":1556985600000,"dateStr":"2019-05-05","id":9893,"priority":2,"status":0,"title":"1","type":4,"userId":7891}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 9
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

        public static class DatasBean implements Serializable {
            /**
             * completeDate : null
             * completeDateStr :
             * content : 2
             * date : 1557072000000
             * dateStr : 2019-05-06
             * id : 9894
             * priority : 0
             * status : 0
             * title : 2
             * type : 1
             * userId : 7891
             */

            private Object completeDate;
            private String completeDateStr;
            private String content;
            private long date;
            private String dateStr;
            private int id;
            private int priority;
            private int status;
            private String title;
            private int type;
            private int userId;

            public Object getCompleteDate() {
                return completeDate;
            }

            public void setCompleteDate(Object completeDate) {
                this.completeDate = completeDate;
            }

            public String getCompleteDateStr() {
                return completeDateStr;
            }

            public void setCompleteDateStr(String completeDateStr) {
                this.completeDateStr = completeDateStr;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public String getDateStr() {
                return dateStr;
            }

            public void setDateStr(String dateStr) {
                this.dateStr = dateStr;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
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
        }
    }
}
