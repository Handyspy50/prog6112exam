/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsales1;

/**
 *
 * @author nkosi
 */
public class ProductSales1 {

    public static void main(String[] args) {

        Product product = new Product();
        PrintProduct report = new PrintProduct();

        System.out.println("================================");
        System.out.println("       MATTRESS SALES REPORT");
        System.out.println("================================");

        report.printTotalProductSales(product);
        report.printAverageProductSales(product);
        report.printMostPopularProduct(product);

        System.out.println("================================");
    }
}

