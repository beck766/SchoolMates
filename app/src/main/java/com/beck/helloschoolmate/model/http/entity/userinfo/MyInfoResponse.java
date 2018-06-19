package com.beck.helloschoolmate.model.http.entity.userinfo;

import java.util.List;

/**
 * Created by beck on 2018/6/19.
 */

public class MyInfoResponse {

    /**
     * success : true
     * errorMsg :
     * errorCode : 0
     * resultCount : null
     * errorCount : null
     * result : {"userId":1,"account":"b","nickName":"逼格秩","userImgs":["http://hongqian.f3322.net:2290/mates/api/img/stu.jpg","http://hongqian.f3322.net:2290/mates/api/img/login.png"],"sex":1,"age":25,"homeplace":"江苏 连云港","area":"江苏 苏州","industry":"IT/软件开发","hobbies":["健身"],"signature":"生活太表面化，就容易被俗化","loveStatus":0,"momentImgs":["http://hongqian.f3322.net:2290/mates/api/img/02.JPG"],"qrcode":"http://hongqian.f3322.net:2290/mates/api/qrcode/1.png"}
     * results : null
     */

    private boolean success;
    private String errorMsg;
    private int errorCode;
    private Object resultCount;
    private Object errorCount;
    private ResultBean result;
    private Object results;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    public static class ResultBean {
        /**
         * userId : 1
         * account : b
         * nickName : 逼格秩
         * userImgs : ["http://hongqian.f3322.net:2290/mates/api/img/stu.jpg","http://hongqian.f3322.net:2290/mates/api/img/login.png"]
         * sex : 1
         * age : 25
         * homeplace : 江苏 连云港
         * area : 江苏 苏州
         * industry : IT/软件开发
         * hobbies : ["健身"]
         * signature : 生活太表面化，就容易被俗化
         * loveStatus : 0
         * momentImgs : ["http://hongqian.f3322.net:2290/mates/api/img/02.JPG"]
         * qrcode : http://hongqian.f3322.net:2290/mates/api/qrcode/1.png
         */

        private int userId;
        private String account;
        private String nickName;
        private int sex;
        private int age;
        private String homeplace;
        private String area;
        private String industry;
        private String signature;
        private int loveStatus;
        private String qrcode;
        private List<String> userImgs;
        private List<String> hobbies;
        private List<String> momentImgs;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHomeplace() {
            return homeplace;
        }

        public void setHomeplace(String homeplace) {
            this.homeplace = homeplace;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getLoveStatus() {
            return loveStatus;
        }

        public void setLoveStatus(int loveStatus) {
            this.loveStatus = loveStatus;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }

        public List<String> getUserImgs() {
            return userImgs;
        }

        public void setUserImgs(List<String> userImgs) {
            this.userImgs = userImgs;
        }

        public List<String> getHobbies() {
            return hobbies;
        }

        public void setHobbies(List<String> hobbies) {
            this.hobbies = hobbies;
        }

        public List<String> getMomentImgs() {
            return momentImgs;
        }

        public void setMomentImgs(List<String> momentImgs) {
            this.momentImgs = momentImgs;
        }
    }
}
