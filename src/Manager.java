import java.lang.reflect.InvocationHandler;
import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Info> customerManager = new HashMap<String, Info>();
    private Map<String, Invoice> invoiceManager = new HashMap<String, Invoice>();

    // Phương thức thao tác với quản lý thông tin khách hàng.

    public void addNewInfo(Info e) {
        // Thêm mới một khách hàng vào quản lý thông tin khách hàng.
        customerManager.put(e.getId(), e);
        System.out.println("----> Thêm mới thông tin khách hàng " + e.getId() + " thành công.");
    }

    public Info getInfoByID(String id) {
        // Lấy ra thông tin của khách hàng dựa vào số ID.
        if (customerManager.isEmpty()) {
            return null;
        }
        return customerManager.get(id);
    }

    public String getNameCustomerByID(String id) {
        // Lấy ra tên khách hàng dựa vào số id
        if (customerManager.isEmpty()) {
            return null;
        }
        return getInfoByID(id).getName();
    }

    public String getAddressByID(String id) {
        // Lấy ra địa chỉ khách hàng dựa vào số id
        if (customerManager.isEmpty()) {
            return null;
        }
        return getInfoByID(id).getAddress();
    }

    public String showInfoByID(String id) {
        // Hiển thị thông tin của khách hàng dựa vào ID.
        return toStringInfo(id);
    }

    public String toStringInfo(String id) {
        Info e = getInfoByID(id);
        return e.getId() + '\t' + e.getName() + '\t' + e.getAddress();
    }

    public Boolean checkInfoByID(String id) {
        // Kiểm tra khách hàng có tồn tại trong danh mục thông tin không.
        for (String k : customerManager.keySet()) {
            if (k.equals(id)) {
                return true;
            }
        }
        return false;
    }
    // Phương thức thao tác với quản lý sản phẩm ( điện , nước, vệ sinh ).

    // Phương thức thao tác với quản lý khách hàng sử dụng dịch vụ.

    public void addNewInvoice(Invoice inv) {
        // Phương thức thêm mới hóa đơn.
        invoiceManager.put(inv.getNumberInvoice(), inv);
    }

    public Invoice getInvoiceByNumber(String number) {
        // Lấy ra đối tượng Invoice từ quản lý hóa đơn dựa vào số hóa đơn.
        return invoiceManager.get(number);
    }

    public Boolean checkInvoiceByID(String number) {
        // Kiểm tra số hóa đơn có trong danh sách quản lý hóa đơn không.
        for (String k : invoiceManager.keySet()) {
            if (k.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public void showAllInvoice(){
        for(String key: invoiceManager.keySet()){
            Invoice e = invoiceManager.get(key);
            System.out.print("Số HĐ: " + e.getNumberInvoice() + '\n' +
                    "Mã Khách: " + e.getIdCustomer() + '\n' +
                    "Tên Khách: " + customerManager.get(e.getIdCustomer()).getName());
            toStringInvoice(e);
        }
    }

    public void toStringInvoice(Invoice e) {
        System.out.println();
        System.out.printf("\n%-10s%-30s%-15s%-15s"
                ,"Mã hàng"
                ,"Tên hàng"
                ,"Chỉ số đầu"
                ,"Chỉ số cuối",'\n');
        e.getEachProduct(e.getListProducts());
        System.out.println();
        System.out.println("<-------------->");
    }
}
