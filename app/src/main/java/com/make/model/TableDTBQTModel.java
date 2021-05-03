package com.make.model;

public class TableDTBQTModel {

    private String dongTuNguyenMau;
    private String theQuaKhu;
    private String quaKhuPhanTu;
    private String nghiaDongTu;

    public TableDTBQTModel() {
    }

    public TableDTBQTModel(String dongTuNguyenMau, String theQuaKhu, String quaKhuPhanTu, String nghiaDongTu) {
        this.dongTuNguyenMau = dongTuNguyenMau;
        this.theQuaKhu = theQuaKhu;
        this.quaKhuPhanTu = quaKhuPhanTu;
        this.nghiaDongTu = nghiaDongTu;
    }

    public String getDongTuNguyenMau() {
        return dongTuNguyenMau;
    }

    public void setDongTuNguyenMau(String dongTuNguyenMau) {
        this.dongTuNguyenMau = dongTuNguyenMau;
    }

    public String getTheQuaKhu() {
        return theQuaKhu;
    }

    public void setTheQuaKhu(String theQuaKhu) {
        this.theQuaKhu = theQuaKhu;
    }

    public String getQuaKhuPhanTu() {
        return quaKhuPhanTu;
    }

    public void setQuaKhuPhanTu(String quaKhuPhanTu) {
        this.quaKhuPhanTu = quaKhuPhanTu;
    }

    public String getNghiaDongTu() {
        return nghiaDongTu;
    }

    public void setNghiaDongTu(String nghiaDongTu) {
        this.nghiaDongTu = nghiaDongTu;
    }
}
