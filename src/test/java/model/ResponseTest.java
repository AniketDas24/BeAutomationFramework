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
public class ResponseTest {
    public Integer expectedStatusCode;
    public HashMap<String, String> jsonPathAssertions;
}
