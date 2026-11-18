/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.productsalesapplication.ProductCalculations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nkosi
 */
public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calculation = new ProductCalculations(1000);
        assertEquals(150.0, calculation.GetVat(), 0.01);
    }

    @Test
    public void GetToatal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calculation = new ProductCalculations(1000);
        assertEquals(1200.0, calculation.GetTotal(), 0.01);
    }
}
