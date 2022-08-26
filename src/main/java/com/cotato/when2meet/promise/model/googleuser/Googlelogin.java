package com.cotato.when2meet.promise.model.googleuser;


import com.cotato.when2meet.promise.model.BaseTimeEntity;

import lombok.*;

import javax.management.relation.Role;
import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Googlelogin extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;



    @Builder
    public Googlelogin(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }




    public Googlelogin update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();  //왜 안되는지 모르겠다.
    }
}
