package com.beck.helloschoolmate.model.http.entity.state;

import java.util.List;

/**
 * Created by beck on 2018/8/13.
 */

public class StateResponse {

    /**
     * success : true
     * errorMsg :
     * errorCode : 0
     * resultCount : null
     * errorCount : null
     * result : [{"momentId":65,"publisherId":48,"publisherName":"抚Touch膜","publisherIcon":"http://hongqian.f3322.net:8888/mates/api/img/2c901a77-46de-4a03-942e-02a0a06dbccb.jpg","publishTime":"3天前","content":"测试","imgList":null,"viewNum":7,"praiseNum":1,"commentNum":2,"praiserList":[{"praiserId":48,"praiserName":"抚Touch膜","praiserIcon":"2c901a77-46de-4a03-942e-02a0a06dbccb.jpg"}],"commentList":[{"respondId":100,"content":"测试","responderId":48,"responderName":"抚Touch膜","respondentId":null,"respondentName":null}]},{"momentId":63,"publisherId":48,"publisherName":"抚Touch膜","publisherIcon":"http://hongqian.f3322.net:8888/mates/api/img/2c901a77-46de-4a03-942e-02a0a06dbccb.jpg","publishTime":"18天前","content":"真正的全面屏","imgList":["http://hongqian.f3322.net:8888/mates/api/img/2a206d4a-f85b-4112-b550-3359882ed4ac.jpg"],"viewNum":22,"praiseNum":1,"commentNum":2,"praiserList":[{"praiserId":48,"praiserName":"抚Touch膜","praiserIcon":"2c901a77-46de-4a03-942e-02a0a06dbccb.jpg"}],"commentList":[{"respondId":95,"content":"厉害了","responderId":48,"responderName":"抚Touch膜","respondentId":null,"respondentName":null},{"respondId":99,"content":"牛逼啊","responderId":48,"responderName":"抚Touch膜","respondentId":48,"respondentName":"抚Touch膜"}]},{"momentId":62,"publisherId":48,"publisherName":"抚Touch膜","publisherIcon":"http://hongqian.f3322.net:8888/mates/api/img/2c901a77-46de-4a03-942e-02a0a06dbccb.jpg","publishTime":"18天前","content":"猥琐，是因为你暴露人性的方式不够高大上","imgList":["http://hongqian.f3322.net:8888/mates/api/img/58ab335d-6ffe-4213-befd-aa7fbc039abb.jpg"],"viewNum":6,"praiseNum":1,"commentNum":1,"praiserList":[{"praiserId":48,"praiserName":"抚Touch膜","praiserIcon":"2c901a77-46de-4a03-942e-02a0a06dbccb.jpg"}],"commentList":[{"respondId":94,"content":"你牛逼","responderId":48,"responderName":"抚Touch膜","respondentId":null,"respondentName":null}]}]
     * results : null
     */

    private boolean success;
    private String errorMsg;
    private int errorCode;
    private Object resultCount;
    private Object errorCount;
    private Object results;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getResultCount() {
        return resultCount;
    }

    public void setResultCount(Object resultCount) {
        this.resultCount = resultCount;
    }

    public Object getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Object errorCount) {
        this.errorCount = errorCount;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * momentId : 65
         * publisherId : 48
         * publisherName : 抚Touch膜
         * publisherIcon : http://hongqian.f3322.net:8888/mates/api/img/2c901a77-46de-4a03-942e-02a0a06dbccb.jpg
         * publishTime : 3天前
         * content : 测试
         * imgList : null
         * viewNum : 7
         * praiseNum : 1
         * commentNum : 2
         * praiserList : [{"praiserId":48,"praiserName":"抚Touch膜","praiserIcon":"2c901a77-46de-4a03-942e-02a0a06dbccb.jpg"}]
         * commentList : [{"respondId":100,"content":"测试","responderId":48,"responderName":"抚Touch膜","respondentId":null,"respondentName":null}]
         */

        private int momentId;
        private int publisherId;
        private String publisherName;
        private String publisherIcon;
        private String publishTime;
        private String content;
        private List<String> imgList;
        private int viewNum;
        private int praiseNum;
        private int commentNum;
        private List<PraiserListBean> praiserList;
        private List<CommentListBean> commentList;

        public int getMomentId() {
            return momentId;
        }

        public void setMomentId(int momentId) {
            this.momentId = momentId;
        }

        public int getPublisherId() {
            return publisherId;
        }

        public void setPublisherId(int publisherId) {
            this.publisherId = publisherId;
        }

        public String getPublisherName() {
            return publisherName;
        }

        public void setPublisherName(String publisherName) {
            this.publisherName = publisherName;
        }

        public String getPublisherIcon() {
            return publisherIcon;
        }

        public void setPublisherIcon(String publisherIcon) {
            this.publisherIcon = publisherIcon;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getImgList() {
            return imgList;
        }

        public void setImgList(List<String> imgList) {
            this.imgList = imgList;
        }

        public int getViewNum() {
            return viewNum;
        }

        public void setViewNum(int viewNum) {
            this.viewNum = viewNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public List<PraiserListBean> getPraiserList() {
            return praiserList;
        }

        public void setPraiserList(List<PraiserListBean> praiserList) {
            this.praiserList = praiserList;
        }

        public List<CommentListBean> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<CommentListBean> commentList) {
            this.commentList = commentList;
        }

        public static class PraiserListBean {
            /**
             * praiserId : 48
             * praiserName : 抚Touch膜
             * praiserIcon : 2c901a77-46de-4a03-942e-02a0a06dbccb.jpg
             */

            private int praiserId;
            private String praiserName;
            private String praiserIcon;

            public int getPraiserId() {
                return praiserId;
            }

            public void setPraiserId(int praiserId) {
                this.praiserId = praiserId;
            }

            public String getPraiserName() {
                return praiserName;
            }

            public void setPraiserName(String praiserName) {
                this.praiserName = praiserName;
            }

            public String getPraiserIcon() {
                return praiserIcon;
            }

            public void setPraiserIcon(String praiserIcon) {
                this.praiserIcon = praiserIcon;
            }
        }

        public static class CommentListBean {
            /**
             * respondId : 100
             * content : 测试
             * responderId : 48
             * responderName : 抚Touch膜
             * respondentId : null
             * respondentName : null
             */

            private int respondId;
            private String content;
            private int responderId;
            private String responderName;
            private Object respondentId;
            private Object respondentName;

            public int getRespondId() {
                return respondId;
            }

            public void setRespondId(int respondId) {
                this.respondId = respondId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getResponderId() {
                return responderId;
            }

            public void setResponderId(int responderId) {
                this.responderId = responderId;
            }

            public String getResponderName() {
                return responderName;
            }

            public void setResponderName(String responderName) {
                this.responderName = responderName;
            }

            public Object getRespondentId() {
                return respondentId;
            }

            public void setRespondentId(Object respondentId) {
                this.respondentId = respondentId;
            }

            public Object getRespondentName() {
                return respondentName;
            }

            public void setRespondentName(Object respondentName) {
                this.respondentName = respondentName;
            }
        }
    }
}
