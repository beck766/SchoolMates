package com.beck.helloschoolmate.model.http.entity.addfriend;

import android.os.Parcel;
import android.os.Parcelable;

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
        /**
         * userId : 1
         * nickName : 逼格秩
         * sex : 1
         * account : 1
         * userIcons : null
         * area : null
         * homeplace : null
         * industry : null
         * hobbies : null
         * signature : null
         */

        private int userId;
        private String nickName;
        private int sex;
        private String account;
        private String userIcons;
        private String area;
        private String homeplace;
        private String industry;
        private String hobbies;
        private String signature;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getUserIcons() {
            return userIcons;
        }

        public void setUserIcons(String userIcons) {
            this.userIcons = userIcons;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
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

        public String getHobbies() {
            return hobbies;
        }

        public void setHobbies(String hobbies) {
            this.hobbies = hobbies;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.userId);
            dest.writeString(this.nickName);
            dest.writeInt(this.sex);
            dest.writeString(this.account);
            dest.writeString(this.userIcons);
            dest.writeString(this.area);
            dest.writeString(this.homeplace);
            dest.writeString(this.industry);
            dest.writeString(this.hobbies);
            dest.writeString(this.signature);
        }

        public ResultBean() {
        }

        protected ResultBean(Parcel in) {
            this.userId = in.readInt();
            this.nickName = in.readString();
            this.sex = in.readInt();
            this.account = in.readString();
            this.userIcons = in.readString();
            this.area = in.readString();
            this.homeplace = in.readString();
            this.industry = in.readString();
            this.hobbies = in.readString();
            this.signature = in.readString();
        }

        public static final Parcelable.Creator<ResultBean> CREATOR = new Parcelable.Creator<ResultBean>() {
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
        dest.writeParcelable(this.result, flags);
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
