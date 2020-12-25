import java.util.HashMap;
import java.util.Map;

public class CategoryPrice {
    private Map<String, Double> categoryPrice = new HashMap<>();

    public CategoryPrice() {
        categoryPrice.put("HH001", 500d);
        categoryPrice.put("HH002", 450d);
        categoryPrice.put("HH003", 300d);
        categoryPrice.put("HH004", 350d);
    }

    public Double getPrice(String codeName) {
        return categoryPrice.get(codeName);
    }
}
