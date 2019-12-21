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


    public static MultiValuedMap<String, MultiValuedMap<String, String>> fahrradlenker= null;
    public  static MultiValuedMap<String, String> flatbarlenker= new ArrayListValuedHashMap<>();


    @SuppressWarnings("Duplicates")
    public static void lenkertyp() throws  IOException {
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
                if (s.equalsIgnoreCase("flatbarlenker")){
                    fahrradlenker.put("Flatbarlenker", flatbarlenker);
                }
            }

        } else {
            System.out.println("GET NOT WORKED");
        }
    }

    @SuppressWarnings("Duplicates")
    public static  void  schaltung() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/schaltung?lenkertyp=Flatbarlenker");
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
                String s ="Schaltung";
                String s1 =list.get(i);
                flatbarlenker.put(s,s1);

            }

        }

    }

    @SuppressWarnings("Duplicates")
    public static  void  material() throws IOException {
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
                String s ="Material";
                String s1 =list.get(i);
                flatbarlenker.put(s,s1);

            }

        }

    }

    @SuppressWarnings("Duplicates")
    public static  void  griff() throws IOException {
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
                String s ="Griff";
                String s1 =list.get(i);
                flatbarlenker.put(s,s1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        schaltung();
        material();
        griff();

        Collection<Map.Entry<String, String>> entries = flatbarlenker.entries();
        entries.forEach(x-> System.out.println(x));

        lenkertyp();
        Collection<Map.Entry<String, MultiValuedMap<String, String>>> entries1 = fahrradlenker.entries();
        entries1.forEach(x-> System.out.println(x));
    }
}
