package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {
    private static final String testDataPath= "src/test/resources/TestData/";

    //TODO: Reading Data from JSON
    public static String getJsonData(String fileName, String field) throws FileNotFoundException {
        FileReader fileReader = new FileReader(testDataPath+fileName+".json");
        JsonElement jsonElement = JsonParser.parseReader(fileReader);
        // Reading from this file and Parser قطعها data after that convert to json object and return to string data
        return jsonElement.getAsJsonObject().get(field).getAsString();

    }


    //TODO:Reading Data from Proprieties File
    public static String getPropertyValue(String filename, String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(testDataPath+filename+".properties"));
        return properties.getProperty(key);
    }
}
