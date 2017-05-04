package com.jaydenxiao.common.basebean.homepage;

import java.io.Serializable;
import java.util.List;

/**
 * 企业基本信息展示
 * Created by RXPC-D252 on 2017/3/24.
 */

public class EnterPriseDetailInfo implements Serializable {
    private int id;
    private String name;
    private int cityId;
    private String cityName;
    private String address;
    private int authentication;
    private String scale;
    private String scaleStr;
    private String mobile;
    private String description;
    private String logoUrl;
    private int status;
    private String juridicalPerson;
    private int modifier;
    private int provinceId;
    private String provinceNmae;
    private int creator;

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    /**
     * id : 4
     * enterpriseId : 6
     * contactName : 联系人信息1
     * contactEmail : 联系邮箱1
     * contactMobile : 手机号码1
     */

    private List<ContactEnterpriseDtoBean> contactEnterpriseDto;

    public String getScaleStr() {
        return scaleStr;
    }

    public void setScaleStr(String scaleStr) {
        this.scaleStr = scaleStr;
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

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAuthentication() {
        return authentication;
    }

    public void setAuthentication(int authentication) {
        this.authentication = authentication;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getJuridicalPerson() {
        return juridicalPerson;
    }

    public void setJuridicalPerson(String juridicalPerson) {
        this.juridicalPerson = juridicalPerson;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceNmae() {
        return provinceNmae;
    }

    public void setProvinceNmae(String provinceNmae) {
        this.provinceNmae = provinceNmae;
    }

    public List<ContactEnterpriseDtoBean> getContactEnterpriseDto() {
        return contactEnterpriseDto;
    }

    public void setContactEnterpriseDto(List<ContactEnterpriseDtoBean> contactEnterpriseDto) {
        this.contactEnterpriseDto = contactEnterpriseDto;
    }

    public static class ContactEnterpriseDtoBean {
        private int id;
        private int enterpriseId;
        private String contactName;
        private String contactEmail;
        private String contactMobile;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(int enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getContactMobile() {
            return contactMobile;
        }

        public void setContactMobile(String contactMobile) {
            this.contactMobile = contactMobile;
        }
    }
}
