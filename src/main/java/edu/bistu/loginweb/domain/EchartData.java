package edu.bistu.loginweb.domain;

import java.util.ArrayList;
import java.util.List;


public class EchartData {

    public XAxis xAxis;//数据分组
    public YAxis yAxis;//横坐标
    public List<String> legend;
    public List<Series> series = new ArrayList<Series>();//纵坐标

    public EchartData(List<String> legend,XAxis xAxis, YAxis yAxis, List<Series> seriesList) {
        super();
        this.legend=legend;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.series = seriesList;
    }
}
