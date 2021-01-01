package edu.bistu.loginweb.service.impl;

import com.github.pagehelper.PageInfo;
import edu.bistu.loginweb.domain.CovidData;
import edu.bistu.loginweb.mapper.DataMapper;
import edu.bistu.loginweb.service.DataService;
import edu.bistu.loginweb.vo.DataVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;

import javax.xml.crypto.Data;
import java.util.List;
@Service
public class DataServiceimpl implements DataService {
    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<CovidData> findAllData(CovidData covidData){
        return dataMapper.selectAll();

    }


    @Override
    public DataVO findData(Integer page,Integer limit) {
        DataVO dataVO =new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(dataMapper.selectCount());
        PageHelper.startPage(page,limit);
        List<CovidData> result = dataMapper.selectAll();
        PageInfo<CovidData>  covidDataPageInfo=new PageInfo<>(result);
        dataVO.setData(covidDataPageInfo.getList());
        return dataVO;
    }

    @Override
    public DataVO query(String prov) {
        DataVO dataVO =new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(dataMapper.selectCount());
        List<CovidData> result = dataMapper.queryProv(prov);
        dataVO.setData(result);
        return dataVO;
    }
    @Override
    public int add(CovidData covidData){
            String prov = covidData.getProv();
            String date= covidData.getDate();
            Integer cumulative =covidData.getCumulative();
            Integer deadth = covidData.getDeadth();
            Integer cure= covidData.getCure();
            Integer increase = covidData.getIncrease();
            return  dataMapper.InsertOne(prov,date,cumulative,deadth,cure,increase);
    }

    @Override
    public int edit(CovidData covidData) {
        int id= covidData.getId();
        String prov = covidData.getProv();
        String date= covidData.getDate();
        Integer cumulative =covidData.getCumulative();
        Integer deadth = covidData.getDeadth();
        Integer cure= covidData.getCure();
        Integer increase = covidData.getIncrease();
        return dataMapper.alter(prov,date,cumulative,deadth,cure,increase);
    }

}

