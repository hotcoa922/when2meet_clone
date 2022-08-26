package com.cotato.when2meet.promise.web.dto;

import com.cotato.when2meet.promise.model.googleuser.Googlelogin;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(Googlelogin googlelogin){
        this.name =  googlelogin.getName();
        this.email =  googlelogin.getEmail();
        this.picture =  googlelogin.getPicture();
    }
}