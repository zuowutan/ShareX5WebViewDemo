package com.example.administrator.sharex5webviewdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tzw on 2018/3/13.
 */

public class MVPLoginResultBean implements Parcelable {

    private int code;
    private String msg;
    private UserBean user;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }



    public static class UserBean implements Parcelable {


        private int id;
        private String username;
        private String icon;
        private int gift_count;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getGift_count() {
            return gift_count;
        }

        public void setGift_count(int gift_count) {
            this.gift_count = gift_count;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.username);
            dest.writeString(this.icon);
            dest.writeInt(this.gift_count);
        }

        public UserBean() {
        }

        protected UserBean(Parcel in) {
            this.id = in.readInt();
            this.username = in.readString();
            this.icon = in.readString();
            this.gift_count = in.readInt();
        }

        public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() {
            @Override
            public UserBean createFromParcel(Parcel source) {
                return new UserBean(source);
            }

            @Override
            public UserBean[] newArray(int size) {
                return new UserBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.msg);
        dest.writeParcelable(this.user, flags);
    }

    public MVPLoginResultBean() {
    }

    protected MVPLoginResultBean(Parcel in) {
        this.code = in.readInt();
        this.msg = in.readString();
        this.user = in.readParcelable(UserBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<MVPLoginResultBean> CREATOR = new Parcelable.Creator<MVPLoginResultBean>() {
        @Override
        public MVPLoginResultBean createFromParcel(Parcel source) {
            return new MVPLoginResultBean(source);
        }

        @Override
        public MVPLoginResultBean[] newArray(int size) {
            return new MVPLoginResultBean[size];
        }
    };
}
