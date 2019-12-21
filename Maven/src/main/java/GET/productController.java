package GET;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class productController {


    public Map<String, Map<String, String>> fahrradlenker= null;

    public static void lenkertyp() throws  IOException {
        ObjectMapper mapper = new ObjectMapper();


        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/lenkertyp");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();


            String lenker =response.toString();

            List<String> list = mapper.readValue(lenker, new TypeReference<List<String >>() {});

            list.stream().forEach(x -> System.out.println(x));
        } else {
            System.out.println("GET NOT WORKED");
        }
    }

    public static void main(String[] args) throws IOException {
        lenkertyp();
    }
}
