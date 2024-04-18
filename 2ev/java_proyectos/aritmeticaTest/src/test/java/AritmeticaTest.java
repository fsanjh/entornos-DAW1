/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.aritmeticatest.Aritmetica;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author Nocturno
 */
@TestMethodOrder(OrderAnnotation.class)
public class AritmeticaTest {
    
    public AritmeticaTest() {
    }
    
    @Test
    @Order(2)
    public void testSuma(){
        System.out.println("suma");
        Aritmetica a1 = new Aritmetica(5, 7);
        assertEquals(12, a1.suma());
    }
    @Test
    @Order(4)
    public void testResta(){
        System.out.println("resta");
        Aritmetica a1 = new Aritmetica(5, 7);
        assertEquals(-2, a1.resta());
    }
    @Test
    @Order(1)
    public void testMult(){
        System.out.println("mult");
        Aritmetica a1 = new Aritmetica(5, 7);
        assertEquals(30, a1.mult());
    }
    @Test
    @Order(3)
    public void testDivi(){
        System.out.println("divi");
        Aritmetica a1 = new Aritmetica(5, 7);
        assertEquals(0.5, a1.divi());
    }
    
    
    
    
}
