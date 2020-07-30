package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.http.HttpSessionBindingEvent;
import domain.UserInfo;

public class UserSessionBinding implements javax.servlet.http.HttpSessionBindingListener {

    private String username;
    private UserInfo ui = UserInfo.getInstance();

    public UserSessionBinding() {
        this.username = "";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void valueBound(HttpSessionBindingEvent arg0) {   //必須實做此方法 代表屬性被繫結
        System.out.println("上線用戶 : " + this.username);
    }

    public void valueUnbound(HttpSessionBindingEvent arg0) {  //必須實做此方法  
        System.out.println("下線用戶 : " + this.username);
        if (this.username != "") {
            ui.removeUser(username);    //移除該上線用戶
        }
    }
}
