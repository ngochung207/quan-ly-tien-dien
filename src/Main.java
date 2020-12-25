import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Manager eCompany = new Manager();
    static CategoryPrice categoryPrice = new CategoryPrice();
    static CategoryProducts categoryProducts = new CategoryProducts();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            Menu();
            Integer chose = Integer.parseInt(sc.nextLine());
            switch (chose) {
                case 1: // Khai báo thông tin khách hàng mới.
                    createNewInfoCustomer();
                    break;
                case 2: // Lập hóa đơn thông tin khách hàng.
                    createNewInvoice();
                    break;
                case 3: // Hiện thị thông tin của một khách hàng

                    break;
                case 4: // Thoát khoải chương trình.
                    System.exit(0);
                    break;
                default:

                    break;
            }
        } while (true);

    }

    public static void Menu() {
        System.out.println("-------- Quan ly hoa don dien -------");
        System.out.println("01.Thêm mới thông tin khách hàng");
        System.out.println("02. Lập hóa đơn");
        System.out.println("03. Hiện thị thông tin của một người dùng");
        System.out.println("04. Exit");
    }

    public static void createNewInfoCustomer() {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập vào mã khách hàng: ");
            String id = sc.nextLine();
            System.out.print("Nhập vào tên khách hàng: ");
            String name = sc.nextLine();
            System.out.print("Nhập vào địa chỉ khách hàng: ");
            String address = sc.nextLine();
            Info info = new Info(id, address, name);

            Boolean check = eCompany.checkInfoByID(info.getId());

            if (check) {
                System.out.println("---> Mã khách đã tồn tại <---");
            } else {
                eCompany.addNewInfo(info);
                break;
            }
        } while (true);
    }

    public static void createNewInvoice() {
        do {
            System.out.println("--> Khai báo thông tin người mua <--");
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập số hóa đơn: ");
            String numberInvoice = sc.nextLine();
            if(eCompany.checkInvoiceByID(numberInvoice)){
                System.out.println("--> Hóa đơn đã tồn tại <--");
            } else {
                System.out.print("Nhập vào tháng: ");
                int month = sc.nextInt();
                sc.nextLine();
                System.out.print("Nhập vào mã khách hàng: ");
                String idCustomer = sc.nextLine();
                String nameCustomer = eCompany.getNameByID(idCustomer);
                System.out.println("Tên khách hàng: " + nameCustomer);
                System.out.print("--> Nhập thông tin hàng hóa <--");
                sc.nextLine();
                do {
                    System.out.print("Nhập thông tin mã hàng: ");
                    String codeName = sc.nextLine();
                    String nameProduct = categoryProducts.getNameProduct(codeName);
                    System.out.println("Tên hàng hóa là: " + nameProduct);
                    System.out.print("Nhập vào chỉ số đâu: ");
                    int indexHead = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập vào chỉ số cuối: ");
                    int indexFinal = Integer.parseInt(sc.nextLine());

                    Products product = new Products(codeName, nameProduct, indexHead, indexFinal);
                    List<Products> tempProducts = new ArrayList<>();
                    tempProducts.add(product);
                    Invoice tempInvoice = new Invoice(numberInvoice, month, idCustomer, tempProducts);
                    eCompany.addNewInvoice(tempInvoice);
                    System.out.println("Có thêm hàng hóa không Y/N: ");
                    String add = sc.nextLine();
                    if (add.equals("N")){
                        System.out.println("Tạo thành công hóa đơn số: " + numberInvoice);
                        break;
                    }
                }while (true);
            }
            System.out.println("Có muốn lập mới một hóa đơn khác không Y/N: ");
            String add = sc.nextLine();
            if (add.equals("N")){
                break;
            }
        }
        while (true);
    }

    // Thêm mới thông tin khách hàng.
    // Check mã khách hàng có trong danh mục không
    // Thêm mới hóa đơn.
    // Check số hóa đơn có trong danh sách hóa đơn không.
}
