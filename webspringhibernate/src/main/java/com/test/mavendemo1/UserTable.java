package com.test.mavendemo1;

import java.util.Date;

/**
 * UserTable generated by hbm2java
 */
public class UserTable  implements java.io.Serializable {


     private int userId;
     private String userName;
     private String createdBy;
     private Date createdDate;

    public UserTable() {
    }

	
    public UserTable(int userId, String createdBy, Date createdDate) {
        this.userId = userId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }
    public UserTable(int userId, String userName, String createdBy, Date createdDate) {
       this.userId = userId;
       this.userName = userName;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
    }
   
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }




}


