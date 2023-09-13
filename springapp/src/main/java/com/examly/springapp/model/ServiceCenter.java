package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.Provider;

@Entity
public class ServiceCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceCenterId;
    private String serviceCenterName;
    private String serviceCenterPhone;
    private String serviceCenterAddress;
    private String serviceCenterImageUrl;
    private String serviceCenterEmailId;
    private String serviceCenterDescription;

    public ServiceCenter(){
        //TODO
    }

    public Long getServiceCenterId() {
        return serviceCenterId;
    }

    public void setServiceCenterId(Long serviceCenterId) {
        this.serviceCenterId = serviceCenterId;
    }

    public String getServiceCenterName() {
        return serviceCenterName;
    }

    public void setServiceCenterName(String serviceCenterName) {
        this.serviceCenterName = serviceCenterName;
    }

    public String getServiceCenterPhone() {
        return serviceCenterPhone;
    }

    public void setServiceCenterPhone(String serviceCenterPhone) {
        this.serviceCenterPhone = serviceCenterPhone;
    }

    public String getServiceCenterAddress() {
        return serviceCenterAddress;
    }

    public void setServiceCenterAddress(String serviceCenterAddress) {
        this.serviceCenterAddress = serviceCenterAddress;
    }

    public String getServiceCenterImageUrl() {
        return serviceCenterImageUrl;
    }

    public void setServiceCenterImageUrl(String serviceCenterImageUrl) {
        this.serviceCenterImageUrl = serviceCenterImageUrl;
    }

    public String getServiceCenterEmailId() {
        return serviceCenterEmailId;
    }

    public void setServiceCenterEmailId(String serviceCenterEmailId) {
        this.serviceCenterEmailId = serviceCenterEmailId;
    }

    public String getServiceCenterDescription() {
        return serviceCenterDescription;
    }

    public void setServiceCenterDescription(String serviceCenterDescription) {
        this.serviceCenterDescription = serviceCenterDescription;
    }
}
