import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable {
    private int id ;
    private String name;
    private LocalDate date;
    private int price;
    private String Describe;

    static int idd = 7;


    public Product(int id, String name, String date, int price, String describe) {
        this.id = id;
        this.name = name;
        this.date = LocalDate.parse(date);
        this.price = price;
        Describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String describe) {
        Describe = describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", Describe='" + Describe + '\'' +
                '}' + "\n";
    }
}
