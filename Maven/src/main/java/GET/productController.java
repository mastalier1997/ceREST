package GET;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class productController {

    public static void lenkertyp() throws  IOException {
        URL urlForGetRequest = new URL("https://www.maripavi.at/produkt/lenkertyp\n");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            System.out.println(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
    }

    public static void main(String[] args) throws IOException {
        lenkertyp();
    }
}
