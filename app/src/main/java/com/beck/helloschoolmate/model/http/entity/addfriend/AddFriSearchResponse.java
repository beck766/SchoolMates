package com.beck.helloschoolmate.model.http.entity.addfriend;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by beck on 2018/6/2.
 */

public class AddFriSearchResponse implements Parcelable {

    /**
     * success : true
     * errorMsg :
     * errorCode : 0
     * resultCount : null
     * errorCount : null
     * result : {"userId":1,"nickName":"逼格秩","sex":1,"account":"1","userIcons":null,"area":null,"homeplace":null,"industry":null,"hobbies":null,"signature":null}
     * results : null
     */

    private boolean success;
    private String errorMsg;
    private int errorCode;
    private String resultCount;
    private String errorCount;
    private ResultBean result;
    private String results;

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

    public String getResultCount() {
        return resultCount;
    }

    public void setResultCount(String resultCount) {
        this.resultCount = resultCount;
    }

    public String getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(String errorCount) {
        this.errorCount = errorCount;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public static class ResultBean implements Parcelable {

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        /**
         * userId : 1
         * account : i_am_big_zhi
         * nickName : 逼格秩
         * userImgs : ["http://hongqian.f3322.net:2290/mates/api/img/stu.jpg","http://hongqian.f3322.net:2290/mates/api/img/login.png"]
         * sex : 1
         * birthday : null
         * "area": null
         * homeplace : 江苏 连云港
         * industry : IT
         * hobbies : ["健身"]
         * signature : 生活太表面化，就容易被俗化
         * qrcode : null
         * remarkName : null
         */


        private int userId;
        private String account;
        private String nickName;
        private int sex;
        private String birthday;
        private String homeplace;
        private String area;
        private String industry;
        private String signature;
        private String qrcode;
        private String remarkName;
        private List<String> userImgs;
        private List<String> hobbies;
        private String friend;

        public String getFriend() {
            return friend;
        }

        public void setFriend(String friend) {
            this.friend = friend;
        }

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

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getHomeplace() {
            return homeplace;
        }

        public void setHomeplace(String homeplace) {
            this.homeplace = homeplace;
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

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }

        public String getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(String remarkName) {
            this.remarkName = remarkName;
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

        public ResultBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.userId);
            dest.writeString(this.account);
            dest.writeString(this.nickName);
            dest.writeInt(this.sex);
            dest.writeString(this.birthday);
            dest.writeString(this.homeplace);
            dest.writeString(this.area);
            dest.writeString(this.industry);
            dest.writeString(this.signature);
            dest.writeString(this.qrcode);
            dest.writeString(this.remarkName);
            dest.writeStringList(this.userImgs);
            dest.writeStringList(this.hobbies);
            dest.writeString(this.friend);
        }

        protected ResultBean(Parcel in) {
            this.userId = in.readInt();
            this.account = in.readString();
            this.nickName = in.readString();
            this.sex = in.readInt();
            this.birthday = in.readString();
            this.homeplace = in.readString();
            this.area = in.readString();
            this.industry = in.readString();
            this.signature = in.readString();
            this.qrcode = in.readString();
            this.remarkName = in.readString();
            this.userImgs = in.createStringArrayList();
            this.hobbies = in.createStringArrayList();
            this.friend = in.readString();
        }

        public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel source) {
                return new ResultBean(source);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.success ? (byte) 1 : (byte) 0);
        dest.writeString(this.errorMsg);
        dest.writeInt(this.errorCode);
        dest.writeString(this.resultCount);
        dest.writeString(this.errorCount);
        dest.writeParcelable((Parcelable) this.result, flags);
        dest.writeString(this.results);
    }

    public AddFriSearchResponse() {
    }

    protected AddFriSearchResponse(Parcel in) {
        this.success = in.readByte() != 0;
        this.errorMsg = in.readString();
        this.errorCode = in.readInt();
        this.resultCount = in.readString();
        this.errorCount = in.readString();
        this.result = in.readParcelable(ResultBean.class.getClassLoader());
        this.results = in.readString();
    }

    public static final Parcelable.Creator<AddFriSearchResponse> CREATOR = new Parcelable.Creator<AddFriSearchResponse>() {
        @Override
        public AddFriSearchResponse createFromParcel(Parcel source) {
            return new AddFriSearchResponse(source);
        }

        @Override
        public AddFriSearchResponse[] newArray(int size) {
            return new AddFriSearchResponse[size];
        }
    };
}
