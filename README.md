#E-commerce-order-processing

Overview
This project simulates a basic e-commerce order processing system. It calculates the total cost of an order, applies any discounts or promotions, and returns the final price after these adjustments. It demonstrates how to use Java Stream API and Optional to handle complex operations and optional values like discounts and promotions in a clean and declarative way.

Features
Item Management: Items with their names and prices are added to the order.
Discount Handling: Applies percentage-based or fixed amount discounts.
Promotion Handling: Implements a basic "Buy One Get One Free" promotion.
Optional Handling: Uses Optional to handle missing or absent values like discounts or promotions.

Requirements
Java 8 or higher is required to run this project because it uses features like Stream API and Optional.

Setup
Clone this repository or download the Java file.

Compile and Run the Program: If you're using the command line:

bash
Copy code--
javac OrderProcessing.java
java OrderProcessing

How It Works
Item Class:
Represents the items in the order. Each item has a name and a price.
Discount Class:
Handles percentage-based or fixed amount discounts. It calculates the discount amount based on the total price.
Promotion Class:
Implements a "Buy One Get One Free" promotion. If the order contains more than one item, the cheapest item is free.
Order Processing:
The program first calculates the total price of the order.
It then applies any available discount.
After that, any applicable promotion is applied.
Finally, it prints out the total price before and after the discount and promotion.
Optional Class:
Optional is used to handle values that might be missing, like when there is no discount or promotion available.
The Optional.map() method is used to apply a discount or promotion only if they are present.

License
This project is licensed under the MIT License - see the LICENSE file for details.
