
public class Extras {
	
	public static void clearConsole() {
	    try {
	        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "cls");
	        
	        processBuilder.inheritIO().start().waitFor();
	    } catch (final Exception e) {
	        System.out.println("Błąd podczas czyszczenia konsoli: " + e.getMessage());
	    }
	}
	
	public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
