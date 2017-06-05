package com.hado.brainchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hado on 6/2/17.
 */

public class UserInfo {
  @SerializedName("username")
  private String username;

  @SerializedName("password")
  @Expose(serialize = false)
  private String password;

  @SerializedName("email")
  private String email;

  @SerializedName("phone")
  private String phone;

  @SerializedName("avatar")
  private String avatar;

  @SerializedName("dob")
  private long dateOfBirth;

  @SerializedName("score")
  private int score;

  @SerializedName("gender")
  private int gender;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public long getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(long dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }
}
