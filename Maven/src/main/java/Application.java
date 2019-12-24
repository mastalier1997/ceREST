import GET.productController;
import org.apache.commons.collections4.MultiValuedMap;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws IOException {
        productController productController = new productController();
        productController.schaltung();
        productController.material();
        productController.griff();

        Collection<Map.Entry<String, String>> entries = productController.flatbarlenker.entries();
        entries.forEach(x-> System.out.println(x));

        productController.lenkertyp();
        Collection<Map.Entry<String, MultiValuedMap<String, String>>> entries1 = productController.fahrradlenker.entries();
        entries1.forEach(x-> System.out.println(x));
    }
}
