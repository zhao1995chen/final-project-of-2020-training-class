/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.*;
public class UserInfo {
    private static UserInfo user = new UserInfo();
    private ArrayList list = new ArrayList();

    public UserInfo() {
        this.list = new ArrayList();
    }

    public static UserInfo getInstance() {  //取得該靜態變數 UserInfo 
        return user;
    }

    public boolean addUser(String user) {   //加入一個用戶  代表上線
        if (user != null) {
            this.list.add(user);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList getList() {
        return this.list;
    }

    public void removeUser(String user) {    //移除某一個線上用戶  代表下線
        if (user != null) {
            this.list.remove(user);
        }
    }
}
