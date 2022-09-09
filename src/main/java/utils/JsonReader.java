package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public static Object[][] getJSONData(String JSON_path, String JSON_data, int JSON_attributes) throws IOException, ParseException {
        Object object = new JSONParser().parse(new FileReader(JSON_path));
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(JSON_data);

        Object[][] array = new String[jsonArray.size()][JSON_attributes];

        for (int i = 0; i < jsonArray.size(); i++) {

            JSONObject object1 = (JSONObject) jsonArray.get(i);
            array[i][0] = String.valueOf(object1.get("FirstName"));
            array[i][1] = String.valueOf(object1.get("LastName"));
            array[i][2] = String.valueOf(object1.get("Email"));
            array[i][3] = String.valueOf(object1.get("Company"));
            array[i][4] = String.valueOf(object1.get("City"));
            array[i][5] = String.valueOf(object1.get("StreetAddress"));
            array[i][6] = String.valueOf(object1.get("StreetAddress2"));
            array[i][7] = String.valueOf(object1.get("ZipCode"));
            array[i][8] = String.valueOf(object1.get("PhoneNumber"));
        }
        return array;
    }
}
