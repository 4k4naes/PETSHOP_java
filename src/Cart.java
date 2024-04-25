import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
	 private List<String> names = new ArrayList<>();
	 private List<Double> prices = new ArrayList<>();

	 Scanner writer = new Scanner(System.in);

	 public void addToCart(String name, Double price) {
		 names.add(name);
		 prices.add(price);
	 }





	 public void displayCart() {
		 Extras.clearConsole();
		 System.out.println("Znaleziono " + names.size() + " produktów w koszyku.\n");

		 double total = 0;

			 for (int i = 0; i < names.size(); i++) {
				 System.out.println(" - " + prices.get(i) + "zl      " + names.get(i));
				 total = total + prices.get(i);
			 }

		 String formattedTotal = String.format("%.2f zł", total);
		 System.out.println("Total: " + formattedTotal);

		 System.out.println("[ KUPUJ ]     [ USUN ]     [ ZAKUPY ]\n");
		 
		 String option = writer.nextLine().toLowerCase();
		 
		 switch(option) {
		 case "kupuj":
			 buy(total);
			 break;
		 case "usun":
			 delateFromCart();
			 break;
		 case "zakupy":
			 Main.dis.displayProducts();
			 break;
		 default:
			 displayCart();
		 }
	 }


	 public void clearCart() {
	        names.clear();
	        prices.clear();
	        return;
	    }
	 
	 private void buy(double total) {
		 if(total == 0.0) {
			 System.out.println("Brak produktow w koszyku!");
			 Extras.delay(1000);
			 displayCart();
		 }
		 
		 Extras.clearConsole();
		 System.out.println("\033[1m - - - - - PODSUMOWANIE - - - - - \n\n\033[0m"); 
		 for(int i = 0; i<names.size(); i++) {
			 System.out.println(" - " + prices.get(i) + "zł      " + names.get(i));
		 }
		 System.out.println("\n\nLACZNA SUMA: " + total + "zł\n");
		 System.out.println("[ POTWIERDZAM ]     [ ANULUJ ]");
		 
		 String option;
     	 while (true) {
             option = writer.nextLine().toLowerCase();

             if (option.equals("potwierdzam") || option.equals("anuluj")) {
                 System.out.println("Wybrałeś: " + option);
                 break;
             } else {
                 System.out.println("nie");
             }
         }
		 
		 
		 
		 
	     switch(option) {
	     case "potwierdzam":
	    	 Extras.clearConsole();
	    	 System.out.println(" - - - - ZAKUP UDANY! - - - - \n");
	    	 
	    	 Extras.delay(1000);
	    	 Extras.clearConsole();
	    	 System.out.println("Powrot.");
	    	 Extras.delay(1000);
	    	 Extras.clearConsole();
	    	 System.out.println("Powrot..");
	    	 Extras.delay(1000);
	    	 Extras.clearConsole();
	    	 System.out.println("Powrot...");
	    	 displayCart();
	    	 break;
	     case "anuluj":
	    	 displayCart();
	     }
	 
	 }
	 
	 private void delateFromCart() {
		 if (names.isEmpty()) {
		        System.out.println("Koszyk jest pusty. Brak produktów do usunięcia.");
		        Extras.delay(1000);
		        displayCart();
		 }
		 
		 String dname;
		 
		 int delateNumber;
    	 while (true) {
    		 Extras.clearConsole();
    		 System.out.println("Wybierz który produkt usunąć:");
    		 for(int i = 0; i<names.size(); i++) {
    			 System.out.println(i+1 + ". " + names.get(i));
    		 }
    		 
    		 delateNumber = writer.nextInt();
    		 delateNumber--;

             if (delateNumber>=0 && delateNumber < names.size()) {
            	 dname = names.get(delateNumber);
            	 names.remove(delateNumber);
 	             prices.remove(delateNumber);
                 break;
             } else {
            	 System.out.println("Zły numer! ");
            	 Extras.delay(1000);
             }
         }
    	 
		 coolDelate(dname);
	 }
	 
	 private void coolDelate(String dname) {
		 Extras.clearConsole();
		 System.out.println("usuwanie " + dname + ".");
		 Extras.delay(1000);
		 Extras.clearConsole();
		 System.out.println("usuwanie " + dname + "..");
		 Extras.delay(1000);
		 Extras.clearConsole();
		 System.out.println("usuwanie " + dname + "...");
		 Extras.delay(1000);
		 
		 displayCart();
	 }
}
