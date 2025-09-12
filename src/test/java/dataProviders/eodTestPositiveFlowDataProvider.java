package dataProviders;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import model.TestDataModel;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import static model.Constants.eodTestPositiveFlowTestPath;

@Slf4j
public class eodTestPositiveFlowDataProvider {
    @DataProvider(name = "eodTestPositiveFlowDataProvider")
    public Object[][] provideEodPositiveTestData() {
        File file = new File(eodTestPositiveFlowTestPath);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<TestDataModel> testDataList = Arrays.asList(objectMapper.readValue(file, TestDataModel[].class));
            Object[][] testDataArray = new Object[testDataList.size()][1];
            for (int i = 0; i < testDataList.size(); i++) {
                testDataArray[i][0] = testDataList.get(i);
            }
            log.info("Successfully loaded {} test cases from {}", testDataList.size(), file.getPath());
            return testDataArray;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}