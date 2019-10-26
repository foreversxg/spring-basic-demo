package com.example.file;

import java.util.Date;

/**
 * @author shaoxiangen
 * create in 2019/10/25
 */
public class LogMetaWrapper {

    private Date date;
    private LogMeta logMeta;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LogMeta getLogMeta() {
        return logMeta;
    }

    public void setLogMeta(LogMeta logMeta) {
        this.logMeta = logMeta;
    }
}
