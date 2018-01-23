package com.easytoquit.easytoquit_user.RetreiveData;

/**
 * Created by Polaris0712 on 12/01/2018.
 */

public class User {
    private String name ;
    private String age ;
    private String gender;
    private String phone;
    private String BitmapString;

    public User() {
    }

    public User(String name, String age,String gender,String phone,String BitmapString) {
        this.name = name;
        this.age = age;
        this.gender=gender;
        this.phone=phone;
        this.BitmapString=BitmapString;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getBitmapString() {
        return BitmapString;
    }
    public void setBitmapString(String BitmapString) {
        this.BitmapString = BitmapString;
    }

}
