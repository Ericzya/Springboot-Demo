package com.cctv.springbootdemo.model.bo.housingprice;

/**
 * @Author: Eric.Zhang
 * @Description: 房价BO（为Python爬取demo提供）
 * @Date: 2020/9/1 9:48
 */
@SuppressWarnings("AlibabaPojoMustUsePrimitiveField")
public class HousingPriceBO {
    /**
     * 城市行政区
     */
    private String houseArea;
    /**
     * 城市
     */
    private String houseCity;
    /**
     * 房价
     */
    private Double housePrice;
    /**
     * 小区名
     */
    private String houseCommunity;
    /**
     * 平方数
     */
    private String houseSquare;

    public HousingPriceBO() {
    }

    public HousingPriceBO(String houseArea, String houseCity, Double housePrice, String houseCommunity, String houseSquare) {
        this.houseArea = houseArea;
        this.houseCity = houseCity;
        this.housePrice = housePrice;
        this.houseCommunity = houseCommunity;
        this.houseSquare = houseSquare;
    }

    @Override
    public String toString() {
        return "HousingPrice{" +
                "houseArea='" + houseArea + '\'' +
                ", houseCity='" + houseCity + '\'' +
                ", housePrice=" + housePrice +
                ", houseCommunity='" + houseCommunity + '\'' +
                ", houseSquare=" + houseSquare +
                '}';
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseCity() {
        return houseCity;
    }

    public void setHouseCity(String houseCity) {
        this.houseCity = houseCity;
    }

    public double getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(double housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseCommunity() {
        return houseCommunity;
    }

    public void setHouseCommunity(String houseCommunity) {
        this.houseCommunity = houseCommunity;
    }

    public String getHouseSquare() {
        return houseSquare;
    }

    public void setHouseSquare(String houseSquare) {
        this.houseSquare = houseSquare;
    }
}
