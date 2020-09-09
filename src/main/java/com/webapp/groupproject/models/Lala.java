/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author alexk
 */
public class Lala {
    
    private String koko;
    private String mimi;
//    private MultipartFile file;

    public Lala() {
    }

    public Lala(String koko, String mimi) {
        this.koko = koko;
        this.mimi = mimi;
    }
    
    
//
//    public Lala(String koko, String mimi, MultipartFile file) {
//        this.koko = koko;
//        this.mimi = mimi;
//        this.file = file;
//    }

    public String getKoko() {
        return koko;
    }

    public void setKoko(String koko) {
        this.koko = koko;
    }

    public String getMimi() {
        return mimi;
    }

    public void setMimi(String mimi) {
        this.mimi = mimi;
    }
//
//    public MultipartFile getFile() {
//        return file;
//    }
//
//    public void setFile(MultipartFile file) {
//        this.file = file;
//    }
//    
}
