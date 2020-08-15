package com.jwt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Decription：
 * @Author： huang_guoqiang
 * @Date 2019年05月10日 17:52
 * @Version 1.0
 */
@Data
public class UserEntity implements Serializable {

   private String id;
   private String userName;
   private String nickName;
   private String password;
   private String phone;
   private String sex;
   private String age;
   private String address;

}
