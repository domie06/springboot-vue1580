package com.entity;

public class Qiuzhuoxinxi {
    private Integer id;
	private String qiuzhuohao;	private String zhuangtai;	private String meixiaoshijifei;	private String beizhu;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getQiuzhuohao() {
        return qiuzhuohao;
    }
    public void setQiuzhuohao(String qiuzhuohao) {
        this.qiuzhuohao = qiuzhuohao == null ? null : qiuzhuohao.trim();
    }	public String getZhuangtai() {
        return zhuangtai;
    }
    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai == null ? null : zhuangtai.trim();
    }	public String getMeixiaoshijifei() {
        return meixiaoshijifei;
    }
    public void setMeixiaoshijifei(String meixiaoshijifei) {
        this.meixiaoshijifei = meixiaoshijifei == null ? null : meixiaoshijifei.trim();
    }	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
