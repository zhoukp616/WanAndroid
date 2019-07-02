package com.zkp.androidwan.bean;

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
     * status : ok
     * lang : zh_CN
     * unit : metric
     * server_time : 1557480498
     * location : [24.502836,118.178221]
     * api_status : active
     * tzshift : 28800
     * api_version : v2.2
     * result : {"status":"ok","o3":147,"co":0.3,"temperature":24.21,"pm10":51,"skycon":"PARTLY_CLOUDY_DAY","cloudrate":0.3,"precipitation":{"nearest":{"status":"ok","distance":10000,"intensity":0},"local":{"status":"ok","intensity":0,"datasource":"radar"}},"dswrf":614.4,"visibility":21.51,"humidity":0.66,"so2":5,"ultraviolet":{"index":2,"desc":"很弱"},"pres":100672.8,"aqi":51,"pm25":28,"no2":4,"apparent_temperature":19.5,"comfort":{"index":5,"desc":"舒适"},"wind":{"direction":118,"speed":16.56}}
     */

    private String status;
    private String lang;
    private String unit;
    private int server_time;
    private String api_status;
    private int tzshift;
    private String api_version;
    private ResultBean result;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * status : ok
         * o3 : 147
         * co : 0.3
         * temperature : 24.21
         * pm10 : 51
         * skycon : PARTLY_CLOUDY_DAY
         * cloudrate : 0.3
         * precipitation : {"nearest":{"status":"ok","distance":10000,"intensity":0},"local":{"status":"ok","intensity":0,"datasource":"radar"}}
         * dswrf : 614.4
         * visibility : 21.51
         * humidity : 0.66
         * so2 : 5
         * ultraviolet : {"index":2,"desc":"很弱"}
         * pres : 100672.8
         * aqi : 51
         * pm25 : 28
         * no2 : 4
         * apparent_temperature : 19.5
         * comfort : {"index":5,"desc":"舒适"}
         * wind : {"direction":118,"speed":16.56}
         */

        private String status;
        private int o3;
        private double co;
        private double temperature;
        private int pm10;
        private String skycon;
        private double cloudrate;
        private PrecipitationBean precipitation;
        private double dswrf;
        private double visibility;
        private double humidity;
        private int so2;
        private UltravioletBean ultraviolet;
        private double pres;
        private int aqi;
        private int pm25;
        private int no2;
        private double apparent_temperature;
        private ComfortBean comfort;
        private WindBean wind;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getO3() {
            return o3;
        }

        public void setO3(int o3) {
            this.o3 = o3;
        }

        public double getCo() {
            return co;
        }

        public void setCo(double co) {
            this.co = co;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public String getSkycon() {
            return skycon;
        }

        public void setSkycon(String skycon) {
            this.skycon = skycon;
        }

        public double getCloudrate() {
            return cloudrate;
        }

        public void setCloudrate(double cloudrate) {
            this.cloudrate = cloudrate;
        }

        public PrecipitationBean getPrecipitation() {
            return precipitation;
        }

        public void setPrecipitation(PrecipitationBean precipitation) {
            this.precipitation = precipitation;
        }

        public double getDswrf() {
            return dswrf;
        }

        public void setDswrf(double dswrf) {
            this.dswrf = dswrf;
        }

        public double getVisibility() {
            return visibility;
        }

        public void setVisibility(double visibility) {
            this.visibility = visibility;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public int getSo2() {
            return so2;
        }

        public void setSo2(int so2) {
            this.so2 = so2;
        }

        public UltravioletBean getUltraviolet() {
            return ultraviolet;
        }

        public void setUltraviolet(UltravioletBean ultraviolet) {
            this.ultraviolet = ultraviolet;
        }

        public double getPres() {
            return pres;
        }

        public void setPres(double pres) {
            this.pres = pres;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getNo2() {
            return no2;
        }

        public void setNo2(int no2) {
            this.no2 = no2;
        }

        public double getApparent_temperature() {
            return apparent_temperature;
        }

        public void setApparent_temperature(double apparent_temperature) {
            this.apparent_temperature = apparent_temperature;
        }

        public ComfortBean getComfort() {
            return comfort;
        }

        public void setComfort(ComfortBean comfort) {
            this.comfort = comfort;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public static class PrecipitationBean {
            /**
             * nearest : {"status":"ok","distance":10000,"intensity":0}
             * local : {"status":"ok","intensity":0,"datasource":"radar"}
             */

            private NearestBean nearest;
            private LocalBean local;

            public NearestBean getNearest() {
                return nearest;
            }

            public void setNearest(NearestBean nearest) {
                this.nearest = nearest;
            }

            public LocalBean getLocal() {
                return local;
            }

            public void setLocal(LocalBean local) {
                this.local = local;
            }

            public static class NearestBean {
                /**
                 * status : ok
                 * distance : 10000
                 * intensity : 0
                 */

                private String status;
                private double distance;
                private double intensity;

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

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
            }

            public static class LocalBean {
                /**
                 * status : ok
                 * intensity : 0
                 * datasource : radar
                 */

                private String status;
                private double intensity;
                private String datasource;

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public double getIntensity() {
                    return intensity;
                }

                public void setIntensity(double intensity) {
                    this.intensity = intensity;
                }

                public String getDatasource() {
                    return datasource;
                }

                public void setDatasource(String datasource) {
                    this.datasource = datasource;
                }
            }
        }

        public static class UltravioletBean {
            /**
             * index : 2
             * desc : 很弱
             */

            private int index;
            private String desc;

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }

        public static class ComfortBean {
            /**
             * index : 5
             * desc : 舒适
             */

            private int index;
            private String desc;

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }

        public static class WindBean {
            /**
             * direction : 118
             * speed : 16.56
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
