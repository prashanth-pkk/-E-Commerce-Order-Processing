package org.pk;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OrderProcessing {
    public record Item(String name, double price) {

        public String toString() {
            return name + " " + price;
        }
    }

    public static class Discount {
        private final double percentage;
        private final double fixedDiscountAmount;

        public Discount(double percentage, double fixedDiscountAmount) {
            this.percentage = percentage;
            this.fixedDiscountAmount = fixedDiscountAmount;
        }

        public String toString() {
            return percentage + " " + fixedDiscountAmount;
        }

        public Optional<Double> getDiscountAmount(double totalPrice) {
            if (percentage > 0) {
                return Optional.of(totalPrice * percentage / 100);
            } else if (fixedDiscountAmount > 0) {
                return Optional.of(fixedDiscountAmount);
            }
            return Optional.empty();
        }
    }

    public static class Promotion {
        private final String promotionType;

        public Promotion(String promotionType) {
            this.promotionType = promotionType;
        }

        public Optional<Double> applyPromotion(List<Item> itemList) {
            if ("OFFK".equals(promotionType)) {
                if (itemList.size() > 2) {
                    return Optional.of(itemList.get(0).price());
                }
            }
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        List<Item> order1 = Arrays.asList(
                new Item("Laptop", 1200.00),
                new Item("Mouse", 25.00),
                new Item("Keyboard", 45.00),
                new Item("Furniture", 1400.00),
                new Item("Car", 2100.00)
        );
        List<Item> order2 = Arrays.asList(
                new Item("Book", 15.00),
                new Item("Pen", 2.00)
        );
        List<Item> order3 = Arrays.asList(
                new Item("Furniture", 1100.0),
                new Item("chairs", 350.0),
                new Item("bicycle", 450.0)
        );

        Discount discount = new Discount(10, 0);
        Promotion promotion = new Promotion("OFFK");

        processOrder(order1, discount, promotion);
        processOrder(order2, discount, promotion);
        processOrder(order3, discount, promotion);
    }

    private static void processOrder(List<Item> order, Discount discount, Promotion promotion) {
        double totalPrice = order.stream()
                .mapToDouble(Item::price)
                .sum();

        Optional<Double> discountAmount = discount.getDiscountAmount(totalPrice);
        Optional<Double> promotionAmount = promotion.applyPromotion(order);

        double finalPrice = discountAmount
                .map(amount -> totalPrice - amount)
                .orElse(totalPrice);

        double finalPrice1 = finalPrice;
        finalPrice = promotionAmount
                .map(amount -> finalPrice1 - amount)
                .orElse(finalPrice);


        System.out.println("Total Price Before Discount and Promotion: $" + totalPrice);
        System.out.println("Discount Applied: $" + discountAmount.orElse(0.0));
        System.out.println("Promotion Applied: $" + promotionAmount.orElse(0.0));
        System.out.println("Final Price After Discount and Promotion: $" + finalPrice);
        System.out.println("----------");
    }


}
