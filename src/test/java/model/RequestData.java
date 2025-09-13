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
public class RequestData {
    private HashMap<String, String> param;
    private String endpoint;
    private Object payload;
    private httpMethord httpMethord;
}
