/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "subscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s")
    , @NamedQuery(name = "Subscription.findBySubscriptionId", query = "SELECT s FROM Subscription s WHERE s.subscriptionId = :subscriptionId")
    , @NamedQuery(name = "Subscription.findBySubscriptionType", query = "SELECT s FROM Subscription s WHERE s.subscriptionType = :subscriptionType")})
public class Subscription implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "subscription_type")
    private String subscriptionType;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subscription_id")
    private Integer subscriptionId;
    @OneToMany(mappedBy = "subscriptionId")
    private Collection<ShopSubscriptionAccess> shopSubscriptionAccessCollection;

    public Subscription() {
    }

    public Subscription(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Subscription(Integer subscriptionId, String subscriptionType) {
        this.subscriptionId = subscriptionId;
        this.subscriptionType = subscriptionType;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    @XmlTransient
    public Collection<ShopSubscriptionAccess> getShopSubscriptionAccessCollection() {
        return shopSubscriptionAccessCollection;
    }

    public void setShopSubscriptionAccessCollection(Collection<ShopSubscriptionAccess> shopSubscriptionAccessCollection) {
        this.shopSubscriptionAccessCollection = shopSubscriptionAccessCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subscriptionId != null ? subscriptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.subscriptionId == null && other.subscriptionId != null) || (this.subscriptionId != null && !this.subscriptionId.equals(other.subscriptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.Subscription[ subscriptionId=" + subscriptionId + " ]";
    }


}
