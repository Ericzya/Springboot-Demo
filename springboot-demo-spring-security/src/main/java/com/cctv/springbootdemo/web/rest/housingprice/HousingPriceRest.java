package com.cctv.springbootdemo.web.rest.housingprice;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.cctv.springbootdemo.model.bo.housingprice.HousingPriceBO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Eric.Zhang
 * @Description: A rest interface controller for python demo
 * @Date: 2020/9/1 9:38
 */
@RestController
@RequestMapping("/housing-price")
public class HousingPriceRest {
    @GetMapping("/search")
    @ResponseBody
    public String getHousingPrice(@RequestParam("city") String city, @RequestParam("cityArea") String cityArea,
                                  @RequestParam("index") int index, @RequestParam("size") int size) {
        //目前只提供苏州地区查询
        String currentCity = "苏州";
        String[] cityAreaArr = {"姑苏区", "相城区", "高新区", "园区", "吴中区", "吴江区"};
        String[] houseCommunityArr = {"新城红树湾", "越湖家天下", "香堤澜湾", "旭辉美澜城", "万科北宸之光", "恒基水漾花城",
                "中海国际社区", "路劲主场一期", "建屋海德公园", "中海双湾花园一期", "越湖名邸", "海尚壹品", "中海8号公馆",
                "阳光水榭花园", "湖畔天城", "中央景城", "路劲凤凰城", "万达广场", "中海御景湾", "万科魅力花园",
                "弘阳上湖", "保利悦玺", "翰林缘", "建发独墅湾", "新城金郡北区", "新城金郡南区二期"};
        String[] houseSquareArr = {"120", "109", "103.5", "98", "92.3", "87"};
        List<HousingPriceBO> housingPriceBOList = new ArrayList<>();
        if (index < 0) {
            index = 0;
        }
        if (size < 1) {
            size = 20;
        }
        if (currentCity.equals(city)) {
            for (int startIndex = index; startIndex <= index + size; startIndex++) {
                if (StringUtils.isEmpty(cityArea)) {
                    cityArea = cityAreaArr[new Random().nextInt(6)];
                }
                String houseCommunity = houseCommunityArr[new Random().nextInt(26)];
                int housePrice = new Random().nextInt(6000) * 1000 + 1200000;
                String houseSquare = houseSquareArr[new Random().nextInt(6)];
                housingPriceBOList.add(new HousingPriceBO(cityArea, city, (double) housePrice, houseCommunity, houseSquare));
            }
            return JSONArray.toJSONString(housingPriceBOList);
        }
        return "";
    }
}
