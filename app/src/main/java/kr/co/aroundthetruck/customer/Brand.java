package kr.co.aroundthetruck.customer;

/**
 * Created by sumin on 2014-12-03.
 */
public class Brand {
    private int brandImage;
    private String brandName;
    private  String brandDistance;
    private int like;
    private String category;

    public int getBrandImage(){ return brandImage;}
    public String getBrandName(){
        return brandName;
    }
    public String getBrandDistance(){
        return brandDistance;
    }
    public int getLike(){return  like; }
    public String getCategory(){return category; }

}