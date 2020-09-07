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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vaggelis
 */
@Entity
@Table(name = "shop_subscription_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShopSubscriptionAccess.findAll", query = "SELECT s FROM ShopSubscriptionAccess s")
    , @NamedQuery(name = "ShopSubscriptionAccess.findById", query = "SELECT s FROM ShopSubscriptionAccess s WHERE s.id = :id")
    , @NamedQuery(name = "ShopSubscriptionAccess.findByAccess", query = "SELECT s FROM ShopSubscriptionAccess s WHERE s.access = :access")})
public class ShopSubscriptionAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "access")
    private int access;
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    @ManyToOne(optional = false)
    private Shop shopId;
    @JoinColumn(name = "subscription_id", referencedColumnName = "subscription_id")
    @ManyToOne(optional = false)
    private Subscription subscriptionId;

    public ShopSubscriptionAccess() {
    }

    public ShopSubscriptionAccess(Integer id) {
        this.id = id;
    }

    public ShopSubscriptionAccess(Integer id, int access) {
        this.id = id;
        this.access = access;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
    }

    public Subscription getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Subscription subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopSubscriptionAccess)) {
            return false;
        }
        ShopSubscriptionAccess other = (ShopSubscriptionAccess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.ShopSubscriptionAccess[ id=" + id + " ]";
    }
    
}
