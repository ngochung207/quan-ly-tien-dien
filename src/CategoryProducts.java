import java.util.HashMap;
import java.util.Map;

public class CategoryProducts {
    private Map<String, String> category = new HashMap<>();

    public CategoryProducts() {
        category.put("HH001", "Dịch vụ điện sinh hoạt");
        category.put("HH002", "Dịch vụ điện sản xuất");
        category.put("HH003", "Dịch vụ nước sinh hoạt");
        category.put("HH004", "Dịch vụ nước sản xuất");
    }

    public String getNameProduct(String codeName) {
        return category.get(codeName);
    }

}
