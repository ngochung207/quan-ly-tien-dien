import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String numberInvoice;
    private int month;
    private String idCustomer;
    private List<Products> listProducts = new ArrayList<Products>();

    public Invoice() {
    }

    public Invoice(String numberInvoice, int month, String idCustomer, List<Products> listProducts) {
        this.numberInvoice = numberInvoice;
        this.month = month;
        this.idCustomer = idCustomer;
        this.listProducts = listProducts;
    }

    public String getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(String numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<Products> getListProducts() {
        return listProducts;
    }
    public void getEachProduct(List<Products> listProducts){
        for(Products p: listProducts){
            p.toStringProduct();
        }
    }
    public void setListProducts(List<Products> listProducts) {
        this.listProducts = listProducts;
    }
}
