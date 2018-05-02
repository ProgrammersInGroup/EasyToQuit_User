package com.easytoquit.easytoquit_user.RetreiveData;

/**
 * Created by chenyunjing on 2018/4/28.
 */

public class Why_smoking {
    private String sumstimulate;
    private  String sumcontrol;
    private  String sumrelax;
    private String sumemotional＿support;
    private String sumdesire;
    private String sumhabitual;

    public  Why_smoking(){
    }
    public Why_smoking(String sumstimulate, String sumcontrol,String sumrelax,String sumemotional＿support,String sumdesire,String sumhabitual) {
        this.sumstimulate = sumstimulate;
        this.sumcontrol = sumcontrol;
        this.sumrelax=sumrelax;
        this.sumemotional＿support=sumemotional＿support;
        this.sumdesire=sumdesire;
        this.sumhabitual=sumhabitual;
    }
    public String getsumStimulate() {
        return sumstimulate;
    }
    public void setsumStimulate(String sumstimulate) {
        this.sumstimulate = sumstimulate;
    }

    public String getsumControl() {
        return sumcontrol;
    }
    public void setsumControl(String sumcontrol) {
        this.sumcontrol = sumcontrol;
    }

    public String getsumRelax() {
        return sumrelax;
    }
    public void setsumRelax(String sumrelax) {
        this.sumrelax = sumrelax;
    }

    public String getsumEmotional＿support() {
        return sumemotional＿support;
    }
    public void setsumEmotional＿support(String sumemotional＿support) {
        this.sumemotional＿support = sumemotional＿support;
    }

    public String getsumDesire() {
        return sumdesire;
    }
    public void setsumDesire(String sumdesire) {
        this.sumdesire = sumdesire;
    }

    public String getsumHabitual() {
        return sumhabitual;
    }
    public void setsumHabitual(String sumhabitual) {
        this.sumhabitual = sumhabitual;
    }
}
