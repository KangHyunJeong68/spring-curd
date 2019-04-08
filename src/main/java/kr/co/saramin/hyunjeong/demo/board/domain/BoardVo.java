package kr.co.saramin.hyunjeong.demo.board.domain;

import java.util.Date;

public class BoardVo {

    private int idx;
    private String subject;
    private String content;
    private String ip;
    private Date reg_date;

    public int getBno() {
        return idx;
    }

    public void setBno(int idx) {
        this.idx = idx;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
}


