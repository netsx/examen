
package com.core.examen.mouleSeries.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("score")
    @Expose
    private float score;
    @SerializedName("show")
    @Expose
    private Show show;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

}
