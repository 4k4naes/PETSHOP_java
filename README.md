# Pet Shop Application Documentation

## Overview

The Pet Shop Application is a Java-based command-line application that simulates a pet shop. It allows users to browse, view details, and purchase various pet-related products. The application includes functionalities such as displaying products, adding them to the shopping cart, viewing the cart contents, and making purchases.

## Usage

To use the Pet Shop Application, follow these steps:

1. Clone the repository to your local machine.

```
git clone https://github.com/4k4naes/PETSHOP_java
```

2. Ensure you have Java installed.
3. Open the project in your preferred Java IDE.
4. Compile and run the `Main` class to start the application.
5. Follow the prompts to navigate through the application's functionalities.

## Features

### Main Class

The `Main` class serves as the entry point of the application. It initializes the `Display` class and starts the application by calling the `info()` method.

### Display Class

The `Display` class handles user interaction and displays the main menu and product information. It includes methods for displaying products, adding them to the shopping cart, and navigating through the application.

### Artykuly Class

The `Artykuly` class represents a product in the pet shop. It stores information such as the product name, price, description, and quantity. The class also includes methods for reading product data from a file and managing product categories.

### Cart Class

The `Cart` class manages the shopping cart functionality. It allows users to add products to the cart, view the contents of the cart, remove products, and make purchases.

## Usage Examples

- Adding Products to the shop:

The file products.txt contains the informations about the products, seperated by a semicolon (;). Append a list manualy to add a product to display.

*Example:*  super karma dla kotkow;30.90;super bombowa karma dla kotow;90

Where: String name; double price; String description; int quantity

## File Structure

- **Main.java**: Entry point of the application.
- **Display.java**: Handles user interaction and displays product information.
- **Artykuly.java**: Represents a product and manages product data.
- **Cart.java**: Manages shopping cart functionality.
- **products.txt**: Contains product data in the format: name;price;description;quantity.
- **Extras.java**: Provides additional utility methods used in the Pet Shop Application.
