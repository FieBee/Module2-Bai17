import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Client {
    public  static  ArrayList<Product> arr = ProductFile.readFile();
//    static {
//        Product p1 = new Product(1,"p1", "2022-10-10",1000,"Siu cap vjppr01");
//        Product p2 = new Product(2,"p1", "2022-10-10",2000,"Siu cap vjppr02");
//        Product p3 = new Product(3,"p1", "2022-10-10",3000,"Siu cap vjppr03");
//        Product p4 = new Product(4,"p1", "2022-10-10",4000,"Siu cap vjppr04");
//        Product p5 = new Product(5,"p1", "2022-10-10",5000,"Siu cap vjppr05");
//        Product p6 = new Product(6,"p1", "2022-10-10",6000,"Siu cap vjppr06");
//
//
//        arr.add(p1);
//        arr.add(p2);
//        arr.add(p3);
//        arr.add(p4);
//        arr.add(p5);
//        arr.add(p6);
//    }
    public static void main(String[] args) {
//        ArrayList<Product> arr = new ArrayList<>();

//        Product p1 = new Product(1,"p1", "2022-10-10",1000,"Siu cap vjppr01");
//        Product p2 = new Product(2,"p1", "2022-10-10",2000,"Siu cap vjppr02");
//        Product p3 = new Product(3,"p1", "2022-10-10",3000,"Siu cap vjppr03");
//        Product p4 = new Product(4,"p1", "2022-10-10",4000,"Siu cap vjppr04");
//        Product p5 = new Product(5,"p1", "2022-10-10",5000,"Siu cap vjppr05");
//        Product p6 = new Product(6,"p1", "2022-10-10",6000,"Siu cap vjppr06");
//
//        ArrayList<Product> arr = new ArrayList<>();
//        arr.add(p1);
//        arr.add(p2);
//        arr.add(p3);
//        arr.add(p4);
//        arr.add(p5);
//        arr.add(p6);

        addProduct(arr);
//        deleteProduct(arr);
        for (Product ob: arr
             ) {
            System.out.println(ob);
        }

    }


    public static void addProduct(ArrayList<Product> arr){
        Scanner scanner = new Scanner(System.in);

        int id = Product.idd;
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.println("Ngày sản xuất (YY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.println("Nhập giá: ");
        int price = scanner.nextInt();

        System.out.println("Nhập mô tả: ");
        String describe = scanner.nextLine();

        arr.add(new Product(id, name, date, price, describe));
        Product.idd++;
        ProductFile.writeFile(arr);
    }

    public static Product checkId(ArrayList<Product> arr, String option){
        Scanner input = new Scanner(System.in);
        System.out.println(option);
        int id = input.nextInt();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getId() == id){
                return arr.get(i);
            };
        }
        return null;
    }

    public static void editProduct(ArrayList<Product> arr){
        Scanner input = new Scanner(System.in);
        Product product = checkId(arr,"Nhập id sản phẩm muốn sửa: ");

        if (product != null){
            System.out.println("Nhập lại tên sản phẩm: ");
            String name = input.nextLine();
            product.setName(name);

            System.out.println("Ngày lại sản xuất (YY-MM-DD): ");
            String date = input.nextLine();
            product.setDate(LocalDate.parse(date));

            System.out.println("Nhập lại giá: ");
            int price = input.nextInt();
            product.setPrice(price);

            Scanner input1 = new Scanner(System.in);
            System.out.println("Nhập lại mô tả: ");
            String describe = input1.nextLine();

            product.setDescribe(describe);

        }else {
            System.out.println("Id không hợp lệ!!!");
        }
        ProductFile.writeFile(arr);

    }

    public static void deleteProduct(ArrayList<Product>arr){
        Product product = checkId(arr, "Nhập id sản phẩm cần xóa: ");
        if (product != null) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == product) {
                    arr.remove(i);
                    ProductFile.writeFile(arr);
                    return;
                }
            }
        }else {
            System.out.println("Id không hợp lệ!!!");
        }

    }
}


