/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vaggelis
 */
@Entity
@Table(name = "shops")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shop.findAll", query = "SELECT s FROM Shop s")
    , @NamedQuery(name = "Shop.findByShopId", query = "SELECT s FROM Shop s WHERE s.shopId = :shopId")
    , @NamedQuery(name = "Shop.findByShopName", query = "SELECT s FROM Shop s WHERE s.shopName = :shopName")})
public class Shop implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "shop_name")
    private String shopName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "SHOP_PHOTO")
    private String shopPhoto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopId")
    private Collection<ShopSubscriptionAccess> shopSubscriptionAccessCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sHOPid")
    private Collection<Reservation> reservationCollection;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shop_id")
    private Integer shopId;
    @JoinTable(name="shops_activities",joinColumns={@JoinColumn(name="shop_id")},
            inverseJoinColumns={@JoinColumn(name="activity_id")})
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Activity> activities=new ArrayList<Activity>();

    public Shop() {
    }

    public Shop(Integer shopId) {
        this.shopId = shopId;
    }

    public Shop(Integer shopId, String shopName) {
        this.shopId = shopId;
        this.shopName = shopName;
    }
    public Shop(Integer shopId, String shopName,List<Activity> activities) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.activities= activities;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopId != null ? shopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shop)) {
            return false;
        }
        Shop other = (Shop) object;
        if ((this.shopId == null && other.shopId != null) || (this.shopId != null && !this.shopId.equals(other.shopId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.Shops[ shopId=" + shopId + " ]";
    }

  
    public String getShopPhoto() {
        return shopPhoto;
    }

    public void setShopPhoto(String shopPhoto) {
        this.shopPhoto = shopPhoto;
    }

 

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }



    @XmlTransient
    public Collection<ShopSubscriptionAccess> getShopSubscriptionAccessCollection() {
        return shopSubscriptionAccessCollection;
    }

    public void setShopSubscriptionAccessCollection(Collection<ShopSubscriptionAccess> shopSubscriptionAccessCollection) {
        this.shopSubscriptionAccessCollection = shopSubscriptionAccessCollection;
    }




    
}
