import java.io.*;
import java.util.ArrayList;

public class ProductFile {

    public static void writeFile(ArrayList<Product>arr) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("product.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(arr);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        writeFile(new ArrayList<>());
    }
    public static ArrayList<Product> readFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream("product.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object ob = objectInputStream.readObject();
            ArrayList<Product> arr1 = (ArrayList<Product>) ob;
            objectInputStream.close();
            fileInputStream.close();
            return arr1;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
