import GET.productController;
import org.apache.commons.collections4.MultiValuedMap;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws IOException {
        productController productController = new productController();
        productController.schaltung("Flatbarlenker");
        productController.material("Flatbarlenker");
        productController.griff("Carbon");
        productController.griff("Aluminium");

        productController.schaltung("Bullhornlenker");
        productController.material("Bullhornlenker");
        productController.griff("Stahl");
        productController.griff("Aluminium");

        productController.schaltung("Rennradlenker");
        productController.material("Rennradlenker");
        productController.griff("Carbon");
        productController.griff("Aluminium");

        productController.lenkertyp();
        Collection<Map.Entry<String, MultiValuedMap<String, String>>> entries1 = productController.fahrradlenker.entries();
        entries1.forEach(x-> System.out.println(x));
    }
}
