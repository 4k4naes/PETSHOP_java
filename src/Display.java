import java.util.List;
import java.util.Scanner;


//TODO
// - niech sie w while przy wyborze koszyk/dalej nie wyswietla ze zle jak nic jeszcze nie klikles
// - displayCart(); w Cart.java 


public class Display {
	
	List<Artykuly> listaArtykulow = Artykuly.getArtykulyList();
	
	Scanner writer = new Scanner(System.in);
	Cart cart = new Cart();
	

	
	public void info(){
		Extras.clearConsole();
		System.out.println("\033[1mWITAJ W NASZYM SKLEPIE PET SHOP!\n\n\n\033[0m"); 
        System.out.println("Od czego chciałbyś zacząć?\n");
        System.out.println("[ KOSZYK ]     [ ZAKUPY ]\n");
        String option = writer.nextLine().toLowerCase();
        Extras.clearConsole();
        
        switch (option){
        case "zakupy":
        	displayProducts();
        	break;
        case "koszyk":
        	cart.displayCart();
            break;
        default:
        	info();
        }
	}
	
	public void displayProducts() {
		Extras.clearConsole();
		System.out.println("\033[1mWyświetlanie produktów... Znaleziono " + listaArtykulow.size() + " produktów.\n\033[0m"); 
//		 System.out.println("Wyświetlanie produktów... Znaleziono " + listaArtykulow.size() + " produktów.\n");
		 System.out.println("+-------------------------------------------------------------+");
		 System.out.println("|                                                             |");
		 
		 int position = 1;
		 System.out.println("     0 - Filtry cenowe");
		 
	     for (Artykuly artykul : listaArtykulow) {
            System.out.println("     " + position + " - " + artykul.getPrice() + " Zl"  + "   "+ artykul.getName());
            position++;
        }
		System.out.println("|                                                             |");
		System.out.println("+-------------------------------------------------------------+");
	    System.out.print("\n\nCo cie interesuje? (cyfra na klawiaturze z zakresu produktow na ekranie): ");
	    int option;
	    

	    while (true) {
            if (writer.hasNextInt()) {
                option = writer.nextInt();
                
                if (option<position && option>=0) {
                    break;
                } else {
                    System.out.print("Z ZAKRESU produktow na ekranie: ");
                }
            } else {
                String input = writer.next();
                System.out.print("CYFRA z klawiatury: ");
            }
	    }
	    
	    descriptionDisplay(option);
	}
	
	public void displayWithFilters() {
		Extras.clearConsole();
		 

		 Double min,max;
		 System.out.println("Podaj minimalną kwotę: ");
		 while (true) {
			 if (writer.hasNextDouble()) {
	         	 min = writer.nextDouble();
	         	 break;
			 } else {
	             String input = writer.next();
	             System.out.print("no to niezla cena: ");
	         }
		 }
		 System.out.println("Podaj maksymalną kwotę: ");
		 while (true) {
			 if (writer.hasNextDouble()) {
	         	 max = writer.nextDouble();
	         	 break;
			 } else {
	                String input = writer.next();
	                System.out.print("cyfra kurwo: ");
	         }
		 }
		 Extras.clearConsole();
		 
		 
		 System.out.println("Aktualne filtry:");
		 System.out.println("Kwota minimalna - " + min);
		 System.out.println("Kwota maksymalna - " + max + "\n");
		 int positions = 0;
		 for (Artykuly artykul : listaArtykulow) {
		        if (artykul.getPrice() >= min && artykul.getPrice() <= max) {
		        	positions++;
		        }
	        }
		 
		 
		 int position = 1;
		 
		 if(positions==0) {
			 System.out.println("\nBRAK PRODUKTOW W WYBRANYM PRZEDZIALE CENOWYM\n");
			 System.out.println("     0 - Zmien filtr\n\n");
		 } else {
			 System.out.println("Wyświetlanie produktów... Znaleziono " + positions + " produktów.");
			 System.out.println("+-------------------------------------------------------------+");
			 System.out.println("|                                                             |");
			
			 System.out.println("     0 - Zmien filtr");
			 
		    for (Artykuly artykul : listaArtykulow) {
		    	double cena = artykul.getPrice();
		        if (cena >= min && cena <= max) {
		            System.out.println("     " + position + " - " + cena + " Zl" + "   " + artykul.getName());
		            position++;
		        }
	        }
		    
			System.out.println("|                                                             |");
			System.out.println("+-------------------------------------------------------------+");
		 }
		
		 System.out.print("\n\nCo cie interesuje? (wprowadz cyfre z klawiatury z zakresu produktow): ");
		 
	    int option;
	    
	    while (true) {
            if (writer.hasNextInt()) {
                option = writer.nextInt();
                
                if (option<position && option>=0) {
                    break;
                } else {
                    System.out.print("Z ZAKRESU PRODUKTOW: ");
                }
            } else {
                String input = writer.next();
                System.out.print("cyfre ARABSKA: ");
            }
	    }
	    
	    descriptionDisplay(option);
	}
	
	public void descriptionDisplay(int option) {
		Extras.clearConsole();
		System.out.println(option);
	    switch(option) {
	    case 0:
	    	System.out.println("filtry");
	    	displayWithFilters();
	    	break;
	    default:
	    	option--;
	    	String opisArtykulu = listaArtykulow.get(option).getDescription();
            String nazwaArtykulu = listaArtykulow.get(option).getName();
	    	if (option >= 0 && option < listaArtykulow.size()) {
                option++;
                System.out.println("\033[1m" + nazwaArtykulu + "\033[0m \n\n   " + opisArtykulu + "\n\n\n");
            }



            String whatNext;
            while (true) {
            	Extras.clearConsole();
            	System.out.println("\033[1m" + nazwaArtykulu + "\033[0m \n\n   " + opisArtykulu + "\n\n\n");
                System.out.println("[ + KOSZYK ]     [ WROC ]");
                whatNext = writer.nextLine().toLowerCase();
                
     

                if (whatNext.equals("koszyk") || whatNext.equals("wroc")) {
                    System.out.println("Wybrałeś: " + whatNext);
                    break;
                } else {
                    System.out.println("NUH UH\n\nJeszcze raz");
                }
            }

        

			switch(whatNext) {
            case "koszyk":
            	Extras.clearConsole();
            	Artykuly newInCart = listaArtykulow.get(option-1);
            	String newName = newInCart.getName();
            	Double newPrice = newInCart.getPrice();
            	cart.addToCart(newName, newPrice);
            	
            	System.out.println("\033[1;30m + dodano do koszyka " + newName + ".\n\033[0m");
            	
            	
            	String whatNextLater;
            	while (true) {
                    System.out.println("[ KOSZYK ]     [ ZAKUPY ]");
                    whatNextLater = writer.nextLine().toLowerCase();

                    if (whatNextLater.equals("koszyk") || whatNextLater.equals("zakupy")) {
                        System.out.println("Wybrałeś: " + whatNextLater);
                        break;
                    } else {
                        System.out.println("! Zła wartość !");
                    }
                }
            	
            	switch(whatNextLater) {
            	case "koszyk":
            		cart.displayCart();
            		break;
            	case "zakupy":
            		displayProducts();
            		break;
            	}
            	break;
            case "wroc":
            	displayProducts();
            	break;
            }
            
	    }
	}
}
