package com.zkp.androidwan.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.module.main.activity.weather
 * @time: 2019/5/9 17:21
 * @description:
 */
public class AddressItem {

    /**
     * 省级数据
     */
    private List<JsonBean> options1Items;
    /**
     * 市级数据
     */
    private ArrayList<ArrayList<String>> options2Items;
    /**
     * 区级数据
     */
    private ArrayList<ArrayList<ArrayList<String>>> options3Items;

    public AddressItem() {
        options1Items = new ArrayList<>();
        options2Items = new ArrayList<>();
        options3Items = new ArrayList<>();
    }

    public List<JsonBean> getOptions1Items() {
        if (options1Items == null) {
            return new ArrayList<>();
        }
        return options1Items;
    }

    public void setOptions1Items(List<JsonBean> options1Items) {
        this.options1Items = options1Items;
    }

    public ArrayList<ArrayList<String>> getOptions2Items() {
        if (options2Items == null) {
            return new ArrayList<>();
        }
        return options2Items;
    }

    public void setOptions2Items(ArrayList<ArrayList<String>> options2Items) {
        this.options2Items = options2Items;
    }

    public ArrayList<ArrayList<ArrayList<String>>> getOptions3Items() {
        if (options3Items == null) {
            return new ArrayList<>();
        }
        return options3Items;
    }

    public void setOptions3Items(ArrayList<ArrayList<ArrayList<String>>> options3Items) {
        this.options3Items = options3Items;
    }
}
