package model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class EnvironmentsStructure {

    boolean isActive;
    public boolean isActive(){return isActive;}

    @JsonAnyGetter
    @JsonAnySetter
    private Map<String,Object> structure = new LinkedHashMap<>();
}
