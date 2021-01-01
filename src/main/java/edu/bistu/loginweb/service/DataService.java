package edu.bistu.loginweb.service;

import edu.bistu.loginweb.domain.CovidData;

import edu.bistu.loginweb.vo.DataVO;


import java.util.List;

public interface DataService {

    DataVO findData(Integer page, Integer limit);

    List<CovidData> findAllData(CovidData covidData);

    DataVO query(String prov);

    int add(CovidData covidData);

    int edit(CovidData covidData);

}
