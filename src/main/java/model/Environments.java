package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Environments {

    private EnvironmentsStructure env_int;
    private EnvironmentsStructure env_test;

    public List<EnvironmentsStructure> lifOfEnvironments(){
        List<EnvironmentsStructure> list = new ArrayList<>();
        list.add(getEnv_int());
        list.add(getEnv_test());
        return list;
    }


}
