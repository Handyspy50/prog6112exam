/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsales1;

/**
 *
 * @author nkosi
 */
public class Product implements IProduct {
    
    String[] products = {
        "Cozy Nights Monarch Mattress",
        "Restonic Barbados Mattress",
        "Sealy Phuket Mattress"
    };

    int[][] sales = {
        {25, 18, 20},
        {15, 10, 12},
        {18, 15, 20}
    };

    public int GetTotalProductsSold() {
        int total = 0;

        for (int[] sale : sales) {
            for (int j = 0; j < sale.length; j++) {
                total = total + sale[j];
            }
        }

        return total;
    }        
        
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        return total / 3.0;
    }

    public String GetMostPopularProduct() {
        int highest = 0;
        int position = 0;

        for (int i = 0; i < sales.length; i++) {

            int productTotal = 0;

            for (int j = 0; j < sales[i].length; j++) {
                productTotal = productTotal + sales[i][j];
            }
                
            if (productTotal > highest) {
                highest = productTotal;
                position = i;
            }
        }

        return products[position];
    }
}

