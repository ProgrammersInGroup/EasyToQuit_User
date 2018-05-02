package com.easytoquit.easytoquit_user.RetreiveData;

/**
 * Created by chenyunjing on 2018/4/24.
 */

public class Stop_Smoking_Really {
    private  String sumaei;
    private  String sumbfj;
    private  String sumcgk;
    private  String sumdhl;

    public  Stop_Smoking_Really(){
    }
    public Stop_Smoking_Really(String sumaei, String sumbfj,String sumcgk,String sumdhl) {
        this.sumaei = sumaei;
        this.sumbfj = sumbfj;
        this.sumcgk=sumcgk;
        this.sumdhl=sumdhl;
    }
    public String getsumaei() {
        return sumaei;
    }
    public void setsumaei(String sumaei) {
        this.sumaei = sumaei;
    }

    public String getsumbfj() {
        return sumbfj;
    }
    public void setsumbfj(String sumbfj) {
        this.sumbfj = sumbfj;
    }

    public String getsumcgk() {
        return sumcgk;
    }
    public void setsumcgk(String sumcgk) {
        this.sumcgk = sumcgk;
    }

    public String getsumdhl() {
        return sumdhl;
    }
    public void setsumdhl(String sumdhl) {
        this.sumdhl = sumdhl;
    }
}
