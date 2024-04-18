/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.aritmeticatests.Aritmetica;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nocturno
 */
public class aritmeticaTest {
    
    private Aritmetica aritmetica;
    
    public aritmeticaTest() {
    }
    
    @BeforeEach
    public void init(){
        
        aritmetica = new Aritmetica();
    
    }
    
    /*@Test
    public void testSuma(){
        fail("Not yet implemented");
    
    }*/
    
    @Test
    public void testResta(){
        assertEquals(2.5f, aritmetica.resta(3f, 0.5f));
    }
    
    @Test
    public void testMult(){
        assertEquals(25f, aritmetica.multiplicacion(5f, 5f));
    }
    
    @Test
    public void testDivi(){
        assertEquals(2f, aritmetica.division(20f, 10f));
    }
    
}
