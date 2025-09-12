package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestDataModel {
    private String description;
    private HashMap<String, String> param;
    private String endpoint;
    private Object payload;
    private HTTP_METHORD httpMethord;
    private ResponseTest responseTest;
}
