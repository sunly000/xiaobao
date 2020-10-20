package com.xiaobao.demo.domain;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String sex;
    private int age;
    private String email;
    private String createDate;
    private String lastUpdateDate;
    private String comments;

    public User() {
    }

    public User(String userName, String password, String sex, int age, String phoneNum, String createDate, String lastUpdateDate, String comments) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.email = phoneNum;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.comments = comments;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String phoneNum) {
        this.email = phoneNum;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phoneNum='" + email + '\'' +
                ", createDate='" + createDate + '\'' +
                ", lastUpdateDate='" + lastUpdateDate + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
