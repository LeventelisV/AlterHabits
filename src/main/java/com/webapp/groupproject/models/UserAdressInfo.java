/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vaggelis
 */
@Entity
@Table(name = "user_adress_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAdressInfo.findAll", query = "SELECT u FROM UserAdressInfo u")
    , @NamedQuery(name = "UserAdressInfo.findByAdressInfoId", query = "SELECT u FROM UserAdressInfo u WHERE u.adressInfoId = :adressInfoId")
    , @NamedQuery(name = "UserAdressInfo.findByAdress", query = "SELECT u FROM UserAdressInfo u WHERE u.adress = :adress")
    , @NamedQuery(name = "UserAdressInfo.findByAdressNumber", query = "SELECT u FROM UserAdressInfo u WHERE u.adressNumber = :adressNumber")
    , @NamedQuery(name = "UserAdressInfo.findByCity", query = "SELECT u FROM UserAdressInfo u WHERE u.city = :city")
    , @NamedQuery(name = "UserAdressInfo.findByPostalCode", query = "SELECT u FROM UserAdressInfo u WHERE u.postalCode = :postalCode")
    , @NamedQuery(name = "UserAdressInfo.findByState", query = "SELECT u FROM UserAdressInfo u WHERE u.state = :state")
    , @NamedQuery(name = "UserAdressInfo.findByCountry", query = "SELECT u FROM UserAdressInfo u WHERE u.country = :country")})
public class UserAdressInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adress_info_id")
    private Integer adressInfoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adress")
    private String adress;
    @Column(name = "adress_number")
    private Integer adressNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postal_code")
    private int postalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "country")
    private String country;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private MyUser userId;

    public UserAdressInfo() {
    }

    public UserAdressInfo(Integer adressInfoId) {
        this.adressInfoId = adressInfoId;
    }

    public UserAdressInfo(Integer adressInfoId, String adress, String city, int postalCode, String state, String country) {
        this.adressInfoId = adressInfoId;
        this.adress = adress;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
    }

    public Integer getAdressInfoId() {
        return adressInfoId;
    }

    public void setAdressInfoId(Integer adressInfoId) {
        this.adressInfoId = adressInfoId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getAdressNumber() {
        return adressNumber;
    }

    public void setAdressNumber(Integer adressNumber) {
        this.adressNumber = adressNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public MyUser getUserId() {
        return userId;
    }

    public void setUserId(MyUser userId) {
        this.userId = userId;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adressInfoId != null ? adressInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAdressInfo)) {
            return false;
        }
        UserAdressInfo other = (UserAdressInfo) object;
        if ((this.adressInfoId == null && other.adressInfoId != null) || (this.adressInfoId != null && !this.adressInfoId.equals(other.adressInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.UserAdressInfo[ adressInfoId=" + adressInfoId + " ]";
    }
    
}
