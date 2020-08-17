/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexk
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MyUser.findAll", query = "SELECT m FROM MyUser m"),
    @NamedQuery(name = "MyUser.findByUserId", query = "SELECT m FROM MyUser m WHERE m.userId = :userId"),
    @NamedQuery(name = "MyUser.findByUsername", query = "SELECT m FROM MyUser m WHERE m.username = :username"),
    @NamedQuery(name = "MyUser.findByUserPassword", query = "SELECT m FROM MyUser m WHERE m.userPassword = :userPassword")})
public class MyUser implements Serializable {

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
//    private Collection<UserAddressInfo> userAddressInfoCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UserPersonalInfo> userPersonalInfoCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UserContactInfo> userContactInfoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "user_password")
    private String userPassword;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public MyUser() {
    }

    public MyUser(Integer userId) {
        this.userId = userId;
    }

    public MyUser(Integer userId, String username, String userPassword) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyUser)) {
            return false;
        }
        MyUser other = (MyUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webapp.groupproject.models.MyUser[ userId=" + userId + " ]";
    }

    @XmlTransient
    public Collection<UserContactInfo> getUserContactInfoCollection() {
        return userContactInfoCollection;
    }

    public void setUserContactInfoCollection(Collection<UserContactInfo> userContactInfoCollection) {
        this.userContactInfoCollection = userContactInfoCollection;
    }

    @XmlTransient
    public Collection<UserPersonalInfo> getUserPersonalInfoCollection() {
        return userPersonalInfoCollection;
    }

    public void setUserPersonalInfoCollection(Collection<UserPersonalInfo> userPersonalInfoCollection) {
        this.userPersonalInfoCollection = userPersonalInfoCollection;
    }

//    @XmlTransient
//    public Collection<UserAddressInfo> getUserAddressInfoCollection() {
//        return userAddressInfoCollection;
//    }
//
//    public void setUserAddressInfoCollection(Collection<UserAddressInfo> userAddressInfoCollection) {
//        this.userAddressInfoCollection = userAddressInfoCollection;
//    }
    
}
