package com.zkp.gank.bean;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.bean
 * @time: 2019/5/13 15:59
 * @description:
 */
public class DailyWeatherBean {


    /**
     * status : ok
     * lang : zh_CN
     * result : {"primary":0,"daily":{"status":"ok","comfort":[{"index":"3","desc":"热","datetime":"2019-05-13"},{"index":"3","desc":"热","datetime":"2019-05-14"},{"index":"3","desc":"热","datetime":"2019-05-15"},{"index":"0","desc":"闷热","datetime":"2019-05-16"},{"index":"0","desc":"闷热","datetime":"2019-05-17"}],"skycon_20h_32h":[{"date":"2019-05-13","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-05-14","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-05-15","value":"CLOUDY"},{"date":"2019-05-16","value":"RAIN"},{"date":"2019-05-17","value":"RAIN"}],"temperature":[{"date":"2019-05-13","max":28.34,"avg":24.03,"min":21},{"date":"2019-05-14","max":30.5,"avg":25.97,"min":23},{"date":"2019-05-15","max":30,"avg":26.27,"min":24},{"date":"2019-05-16","max":31,"avg":26.78,"min":24.93},{"date":"2019-05-17","max":32,"avg":27.22,"min":25}],"dswrf":[{"date":"2019-05-13","max":865.5,"avg":376.6,"min":0},{"date":"2019-05-14","max":866.7,"avg":338.6,"min":0},{"date":"2019-05-15","max":829.4,"avg":318.2,"min":0},{"date":"2019-05-16","max":516.6,"avg":144.7,"min":0},{"date":"2019-05-17","max":420.6,"avg":138,"min":0}],"cloudrate":[{"date":"2019-05-13","max":0.47,"avg":0.07,"min":0},{"date":"2019-05-14","max":0.73,"avg":0.42,"min":0},{"date":"2019-05-15","max":1,"avg":0.61,"min":0.19},{"date":"2019-05-16","max":1,"avg":0.99,"min":0.96},{"date":"2019-05-17","max":1,"avg":1,"min":1}],"aqi":[{"date":"2019-05-13","max":53,"avg":42.67,"min":26},{"date":"2019-05-14","max":52,"avg":38.21,"min":24},{"date":"2019-05-15","max":36,"avg":24.92,"min":16},{"date":"2019-05-16","max":24,"avg":16.54,"min":13},{"date":"2019-05-17","max":21,"avg":14.96,"min":10}],"skycon":[{"date":"2019-05-13","value":"CLEAR_DAY"},{"date":"2019-05-14","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-15","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-16","value":"RAIN"},{"date":"2019-05-17","value":"RAIN"}],"visibility":[{"date":"2019-05-13","max":24.1,"avg":10.81,"min":9.18},{"date":"2019-05-14","max":16.49,"avg":10.57,"min":8.04},{"date":"2019-05-15","max":11.61,"avg":8.93,"min":7.29},{"date":"2019-05-16","max":11.83,"avg":8.58,"min":7.14},{"date":"2019-05-17","max":11.15,"avg":8.91,"min":7.64}],"humidity":[{"date":"2019-05-13","max":0.87,"avg":0.83,"min":0.73},{"date":"2019-05-14","max":0.9,"avg":0.84,"min":0.75},{"date":"2019-05-15","max":0.93,"avg":0.88,"min":0.81},{"date":"2019-05-16","max":0.94,"avg":0.89,"min":0.81},{"date":"2019-05-17","max":0.92,"avg":0.88,"min":0.82}],"astro":[{"date":"2019-05-13","sunset":{"time":"18:42"},"sunrise":{"time":"05:24"}},{"date":"2019-05-14","sunset":{"time":"18:42"},"sunrise":{"time":"05:24"}},{"date":"2019-05-15","sunset":{"time":"18:43"},"sunrise":{"time":"05:23"}},{"date":"2019-05-16","sunset":{"time":"18:43"},"sunrise":{"time":"05:23"}},{"date":"2019-05-17","sunset":{"time":"18:44"},"sunrise":{"time":"05:23"}}],"coldRisk":[{"index":"4","desc":"极易发","datetime":"2019-05-13"},{"index":"4","desc":"极易发","datetime":"2019-05-14"},{"index":"3","desc":"易发","datetime":"2019-05-15"},{"index":"3","desc":"易发","datetime":"2019-05-16"},{"index":"3","desc":"易发","datetime":"2019-05-17"}],"ultraviolet":[{"index":"4","desc":"强","datetime":"2019-05-13"},{"index":"3","desc":"中等","datetime":"2019-05-14"},{"index":"2","desc":"弱","datetime":"2019-05-15"},{"index":"1","desc":"最弱","datetime":"2019-05-16"},{"index":"1","desc":"最弱","datetime":"2019-05-17"}],"pres":[{"date":"2019-05-13","max":101088.6,"avg":100751.98,"min":100688.36},{"date":"2019-05-14","max":100905.93,"avg":100723.84,"min":100585.68},{"date":"2019-05-15","max":100905.68,"avg":100760.55,"min":100585.68},{"date":"2019-05-16","max":100688.6,"avg":100523.51,"min":100345.68},{"date":"2019-05-17","max":100449.21,"avg":100274.57,"min":100128.6}],"pm25":[{"date":"2019-05-13","max":36,"avg":29.56,"min":16},{"date":"2019-05-14","max":37,"avg":26.79,"min":17},{"date":"2019-05-15","max":25,"avg":17.46,"min":11},{"date":"2019-05-16","max":17,"avg":11.5,"min":9},{"date":"2019-05-17","max":15,"avg":10.54,"min":7}],"dressing":[{"index":"3","desc":"热","datetime":"2019-05-13"},{"index":"3","desc":"热","datetime":"2019-05-14"},{"index":"2","desc":"很热","datetime":"2019-05-15"},{"index":"2","desc":"很热","datetime":"2019-05-16"},{"index":"2","desc":"很热","datetime":"2019-05-17"}],"carWashing":[{"index":"1","desc":"适宜","datetime":"2019-05-13"},{"index":"1","desc":"适宜","datetime":"2019-05-14"},{"index":"3","desc":"较不适宜","datetime":"2019-05-15"},{"index":"3","desc":"较不适宜","datetime":"2019-05-16"},{"index":"3","desc":"较不适宜","datetime":"2019-05-17"}],"precipitation":[{"date":"2019-05-13","max":0,"avg":0,"min":0},{"date":"2019-05-14","max":0,"avg":0,"min":0},{"date":"2019-05-15","max":0,"avg":0,"min":0},{"date":"2019-05-16","max":0.3551,"avg":0.1135,"min":0},{"date":"2019-05-17","max":0.6848,"avg":0.199,"min":0}],"wind":[{"date":"2019-05-13","max":{"direction":141,"speed":20.16},"avg":{"direction":150.07,"speed":9.27},"min":{"direction":287.12,"speed":1.39}},{"date":"2019-05-14","max":{"direction":173.26,"speed":23.66},"avg":{"direction":183.9,"speed":11.34},"min":{"direction":240.79,"speed":5.08}},{"date":"2019-05-15","max":{"direction":165.91,"speed":18.98},"avg":{"direction":147.85,"speed":12.03},"min":{"direction":121.82,"speed":6.01}},{"date":"2019-05-16","max":{"direction":182.53,"speed":16.87},"avg":{"direction":201.83,"speed":11.63},"min":{"direction":216.26,"speed":7.99}},{"date":"2019-05-17","max":{"direction":241.63,"speed":15.42},"avg":{"direction":221.55,"speed":12.4},"min":{"direction":228.87,"speed":9.39}}],"skycon_08h_20h":[{"date":"2019-05-13","value":"CLEAR_DAY"},{"date":"2019-05-14","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-15","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-16","value":"RAIN"},{"date":"2019-05-17","value":"RAIN"}]}}
     * server_time : 1557734254
     * api_status : active
     * tzshift : 28800
     * api_version : v2.2
     * unit : metric
     * location : [24.502645,118.178377]
     */

    private String status;
    private String lang;
    private ResultBean result;
    private long server_time;
    private String api_status;
    private int tzshift;
    private String api_version;
    private String unit;
    private List<Double> location;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public long getServer_time() {
        return server_time;
    }

    public void setServer_time(long server_time) {
        this.server_time = server_time;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * primary : 0
         * daily : {"status":"ok","comfort":[{"index":"3","desc":"热","datetime":"2019-05-13"},{"index":"3","desc":"热","datetime":"2019-05-14"},{"index":"3","desc":"热","datetime":"2019-05-15"},{"index":"0","desc":"闷热","datetime":"2019-05-16"},{"index":"0","desc":"闷热","datetime":"2019-05-17"}],"skycon_20h_32h":[{"date":"2019-05-13","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-05-14","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-05-15","value":"CLOUDY"},{"date":"2019-05-16","value":"RAIN"},{"date":"2019-05-17","value":"RAIN"}],"temperature":[{"date":"2019-05-13","max":28.34,"avg":24.03,"min":21},{"date":"2019-05-14","max":30.5,"avg":25.97,"min":23},{"date":"2019-05-15","max":30,"avg":26.27,"min":24},{"date":"2019-05-16","max":31,"avg":26.78,"min":24.93},{"date":"2019-05-17","max":32,"avg":27.22,"min":25}],"dswrf":[{"date":"2019-05-13","max":865.5,"avg":376.6,"min":0},{"date":"2019-05-14","max":866.7,"avg":338.6,"min":0},{"date":"2019-05-15","max":829.4,"avg":318.2,"min":0},{"date":"2019-05-16","max":516.6,"avg":144.7,"min":0},{"date":"2019-05-17","max":420.6,"avg":138,"min":0}],"cloudrate":[{"date":"2019-05-13","max":0.47,"avg":0.07,"min":0},{"date":"2019-05-14","max":0.73,"avg":0.42,"min":0},{"date":"2019-05-15","max":1,"avg":0.61,"min":0.19},{"date":"2019-05-16","max":1,"avg":0.99,"min":0.96},{"date":"2019-05-17","max":1,"avg":1,"min":1}],"aqi":[{"date":"2019-05-13","max":53,"avg":42.67,"min":26},{"date":"2019-05-14","max":52,"avg":38.21,"min":24},{"date":"2019-05-15","max":36,"avg":24.92,"min":16},{"date":"2019-05-16","max":24,"avg":16.54,"min":13},{"date":"2019-05-17","max":21,"avg":14.96,"min":10}],"skycon":[{"date":"2019-05-13","value":"CLEAR_DAY"},{"date":"2019-05-14","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-15","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-16","value":"RAIN"},{"date":"2019-05-17","value":"RAIN"}],"visibility":[{"date":"2019-05-13","max":24.1,"avg":10.81,"min":9.18},{"date":"2019-05-14","max":16.49,"avg":10.57,"min":8.04},{"date":"2019-05-15","max":11.61,"avg":8.93,"min":7.29},{"date":"2019-05-16","max":11.83,"avg":8.58,"min":7.14},{"date":"2019-05-17","max":11.15,"avg":8.91,"min":7.64}],"humidity":[{"date":"2019-05-13","max":0.87,"avg":0.83,"min":0.73},{"date":"2019-05-14","max":0.9,"avg":0.84,"min":0.75},{"date":"2019-05-15","max":0.93,"avg":0.88,"min":0.81},{"date":"2019-05-16","max":0.94,"avg":0.89,"min":0.81},{"date":"2019-05-17","max":0.92,"avg":0.88,"min":0.82}],"astro":[{"date":"2019-05-13","sunset":{"time":"18:42"},"sunrise":{"time":"05:24"}},{"date":"2019-05-14","sunset":{"time":"18:42"},"sunrise":{"time":"05:24"}},{"date":"2019-05-15","sunset":{"time":"18:43"},"sunrise":{"time":"05:23"}},{"date":"2019-05-16","sunset":{"time":"18:43"},"sunrise":{"time":"05:23"}},{"date":"2019-05-17","sunset":{"time":"18:44"},"sunrise":{"time":"05:23"}}],"coldRisk":[{"index":"4","desc":"极易发","datetime":"2019-05-13"},{"index":"4","desc":"极易发","datetime":"2019-05-14"},{"index":"3","desc":"易发","datetime":"2019-05-15"},{"index":"3","desc":"易发","datetime":"2019-05-16"},{"index":"3","desc":"易发","datetime":"2019-05-17"}],"ultraviolet":[{"index":"4","desc":"强","datetime":"2019-05-13"},{"index":"3","desc":"中等","datetime":"2019-05-14"},{"index":"2","desc":"弱","datetime":"2019-05-15"},{"index":"1","desc":"最弱","datetime":"2019-05-16"},{"index":"1","desc":"最弱","datetime":"2019-05-17"}],"pres":[{"date":"2019-05-13","max":101088.6,"avg":100751.98,"min":100688.36},{"date":"2019-05-14","max":100905.93,"avg":100723.84,"min":100585.68},{"date":"2019-05-15","max":100905.68,"avg":100760.55,"min":100585.68},{"date":"2019-05-16","max":100688.6,"avg":100523.51,"min":100345.68},{"date":"2019-05-17","max":100449.21,"avg":100274.57,"min":100128.6}],"pm25":[{"date":"2019-05-13","max":36,"avg":29.56,"min":16},{"date":"2019-05-14","max":37,"avg":26.79,"min":17},{"date":"2019-05-15","max":25,"avg":17.46,"min":11},{"date":"2019-05-16","max":17,"avg":11.5,"min":9},{"date":"2019-05-17","max":15,"avg":10.54,"min":7}],"dressing":[{"index":"3","desc":"热","datetime":"2019-05-13"},{"index":"3","desc":"热","datetime":"2019-05-14"},{"index":"2","desc":"很热","datetime":"2019-05-15"},{"index":"2","desc":"很热","datetime":"2019-05-16"},{"index":"2","desc":"很热","datetime":"2019-05-17"}],"carWashing":[{"index":"1","desc":"适宜","datetime":"2019-05-13"},{"index":"1","desc":"适宜","datetime":"2019-05-14"},{"index":"3","desc":"较不适宜","datetime":"2019-05-15"},{"index":"3","desc":"较不适宜","datetime":"2019-05-16"},{"index":"3","desc":"较不适宜","datetime":"2019-05-17"}],"precipitation":[{"date":"2019-05-13","max":0,"avg":0,"min":0},{"date":"2019-05-14","max":0,"avg":0,"min":0},{"date":"2019-05-15","max":0,"avg":0,"min":0},{"date":"2019-05-16","max":0.3551,"avg":0.1135,"min":0},{"date":"2019-05-17","max":0.6848,"avg":0.199,"min":0}],"wind":[{"date":"2019-05-13","max":{"direction":141,"speed":20.16},"avg":{"direction":150.07,"speed":9.27},"min":{"direction":287.12,"speed":1.39}},{"date":"2019-05-14","max":{"direction":173.26,"speed":23.66},"avg":{"direction":183.9,"speed":11.34},"min":{"direction":240.79,"speed":5.08}},{"date":"2019-05-15","max":{"direction":165.91,"speed":18.98},"avg":{"direction":147.85,"speed":12.03},"min":{"direction":121.82,"speed":6.01}},{"date":"2019-05-16","max":{"direction":182.53,"speed":16.87},"avg":{"direction":201.83,"speed":11.63},"min":{"direction":216.26,"speed":7.99}},{"date":"2019-05-17","max":{"direction":241.63,"speed":15.42},"avg":{"direction":221.55,"speed":12.4},"min":{"direction":228.87,"speed":9.39}}],"skycon_08h_20h":[{"date":"2019-05-13","value":"CLEAR_DAY"},{"date":"2019-05-14","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-15","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-16","value":"RAIN"},{"date":"2019-05-17","value":"RAIN"}]}
         */

        private int primary;
        private DailyBean daily;

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public DailyBean getDaily() {
            return daily;
        }

        public void setDaily(DailyBean daily) {
            this.daily = daily;
        }

        public static class DailyBean {
            /**
             * status : ok
             * comfort : [{"index":"3","desc":"热","datetime":"2019-05-13"},{"index":"3","desc":"热","datetime":"2019-05-14"},{"index":"3","desc":"热","datetime":"2019-05-15"},{"index":"0","desc":"闷热","datetime":"2019-05-16"},{"index":"0","desc":"闷热","datetime":"2019-05-17"}]
             * skycon_20h_32h : [{"date":"2019-05-13","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-05-14","value":"PARTLY_CLOUDY_NIGHT"},{"date":"2019-05-15","value":"CLOUDY"},{"date":"2019-05-16","value":"RAIN"},{"date":"2019-05-17","value":"RAIN"}]
             * temperature : [{"date":"2019-05-13","max":28.34,"avg":24.03,"min":21},{"date":"2019-05-14","max":30.5,"avg":25.97,"min":23},{"date":"2019-05-15","max":30,"avg":26.27,"min":24},{"date":"2019-05-16","max":31,"avg":26.78,"min":24.93},{"date":"2019-05-17","max":32,"avg":27.22,"min":25}]
             * dswrf : [{"date":"2019-05-13","max":865.5,"avg":376.6,"min":0},{"date":"2019-05-14","max":866.7,"avg":338.6,"min":0},{"date":"2019-05-15","max":829.4,"avg":318.2,"min":0},{"date":"2019-05-16","max":516.6,"avg":144.7,"min":0},{"date":"2019-05-17","max":420.6,"avg":138,"min":0}]
             * cloudrate : [{"date":"2019-05-13","max":0.47,"avg":0.07,"min":0},{"date":"2019-05-14","max":0.73,"avg":0.42,"min":0},{"date":"2019-05-15","max":1,"avg":0.61,"min":0.19},{"date":"2019-05-16","max":1,"avg":0.99,"min":0.96},{"date":"2019-05-17","max":1,"avg":1,"min":1}]
             * aqi : [{"date":"2019-05-13","max":53,"avg":42.67,"min":26},{"date":"2019-05-14","max":52,"avg":38.21,"min":24},{"date":"2019-05-15","max":36,"avg":24.92,"min":16},{"date":"2019-05-16","max":24,"avg":16.54,"min":13},{"date":"2019-05-17","max":21,"avg":14.96,"min":10}]
             * skycon : [{"date":"2019-05-13","value":"CLEAR_DAY"},{"date":"2019-05-14","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-15","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-16","value":"RAIN"},{"date":"2019-05-17","value":"RAIN"}]
             * visibility : [{"date":"2019-05-13","max":24.1,"avg":10.81,"min":9.18},{"date":"2019-05-14","max":16.49,"avg":10.57,"min":8.04},{"date":"2019-05-15","max":11.61,"avg":8.93,"min":7.29},{"date":"2019-05-16","max":11.83,"avg":8.58,"min":7.14},{"date":"2019-05-17","max":11.15,"avg":8.91,"min":7.64}]
             * humidity : [{"date":"2019-05-13","max":0.87,"avg":0.83,"min":0.73},{"date":"2019-05-14","max":0.9,"avg":0.84,"min":0.75},{"date":"2019-05-15","max":0.93,"avg":0.88,"min":0.81},{"date":"2019-05-16","max":0.94,"avg":0.89,"min":0.81},{"date":"2019-05-17","max":0.92,"avg":0.88,"min":0.82}]
             * astro : [{"date":"2019-05-13","sunset":{"time":"18:42"},"sunrise":{"time":"05:24"}},{"date":"2019-05-14","sunset":{"time":"18:42"},"sunrise":{"time":"05:24"}},{"date":"2019-05-15","sunset":{"time":"18:43"},"sunrise":{"time":"05:23"}},{"date":"2019-05-16","sunset":{"time":"18:43"},"sunrise":{"time":"05:23"}},{"date":"2019-05-17","sunset":{"time":"18:44"},"sunrise":{"time":"05:23"}}]
             * coldRisk : [{"index":"4","desc":"极易发","datetime":"2019-05-13"},{"index":"4","desc":"极易发","datetime":"2019-05-14"},{"index":"3","desc":"易发","datetime":"2019-05-15"},{"index":"3","desc":"易发","datetime":"2019-05-16"},{"index":"3","desc":"易发","datetime":"2019-05-17"}]
             * ultraviolet : [{"index":"4","desc":"强","datetime":"2019-05-13"},{"index":"3","desc":"中等","datetime":"2019-05-14"},{"index":"2","desc":"弱","datetime":"2019-05-15"},{"index":"1","desc":"最弱","datetime":"2019-05-16"},{"index":"1","desc":"最弱","datetime":"2019-05-17"}]
             * pres : [{"date":"2019-05-13","max":101088.6,"avg":100751.98,"min":100688.36},{"date":"2019-05-14","max":100905.93,"avg":100723.84,"min":100585.68},{"date":"2019-05-15","max":100905.68,"avg":100760.55,"min":100585.68},{"date":"2019-05-16","max":100688.6,"avg":100523.51,"min":100345.68},{"date":"2019-05-17","max":100449.21,"avg":100274.57,"min":100128.6}]
             * pm25 : [{"date":"2019-05-13","max":36,"avg":29.56,"min":16},{"date":"2019-05-14","max":37,"avg":26.79,"min":17},{"date":"2019-05-15","max":25,"avg":17.46,"min":11},{"date":"2019-05-16","max":17,"avg":11.5,"min":9},{"date":"2019-05-17","max":15,"avg":10.54,"min":7}]
             * dressing : [{"index":"3","desc":"热","datetime":"2019-05-13"},{"index":"3","desc":"热","datetime":"2019-05-14"},{"index":"2","desc":"很热","datetime":"2019-05-15"},{"index":"2","desc":"很热","datetime":"2019-05-16"},{"index":"2","desc":"很热","datetime":"2019-05-17"}]
             * carWashing : [{"index":"1","desc":"适宜","datetime":"2019-05-13"},{"index":"1","desc":"适宜","datetime":"2019-05-14"},{"index":"3","desc":"较不适宜","datetime":"2019-05-15"},{"index":"3","desc":"较不适宜","datetime":"2019-05-16"},{"index":"3","desc":"较不适宜","datetime":"2019-05-17"}]
             * precipitation : [{"date":"2019-05-13","max":0,"avg":0,"min":0},{"date":"2019-05-14","max":0,"avg":0,"min":0},{"date":"2019-05-15","max":0,"avg":0,"min":0},{"date":"2019-05-16","max":0.3551,"avg":0.1135,"min":0},{"date":"2019-05-17","max":0.6848,"avg":0.199,"min":0}]
             * wind : [{"date":"2019-05-13","max":{"direction":141,"speed":20.16},"avg":{"direction":150.07,"speed":9.27},"min":{"direction":287.12,"speed":1.39}},{"date":"2019-05-14","max":{"direction":173.26,"speed":23.66},"avg":{"direction":183.9,"speed":11.34},"min":{"direction":240.79,"speed":5.08}},{"date":"2019-05-15","max":{"direction":165.91,"speed":18.98},"avg":{"direction":147.85,"speed":12.03},"min":{"direction":121.82,"speed":6.01}},{"date":"2019-05-16","max":{"direction":182.53,"speed":16.87},"avg":{"direction":201.83,"speed":11.63},"min":{"direction":216.26,"speed":7.99}},{"date":"2019-05-17","max":{"direction":241.63,"speed":15.42},"avg":{"direction":221.55,"speed":12.4},"min":{"direction":228.87,"speed":9.39}}]
             * skycon_08h_20h : [{"date":"2019-05-13","value":"CLEAR_DAY"},{"date":"2019-05-14","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-15","value":"PARTLY_CLOUDY_DAY"},{"date":"2019-05-16","value":"RAIN"},{"date":"2019-05-17","value":"RAIN"}]
             */

            private String status;
            private List<ComfortBean> comfort;
            private List<Skycon20h32hBean> skycon_20h_32h;
            private List<TemperatureBean> temperature;
            private List<DswrfBean> dswrf;
            private List<CloudrateBean> cloudrate;
            private List<AqiBean> aqi;
            private List<SkyconBean> skycon;
            private List<VisibilityBean> visibility;
            private List<HumidityBean> humidity;
            private List<AstroBean> astro;
            private List<ColdRiskBean> coldRisk;
            private List<UltravioletBean> ultraviolet;
            private List<PresBean> pres;
            private List<Pm25Bean> pm25;
            private List<DressingBean> dressing;
            private List<CarWashingBean> carWashing;
            private List<PrecipitationBean> precipitation;
            private List<WindBean> wind;
            private List<Skycon08h20hBean> skycon_08h_20h;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<ComfortBean> getComfort() {
                return comfort;
            }

            public void setComfort(List<ComfortBean> comfort) {
                this.comfort = comfort;
            }

            public List<Skycon20h32hBean> getSkycon_20h_32h() {
                return skycon_20h_32h;
            }

            public void setSkycon_20h_32h(List<Skycon20h32hBean> skycon_20h_32h) {
                this.skycon_20h_32h = skycon_20h_32h;
            }

            public List<TemperatureBean> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBean> temperature) {
                this.temperature = temperature;
            }

            public List<DswrfBean> getDswrf() {
                return dswrf;
            }

            public void setDswrf(List<DswrfBean> dswrf) {
                this.dswrf = dswrf;
            }

            public List<CloudrateBean> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBean> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<AqiBean> getAqi() {
                return aqi;
            }

            public void setAqi(List<AqiBean> aqi) {
                this.aqi = aqi;
            }

            public List<SkyconBean> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBean> skycon) {
                this.skycon = skycon;
            }

            public List<VisibilityBean> getVisibility() {
                return visibility;
            }

            public void setVisibility(List<VisibilityBean> visibility) {
                this.visibility = visibility;
            }

            public List<HumidityBean> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBean> humidity) {
                this.humidity = humidity;
            }

            public List<AstroBean> getAstro() {
                return astro;
            }

            public void setAstro(List<AstroBean> astro) {
                this.astro = astro;
            }

            public List<ColdRiskBean> getColdRisk() {
                return coldRisk;
            }

            public void setColdRisk(List<ColdRiskBean> coldRisk) {
                this.coldRisk = coldRisk;
            }

            public List<UltravioletBean> getUltraviolet() {
                return ultraviolet;
            }

            public void setUltraviolet(List<UltravioletBean> ultraviolet) {
                this.ultraviolet = ultraviolet;
            }

            public List<PresBean> getPres() {
                return pres;
            }

            public void setPres(List<PresBean> pres) {
                this.pres = pres;
            }

            public List<Pm25Bean> getPm25() {
                return pm25;
            }

            public void setPm25(List<Pm25Bean> pm25) {
                this.pm25 = pm25;
            }

            public List<DressingBean> getDressing() {
                return dressing;
            }

            public void setDressing(List<DressingBean> dressing) {
                this.dressing = dressing;
            }

            public List<CarWashingBean> getCarWashing() {
                return carWashing;
            }

            public void setCarWashing(List<CarWashingBean> carWashing) {
                this.carWashing = carWashing;
            }

            public List<PrecipitationBean> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBean> precipitation) {
                this.precipitation = precipitation;
            }

            public List<WindBean> getWind() {
                return wind;
            }

            public void setWind(List<WindBean> wind) {
                this.wind = wind;
            }

            public List<Skycon08h20hBean> getSkycon_08h_20h() {
                return skycon_08h_20h;
            }

            public void setSkycon_08h_20h(List<Skycon08h20hBean> skycon_08h_20h) {
                this.skycon_08h_20h = skycon_08h_20h;
            }

            public static class ComfortBean {
                /**
                 * index : 3
                 * desc : 热
                 * datetime : 2019-05-13
                 */

                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class Skycon20h32hBean {
                /**
                 * date : 2019-05-13
                 * value : PARTLY_CLOUDY_NIGHT
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class TemperatureBean {
                /**
                 * date : 2019-05-13
                 * max : 28.34
                 * avg : 24.03
                 * min : 21
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class DswrfBean {
                /**
                 * date : 2019-05-13
                 * max : 865.5
                 * avg : 376.6
                 * min : 0
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class CloudrateBean {
                /**
                 * date : 2019-05-13
                 * max : 0.47
                 * avg : 0.07
                 * min : 0
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class AqiBean {
                /**
                 * date : 2019-05-13
                 * max : 53
                 * avg : 42.67
                 * min : 26
                 */

                private String date;
                private int max;
                private double avg;
                private int min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public int getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }
            }

            public static class SkyconBean {
                /**
                 * date : 2019-05-13
                 * value : CLEAR_DAY
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class VisibilityBean {
                /**
                 * date : 2019-05-13
                 * max : 24.1
                 * avg : 10.81
                 * min : 9.18
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class HumidityBean {
                /**
                 * date : 2019-05-13
                 * max : 0.87
                 * avg : 0.83
                 * min : 0.73
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class AstroBean {
                /**
                 * date : 2019-05-13
                 * sunset : {"time":"18:42"}
                 * sunrise : {"time":"05:24"}
                 */

                private String date;
                private SunsetBean sunset;
                private SunriseBean sunrise;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public SunsetBean getSunset() {
                    return sunset;
                }

                public void setSunset(SunsetBean sunset) {
                    this.sunset = sunset;
                }

                public SunriseBean getSunrise() {
                    return sunrise;
                }

                public void setSunrise(SunriseBean sunrise) {
                    this.sunrise = sunrise;
                }

                public static class SunsetBean {
                    /**
                     * time : 18:42
                     */

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }

                public static class SunriseBean {
                    /**
                     * time : 05:24
                     */

                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }
            }

            public static class ColdRiskBean {
                /**
                 * index : 4
                 * desc : 极易发
                 * datetime : 2019-05-13
                 */

                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class UltravioletBean {
                /**
                 * index : 4
                 * desc : 强
                 * datetime : 2019-05-13
                 */

                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class PresBean {
                /**
                 * date : 2019-05-13
                 * max : 101088.6
                 * avg : 100751.98
                 * min : 100688.36
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class Pm25Bean {
                /**
                 * date : 2019-05-13
                 * max : 36
                 * avg : 29.56
                 * min : 16
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class DressingBean {
                /**
                 * index : 3
                 * desc : 热
                 * datetime : 2019-05-13
                 */

                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class CarWashingBean {
                /**
                 * index : 1
                 * desc : 适宜
                 * datetime : 2019-05-13
                 */

                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class PrecipitationBean {
                /**
                 * date : 2019-05-13
                 * max : 0
                 * avg : 0
                 * min : 0
                 */

                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class WindBean {
                /**
                 * date : 2019-05-13
                 * max : {"direction":141,"speed":20.16}
                 * avg : {"direction":150.07,"speed":9.27}
                 * min : {"direction":287.12,"speed":1.39}
                 */

                private String date;
                private MaxBean max;
                private AvgBean avg;
                private MinBean min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public MaxBean getMax() {
                    return max;
                }

                public void setMax(MaxBean max) {
                    this.max = max;
                }

                public AvgBean getAvg() {
                    return avg;
                }

                public void setAvg(AvgBean avg) {
                    this.avg = avg;
                }

                public MinBean getMin() {
                    return min;
                }

                public void setMin(MinBean min) {
                    this.min = min;
                }

                public static class MaxBean {
                    /**
                     * direction : 141
                     * speed : 20.16
                     */

                    private double direction;
                    private double speed;

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }
                }

                public static class AvgBean {
                    /**
                     * direction : 150.07
                     * speed : 9.27
                     */

                    private double direction;
                    private double speed;

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }
                }

                public static class MinBean {
                    /**
                     * direction : 287.12
                     * speed : 1.39
                     */

                    private double direction;
                    private double speed;

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }
                }
            }

            public static class Skycon08h20hBean {
                /**
                 * date : 2019-05-13
                 * value : CLEAR_DAY
                 */

                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}
