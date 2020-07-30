/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.io.Serializable;
import java.util.Map;

public class Mail implements Serializable {

    private static final long serialVersionUID = -6390720891150157552L;
    public static final String ENCODEING = "UTF-8";
// 伺服器地址 
    private String host;
// 發件人的郵箱 
    private String sender;
// 發件人暱稱 
    private String name;
// 賬號 
    private String username;
// 密碼 
    private String password;
// 收件人的郵箱 
    private String receiver;
// 收件人的名稱
    private String receiverName;
// 收件人的郵箱(key)和名稱(value)
    private Map<String, String> to;
// 抄送人的郵箱(key)和名稱(value)
    private Map<String, String> cc;
// 祕密抄送人的郵箱(key)和名稱(value)
    private Map<String, String> bcc;
// 主題 
    private String subject;
// 資訊(支援HTML)
    private String message;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Map<String, String> getTo() {
        return to;
    }

    public void setTo(Map<String, String> to) {
        this.to = to;
    }

    public Map<String, String> getCc() {
        return cc;
    }

    public void setCc(Map<String, String> cc) {
        this.cc = cc;
    }

    public Map<String, String> getBcc() {
        return bcc;
    }

    public void setBcc(Map<String, String> bcc) {
        this.bcc = bcc;
    }
}