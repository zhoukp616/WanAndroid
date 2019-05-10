package com.zkp.gank.bean;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.bean
 * @time: 2019/5/10 15:57
 * @description:
 */
public class CurrentWetaherBean {


    /**
     * api_status : active
     * api_version : v2.2
     * lang : zh_CN
     * location : [25.1552,121.6544]
     * result : {"apparent_temperature":19.1,"aqi":40,"cloudrate":0.46,"co":0.4708,"comfort":{"desc":"温暖","index":4},"dswrf":590.9,"humidity":0.79,"no2":8.56,"o3":156.22,"pm10":40,"pm25":10,"precipitation":{"local":{"datasource":"radar","intensity":0,"status":"ok"},"nearest":{"distance":110.7,"intensity":0.1875,"status":"ok"}},"pres":99529.19,"skycon":"PARTLY_CLOUDY_DAY","so2":1.93,"status":"ok","temperature":24,"ultraviolet":{"desc":"弱","index":3},"visibility":21.7,"wind":{"direction":68.79,"speed":17.89}}
     * server_time : 1557474998
     * status : ok
     * tzshift : 28800
     * unit : metric
     */

    private String api_status;
    private String api_version;
    private String lang;
    private ResultBean result;
    private int server_time;
    private String status;
    private int tzshift;
    private String unit;
    private List<Double> location;

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
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

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
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
         * apparent_temperature : 19.1
         * aqi : 40
         * cloudrate : 0.46
         * co : 0.4708
         * comfort : {"desc":"温暖","index":4}
         * dswrf : 590.9
         * humidity : 0.79
         * no2 : 8.56
         * o3 : 156.22
         * pm10 : 40
         * pm25 : 10
         * precipitation : {"local":{"datasource":"radar","intensity":0,"status":"ok"},"nearest":{"distance":110.7,"intensity":0.1875,"status":"ok"}}
         * pres : 99529.19
         * skycon : PARTLY_CLOUDY_DAY
         * so2 : 1.93
         * status : ok
         * temperature : 24
         * ultraviolet : {"desc":"弱","index":3}
         * visibility : 21.7
         * wind : {"direction":68.79,"speed":17.89}
         */

        private double apparent_temperature;
        private int aqi;
        private double cloudrate;
        private double co;
        private ComfortBean comfort;
        private double dswrf;
        private double humidity;
        private double no2;
        private double o3;
        private int pm10;
        private int pm25;
        private PrecipitationBean precipitation;
        private double pres;
        private String skycon;
        private double so2;
        private String status;
        private int temperature;
        private UltravioletBean ultraviolet;
        private double visibility;
        private WindBean wind;

        public double getApparent_temperature() {
            return apparent_temperature;
        }

        public void setApparent_temperature(double apparent_temperature) {
            this.apparent_temperature = apparent_temperature;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public double getCloudrate() {
            return cloudrate;
        }

        public void setCloudrate(double cloudrate) {
            this.cloudrate = cloudrate;
        }

        public double getCo() {
            return co;
        }

        public void setCo(double co) {
            this.co = co;
        }

        public ComfortBean getComfort() {
            return comfort;
        }

        public void setComfort(ComfortBean comfort) {
            this.comfort = comfort;
        }

        public double getDswrf() {
            return dswrf;
        }

        public void setDswrf(double dswrf) {
            this.dswrf = dswrf;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public double getNo2() {
            return no2;
        }

        public void setNo2(double no2) {
            this.no2 = no2;
        }

        public double getO3() {
            return o3;
        }

        public void setO3(double o3) {
            this.o3 = o3;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public PrecipitationBean getPrecipitation() {
            return precipitation;
        }

        public void setPrecipitation(PrecipitationBean precipitation) {
            this.precipitation = precipitation;
        }

        public double getPres() {
            return pres;
        }

        public void setPres(double pres) {
            this.pres = pres;
        }

        public String getSkycon() {
            return skycon;
        }

        public void setSkycon(String skycon) {
            this.skycon = skycon;
        }

        public double getSo2() {
            return so2;
        }

        public void setSo2(double so2) {
            this.so2 = so2;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public UltravioletBean getUltraviolet() {
            return ultraviolet;
        }

        public void setUltraviolet(UltravioletBean ultraviolet) {
            this.ultraviolet = ultraviolet;
        }

        public double getVisibility() {
            return visibility;
        }

        public void setVisibility(double visibility) {
            this.visibility = visibility;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public static class ComfortBean {
            /**
             * desc : 温暖
             * index : 4
             */

            private String desc;
            private int index;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }
        }

        public static class PrecipitationBean {
            /**
             * local : {"datasource":"radar","intensity":0,"status":"ok"}
             * nearest : {"distance":110.7,"intensity":0.1875,"status":"ok"}
             */

            private LocalBean local;
            private NearestBean nearest;

            public LocalBean getLocal() {
                return local;
            }

            public void setLocal(LocalBean local) {
                this.local = local;
            }

            public NearestBean getNearest() {
                return nearest;
            }

            public void setNearest(NearestBean nearest) {
                this.nearest = nearest;
            }

            public static class LocalBean {
                /**
                 * datasource : radar
                 * intensity : 0
                 * status : ok
                 */

                private String datasource;
                private int intensity;
                private String status;

                public String getDatasource() {
                    return datasource;
                }

                public void setDatasource(String datasource) {
                    this.datasource = datasource;
                }

                public int getIntensity() {
                    return intensity;
                }

                public void setIntensity(int intensity) {
                    this.intensity = intensity;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }
            }

            public static class NearestBean {
                /**
                 * distance : 110.7
                 * intensity : 0.1875
                 * status : ok
                 */

                private double distance;
                private double intensity;
                private String status;

                public double getDistance() {
                    return distance;
                }

                public void setDistance(double distance) {
                    this.distance = distance;
                }

                public double getIntensity() {
                    return intensity;
                }

                public void setIntensity(double intensity) {
                    this.intensity = intensity;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }
            }
        }

        public static class UltravioletBean {
            /**
             * desc : 弱
             * index : 3
             */

            private String desc;
            private int index;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }
        }

        public static class WindBean {
            /**
             * direction : 68.79
             * speed : 17.89
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
}
