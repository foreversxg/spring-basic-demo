package com.example.file;


import java.util.List;

/**
 * @author shaoxiangen
 * create in 2019/10/25
 */
public class LogMeta {
    private long id;
    private boolean confirm;
    private int score;
    private List<UpdateParams> params;

    public List<UpdateParams> getParams() {
        return params;
    }

    public void setParams(List<UpdateParams> params) {
        this.params = params;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
