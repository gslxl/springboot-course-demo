package edu.bistu.loginweb.controller;


import edu.bistu.loginweb.domain.CovidData;
import edu.bistu.loginweb.domain.EchartData;
import edu.bistu.loginweb.domain.XAxis;
import edu.bistu.loginweb.domain.YAxis;
import edu.bistu.loginweb.domain.Series;
import edu.bistu.loginweb.mapper.DataMapper;
import edu.bistu.loginweb.service.DataService;
import edu.bistu.loginweb.vo.DataVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

@Slf4j
@Controller
@RequestMapping("/data/")
public class DataController {
//    @Autowired
//    private DataMapper dataMapper;
    @Autowired
    private DataService dataService;

//    @PutMapping("add")
//    @ApiImplicitParam(name="info",value = "信息对象",required = true,dataType = "Infor")

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public DataVO index(Integer page, Integer limit){
        return dataService.findData(page,limit);
    }
    //查看数据列表
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail() {
        return "main";
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ResponseBody
    public DataVO getInfo(String prov){
        return dataService.query(prov);
    }
    //返回add视图
    @RequestMapping("/initAdd")
    public String initAdd(){
        return "add";
    }
     //实现add数据逻辑
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @Transactional
    @ResponseBody
    public String add(@RequestBody CovidData covidData){
        log.info("增加的数据是：",covidData.toString());
        dataService.add(covidData);
        return "ok";
    }

    @RequestMapping("/initEdit")
    public String init() {
        return "edit";
    }
    //修改信息
    @ResponseBody
    @Transactional
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody CovidData covidData) {
        log.info("修改的信息是：",covidData.toString());
        dataService.edit(covidData);
        return "ok";
    }

    @RequestMapping("/initStatictics")
    public String initStatictics() {
        return "statictics";

    }

//
//    //删除信息
//    @ResponseBody
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String delete(@RequestParam int id) {
//        inforService.delete(id);
//        return "ok";
//    }

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    @ResponseBody
    public EchartData getData(@RequestBody CovidData covidData){
        String prov = covidData.getProv();
        log.info("查询的省份是{}",prov);
        DataVO dataVO = dataService.query(prov);
        List<CovidData> covidData1 = dataVO.getData();
        XAxis xAxis=new XAxis();
        YAxis yAxis=new YAxis();
        List<Series> series = new ArrayList<Series>();//纵坐标

        List<String> legend=new ArrayList<String>();
        List<String> xdata=new ArrayList<String>();
        List<Integer> cureList=new ArrayList<Integer>();
        List<Integer> deathList=new ArrayList<Integer>();
        List<Integer> cumulativeList=new ArrayList<Integer>();
        List<Integer> increaseList=new ArrayList<Integer>();
        /*select id,area,cumulative,cure,death,increase,createtime from info where 1=1*/
        covidData1.forEach(n->{
            xdata.add(n.getDate());
            cureList.add(n.getCure());
            deathList.add(n.getDeadth());
            cumulativeList.add(n.getCumulative());
            increaseList.add(n.getIncrease());
        });
        Series cure=new Series("治愈","line",cureList);
        Series death=new Series("死亡","line",deathList);
        Series cumulative=new Series("累计","line",cumulativeList);
        Series increase=new Series("新增","line",increaseList);
        log.info("cure data are {}",cure);
        legend= Arrays.asList("治愈","死亡","累计","新增");
        series.add(cure);
        series.add(death);
        series.add(cumulative);
        series.add(increase);
        xAxis.setType("category");
        xAxis.setBoundaryGap(false);
        xAxis.setData(xdata);
        yAxis.setType("value");

        EchartData data=new EchartData(legend,xAxis, yAxis, series);

        return data;
    }

}
