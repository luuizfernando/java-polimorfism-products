package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
        public static void main(String[] args) {
                Locale.setDefault(Locale.US);
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter the number of products: ");
                int quantity = sc.nextInt();
                List<Product> list = new ArrayList<>();
                for (int i = 0 ; i < quantity ; i++) {
                        System.out.println("Product #" + ( i + 1 ) + " data:");
                        System.out.print("Common, used or imported (c/u/i)? ");
                        char option = sc.next().charAt(0);
                        System.out.print("Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        if (option == 'c') {
                                list.add(new Product(name, price));
                        } else if (option == 'i') {
                                System.out.print("Customs fee: ");
                                double customFee = sc.nextDouble();
                                list.add(new ImportedProduct(name, price, customFee));
                        } else if (option == 'u') {
                                System.out.print("Manufacture date (DD/MM/YYYY): ");
                                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                list.add(new UsedProduct(name, price, date));
                        }
                }

                System.out.println("PRICE TAGS: ");
                for (Product p : list) {
                        System.out.println(p.priceTag());
                }

                sc.close();
        }
}