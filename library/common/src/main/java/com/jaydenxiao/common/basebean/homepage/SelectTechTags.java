package com.jaydenxiao.common.basebean.homepage;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by RXPC-D252 on 2017/3/27.
 */
public class SelectTechTags {

        /**
         * code : education
         * id : 84
         * name : 店面经营
         * used : true
         */

        private List<TechniqueListBean> techniqueList;
        /**
         * code : 1
         * description : 线上
         */

        private List<TypesBean> types;



    public List<TechniqueListBean> getTechniqueList() {
            return techniqueList;
        }

        public void setTechniqueList(List<TechniqueListBean> techniqueList) {
            this.techniqueList = techniqueList;
        }

        public List<TypesBean> getTypes() {
            return types;
        }

        public void setTypes(List<TypesBean> types) {
            this.types = types;
        }


    public static class TechniqueListBean implements Parcelable{
            private String code;
            private int id;
            private String name;
            private boolean used;

        protected TechniqueListBean(Parcel in) {
            code = in.readString();
            id = in.readInt();
            name = in.readString();
            used = in.readByte() != 0;
        }

        public static final Creator<TechniqueListBean> CREATOR = new Creator<TechniqueListBean>() {
            @Override
            public TechniqueListBean createFromParcel(Parcel in) {
                return new TechniqueListBean(in);
            }

            @Override
            public TechniqueListBean[] newArray(int size) {
                return new TechniqueListBean[size];
            }
        };

        public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(code);
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeByte((byte) (used ? 1 : 0));
        }
    }

        public static class TypesBean implements Parcelable{
            private int code;
            private String description;

            protected TypesBean(Parcel in) {
                code = in.readInt();
                description = in.readString();
            }

            public static final Creator<TypesBean> CREATOR = new Creator<TypesBean>() {
                @Override
                public TypesBean createFromParcel(Parcel in) {
                    return new TypesBean(in);
                }

                @Override
                public TypesBean[] newArray(int size) {
                    return new TypesBean[size];
                }
            };

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(code);
                dest.writeString(description);
            }
        }
}
