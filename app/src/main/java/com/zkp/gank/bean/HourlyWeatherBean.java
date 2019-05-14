package com.zkp.gank.bean;

import java.util.List;

/**
 * @author: zkp
 * @project: Gank
 * @package: com.zkp.gank.bean
 * @time: 2019/5/10 14:37
 * @description: 小时级天气预报
 */
public class HourlyWeatherBean {

    /**
     * api_status : active
     * api_version : v2.2
     * lang : zh_CN
     * location : [25.1552,121.6544]
     * result : {"forecast_keypoint":"多云，明天上午9点钟后转阴，其后多云","hourly":{"aqi":[{"datetime":"2019-05-10 14:00","value":41},{"datetime":"2019-05-10 15:00","value":16},{"datetime":"2019-05-10 16:00","value":14},{"datetime":"2019-05-10 17:00","value":14},{"datetime":"2019-05-10 18:00","value":14},{"datetime":"2019-05-10 19:00","value":14},{"datetime":"2019-05-10 20:00","value":14},{"datetime":"2019-05-10 21:00","value":16},{"datetime":"2019-05-10 22:00","value":16},{"datetime":"2019-05-10 23:00","value":16},{"datetime":"2019-05-11 00:00","value":16},{"datetime":"2019-05-11 01:00","value":14},{"datetime":"2019-05-11 02:00","value":14},{"datetime":"2019-05-11 03:00","value":16},{"datetime":"2019-05-11 04:00","value":16},{"datetime":"2019-05-11 05:00","value":17},{"datetime":"2019-05-11 06:00","value":17},{"datetime":"2019-05-11 07:00","value":17},{"datetime":"2019-05-11 08:00","value":17},{"datetime":"2019-05-11 09:00","value":16},{"datetime":"2019-05-11 10:00","value":14},{"datetime":"2019-05-11 11:00","value":13},{"datetime":"2019-05-11 12:00","value":11},{"datetime":"2019-05-11 13:00","value":11},{"datetime":"2019-05-11 14:00","value":10},{"datetime":"2019-05-11 15:00","value":11},{"datetime":"2019-05-11 16:00","value":11},{"datetime":"2019-05-11 17:00","value":11},{"datetime":"2019-05-11 18:00","value":11},{"datetime":"2019-05-11 19:00","value":13},{"datetime":"2019-05-11 20:00","value":13},{"datetime":"2019-05-11 21:00","value":13},{"datetime":"2019-05-11 22:00","value":14},{"datetime":"2019-05-11 23:00","value":14},{"datetime":"2019-05-12 00:00","value":16},{"datetime":"2019-05-12 01:00","value":16},{"datetime":"2019-05-12 02:00","value":16},{"datetime":"2019-05-12 03:00","value":17},{"datetime":"2019-05-12 04:00","value":19},{"datetime":"2019-05-12 05:00","value":19},{"datetime":"2019-05-12 06:00","value":20},{"datetime":"2019-05-12 07:00","value":20},{"datetime":"2019-05-12 08:00","value":20},{"datetime":"2019-05-12 09:00","value":20},{"datetime":"2019-05-12 10:00","value":19},{"datetime":"2019-05-12 11:00","value":17},{"datetime":"2019-05-12 12:00","value":16},{"datetime":"2019-05-12 13:00","value":14}],"cloudrate":[{"datetime":"2019-05-10 14:00","value":0.79},{"datetime":"2019-05-10 15:00","value":0.46},{"datetime":"2019-05-10 16:00","value":0.42},{"datetime":"2019-05-10 17:00","value":0.4},{"datetime":"2019-05-10 18:00","value":0.38},{"datetime":"2019-05-10 19:00","value":0.37},{"datetime":"2019-05-10 20:00","value":0.38},{"datetime":"2019-05-10 21:00","value":0.46},{"datetime":"2019-05-10 22:00","value":0.49},{"datetime":"2019-05-10 23:00","value":0.51},{"datetime":"2019-05-11 00:00","value":0.49},{"datetime":"2019-05-11 01:00","value":0.48},{"datetime":"2019-05-11 02:00","value":0.48},{"datetime":"2019-05-11 03:00","value":0.61},{"datetime":"2019-05-11 04:00","value":0.69},{"datetime":"2019-05-11 05:00","value":0.73},{"datetime":"2019-05-11 06:00","value":0.74},{"datetime":"2019-05-11 07:00","value":0.75},{"datetime":"2019-05-11 08:00","value":0.76},{"datetime":"2019-05-11 09:00","value":0.85},{"datetime":"2019-05-11 10:00","value":0.83},{"datetime":"2019-05-11 11:00","value":0.81},{"datetime":"2019-05-11 12:00","value":0.78},{"datetime":"2019-05-11 13:00","value":0.8},{"datetime":"2019-05-11 14:00","value":0.74},{"datetime":"2019-05-11 15:00","value":0.87},{"datetime":"2019-05-11 16:00","value":0.75},{"datetime":"2019-05-11 17:00","value":0.7},{"datetime":"2019-05-11 18:00","value":0.63},{"datetime":"2019-05-11 19:00","value":0.58},{"datetime":"2019-05-11 20:00","value":0.54},{"datetime":"2019-05-11 21:00","value":0.32},{"datetime":"2019-05-11 22:00","value":0.38},{"datetime":"2019-05-11 23:00","value":0.38},{"datetime":"2019-05-12 00:00","value":0.35},{"datetime":"2019-05-12 01:00","value":0.36},{"datetime":"2019-05-12 02:00","value":0.36},{"datetime":"2019-05-12 03:00","value":0.24},{"datetime":"2019-05-12 04:00","value":0.27},{"datetime":"2019-05-12 05:00","value":0.27},{"datetime":"2019-05-12 06:00","value":0.25},{"datetime":"2019-05-12 07:00","value":0.25},{"datetime":"2019-05-12 08:00","value":0.25},{"datetime":"2019-05-12 09:00","value":0.25},{"datetime":"2019-05-12 10:00","value":0.26},{"datetime":"2019-05-12 11:00","value":0.26},{"datetime":"2019-05-12 12:00","value":0.25},{"datetime":"2019-05-12 13:00","value":0.25}],"description":"多云，明天上午9点钟后转阴，其后多云","dswrf":[{"datetime":"2019-05-10 14:00","value":498.37621504},{"datetime":"2019-05-10 15:00","value":590.850432},{"datetime":"2019-05-10 16:00","value":527.2860672},{"datetime":"2019-05-10 17:00","value":442.7457024},{"datetime":"2019-05-10 18:00","value":362.0073984},{"datetime":"2019-05-10 19:00","value":288.9591552},{"datetime":"2019-05-10 20:00","value":242.19493632},{"datetime":"2019-05-10 21:00","value":0},{"datetime":"2019-05-10 22:00","value":0},{"datetime":"2019-05-10 23:00","value":0},{"datetime":"2019-05-11 00:00","value":0},{"datetime":"2019-05-11 01:00","value":0},{"datetime":"2019-05-11 02:00","value":0},{"datetime":"2019-05-11 03:00","value":0},{"datetime":"2019-05-11 04:00","value":0},{"datetime":"2019-05-11 05:00","value":0},{"datetime":"2019-05-11 06:00","value":1.4500608},{"datetime":"2019-05-11 07:00","value":26.14757632},{"datetime":"2019-05-11 08:00","value":57.3725952},{"datetime":"2019-05-11 09:00","value":270.7804928},{"datetime":"2019-05-11 10:00","value":337.0543104},{"datetime":"2019-05-11 11:00","value":416.6661888},{"datetime":"2019-05-11 12:00","value":464.8783104},{"datetime":"2019-05-11 13:00","value":470.15415296},{"datetime":"2019-05-11 14:00","value":468.2463104},{"datetime":"2019-05-11 15:00","value":280.2579456},{"datetime":"2019-05-11 16:00","value":292.0873984},{"datetime":"2019-05-11 17:00","value":266.2130944},{"datetime":"2019-05-11 18:00","value":223.2169728},{"datetime":"2019-05-11 19:00","value":178.7607296},{"datetime":"2019-05-11 20:00","value":149.6592384},{"datetime":"2019-05-11 21:00","value":0},{"datetime":"2019-05-11 22:00","value":0},{"datetime":"2019-05-11 23:00","value":0},{"datetime":"2019-05-12 00:00","value":0},{"datetime":"2019-05-12 01:00","value":0},{"datetime":"2019-05-12 02:00","value":0},{"datetime":"2019-05-12 03:00","value":0},{"datetime":"2019-05-12 04:00","value":0},{"datetime":"2019-05-12 05:00","value":0},{"datetime":"2019-05-12 06:00","value":7.6580608},{"datetime":"2019-05-12 07:00","value":45.3161216},{"datetime":"2019-05-12 08:00","value":106.00924928},{"datetime":"2019-05-12 09:00","value":607.8130944},{"datetime":"2019-05-12 10:00","value":687.8450944},{"datetime":"2019-05-12 11:00","value":749.3271552},{"datetime":"2019-05-12 12:00","value":796.985216},{"datetime":"2019-05-12 13:00","value":820.728768}],"humidity":[{"datetime":"2019-05-10 14:00","value":0.79},{"datetime":"2019-05-10 15:00","value":0.79},{"datetime":"2019-05-10 16:00","value":0.8},{"datetime":"2019-05-10 17:00","value":0.81},{"datetime":"2019-05-10 18:00","value":0.83},{"datetime":"2019-05-10 19:00","value":0.84},{"datetime":"2019-05-10 20:00","value":0.85},{"datetime":"2019-05-10 21:00","value":0.85},{"datetime":"2019-05-10 22:00","value":0.86},{"datetime":"2019-05-10 23:00","value":0.87},{"datetime":"2019-05-11 00:00","value":0.87},{"datetime":"2019-05-11 01:00","value":0.88},{"datetime":"2019-05-11 02:00","value":0.89},{"datetime":"2019-05-11 03:00","value":0.9},{"datetime":"2019-05-11 04:00","value":0.89},{"datetime":"2019-05-11 05:00","value":0.9},{"datetime":"2019-05-11 06:00","value":0.9},{"datetime":"2019-05-11 07:00","value":0.88},{"datetime":"2019-05-11 08:00","value":0.86},{"datetime":"2019-05-11 09:00","value":0.85},{"datetime":"2019-05-11 10:00","value":0.82},{"datetime":"2019-05-11 11:00","value":0.81},{"datetime":"2019-05-11 12:00","value":0.81},{"datetime":"2019-05-11 13:00","value":0.82},{"datetime":"2019-05-11 14:00","value":0.83},{"datetime":"2019-05-11 15:00","value":0.82},{"datetime":"2019-05-11 16:00","value":0.81},{"datetime":"2019-05-11 17:00","value":0.82},{"datetime":"2019-05-11 18:00","value":0.84},{"datetime":"2019-05-11 19:00","value":0.85},{"datetime":"2019-05-11 20:00","value":0.85},{"datetime":"2019-05-11 21:00","value":0.86},{"datetime":"2019-05-11 22:00","value":0.87},{"datetime":"2019-05-11 23:00","value":0.88},{"datetime":"2019-05-12 00:00","value":0.89},{"datetime":"2019-05-12 01:00","value":0.91},{"datetime":"2019-05-12 02:00","value":0.91},{"datetime":"2019-05-12 03:00","value":0.92},{"datetime":"2019-05-12 04:00","value":0.93},{"datetime":"2019-05-12 05:00","value":0.93},{"datetime":"2019-05-12 06:00","value":0.93},{"datetime":"2019-05-12 07:00","value":0.89},{"datetime":"2019-05-12 08:00","value":0.85},{"datetime":"2019-05-12 09:00","value":0.81},{"datetime":"2019-05-12 10:00","value":0.78},{"datetime":"2019-05-12 11:00","value":0.77},{"datetime":"2019-05-12 12:00","value":0.75},{"datetime":"2019-05-12 13:00","value":0.76}],"pm25":[{"datetime":"2019-05-10 14:00","value":11},{"datetime":"2019-05-10 15:00","value":11},{"datetime":"2019-05-10 16:00","value":10},{"datetime":"2019-05-10 17:00","value":10},{"datetime":"2019-05-10 18:00","value":10},{"datetime":"2019-05-10 19:00","value":10},{"datetime":"2019-05-10 20:00","value":10},{"datetime":"2019-05-10 21:00","value":11},{"datetime":"2019-05-10 22:00","value":11},{"datetime":"2019-05-10 23:00","value":11},{"datetime":"2019-05-11 00:00","value":11},{"datetime":"2019-05-11 01:00","value":10},{"datetime":"2019-05-11 02:00","value":10},{"datetime":"2019-05-11 03:00","value":11},{"datetime":"2019-05-11 04:00","value":11},{"datetime":"2019-05-11 05:00","value":12},{"datetime":"2019-05-11 06:00","value":12},{"datetime":"2019-05-11 07:00","value":12},{"datetime":"2019-05-11 08:00","value":12},{"datetime":"2019-05-11 09:00","value":11},{"datetime":"2019-05-11 10:00","value":10},{"datetime":"2019-05-11 11:00","value":9},{"datetime":"2019-05-11 12:00","value":8},{"datetime":"2019-05-11 13:00","value":8},{"datetime":"2019-05-11 14:00","value":7},{"datetime":"2019-05-11 15:00","value":8},{"datetime":"2019-05-11 16:00","value":8},{"datetime":"2019-05-11 17:00","value":8},{"datetime":"2019-05-11 18:00","value":8},{"datetime":"2019-05-11 19:00","value":9},{"datetime":"2019-05-11 20:00","value":9},{"datetime":"2019-05-11 21:00","value":9},{"datetime":"2019-05-11 22:00","value":10},{"datetime":"2019-05-11 23:00","value":10},{"datetime":"2019-05-12 00:00","value":11},{"datetime":"2019-05-12 01:00","value":11},{"datetime":"2019-05-12 02:00","value":11},{"datetime":"2019-05-12 03:00","value":12},{"datetime":"2019-05-12 04:00","value":13},{"datetime":"2019-05-12 05:00","value":13},{"datetime":"2019-05-12 06:00","value":14},{"datetime":"2019-05-12 07:00","value":14},{"datetime":"2019-05-12 08:00","value":14},{"datetime":"2019-05-12 09:00","value":14},{"datetime":"2019-05-12 10:00","value":13},{"datetime":"2019-05-12 11:00","value":12},{"datetime":"2019-05-12 12:00","value":11},{"datetime":"2019-05-12 13:00","value":10}],"precipitation":[{"datetime":"2019-05-10 14:00","value":0},{"datetime":"2019-05-10 15:00","value":0},{"datetime":"2019-05-10 16:00","value":0},{"datetime":"2019-05-10 17:00","value":0},{"datetime":"2019-05-10 18:00","value":0},{"datetime":"2019-05-10 19:00","value":0},{"datetime":"2019-05-10 20:00","value":0},{"datetime":"2019-05-10 21:00","value":0},{"datetime":"2019-05-10 22:00","value":0},{"datetime":"2019-05-10 23:00","value":0},{"datetime":"2019-05-11 00:00","value":0},{"datetime":"2019-05-11 01:00","value":0},{"datetime":"2019-05-11 02:00","value":0},{"datetime":"2019-05-11 03:00","value":0},{"datetime":"2019-05-11 04:00","value":0},{"datetime":"2019-05-11 05:00","value":0},{"datetime":"2019-05-11 06:00","value":0},{"datetime":"2019-05-11 07:00","value":0},{"datetime":"2019-05-11 08:00","value":0},{"datetime":"2019-05-11 09:00","value":0.056},{"datetime":"2019-05-11 10:00","value":0},{"datetime":"2019-05-11 11:00","value":0},{"datetime":"2019-05-11 12:00","value":0},{"datetime":"2019-05-11 13:00","value":0.0423},{"datetime":"2019-05-11 14:00","value":0},{"datetime":"2019-05-11 15:00","value":0},{"datetime":"2019-05-11 16:00","value":0},{"datetime":"2019-05-11 17:00","value":0},{"datetime":"2019-05-11 18:00","value":0},{"datetime":"2019-05-11 19:00","value":0},{"datetime":"2019-05-11 20:00","value":0},{"datetime":"2019-05-11 21:00","value":0},{"datetime":"2019-05-11 22:00","value":0},{"datetime":"2019-05-11 23:00","value":0},{"datetime":"2019-05-12 00:00","value":0},{"datetime":"2019-05-12 01:00","value":0},{"datetime":"2019-05-12 02:00","value":0},{"datetime":"2019-05-12 03:00","value":0},{"datetime":"2019-05-12 04:00","value":0},{"datetime":"2019-05-12 05:00","value":0},{"datetime":"2019-05-12 06:00","value":0},{"datetime":"2019-05-12 07:00","value":0},{"datetime":"2019-05-12 08:00","value":0},{"datetime":"2019-05-12 09:00","value":0},{"datetime":"2019-05-12 10:00","value":0},{"datetime":"2019-05-12 11:00","value":0},{"datetime":"2019-05-12 12:00","value":0},{"datetime":"2019-05-12 13:00","value":0}],"pres":[{"datetime":"2019-05-10 14:00","value":99559.8643200001},{"datetime":"2019-05-10 15:00","value":99529.1918336001},{"datetime":"2019-05-10 16:00","value":99529.1918336001},{"datetime":"2019-05-10 17:00","value":99529.1918336001},{"datetime":"2019-05-10 18:00","value":99547.9273472001},{"datetime":"2019-05-10 19:00","value":99609.1918336001},{"datetime":"2019-05-10 20:00","value":99609.1918336001},{"datetime":"2019-05-10 21:00","value":99670.2003200001},{"datetime":"2019-05-10 22:00","value":99689.1918336001},{"datetime":"2019-05-10 23:00","value":99689.1918336001},{"datetime":"2019-05-11 00:00","value":99689.1918336001},{"datetime":"2019-05-11 01:00","value":99689.1918336001},{"datetime":"2019-05-11 02:00","value":99609.1918336001},{"datetime":"2019-05-11 03:00","value":99609.1918336001},{"datetime":"2019-05-11 04:00","value":99609.1918336001},{"datetime":"2019-05-11 05:00","value":99620.7923200001},{"datetime":"2019-05-11 06:00","value":99689.1918336001},{"datetime":"2019-05-11 07:00","value":99700.7923200001},{"datetime":"2019-05-11 08:00","value":99769.1918336001},{"datetime":"2019-05-11 09:00","value":99769.1918336001},{"datetime":"2019-05-11 10:00","value":99769.1918336001},{"datetime":"2019-05-11 11:00","value":99769.1918336001},{"datetime":"2019-05-11 12:00","value":99769.1918336001},{"datetime":"2019-05-11 13:00","value":99769.1918336001},{"datetime":"2019-05-11 14:00","value":99689.1918336001},{"datetime":"2019-05-11 15:00","value":99689.1918336001},{"datetime":"2019-05-11 16:00","value":99658.5998336001},{"datetime":"2019-05-11 17:00","value":99658.5998336001},{"datetime":"2019-05-11 18:00","value":99658.5998336001},{"datetime":"2019-05-11 19:00","value":99689.1918336001},{"datetime":"2019-05-11 20:00","value":99707.9273472001},{"datetime":"2019-05-11 21:00","value":99787.9273472},{"datetime":"2019-05-11 22:00","value":99830.2003200001},{"datetime":"2019-05-11 23:00","value":99818.5998336001},{"datetime":"2019-05-12 00:00","value":99769.1918336001},{"datetime":"2019-05-12 01:00","value":99707.9273472001},{"datetime":"2019-05-12 02:00","value":99670.2003200001},{"datetime":"2019-05-12 03:00","value":99609.1918336001},{"datetime":"2019-05-12 04:00","value":99609.1918336001},{"datetime":"2019-05-12 05:00","value":99609.1918336001},{"datetime":"2019-05-12 06:00","value":99689.1918336001},{"datetime":"2019-05-12 07:00","value":99750.2003200001},{"datetime":"2019-05-12 08:00","value":99769.1918336001},{"datetime":"2019-05-12 09:00","value":99787.9273472},{"datetime":"2019-05-12 10:00","value":99769.1918336001},{"datetime":"2019-05-12 11:00","value":99769.1918336001},{"datetime":"2019-05-12 12:00","value":99707.9273472},{"datetime":"2019-05-12 13:00","value":99658.5998336001}],"skycon":[{"datetime":"2018-11-20 10:00","value":"PARTLY_CLOUDY_DAY"},{"datetime":"2018-11-20 11:00","value":"PARTLY_CLOUDY_DAY"}],"status":"ok","temperature":[{"datetime":"2019-05-10 14:00","value":24},{"datetime":"2019-05-10 15:00","value":24},{"datetime":"2019-05-10 16:00","value":24},{"datetime":"2019-05-10 17:00","value":24},{"datetime":"2019-05-10 18:00","value":24},{"datetime":"2019-05-10 19:00","value":23},{"datetime":"2019-05-10 20:00","value":23},{"datetime":"2019-05-10 21:00","value":23},{"datetime":"2019-05-10 22:00","value":23},{"datetime":"2019-05-10 23:00","value":23},{"datetime":"2019-05-11 00:00","value":23},{"datetime":"2019-05-11 01:00","value":23},{"datetime":"2019-05-11 02:00","value":23},{"datetime":"2019-05-11 03:00","value":23},{"datetime":"2019-05-11 04:00","value":22},{"datetime":"2019-05-11 05:00","value":22},{"datetime":"2019-05-11 06:00","value":22},{"datetime":"2019-05-11 07:00","value":23},{"datetime":"2019-05-11 08:00","value":23},{"datetime":"2019-05-11 09:00","value":23},{"datetime":"2019-05-11 10:00","value":24},{"datetime":"2019-05-11 11:00","value":24},{"datetime":"2019-05-11 12:00","value":25},{"datetime":"2019-05-11 13:00","value":25},{"datetime":"2019-05-11 14:00","value":23.29},{"datetime":"2019-05-11 15:00","value":23.24},{"datetime":"2019-05-11 16:00","value":23.39},{"datetime":"2019-05-11 17:00","value":23.16},{"datetime":"2019-05-11 18:00","value":22.94},{"datetime":"2019-05-11 19:00","value":22.65},{"datetime":"2019-05-11 20:00","value":22.65},{"datetime":"2019-05-11 21:00","value":22.65},{"datetime":"2019-05-11 22:00","value":22.71},{"datetime":"2019-05-11 23:00","value":22.71},{"datetime":"2019-05-12 00:00","value":22.65},{"datetime":"2019-05-12 01:00","value":22.43},{"datetime":"2019-05-12 02:00","value":22.33},{"datetime":"2019-05-12 03:00","value":22.16},{"datetime":"2019-05-12 04:00","value":22},{"datetime":"2019-05-12 05:00","value":22.12},{"datetime":"2019-05-12 06:00","value":22.55},{"datetime":"2019-05-12 07:00","value":23.33},{"datetime":"2019-05-12 08:00","value":24.24},{"datetime":"2019-05-12 09:00","value":25.04},{"datetime":"2019-05-12 10:00","value":25.6},{"datetime":"2019-05-12 11:00","value":25.85},{"datetime":"2019-05-12 12:00","value":26.1},{"datetime":"2019-05-12 13:00","value":26}],"visibility":[{"datetime":"2019-05-10 14:00","value":19.31},{"datetime":"2019-05-10 15:00","value":19.16},{"datetime":"2019-05-10 16:00","value":18.42},{"datetime":"2019-05-10 17:00","value":17.41},{"datetime":"2019-05-10 18:00","value":15.78},{"datetime":"2019-05-10 19:00","value":15.03},{"datetime":"2019-05-10 20:00","value":14.57},{"datetime":"2019-05-10 21:00","value":14.22},{"datetime":"2019-05-10 22:00","value":14.14},{"datetime":"2019-05-10 23:00","value":13.6},{"datetime":"2019-05-11 00:00","value":13.22},{"datetime":"2019-05-11 01:00","value":13.04},{"datetime":"2019-05-11 02:00","value":12.59},{"datetime":"2019-05-11 03:00","value":12.26},{"datetime":"2019-05-11 04:00","value":12.36},{"datetime":"2019-05-11 05:00","value":12.26},{"datetime":"2019-05-11 06:00","value":12.16},{"datetime":"2019-05-11 07:00","value":13.07},{"datetime":"2019-05-11 08:00","value":13.78},{"datetime":"2019-05-11 09:00","value":14.72},{"datetime":"2019-05-11 10:00","value":16.23},{"datetime":"2019-05-11 11:00","value":17.45},{"datetime":"2019-05-11 12:00","value":17.21},{"datetime":"2019-05-11 13:00","value":16.79},{"datetime":"2019-05-11 14:00","value":15.82},{"datetime":"2019-05-11 15:00","value":16.83},{"datetime":"2019-05-11 16:00","value":17.33},{"datetime":"2019-05-11 17:00","value":16.32},{"datetime":"2019-05-11 18:00","value":15.37},{"datetime":"2019-05-11 19:00","value":14.3},{"datetime":"2019-05-11 20:00","value":14.21},{"datetime":"2019-05-11 21:00","value":13.68},{"datetime":"2019-05-11 22:00","value":13.36},{"datetime":"2019-05-11 23:00","value":12.82},{"datetime":"2019-05-12 00:00","value":12.38},{"datetime":"2019-05-12 01:00","value":11.82},{"datetime":"2019-05-12 02:00","value":11.53},{"datetime":"2019-05-12 03:00","value":11.18},{"datetime":"2019-05-12 04:00","value":10.97},{"datetime":"2019-05-12 05:00","value":11.01},{"datetime":"2019-05-12 06:00","value":11.06},{"datetime":"2019-05-12 07:00","value":12.46},{"datetime":"2019-05-12 08:00","value":14.7},{"datetime":"2019-05-12 09:00","value":17.55},{"datetime":"2019-05-12 10:00","value":19.73},{"datetime":"2019-05-12 11:00","value":21.64},{"datetime":"2019-05-12 12:00","value":23.37},{"datetime":"2019-05-12 13:00","value":23.02}],"wind":[{"datetime":"2019-05-10 14:00","direction":64.37,"speed":17.66},{"datetime":"2019-05-10 15:00","direction":68.79,"speed":17.89},{"datetime":"2019-05-10 16:00","direction":75.03,"speed":17.47},{"datetime":"2019-05-10 17:00","direction":76.21,"speed":17.61},{"datetime":"2019-05-10 18:00","direction":77.43,"speed":17.45},{"datetime":"2019-05-10 19:00","direction":79.99,"speed":16.99},{"datetime":"2019-05-10 20:00","direction":80.31,"speed":17.11},{"datetime":"2019-05-10 21:00","direction":82.22,"speed":17.21},{"datetime":"2019-05-10 22:00","direction":84.29,"speed":17.08},{"datetime":"2019-05-10 23:00","direction":86.48,"speed":16.36},{"datetime":"2019-05-11 00:00","direction":88.44,"speed":15.2},{"datetime":"2019-05-11 01:00","direction":88.24,"speed":14.47},{"datetime":"2019-05-11 02:00","direction":86.95,"speed":13.86},{"datetime":"2019-05-11 03:00","direction":84.99,"speed":13.16},{"datetime":"2019-05-11 04:00","direction":83.39,"speed":12.34},{"datetime":"2019-05-11 05:00","direction":80.62,"speed":11.73},{"datetime":"2019-05-11 06:00","direction":73.9,"speed":11.96},{"datetime":"2019-05-11 07:00","direction":69.24,"speed":13.24},{"datetime":"2019-05-11 08:00","direction":67.83,"speed":14.66},{"datetime":"2019-05-11 09:00","direction":67.24,"speed":16.2},{"datetime":"2019-05-11 10:00","direction":65.48,"speed":17.88},{"datetime":"2019-05-11 11:00","direction":63.77,"speed":19.77},{"datetime":"2019-05-11 12:00","direction":63.89,"speed":20.48},{"datetime":"2019-05-11 13:00","direction":66.44,"speed":19.66},{"datetime":"2019-05-11 14:00","direction":72.46,"speed":19.5},{"datetime":"2019-05-11 15:00","direction":74.21,"speed":18.8},{"datetime":"2019-05-11 16:00","direction":80.35,"speed":19.02},{"datetime":"2019-05-11 17:00","direction":86.03,"speed":18.99},{"datetime":"2019-05-11 18:00","direction":91.08,"speed":18.62},{"datetime":"2019-05-11 19:00","direction":97.26,"speed":17.98},{"datetime":"2019-05-11 20:00","direction":100.39,"speed":17.31},{"datetime":"2019-05-11 21:00","direction":103.73,"speed":15.77},{"datetime":"2019-05-11 22:00","direction":107.29,"speed":15.57},{"datetime":"2019-05-11 23:00","direction":108.5,"speed":15.88},{"datetime":"2019-05-12 00:00","direction":111.94,"speed":14.75},{"datetime":"2019-05-12 01:00","direction":111.57,"speed":13.68},{"datetime":"2019-05-12 02:00","direction":108.88,"speed":13.47},{"datetime":"2019-05-12 03:00","direction":109.49,"speed":12.83},{"datetime":"2019-05-12 04:00","direction":110.13,"speed":12.17},{"datetime":"2019-05-12 05:00","direction":109.98,"speed":11.61},{"datetime":"2019-05-12 06:00","direction":107.55,"speed":11.52},{"datetime":"2019-05-12 07:00","direction":103.8,"speed":12.46},{"datetime":"2019-05-12 08:00","direction":102.08,"speed":13.88},{"datetime":"2019-05-12 09:00","direction":101.95,"speed":15.53},{"datetime":"2019-05-12 10:00","direction":101.86,"speed":17.34},{"datetime":"2019-05-12 11:00","direction":102.22,"speed":19.11},{"datetime":"2019-05-12 12:00","direction":103.64,"speed":20.66},{"datetime":"2019-05-12 13:00","direction":107.08,"speed":22.03}]},"primary":0}
     * server_time : 1557469934
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
         * forecast_keypoint : 多云，明天上午9点钟后转阴，其后多云
         * hourly : {"aqi":[{"datetime":"2019-05-10 14:00","value":41},{"datetime":"2019-05-10 15:00","value":16},{"datetime":"2019-05-10 16:00","value":14},{"datetime":"2019-05-10 17:00","value":14},{"datetime":"2019-05-10 18:00","value":14},{"datetime":"2019-05-10 19:00","value":14},{"datetime":"2019-05-10 20:00","value":14},{"datetime":"2019-05-10 21:00","value":16},{"datetime":"2019-05-10 22:00","value":16},{"datetime":"2019-05-10 23:00","value":16},{"datetime":"2019-05-11 00:00","value":16},{"datetime":"2019-05-11 01:00","value":14},{"datetime":"2019-05-11 02:00","value":14},{"datetime":"2019-05-11 03:00","value":16},{"datetime":"2019-05-11 04:00","value":16},{"datetime":"2019-05-11 05:00","value":17},{"datetime":"2019-05-11 06:00","value":17},{"datetime":"2019-05-11 07:00","value":17},{"datetime":"2019-05-11 08:00","value":17},{"datetime":"2019-05-11 09:00","value":16},{"datetime":"2019-05-11 10:00","value":14},{"datetime":"2019-05-11 11:00","value":13},{"datetime":"2019-05-11 12:00","value":11},{"datetime":"2019-05-11 13:00","value":11},{"datetime":"2019-05-11 14:00","value":10},{"datetime":"2019-05-11 15:00","value":11},{"datetime":"2019-05-11 16:00","value":11},{"datetime":"2019-05-11 17:00","value":11},{"datetime":"2019-05-11 18:00","value":11},{"datetime":"2019-05-11 19:00","value":13},{"datetime":"2019-05-11 20:00","value":13},{"datetime":"2019-05-11 21:00","value":13},{"datetime":"2019-05-11 22:00","value":14},{"datetime":"2019-05-11 23:00","value":14},{"datetime":"2019-05-12 00:00","value":16},{"datetime":"2019-05-12 01:00","value":16},{"datetime":"2019-05-12 02:00","value":16},{"datetime":"2019-05-12 03:00","value":17},{"datetime":"2019-05-12 04:00","value":19},{"datetime":"2019-05-12 05:00","value":19},{"datetime":"2019-05-12 06:00","value":20},{"datetime":"2019-05-12 07:00","value":20},{"datetime":"2019-05-12 08:00","value":20},{"datetime":"2019-05-12 09:00","value":20},{"datetime":"2019-05-12 10:00","value":19},{"datetime":"2019-05-12 11:00","value":17},{"datetime":"2019-05-12 12:00","value":16},{"datetime":"2019-05-12 13:00","value":14}],"cloudrate":[{"datetime":"2019-05-10 14:00","value":0.79},{"datetime":"2019-05-10 15:00","value":0.46},{"datetime":"2019-05-10 16:00","value":0.42},{"datetime":"2019-05-10 17:00","value":0.4},{"datetime":"2019-05-10 18:00","value":0.38},{"datetime":"2019-05-10 19:00","value":0.37},{"datetime":"2019-05-10 20:00","value":0.38},{"datetime":"2019-05-10 21:00","value":0.46},{"datetime":"2019-05-10 22:00","value":0.49},{"datetime":"2019-05-10 23:00","value":0.51},{"datetime":"2019-05-11 00:00","value":0.49},{"datetime":"2019-05-11 01:00","value":0.48},{"datetime":"2019-05-11 02:00","value":0.48},{"datetime":"2019-05-11 03:00","value":0.61},{"datetime":"2019-05-11 04:00","value":0.69},{"datetime":"2019-05-11 05:00","value":0.73},{"datetime":"2019-05-11 06:00","value":0.74},{"datetime":"2019-05-11 07:00","value":0.75},{"datetime":"2019-05-11 08:00","value":0.76},{"datetime":"2019-05-11 09:00","value":0.85},{"datetime":"2019-05-11 10:00","value":0.83},{"datetime":"2019-05-11 11:00","value":0.81},{"datetime":"2019-05-11 12:00","value":0.78},{"datetime":"2019-05-11 13:00","value":0.8},{"datetime":"2019-05-11 14:00","value":0.74},{"datetime":"2019-05-11 15:00","value":0.87},{"datetime":"2019-05-11 16:00","value":0.75},{"datetime":"2019-05-11 17:00","value":0.7},{"datetime":"2019-05-11 18:00","value":0.63},{"datetime":"2019-05-11 19:00","value":0.58},{"datetime":"2019-05-11 20:00","value":0.54},{"datetime":"2019-05-11 21:00","value":0.32},{"datetime":"2019-05-11 22:00","value":0.38},{"datetime":"2019-05-11 23:00","value":0.38},{"datetime":"2019-05-12 00:00","value":0.35},{"datetime":"2019-05-12 01:00","value":0.36},{"datetime":"2019-05-12 02:00","value":0.36},{"datetime":"2019-05-12 03:00","value":0.24},{"datetime":"2019-05-12 04:00","value":0.27},{"datetime":"2019-05-12 05:00","value":0.27},{"datetime":"2019-05-12 06:00","value":0.25},{"datetime":"2019-05-12 07:00","value":0.25},{"datetime":"2019-05-12 08:00","value":0.25},{"datetime":"2019-05-12 09:00","value":0.25},{"datetime":"2019-05-12 10:00","value":0.26},{"datetime":"2019-05-12 11:00","value":0.26},{"datetime":"2019-05-12 12:00","value":0.25},{"datetime":"2019-05-12 13:00","value":0.25}],"description":"多云，明天上午9点钟后转阴，其后多云","dswrf":[{"datetime":"2019-05-10 14:00","value":498.37621504},{"datetime":"2019-05-10 15:00","value":590.850432},{"datetime":"2019-05-10 16:00","value":527.2860672},{"datetime":"2019-05-10 17:00","value":442.7457024},{"datetime":"2019-05-10 18:00","value":362.0073984},{"datetime":"2019-05-10 19:00","value":288.9591552},{"datetime":"2019-05-10 20:00","value":242.19493632},{"datetime":"2019-05-10 21:00","value":0},{"datetime":"2019-05-10 22:00","value":0},{"datetime":"2019-05-10 23:00","value":0},{"datetime":"2019-05-11 00:00","value":0},{"datetime":"2019-05-11 01:00","value":0},{"datetime":"2019-05-11 02:00","value":0},{"datetime":"2019-05-11 03:00","value":0},{"datetime":"2019-05-11 04:00","value":0},{"datetime":"2019-05-11 05:00","value":0},{"datetime":"2019-05-11 06:00","value":1.4500608},{"datetime":"2019-05-11 07:00","value":26.14757632},{"datetime":"2019-05-11 08:00","value":57.3725952},{"datetime":"2019-05-11 09:00","value":270.7804928},{"datetime":"2019-05-11 10:00","value":337.0543104},{"datetime":"2019-05-11 11:00","value":416.6661888},{"datetime":"2019-05-11 12:00","value":464.8783104},{"datetime":"2019-05-11 13:00","value":470.15415296},{"datetime":"2019-05-11 14:00","value":468.2463104},{"datetime":"2019-05-11 15:00","value":280.2579456},{"datetime":"2019-05-11 16:00","value":292.0873984},{"datetime":"2019-05-11 17:00","value":266.2130944},{"datetime":"2019-05-11 18:00","value":223.2169728},{"datetime":"2019-05-11 19:00","value":178.7607296},{"datetime":"2019-05-11 20:00","value":149.6592384},{"datetime":"2019-05-11 21:00","value":0},{"datetime":"2019-05-11 22:00","value":0},{"datetime":"2019-05-11 23:00","value":0},{"datetime":"2019-05-12 00:00","value":0},{"datetime":"2019-05-12 01:00","value":0},{"datetime":"2019-05-12 02:00","value":0},{"datetime":"2019-05-12 03:00","value":0},{"datetime":"2019-05-12 04:00","value":0},{"datetime":"2019-05-12 05:00","value":0},{"datetime":"2019-05-12 06:00","value":7.6580608},{"datetime":"2019-05-12 07:00","value":45.3161216},{"datetime":"2019-05-12 08:00","value":106.00924928},{"datetime":"2019-05-12 09:00","value":607.8130944},{"datetime":"2019-05-12 10:00","value":687.8450944},{"datetime":"2019-05-12 11:00","value":749.3271552},{"datetime":"2019-05-12 12:00","value":796.985216},{"datetime":"2019-05-12 13:00","value":820.728768}],"humidity":[{"datetime":"2019-05-10 14:00","value":0.79},{"datetime":"2019-05-10 15:00","value":0.79},{"datetime":"2019-05-10 16:00","value":0.8},{"datetime":"2019-05-10 17:00","value":0.81},{"datetime":"2019-05-10 18:00","value":0.83},{"datetime":"2019-05-10 19:00","value":0.84},{"datetime":"2019-05-10 20:00","value":0.85},{"datetime":"2019-05-10 21:00","value":0.85},{"datetime":"2019-05-10 22:00","value":0.86},{"datetime":"2019-05-10 23:00","value":0.87},{"datetime":"2019-05-11 00:00","value":0.87},{"datetime":"2019-05-11 01:00","value":0.88},{"datetime":"2019-05-11 02:00","value":0.89},{"datetime":"2019-05-11 03:00","value":0.9},{"datetime":"2019-05-11 04:00","value":0.89},{"datetime":"2019-05-11 05:00","value":0.9},{"datetime":"2019-05-11 06:00","value":0.9},{"datetime":"2019-05-11 07:00","value":0.88},{"datetime":"2019-05-11 08:00","value":0.86},{"datetime":"2019-05-11 09:00","value":0.85},{"datetime":"2019-05-11 10:00","value":0.82},{"datetime":"2019-05-11 11:00","value":0.81},{"datetime":"2019-05-11 12:00","value":0.81},{"datetime":"2019-05-11 13:00","value":0.82},{"datetime":"2019-05-11 14:00","value":0.83},{"datetime":"2019-05-11 15:00","value":0.82},{"datetime":"2019-05-11 16:00","value":0.81},{"datetime":"2019-05-11 17:00","value":0.82},{"datetime":"2019-05-11 18:00","value":0.84},{"datetime":"2019-05-11 19:00","value":0.85},{"datetime":"2019-05-11 20:00","value":0.85},{"datetime":"2019-05-11 21:00","value":0.86},{"datetime":"2019-05-11 22:00","value":0.87},{"datetime":"2019-05-11 23:00","value":0.88},{"datetime":"2019-05-12 00:00","value":0.89},{"datetime":"2019-05-12 01:00","value":0.91},{"datetime":"2019-05-12 02:00","value":0.91},{"datetime":"2019-05-12 03:00","value":0.92},{"datetime":"2019-05-12 04:00","value":0.93},{"datetime":"2019-05-12 05:00","value":0.93},{"datetime":"2019-05-12 06:00","value":0.93},{"datetime":"2019-05-12 07:00","value":0.89},{"datetime":"2019-05-12 08:00","value":0.85},{"datetime":"2019-05-12 09:00","value":0.81},{"datetime":"2019-05-12 10:00","value":0.78},{"datetime":"2019-05-12 11:00","value":0.77},{"datetime":"2019-05-12 12:00","value":0.75},{"datetime":"2019-05-12 13:00","value":0.76}],"pm25":[{"datetime":"2019-05-10 14:00","value":11},{"datetime":"2019-05-10 15:00","value":11},{"datetime":"2019-05-10 16:00","value":10},{"datetime":"2019-05-10 17:00","value":10},{"datetime":"2019-05-10 18:00","value":10},{"datetime":"2019-05-10 19:00","value":10},{"datetime":"2019-05-10 20:00","value":10},{"datetime":"2019-05-10 21:00","value":11},{"datetime":"2019-05-10 22:00","value":11},{"datetime":"2019-05-10 23:00","value":11},{"datetime":"2019-05-11 00:00","value":11},{"datetime":"2019-05-11 01:00","value":10},{"datetime":"2019-05-11 02:00","value":10},{"datetime":"2019-05-11 03:00","value":11},{"datetime":"2019-05-11 04:00","value":11},{"datetime":"2019-05-11 05:00","value":12},{"datetime":"2019-05-11 06:00","value":12},{"datetime":"2019-05-11 07:00","value":12},{"datetime":"2019-05-11 08:00","value":12},{"datetime":"2019-05-11 09:00","value":11},{"datetime":"2019-05-11 10:00","value":10},{"datetime":"2019-05-11 11:00","value":9},{"datetime":"2019-05-11 12:00","value":8},{"datetime":"2019-05-11 13:00","value":8},{"datetime":"2019-05-11 14:00","value":7},{"datetime":"2019-05-11 15:00","value":8},{"datetime":"2019-05-11 16:00","value":8},{"datetime":"2019-05-11 17:00","value":8},{"datetime":"2019-05-11 18:00","value":8},{"datetime":"2019-05-11 19:00","value":9},{"datetime":"2019-05-11 20:00","value":9},{"datetime":"2019-05-11 21:00","value":9},{"datetime":"2019-05-11 22:00","value":10},{"datetime":"2019-05-11 23:00","value":10},{"datetime":"2019-05-12 00:00","value":11},{"datetime":"2019-05-12 01:00","value":11},{"datetime":"2019-05-12 02:00","value":11},{"datetime":"2019-05-12 03:00","value":12},{"datetime":"2019-05-12 04:00","value":13},{"datetime":"2019-05-12 05:00","value":13},{"datetime":"2019-05-12 06:00","value":14},{"datetime":"2019-05-12 07:00","value":14},{"datetime":"2019-05-12 08:00","value":14},{"datetime":"2019-05-12 09:00","value":14},{"datetime":"2019-05-12 10:00","value":13},{"datetime":"2019-05-12 11:00","value":12},{"datetime":"2019-05-12 12:00","value":11},{"datetime":"2019-05-12 13:00","value":10}],"precipitation":[{"datetime":"2019-05-10 14:00","value":0},{"datetime":"2019-05-10 15:00","value":0},{"datetime":"2019-05-10 16:00","value":0},{"datetime":"2019-05-10 17:00","value":0},{"datetime":"2019-05-10 18:00","value":0},{"datetime":"2019-05-10 19:00","value":0},{"datetime":"2019-05-10 20:00","value":0},{"datetime":"2019-05-10 21:00","value":0},{"datetime":"2019-05-10 22:00","value":0},{"datetime":"2019-05-10 23:00","value":0},{"datetime":"2019-05-11 00:00","value":0},{"datetime":"2019-05-11 01:00","value":0},{"datetime":"2019-05-11 02:00","value":0},{"datetime":"2019-05-11 03:00","value":0},{"datetime":"2019-05-11 04:00","value":0},{"datetime":"2019-05-11 05:00","value":0},{"datetime":"2019-05-11 06:00","value":0},{"datetime":"2019-05-11 07:00","value":0},{"datetime":"2019-05-11 08:00","value":0},{"datetime":"2019-05-11 09:00","value":0.056},{"datetime":"2019-05-11 10:00","value":0},{"datetime":"2019-05-11 11:00","value":0},{"datetime":"2019-05-11 12:00","value":0},{"datetime":"2019-05-11 13:00","value":0.0423},{"datetime":"2019-05-11 14:00","value":0},{"datetime":"2019-05-11 15:00","value":0},{"datetime":"2019-05-11 16:00","value":0},{"datetime":"2019-05-11 17:00","value":0},{"datetime":"2019-05-11 18:00","value":0},{"datetime":"2019-05-11 19:00","value":0},{"datetime":"2019-05-11 20:00","value":0},{"datetime":"2019-05-11 21:00","value":0},{"datetime":"2019-05-11 22:00","value":0},{"datetime":"2019-05-11 23:00","value":0},{"datetime":"2019-05-12 00:00","value":0},{"datetime":"2019-05-12 01:00","value":0},{"datetime":"2019-05-12 02:00","value":0},{"datetime":"2019-05-12 03:00","value":0},{"datetime":"2019-05-12 04:00","value":0},{"datetime":"2019-05-12 05:00","value":0},{"datetime":"2019-05-12 06:00","value":0},{"datetime":"2019-05-12 07:00","value":0},{"datetime":"2019-05-12 08:00","value":0},{"datetime":"2019-05-12 09:00","value":0},{"datetime":"2019-05-12 10:00","value":0},{"datetime":"2019-05-12 11:00","value":0},{"datetime":"2019-05-12 12:00","value":0},{"datetime":"2019-05-12 13:00","value":0}],"pres":[{"datetime":"2019-05-10 14:00","value":99559.8643200001},{"datetime":"2019-05-10 15:00","value":99529.1918336001},{"datetime":"2019-05-10 16:00","value":99529.1918336001},{"datetime":"2019-05-10 17:00","value":99529.1918336001},{"datetime":"2019-05-10 18:00","value":99547.9273472001},{"datetime":"2019-05-10 19:00","value":99609.1918336001},{"datetime":"2019-05-10 20:00","value":99609.1918336001},{"datetime":"2019-05-10 21:00","value":99670.2003200001},{"datetime":"2019-05-10 22:00","value":99689.1918336001},{"datetime":"2019-05-10 23:00","value":99689.1918336001},{"datetime":"2019-05-11 00:00","value":99689.1918336001},{"datetime":"2019-05-11 01:00","value":99689.1918336001},{"datetime":"2019-05-11 02:00","value":99609.1918336001},{"datetime":"2019-05-11 03:00","value":99609.1918336001},{"datetime":"2019-05-11 04:00","value":99609.1918336001},{"datetime":"2019-05-11 05:00","value":99620.7923200001},{"datetime":"2019-05-11 06:00","value":99689.1918336001},{"datetime":"2019-05-11 07:00","value":99700.7923200001},{"datetime":"2019-05-11 08:00","value":99769.1918336001},{"datetime":"2019-05-11 09:00","value":99769.1918336001},{"datetime":"2019-05-11 10:00","value":99769.1918336001},{"datetime":"2019-05-11 11:00","value":99769.1918336001},{"datetime":"2019-05-11 12:00","value":99769.1918336001},{"datetime":"2019-05-11 13:00","value":99769.1918336001},{"datetime":"2019-05-11 14:00","value":99689.1918336001},{"datetime":"2019-05-11 15:00","value":99689.1918336001},{"datetime":"2019-05-11 16:00","value":99658.5998336001},{"datetime":"2019-05-11 17:00","value":99658.5998336001},{"datetime":"2019-05-11 18:00","value":99658.5998336001},{"datetime":"2019-05-11 19:00","value":99689.1918336001},{"datetime":"2019-05-11 20:00","value":99707.9273472001},{"datetime":"2019-05-11 21:00","value":99787.9273472},{"datetime":"2019-05-11 22:00","value":99830.2003200001},{"datetime":"2019-05-11 23:00","value":99818.5998336001},{"datetime":"2019-05-12 00:00","value":99769.1918336001},{"datetime":"2019-05-12 01:00","value":99707.9273472001},{"datetime":"2019-05-12 02:00","value":99670.2003200001},{"datetime":"2019-05-12 03:00","value":99609.1918336001},{"datetime":"2019-05-12 04:00","value":99609.1918336001},{"datetime":"2019-05-12 05:00","value":99609.1918336001},{"datetime":"2019-05-12 06:00","value":99689.1918336001},{"datetime":"2019-05-12 07:00","value":99750.2003200001},{"datetime":"2019-05-12 08:00","value":99769.1918336001},{"datetime":"2019-05-12 09:00","value":99787.9273472},{"datetime":"2019-05-12 10:00","value":99769.1918336001},{"datetime":"2019-05-12 11:00","value":99769.1918336001},{"datetime":"2019-05-12 12:00","value":99707.9273472},{"datetime":"2019-05-12 13:00","value":99658.5998336001}],"skycon":[{"datetime":"2018-11-20 10:00","value":"PARTLY_CLOUDY_DAY"},{"datetime":"2018-11-20 11:00","value":"PARTLY_CLOUDY_DAY"}],"status":"ok","temperature":[{"datetime":"2019-05-10 14:00","value":24},{"datetime":"2019-05-10 15:00","value":24},{"datetime":"2019-05-10 16:00","value":24},{"datetime":"2019-05-10 17:00","value":24},{"datetime":"2019-05-10 18:00","value":24},{"datetime":"2019-05-10 19:00","value":23},{"datetime":"2019-05-10 20:00","value":23},{"datetime":"2019-05-10 21:00","value":23},{"datetime":"2019-05-10 22:00","value":23},{"datetime":"2019-05-10 23:00","value":23},{"datetime":"2019-05-11 00:00","value":23},{"datetime":"2019-05-11 01:00","value":23},{"datetime":"2019-05-11 02:00","value":23},{"datetime":"2019-05-11 03:00","value":23},{"datetime":"2019-05-11 04:00","value":22},{"datetime":"2019-05-11 05:00","value":22},{"datetime":"2019-05-11 06:00","value":22},{"datetime":"2019-05-11 07:00","value":23},{"datetime":"2019-05-11 08:00","value":23},{"datetime":"2019-05-11 09:00","value":23},{"datetime":"2019-05-11 10:00","value":24},{"datetime":"2019-05-11 11:00","value":24},{"datetime":"2019-05-11 12:00","value":25},{"datetime":"2019-05-11 13:00","value":25},{"datetime":"2019-05-11 14:00","value":23.29},{"datetime":"2019-05-11 15:00","value":23.24},{"datetime":"2019-05-11 16:00","value":23.39},{"datetime":"2019-05-11 17:00","value":23.16},{"datetime":"2019-05-11 18:00","value":22.94},{"datetime":"2019-05-11 19:00","value":22.65},{"datetime":"2019-05-11 20:00","value":22.65},{"datetime":"2019-05-11 21:00","value":22.65},{"datetime":"2019-05-11 22:00","value":22.71},{"datetime":"2019-05-11 23:00","value":22.71},{"datetime":"2019-05-12 00:00","value":22.65},{"datetime":"2019-05-12 01:00","value":22.43},{"datetime":"2019-05-12 02:00","value":22.33},{"datetime":"2019-05-12 03:00","value":22.16},{"datetime":"2019-05-12 04:00","value":22},{"datetime":"2019-05-12 05:00","value":22.12},{"datetime":"2019-05-12 06:00","value":22.55},{"datetime":"2019-05-12 07:00","value":23.33},{"datetime":"2019-05-12 08:00","value":24.24},{"datetime":"2019-05-12 09:00","value":25.04},{"datetime":"2019-05-12 10:00","value":25.6},{"datetime":"2019-05-12 11:00","value":25.85},{"datetime":"2019-05-12 12:00","value":26.1},{"datetime":"2019-05-12 13:00","value":26}],"visibility":[{"datetime":"2019-05-10 14:00","value":19.31},{"datetime":"2019-05-10 15:00","value":19.16},{"datetime":"2019-05-10 16:00","value":18.42},{"datetime":"2019-05-10 17:00","value":17.41},{"datetime":"2019-05-10 18:00","value":15.78},{"datetime":"2019-05-10 19:00","value":15.03},{"datetime":"2019-05-10 20:00","value":14.57},{"datetime":"2019-05-10 21:00","value":14.22},{"datetime":"2019-05-10 22:00","value":14.14},{"datetime":"2019-05-10 23:00","value":13.6},{"datetime":"2019-05-11 00:00","value":13.22},{"datetime":"2019-05-11 01:00","value":13.04},{"datetime":"2019-05-11 02:00","value":12.59},{"datetime":"2019-05-11 03:00","value":12.26},{"datetime":"2019-05-11 04:00","value":12.36},{"datetime":"2019-05-11 05:00","value":12.26},{"datetime":"2019-05-11 06:00","value":12.16},{"datetime":"2019-05-11 07:00","value":13.07},{"datetime":"2019-05-11 08:00","value":13.78},{"datetime":"2019-05-11 09:00","value":14.72},{"datetime":"2019-05-11 10:00","value":16.23},{"datetime":"2019-05-11 11:00","value":17.45},{"datetime":"2019-05-11 12:00","value":17.21},{"datetime":"2019-05-11 13:00","value":16.79},{"datetime":"2019-05-11 14:00","value":15.82},{"datetime":"2019-05-11 15:00","value":16.83},{"datetime":"2019-05-11 16:00","value":17.33},{"datetime":"2019-05-11 17:00","value":16.32},{"datetime":"2019-05-11 18:00","value":15.37},{"datetime":"2019-05-11 19:00","value":14.3},{"datetime":"2019-05-11 20:00","value":14.21},{"datetime":"2019-05-11 21:00","value":13.68},{"datetime":"2019-05-11 22:00","value":13.36},{"datetime":"2019-05-11 23:00","value":12.82},{"datetime":"2019-05-12 00:00","value":12.38},{"datetime":"2019-05-12 01:00","value":11.82},{"datetime":"2019-05-12 02:00","value":11.53},{"datetime":"2019-05-12 03:00","value":11.18},{"datetime":"2019-05-12 04:00","value":10.97},{"datetime":"2019-05-12 05:00","value":11.01},{"datetime":"2019-05-12 06:00","value":11.06},{"datetime":"2019-05-12 07:00","value":12.46},{"datetime":"2019-05-12 08:00","value":14.7},{"datetime":"2019-05-12 09:00","value":17.55},{"datetime":"2019-05-12 10:00","value":19.73},{"datetime":"2019-05-12 11:00","value":21.64},{"datetime":"2019-05-12 12:00","value":23.37},{"datetime":"2019-05-12 13:00","value":23.02}],"wind":[{"datetime":"2019-05-10 14:00","direction":64.37,"speed":17.66},{"datetime":"2019-05-10 15:00","direction":68.79,"speed":17.89},{"datetime":"2019-05-10 16:00","direction":75.03,"speed":17.47},{"datetime":"2019-05-10 17:00","direction":76.21,"speed":17.61},{"datetime":"2019-05-10 18:00","direction":77.43,"speed":17.45},{"datetime":"2019-05-10 19:00","direction":79.99,"speed":16.99},{"datetime":"2019-05-10 20:00","direction":80.31,"speed":17.11},{"datetime":"2019-05-10 21:00","direction":82.22,"speed":17.21},{"datetime":"2019-05-10 22:00","direction":84.29,"speed":17.08},{"datetime":"2019-05-10 23:00","direction":86.48,"speed":16.36},{"datetime":"2019-05-11 00:00","direction":88.44,"speed":15.2},{"datetime":"2019-05-11 01:00","direction":88.24,"speed":14.47},{"datetime":"2019-05-11 02:00","direction":86.95,"speed":13.86},{"datetime":"2019-05-11 03:00","direction":84.99,"speed":13.16},{"datetime":"2019-05-11 04:00","direction":83.39,"speed":12.34},{"datetime":"2019-05-11 05:00","direction":80.62,"speed":11.73},{"datetime":"2019-05-11 06:00","direction":73.9,"speed":11.96},{"datetime":"2019-05-11 07:00","direction":69.24,"speed":13.24},{"datetime":"2019-05-11 08:00","direction":67.83,"speed":14.66},{"datetime":"2019-05-11 09:00","direction":67.24,"speed":16.2},{"datetime":"2019-05-11 10:00","direction":65.48,"speed":17.88},{"datetime":"2019-05-11 11:00","direction":63.77,"speed":19.77},{"datetime":"2019-05-11 12:00","direction":63.89,"speed":20.48},{"datetime":"2019-05-11 13:00","direction":66.44,"speed":19.66},{"datetime":"2019-05-11 14:00","direction":72.46,"speed":19.5},{"datetime":"2019-05-11 15:00","direction":74.21,"speed":18.8},{"datetime":"2019-05-11 16:00","direction":80.35,"speed":19.02},{"datetime":"2019-05-11 17:00","direction":86.03,"speed":18.99},{"datetime":"2019-05-11 18:00","direction":91.08,"speed":18.62},{"datetime":"2019-05-11 19:00","direction":97.26,"speed":17.98},{"datetime":"2019-05-11 20:00","direction":100.39,"speed":17.31},{"datetime":"2019-05-11 21:00","direction":103.73,"speed":15.77},{"datetime":"2019-05-11 22:00","direction":107.29,"speed":15.57},{"datetime":"2019-05-11 23:00","direction":108.5,"speed":15.88},{"datetime":"2019-05-12 00:00","direction":111.94,"speed":14.75},{"datetime":"2019-05-12 01:00","direction":111.57,"speed":13.68},{"datetime":"2019-05-12 02:00","direction":108.88,"speed":13.47},{"datetime":"2019-05-12 03:00","direction":109.49,"speed":12.83},{"datetime":"2019-05-12 04:00","direction":110.13,"speed":12.17},{"datetime":"2019-05-12 05:00","direction":109.98,"speed":11.61},{"datetime":"2019-05-12 06:00","direction":107.55,"speed":11.52},{"datetime":"2019-05-12 07:00","direction":103.8,"speed":12.46},{"datetime":"2019-05-12 08:00","direction":102.08,"speed":13.88},{"datetime":"2019-05-12 09:00","direction":101.95,"speed":15.53},{"datetime":"2019-05-12 10:00","direction":101.86,"speed":17.34},{"datetime":"2019-05-12 11:00","direction":102.22,"speed":19.11},{"datetime":"2019-05-12 12:00","direction":103.64,"speed":20.66},{"datetime":"2019-05-12 13:00","direction":107.08,"speed":22.03}]}
         * primary : 0
         */

        private String forecast_keypoint;
        private HourlyBean hourly;
        private int primary;

        public String getForecast_keypoint() {
            return forecast_keypoint;
        }

        public void setForecast_keypoint(String forecast_keypoint) {
            this.forecast_keypoint = forecast_keypoint;
        }

        public HourlyBean getHourly() {
            return hourly;
        }

        public void setHourly(HourlyBean hourly) {
            this.hourly = hourly;
        }

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public static class HourlyBean {
            /**
             * aqi : [{"datetime":"2019-05-10 14:00","value":41},{"datetime":"2019-05-10 15:00","value":16},{"datetime":"2019-05-10 16:00","value":14},{"datetime":"2019-05-10 17:00","value":14},{"datetime":"2019-05-10 18:00","value":14},{"datetime":"2019-05-10 19:00","value":14},{"datetime":"2019-05-10 20:00","value":14},{"datetime":"2019-05-10 21:00","value":16},{"datetime":"2019-05-10 22:00","value":16},{"datetime":"2019-05-10 23:00","value":16},{"datetime":"2019-05-11 00:00","value":16},{"datetime":"2019-05-11 01:00","value":14},{"datetime":"2019-05-11 02:00","value":14},{"datetime":"2019-05-11 03:00","value":16},{"datetime":"2019-05-11 04:00","value":16},{"datetime":"2019-05-11 05:00","value":17},{"datetime":"2019-05-11 06:00","value":17},{"datetime":"2019-05-11 07:00","value":17},{"datetime":"2019-05-11 08:00","value":17},{"datetime":"2019-05-11 09:00","value":16},{"datetime":"2019-05-11 10:00","value":14},{"datetime":"2019-05-11 11:00","value":13},{"datetime":"2019-05-11 12:00","value":11},{"datetime":"2019-05-11 13:00","value":11},{"datetime":"2019-05-11 14:00","value":10},{"datetime":"2019-05-11 15:00","value":11},{"datetime":"2019-05-11 16:00","value":11},{"datetime":"2019-05-11 17:00","value":11},{"datetime":"2019-05-11 18:00","value":11},{"datetime":"2019-05-11 19:00","value":13},{"datetime":"2019-05-11 20:00","value":13},{"datetime":"2019-05-11 21:00","value":13},{"datetime":"2019-05-11 22:00","value":14},{"datetime":"2019-05-11 23:00","value":14},{"datetime":"2019-05-12 00:00","value":16},{"datetime":"2019-05-12 01:00","value":16},{"datetime":"2019-05-12 02:00","value":16},{"datetime":"2019-05-12 03:00","value":17},{"datetime":"2019-05-12 04:00","value":19},{"datetime":"2019-05-12 05:00","value":19},{"datetime":"2019-05-12 06:00","value":20},{"datetime":"2019-05-12 07:00","value":20},{"datetime":"2019-05-12 08:00","value":20},{"datetime":"2019-05-12 09:00","value":20},{"datetime":"2019-05-12 10:00","value":19},{"datetime":"2019-05-12 11:00","value":17},{"datetime":"2019-05-12 12:00","value":16},{"datetime":"2019-05-12 13:00","value":14}]
             * cloudrate : [{"datetime":"2019-05-10 14:00","value":0.79},{"datetime":"2019-05-10 15:00","value":0.46},{"datetime":"2019-05-10 16:00","value":0.42},{"datetime":"2019-05-10 17:00","value":0.4},{"datetime":"2019-05-10 18:00","value":0.38},{"datetime":"2019-05-10 19:00","value":0.37},{"datetime":"2019-05-10 20:00","value":0.38},{"datetime":"2019-05-10 21:00","value":0.46},{"datetime":"2019-05-10 22:00","value":0.49},{"datetime":"2019-05-10 23:00","value":0.51},{"datetime":"2019-05-11 00:00","value":0.49},{"datetime":"2019-05-11 01:00","value":0.48},{"datetime":"2019-05-11 02:00","value":0.48},{"datetime":"2019-05-11 03:00","value":0.61},{"datetime":"2019-05-11 04:00","value":0.69},{"datetime":"2019-05-11 05:00","value":0.73},{"datetime":"2019-05-11 06:00","value":0.74},{"datetime":"2019-05-11 07:00","value":0.75},{"datetime":"2019-05-11 08:00","value":0.76},{"datetime":"2019-05-11 09:00","value":0.85},{"datetime":"2019-05-11 10:00","value":0.83},{"datetime":"2019-05-11 11:00","value":0.81},{"datetime":"2019-05-11 12:00","value":0.78},{"datetime":"2019-05-11 13:00","value":0.8},{"datetime":"2019-05-11 14:00","value":0.74},{"datetime":"2019-05-11 15:00","value":0.87},{"datetime":"2019-05-11 16:00","value":0.75},{"datetime":"2019-05-11 17:00","value":0.7},{"datetime":"2019-05-11 18:00","value":0.63},{"datetime":"2019-05-11 19:00","value":0.58},{"datetime":"2019-05-11 20:00","value":0.54},{"datetime":"2019-05-11 21:00","value":0.32},{"datetime":"2019-05-11 22:00","value":0.38},{"datetime":"2019-05-11 23:00","value":0.38},{"datetime":"2019-05-12 00:00","value":0.35},{"datetime":"2019-05-12 01:00","value":0.36},{"datetime":"2019-05-12 02:00","value":0.36},{"datetime":"2019-05-12 03:00","value":0.24},{"datetime":"2019-05-12 04:00","value":0.27},{"datetime":"2019-05-12 05:00","value":0.27},{"datetime":"2019-05-12 06:00","value":0.25},{"datetime":"2019-05-12 07:00","value":0.25},{"datetime":"2019-05-12 08:00","value":0.25},{"datetime":"2019-05-12 09:00","value":0.25},{"datetime":"2019-05-12 10:00","value":0.26},{"datetime":"2019-05-12 11:00","value":0.26},{"datetime":"2019-05-12 12:00","value":0.25},{"datetime":"2019-05-12 13:00","value":0.25}]
             * description : 多云，明天上午9点钟后转阴，其后多云
             * dswrf : [{"datetime":"2019-05-10 14:00","value":498.37621504},{"datetime":"2019-05-10 15:00","value":590.850432},{"datetime":"2019-05-10 16:00","value":527.2860672},{"datetime":"2019-05-10 17:00","value":442.7457024},{"datetime":"2019-05-10 18:00","value":362.0073984},{"datetime":"2019-05-10 19:00","value":288.9591552},{"datetime":"2019-05-10 20:00","value":242.19493632},{"datetime":"2019-05-10 21:00","value":0},{"datetime":"2019-05-10 22:00","value":0},{"datetime":"2019-05-10 23:00","value":0},{"datetime":"2019-05-11 00:00","value":0},{"datetime":"2019-05-11 01:00","value":0},{"datetime":"2019-05-11 02:00","value":0},{"datetime":"2019-05-11 03:00","value":0},{"datetime":"2019-05-11 04:00","value":0},{"datetime":"2019-05-11 05:00","value":0},{"datetime":"2019-05-11 06:00","value":1.4500608},{"datetime":"2019-05-11 07:00","value":26.14757632},{"datetime":"2019-05-11 08:00","value":57.3725952},{"datetime":"2019-05-11 09:00","value":270.7804928},{"datetime":"2019-05-11 10:00","value":337.0543104},{"datetime":"2019-05-11 11:00","value":416.6661888},{"datetime":"2019-05-11 12:00","value":464.8783104},{"datetime":"2019-05-11 13:00","value":470.15415296},{"datetime":"2019-05-11 14:00","value":468.2463104},{"datetime":"2019-05-11 15:00","value":280.2579456},{"datetime":"2019-05-11 16:00","value":292.0873984},{"datetime":"2019-05-11 17:00","value":266.2130944},{"datetime":"2019-05-11 18:00","value":223.2169728},{"datetime":"2019-05-11 19:00","value":178.7607296},{"datetime":"2019-05-11 20:00","value":149.6592384},{"datetime":"2019-05-11 21:00","value":0},{"datetime":"2019-05-11 22:00","value":0},{"datetime":"2019-05-11 23:00","value":0},{"datetime":"2019-05-12 00:00","value":0},{"datetime":"2019-05-12 01:00","value":0},{"datetime":"2019-05-12 02:00","value":0},{"datetime":"2019-05-12 03:00","value":0},{"datetime":"2019-05-12 04:00","value":0},{"datetime":"2019-05-12 05:00","value":0},{"datetime":"2019-05-12 06:00","value":7.6580608},{"datetime":"2019-05-12 07:00","value":45.3161216},{"datetime":"2019-05-12 08:00","value":106.00924928},{"datetime":"2019-05-12 09:00","value":607.8130944},{"datetime":"2019-05-12 10:00","value":687.8450944},{"datetime":"2019-05-12 11:00","value":749.3271552},{"datetime":"2019-05-12 12:00","value":796.985216},{"datetime":"2019-05-12 13:00","value":820.728768}]
             * humidity : [{"datetime":"2019-05-10 14:00","value":0.79},{"datetime":"2019-05-10 15:00","value":0.79},{"datetime":"2019-05-10 16:00","value":0.8},{"datetime":"2019-05-10 17:00","value":0.81},{"datetime":"2019-05-10 18:00","value":0.83},{"datetime":"2019-05-10 19:00","value":0.84},{"datetime":"2019-05-10 20:00","value":0.85},{"datetime":"2019-05-10 21:00","value":0.85},{"datetime":"2019-05-10 22:00","value":0.86},{"datetime":"2019-05-10 23:00","value":0.87},{"datetime":"2019-05-11 00:00","value":0.87},{"datetime":"2019-05-11 01:00","value":0.88},{"datetime":"2019-05-11 02:00","value":0.89},{"datetime":"2019-05-11 03:00","value":0.9},{"datetime":"2019-05-11 04:00","value":0.89},{"datetime":"2019-05-11 05:00","value":0.9},{"datetime":"2019-05-11 06:00","value":0.9},{"datetime":"2019-05-11 07:00","value":0.88},{"datetime":"2019-05-11 08:00","value":0.86},{"datetime":"2019-05-11 09:00","value":0.85},{"datetime":"2019-05-11 10:00","value":0.82},{"datetime":"2019-05-11 11:00","value":0.81},{"datetime":"2019-05-11 12:00","value":0.81},{"datetime":"2019-05-11 13:00","value":0.82},{"datetime":"2019-05-11 14:00","value":0.83},{"datetime":"2019-05-11 15:00","value":0.82},{"datetime":"2019-05-11 16:00","value":0.81},{"datetime":"2019-05-11 17:00","value":0.82},{"datetime":"2019-05-11 18:00","value":0.84},{"datetime":"2019-05-11 19:00","value":0.85},{"datetime":"2019-05-11 20:00","value":0.85},{"datetime":"2019-05-11 21:00","value":0.86},{"datetime":"2019-05-11 22:00","value":0.87},{"datetime":"2019-05-11 23:00","value":0.88},{"datetime":"2019-05-12 00:00","value":0.89},{"datetime":"2019-05-12 01:00","value":0.91},{"datetime":"2019-05-12 02:00","value":0.91},{"datetime":"2019-05-12 03:00","value":0.92},{"datetime":"2019-05-12 04:00","value":0.93},{"datetime":"2019-05-12 05:00","value":0.93},{"datetime":"2019-05-12 06:00","value":0.93},{"datetime":"2019-05-12 07:00","value":0.89},{"datetime":"2019-05-12 08:00","value":0.85},{"datetime":"2019-05-12 09:00","value":0.81},{"datetime":"2019-05-12 10:00","value":0.78},{"datetime":"2019-05-12 11:00","value":0.77},{"datetime":"2019-05-12 12:00","value":0.75},{"datetime":"2019-05-12 13:00","value":0.76}]
             * pm25 : [{"datetime":"2019-05-10 14:00","value":11},{"datetime":"2019-05-10 15:00","value":11},{"datetime":"2019-05-10 16:00","value":10},{"datetime":"2019-05-10 17:00","value":10},{"datetime":"2019-05-10 18:00","value":10},{"datetime":"2019-05-10 19:00","value":10},{"datetime":"2019-05-10 20:00","value":10},{"datetime":"2019-05-10 21:00","value":11},{"datetime":"2019-05-10 22:00","value":11},{"datetime":"2019-05-10 23:00","value":11},{"datetime":"2019-05-11 00:00","value":11},{"datetime":"2019-05-11 01:00","value":10},{"datetime":"2019-05-11 02:00","value":10},{"datetime":"2019-05-11 03:00","value":11},{"datetime":"2019-05-11 04:00","value":11},{"datetime":"2019-05-11 05:00","value":12},{"datetime":"2019-05-11 06:00","value":12},{"datetime":"2019-05-11 07:00","value":12},{"datetime":"2019-05-11 08:00","value":12},{"datetime":"2019-05-11 09:00","value":11},{"datetime":"2019-05-11 10:00","value":10},{"datetime":"2019-05-11 11:00","value":9},{"datetime":"2019-05-11 12:00","value":8},{"datetime":"2019-05-11 13:00","value":8},{"datetime":"2019-05-11 14:00","value":7},{"datetime":"2019-05-11 15:00","value":8},{"datetime":"2019-05-11 16:00","value":8},{"datetime":"2019-05-11 17:00","value":8},{"datetime":"2019-05-11 18:00","value":8},{"datetime":"2019-05-11 19:00","value":9},{"datetime":"2019-05-11 20:00","value":9},{"datetime":"2019-05-11 21:00","value":9},{"datetime":"2019-05-11 22:00","value":10},{"datetime":"2019-05-11 23:00","value":10},{"datetime":"2019-05-12 00:00","value":11},{"datetime":"2019-05-12 01:00","value":11},{"datetime":"2019-05-12 02:00","value":11},{"datetime":"2019-05-12 03:00","value":12},{"datetime":"2019-05-12 04:00","value":13},{"datetime":"2019-05-12 05:00","value":13},{"datetime":"2019-05-12 06:00","value":14},{"datetime":"2019-05-12 07:00","value":14},{"datetime":"2019-05-12 08:00","value":14},{"datetime":"2019-05-12 09:00","value":14},{"datetime":"2019-05-12 10:00","value":13},{"datetime":"2019-05-12 11:00","value":12},{"datetime":"2019-05-12 12:00","value":11},{"datetime":"2019-05-12 13:00","value":10}]
             * precipitation : [{"datetime":"2019-05-10 14:00","value":0},{"datetime":"2019-05-10 15:00","value":0},{"datetime":"2019-05-10 16:00","value":0},{"datetime":"2019-05-10 17:00","value":0},{"datetime":"2019-05-10 18:00","value":0},{"datetime":"2019-05-10 19:00","value":0},{"datetime":"2019-05-10 20:00","value":0},{"datetime":"2019-05-10 21:00","value":0},{"datetime":"2019-05-10 22:00","value":0},{"datetime":"2019-05-10 23:00","value":0},{"datetime":"2019-05-11 00:00","value":0},{"datetime":"2019-05-11 01:00","value":0},{"datetime":"2019-05-11 02:00","value":0},{"datetime":"2019-05-11 03:00","value":0},{"datetime":"2019-05-11 04:00","value":0},{"datetime":"2019-05-11 05:00","value":0},{"datetime":"2019-05-11 06:00","value":0},{"datetime":"2019-05-11 07:00","value":0},{"datetime":"2019-05-11 08:00","value":0},{"datetime":"2019-05-11 09:00","value":0.056},{"datetime":"2019-05-11 10:00","value":0},{"datetime":"2019-05-11 11:00","value":0},{"datetime":"2019-05-11 12:00","value":0},{"datetime":"2019-05-11 13:00","value":0.0423},{"datetime":"2019-05-11 14:00","value":0},{"datetime":"2019-05-11 15:00","value":0},{"datetime":"2019-05-11 16:00","value":0},{"datetime":"2019-05-11 17:00","value":0},{"datetime":"2019-05-11 18:00","value":0},{"datetime":"2019-05-11 19:00","value":0},{"datetime":"2019-05-11 20:00","value":0},{"datetime":"2019-05-11 21:00","value":0},{"datetime":"2019-05-11 22:00","value":0},{"datetime":"2019-05-11 23:00","value":0},{"datetime":"2019-05-12 00:00","value":0},{"datetime":"2019-05-12 01:00","value":0},{"datetime":"2019-05-12 02:00","value":0},{"datetime":"2019-05-12 03:00","value":0},{"datetime":"2019-05-12 04:00","value":0},{"datetime":"2019-05-12 05:00","value":0},{"datetime":"2019-05-12 06:00","value":0},{"datetime":"2019-05-12 07:00","value":0},{"datetime":"2019-05-12 08:00","value":0},{"datetime":"2019-05-12 09:00","value":0},{"datetime":"2019-05-12 10:00","value":0},{"datetime":"2019-05-12 11:00","value":0},{"datetime":"2019-05-12 12:00","value":0},{"datetime":"2019-05-12 13:00","value":0}]
             * pres : [{"datetime":"2019-05-10 14:00","value":99559.8643200001},{"datetime":"2019-05-10 15:00","value":99529.1918336001},{"datetime":"2019-05-10 16:00","value":99529.1918336001},{"datetime":"2019-05-10 17:00","value":99529.1918336001},{"datetime":"2019-05-10 18:00","value":99547.9273472001},{"datetime":"2019-05-10 19:00","value":99609.1918336001},{"datetime":"2019-05-10 20:00","value":99609.1918336001},{"datetime":"2019-05-10 21:00","value":99670.2003200001},{"datetime":"2019-05-10 22:00","value":99689.1918336001},{"datetime":"2019-05-10 23:00","value":99689.1918336001},{"datetime":"2019-05-11 00:00","value":99689.1918336001},{"datetime":"2019-05-11 01:00","value":99689.1918336001},{"datetime":"2019-05-11 02:00","value":99609.1918336001},{"datetime":"2019-05-11 03:00","value":99609.1918336001},{"datetime":"2019-05-11 04:00","value":99609.1918336001},{"datetime":"2019-05-11 05:00","value":99620.7923200001},{"datetime":"2019-05-11 06:00","value":99689.1918336001},{"datetime":"2019-05-11 07:00","value":99700.7923200001},{"datetime":"2019-05-11 08:00","value":99769.1918336001},{"datetime":"2019-05-11 09:00","value":99769.1918336001},{"datetime":"2019-05-11 10:00","value":99769.1918336001},{"datetime":"2019-05-11 11:00","value":99769.1918336001},{"datetime":"2019-05-11 12:00","value":99769.1918336001},{"datetime":"2019-05-11 13:00","value":99769.1918336001},{"datetime":"2019-05-11 14:00","value":99689.1918336001},{"datetime":"2019-05-11 15:00","value":99689.1918336001},{"datetime":"2019-05-11 16:00","value":99658.5998336001},{"datetime":"2019-05-11 17:00","value":99658.5998336001},{"datetime":"2019-05-11 18:00","value":99658.5998336001},{"datetime":"2019-05-11 19:00","value":99689.1918336001},{"datetime":"2019-05-11 20:00","value":99707.9273472001},{"datetime":"2019-05-11 21:00","value":99787.9273472},{"datetime":"2019-05-11 22:00","value":99830.2003200001},{"datetime":"2019-05-11 23:00","value":99818.5998336001},{"datetime":"2019-05-12 00:00","value":99769.1918336001},{"datetime":"2019-05-12 01:00","value":99707.9273472001},{"datetime":"2019-05-12 02:00","value":99670.2003200001},{"datetime":"2019-05-12 03:00","value":99609.1918336001},{"datetime":"2019-05-12 04:00","value":99609.1918336001},{"datetime":"2019-05-12 05:00","value":99609.1918336001},{"datetime":"2019-05-12 06:00","value":99689.1918336001},{"datetime":"2019-05-12 07:00","value":99750.2003200001},{"datetime":"2019-05-12 08:00","value":99769.1918336001},{"datetime":"2019-05-12 09:00","value":99787.9273472},{"datetime":"2019-05-12 10:00","value":99769.1918336001},{"datetime":"2019-05-12 11:00","value":99769.1918336001},{"datetime":"2019-05-12 12:00","value":99707.9273472},{"datetime":"2019-05-12 13:00","value":99658.5998336001}]
             * skycon : [{"datetime":"2018-11-20 10:00","value":"PARTLY_CLOUDY_DAY"},{"datetime":"2018-11-20 11:00","value":"PARTLY_CLOUDY_DAY"}]
             * status : ok
             * temperature : [{"datetime":"2019-05-10 14:00","value":24},{"datetime":"2019-05-10 15:00","value":24},{"datetime":"2019-05-10 16:00","value":24},{"datetime":"2019-05-10 17:00","value":24},{"datetime":"2019-05-10 18:00","value":24},{"datetime":"2019-05-10 19:00","value":23},{"datetime":"2019-05-10 20:00","value":23},{"datetime":"2019-05-10 21:00","value":23},{"datetime":"2019-05-10 22:00","value":23},{"datetime":"2019-05-10 23:00","value":23},{"datetime":"2019-05-11 00:00","value":23},{"datetime":"2019-05-11 01:00","value":23},{"datetime":"2019-05-11 02:00","value":23},{"datetime":"2019-05-11 03:00","value":23},{"datetime":"2019-05-11 04:00","value":22},{"datetime":"2019-05-11 05:00","value":22},{"datetime":"2019-05-11 06:00","value":22},{"datetime":"2019-05-11 07:00","value":23},{"datetime":"2019-05-11 08:00","value":23},{"datetime":"2019-05-11 09:00","value":23},{"datetime":"2019-05-11 10:00","value":24},{"datetime":"2019-05-11 11:00","value":24},{"datetime":"2019-05-11 12:00","value":25},{"datetime":"2019-05-11 13:00","value":25},{"datetime":"2019-05-11 14:00","value":23.29},{"datetime":"2019-05-11 15:00","value":23.24},{"datetime":"2019-05-11 16:00","value":23.39},{"datetime":"2019-05-11 17:00","value":23.16},{"datetime":"2019-05-11 18:00","value":22.94},{"datetime":"2019-05-11 19:00","value":22.65},{"datetime":"2019-05-11 20:00","value":22.65},{"datetime":"2019-05-11 21:00","value":22.65},{"datetime":"2019-05-11 22:00","value":22.71},{"datetime":"2019-05-11 23:00","value":22.71},{"datetime":"2019-05-12 00:00","value":22.65},{"datetime":"2019-05-12 01:00","value":22.43},{"datetime":"2019-05-12 02:00","value":22.33},{"datetime":"2019-05-12 03:00","value":22.16},{"datetime":"2019-05-12 04:00","value":22},{"datetime":"2019-05-12 05:00","value":22.12},{"datetime":"2019-05-12 06:00","value":22.55},{"datetime":"2019-05-12 07:00","value":23.33},{"datetime":"2019-05-12 08:00","value":24.24},{"datetime":"2019-05-12 09:00","value":25.04},{"datetime":"2019-05-12 10:00","value":25.6},{"datetime":"2019-05-12 11:00","value":25.85},{"datetime":"2019-05-12 12:00","value":26.1},{"datetime":"2019-05-12 13:00","value":26}]
             * visibility : [{"datetime":"2019-05-10 14:00","value":19.31},{"datetime":"2019-05-10 15:00","value":19.16},{"datetime":"2019-05-10 16:00","value":18.42},{"datetime":"2019-05-10 17:00","value":17.41},{"datetime":"2019-05-10 18:00","value":15.78},{"datetime":"2019-05-10 19:00","value":15.03},{"datetime":"2019-05-10 20:00","value":14.57},{"datetime":"2019-05-10 21:00","value":14.22},{"datetime":"2019-05-10 22:00","value":14.14},{"datetime":"2019-05-10 23:00","value":13.6},{"datetime":"2019-05-11 00:00","value":13.22},{"datetime":"2019-05-11 01:00","value":13.04},{"datetime":"2019-05-11 02:00","value":12.59},{"datetime":"2019-05-11 03:00","value":12.26},{"datetime":"2019-05-11 04:00","value":12.36},{"datetime":"2019-05-11 05:00","value":12.26},{"datetime":"2019-05-11 06:00","value":12.16},{"datetime":"2019-05-11 07:00","value":13.07},{"datetime":"2019-05-11 08:00","value":13.78},{"datetime":"2019-05-11 09:00","value":14.72},{"datetime":"2019-05-11 10:00","value":16.23},{"datetime":"2019-05-11 11:00","value":17.45},{"datetime":"2019-05-11 12:00","value":17.21},{"datetime":"2019-05-11 13:00","value":16.79},{"datetime":"2019-05-11 14:00","value":15.82},{"datetime":"2019-05-11 15:00","value":16.83},{"datetime":"2019-05-11 16:00","value":17.33},{"datetime":"2019-05-11 17:00","value":16.32},{"datetime":"2019-05-11 18:00","value":15.37},{"datetime":"2019-05-11 19:00","value":14.3},{"datetime":"2019-05-11 20:00","value":14.21},{"datetime":"2019-05-11 21:00","value":13.68},{"datetime":"2019-05-11 22:00","value":13.36},{"datetime":"2019-05-11 23:00","value":12.82},{"datetime":"2019-05-12 00:00","value":12.38},{"datetime":"2019-05-12 01:00","value":11.82},{"datetime":"2019-05-12 02:00","value":11.53},{"datetime":"2019-05-12 03:00","value":11.18},{"datetime":"2019-05-12 04:00","value":10.97},{"datetime":"2019-05-12 05:00","value":11.01},{"datetime":"2019-05-12 06:00","value":11.06},{"datetime":"2019-05-12 07:00","value":12.46},{"datetime":"2019-05-12 08:00","value":14.7},{"datetime":"2019-05-12 09:00","value":17.55},{"datetime":"2019-05-12 10:00","value":19.73},{"datetime":"2019-05-12 11:00","value":21.64},{"datetime":"2019-05-12 12:00","value":23.37},{"datetime":"2019-05-12 13:00","value":23.02}]
             * wind : [{"datetime":"2019-05-10 14:00","direction":64.37,"speed":17.66},{"datetime":"2019-05-10 15:00","direction":68.79,"speed":17.89},{"datetime":"2019-05-10 16:00","direction":75.03,"speed":17.47},{"datetime":"2019-05-10 17:00","direction":76.21,"speed":17.61},{"datetime":"2019-05-10 18:00","direction":77.43,"speed":17.45},{"datetime":"2019-05-10 19:00","direction":79.99,"speed":16.99},{"datetime":"2019-05-10 20:00","direction":80.31,"speed":17.11},{"datetime":"2019-05-10 21:00","direction":82.22,"speed":17.21},{"datetime":"2019-05-10 22:00","direction":84.29,"speed":17.08},{"datetime":"2019-05-10 23:00","direction":86.48,"speed":16.36},{"datetime":"2019-05-11 00:00","direction":88.44,"speed":15.2},{"datetime":"2019-05-11 01:00","direction":88.24,"speed":14.47},{"datetime":"2019-05-11 02:00","direction":86.95,"speed":13.86},{"datetime":"2019-05-11 03:00","direction":84.99,"speed":13.16},{"datetime":"2019-05-11 04:00","direction":83.39,"speed":12.34},{"datetime":"2019-05-11 05:00","direction":80.62,"speed":11.73},{"datetime":"2019-05-11 06:00","direction":73.9,"speed":11.96},{"datetime":"2019-05-11 07:00","direction":69.24,"speed":13.24},{"datetime":"2019-05-11 08:00","direction":67.83,"speed":14.66},{"datetime":"2019-05-11 09:00","direction":67.24,"speed":16.2},{"datetime":"2019-05-11 10:00","direction":65.48,"speed":17.88},{"datetime":"2019-05-11 11:00","direction":63.77,"speed":19.77},{"datetime":"2019-05-11 12:00","direction":63.89,"speed":20.48},{"datetime":"2019-05-11 13:00","direction":66.44,"speed":19.66},{"datetime":"2019-05-11 14:00","direction":72.46,"speed":19.5},{"datetime":"2019-05-11 15:00","direction":74.21,"speed":18.8},{"datetime":"2019-05-11 16:00","direction":80.35,"speed":19.02},{"datetime":"2019-05-11 17:00","direction":86.03,"speed":18.99},{"datetime":"2019-05-11 18:00","direction":91.08,"speed":18.62},{"datetime":"2019-05-11 19:00","direction":97.26,"speed":17.98},{"datetime":"2019-05-11 20:00","direction":100.39,"speed":17.31},{"datetime":"2019-05-11 21:00","direction":103.73,"speed":15.77},{"datetime":"2019-05-11 22:00","direction":107.29,"speed":15.57},{"datetime":"2019-05-11 23:00","direction":108.5,"speed":15.88},{"datetime":"2019-05-12 00:00","direction":111.94,"speed":14.75},{"datetime":"2019-05-12 01:00","direction":111.57,"speed":13.68},{"datetime":"2019-05-12 02:00","direction":108.88,"speed":13.47},{"datetime":"2019-05-12 03:00","direction":109.49,"speed":12.83},{"datetime":"2019-05-12 04:00","direction":110.13,"speed":12.17},{"datetime":"2019-05-12 05:00","direction":109.98,"speed":11.61},{"datetime":"2019-05-12 06:00","direction":107.55,"speed":11.52},{"datetime":"2019-05-12 07:00","direction":103.8,"speed":12.46},{"datetime":"2019-05-12 08:00","direction":102.08,"speed":13.88},{"datetime":"2019-05-12 09:00","direction":101.95,"speed":15.53},{"datetime":"2019-05-12 10:00","direction":101.86,"speed":17.34},{"datetime":"2019-05-12 11:00","direction":102.22,"speed":19.11},{"datetime":"2019-05-12 12:00","direction":103.64,"speed":20.66},{"datetime":"2019-05-12 13:00","direction":107.08,"speed":22.03}]
             */

            private String description;
            private String status;
            private List<AqiBean> aqi;
            private List<CloudrateBean> cloudrate;
            private List<DswrfBean> dswrf;
            private List<HumidityBean> humidity;
            private List<Pm25Bean> pm25;
            private List<PrecipitationBean> precipitation;
            private List<PresBean> pres;
            private List<SkyconBean> skycon;
            private List<TemperatureBean> temperature;
            private List<VisibilityBean> visibility;
            private List<WindBean> wind;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<AqiBean> getAqi() {
                return aqi;
            }

            public void setAqi(List<AqiBean> aqi) {
                this.aqi = aqi;
            }

            public List<CloudrateBean> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBean> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<DswrfBean> getDswrf() {
                return dswrf;
            }

            public void setDswrf(List<DswrfBean> dswrf) {
                this.dswrf = dswrf;
            }

            public List<HumidityBean> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBean> humidity) {
                this.humidity = humidity;
            }

            public List<Pm25Bean> getPm25() {
                return pm25;
            }

            public void setPm25(List<Pm25Bean> pm25) {
                this.pm25 = pm25;
            }

            public List<PrecipitationBean> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBean> precipitation) {
                this.precipitation = precipitation;
            }

            public List<PresBean> getPres() {
                return pres;
            }

            public void setPres(List<PresBean> pres) {
                this.pres = pres;
            }

            public List<SkyconBean> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBean> skycon) {
                this.skycon = skycon;
            }

            public List<TemperatureBean> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBean> temperature) {
                this.temperature = temperature;
            }

            public List<VisibilityBean> getVisibility() {
                return visibility;
            }

            public void setVisibility(List<VisibilityBean> visibility) {
                this.visibility = visibility;
            }

            public List<WindBean> getWind() {
                return wind;
            }

            public void setWind(List<WindBean> wind) {
                this.wind = wind;
            }

            public static class AqiBean {
                /**
                 * datetime : 2019-05-10 14:00
                 * value : 41
                 */

                private String datetime;
                private int value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class CloudrateBean {
                /**
                 * datetime : 2019-05-10 14:00
                 * value : 0.79
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class DswrfBean {
                /**
                 * datetime : 2019-05-10 14:00
                 * value : 498.37621504
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class HumidityBean {
                /**
                 * datetime : 2019-05-10 14:00
                 * value : 0.79
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class Pm25Bean {
                /**
                 * datetime : 2019-05-10 14:00
                 * value : 11
                 */

                private String datetime;
                private int value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class PrecipitationBean {
                /**
                 * datetime : 2019-05-10 14:00
                 * value : 0
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class PresBean {
                /**
                 * datetime : 2019-05-10 14:00
                 * value : 99559.8643200001
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class SkyconBean {
                /**
                 * datetime : 2018-11-20 10:00
                 * value : PARTLY_CLOUDY_DAY
                 */

                private String datetime;
                private String value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
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
                 * datetime : 2019-05-10 14:00
                 * value : 24
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class VisibilityBean {
                /**
                 * datetime : 2019-05-10 14:00
                 * value : 19.31
                 */

                private String datetime;
                private double value;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class WindBean {
                /**
                 * datetime : 2019-05-10 14:00
                 * direction : 64.37
                 * speed : 17.66
                 */

                private String datetime;
                private double direction;
                private double speed;

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }

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
}
