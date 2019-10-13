package com.example.demo.bean;

import java.util.Date;

/**
 * java bean for Apache Commons test
 */
public class Person {
  private String name = "xrq";
  private int age = 25;
  private Date createTime = new Date();
  private String password;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", createTime=" + createTime +
        ", password='" + password + '\'' +
        '}';
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
