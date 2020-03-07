# WaterQuality
### 全国各个监测站点的实时水质数据
### 一、说明
1. 本项目是一个简单的安卓小程序，可以查看全国各个监测站的实时水质数据。
2. 这只是我拿来练手的，用到了网络编程、多线程、GSON解析JSON这些知识。
3. 效果图：![image](https://github.com/laoyingyong/WaterQuality/blob/master/img/tu.jpg)
### 二、总结
1. 写这个小程序时遇到点问题，就是有不少字段会显示null。经过排查，发现问题出现的原因就是实体类的字段名称起得不合理，没有和JSON中的各个键名匹配上，这样GSON工具就不能正常封装一个对象。
