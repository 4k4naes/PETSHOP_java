import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Artykuly {
    private static String kategoria;

    private String name;
    private double price;
    private String description;
    private Integer quantity;

    private static List<Artykuly> artykulyList = new ArrayList<>();

    static {
        setKategoria("Jedzenie");

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Monika\\eclipse-workspace\\Pet_Shop\\Sklep\\src\\products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";"); // separator w tymtym

                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                String description = parts[2];
                Integer quantity = Integer.parseInt(parts[3]);

                artykulyList.add(new Artykuly(name, price, description, quantity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Artykuly(String name, double price, String description, Integer quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public static String getKategoria() {
        return kategoria;
    }

    public static void setKategoria(String kategoria) {
        Artykuly.kategoria = kategoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setOpis(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // Metoda zwracająca listę artykułów
    public static List<Artykuly> getArtykulyList() {
        return artykulyList;
    }
}
