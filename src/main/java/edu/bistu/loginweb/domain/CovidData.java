package edu.bistu.loginweb.domain;

import lombok.Data;

@Data
public class CovidData {
    private int id;
    private String prov;
    private String date;
    private int cumulative;
    private int deadth;
    private int cure;
    private int increase;

}
