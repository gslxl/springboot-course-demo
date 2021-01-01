package edu.bistu.loginweb.domain;

import lombok.Data;

import java.util.List;

@Data
public class XAxis {

    private String type;
    private Boolean boundaryGap;
    public List<String> data;

}
