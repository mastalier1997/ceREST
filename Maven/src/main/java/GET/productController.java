package GET;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;


public class productController {


    public MultiValuedMap<String, MultiValuedMap<String, String>> fahrradlenker= new ArrayListValuedHashMap<>();
    public MultiValuedMap<String, String> flatbarlenker= new ArrayListValuedHashMap<>();


    @SuppressWarnings("Duplicates")
    public void lenkertyp() throws  IOException {
        ObjectMapper mapper = new ObjectMapper();


        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/lenkertyp");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();

            String lenker =response.toString();
            List<String> list = mapper.readValue(lenker, new TypeReference<List<String >>() {});

            for (int i=0; i<list.size();i++){
                String s = list.get(i);
                if (s.contains("Flatbarlenker")){
                    fahrradlenker.put("Flatbarlenker", flatbarlenker);
                }
            }

        } else {
            System.out.println("GET NOT WORKED");
        }
    }

    @SuppressWarnings("Duplicates")
    public void  schaltung(String s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/schaltung?lenkertyp="+s);
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();

            String lenker =response.toString();
            List<String> list = mapper.readValue(lenker, new TypeReference<List<String >>() {});

            for (int i =0; i<list.size();i++){
                String s2 ="Schaltung";
                String s1 =list.get(i);
                flatbarlenker.put(s2,s1);

            }

        }

    }

    @SuppressWarnings("Duplicates")
    public void  material(String s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/material?lenkertyp=Flatbarlenker");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();

            String lenker =response.toString();
            List<String> list = mapper.readValue(lenker, new TypeReference<List<String >>() {});

            for (int i =0; i<list.size();i++){
                String s2 ="Material";
                String s1 =list.get(i);
                flatbarlenker.put(s2,s1);

            }

        }

    }

    @SuppressWarnings("Duplicates")
    public void  griff(String s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/griff?material=carbon");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();

            String lenker =response.toString();
            List<String> list = mapper.readValue(lenker, new TypeReference<List<String >>() {});

            for (int i =0; i<list.size();i++){
                String s2 ="Griff";
                String s1 =list.get(i);
                flatbarlenker.put(s2,s1);
            }
        }

    }

}
