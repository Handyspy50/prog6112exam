/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsales1;

/**
 *
 * @author nkosi
 */
public class PrintProduct {

    public void printTotalProductSales(Product product) {
        System.out.println("Total Products Sold: "
                + product.GetTotalProductsSold());
    }

    public void printAverageProductSales(Product product) {
        System.out.println("Average Products Sold: "
                + product.GetAverageProductSold());
    }

    public void printMostPopularProduct(Product product) {
        System.out.println("Most Popular Product: "
                + product.GetMostPopularProduct());
    }
}

