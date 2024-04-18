/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

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
public class testAssertArrayEquals {
    
    public testAssertArrayEquals() {
    }
    
        
    @Test
    public void testAssertArrayEquals2(){
        String [] nombresEsperados = {"java", "junit", "jboss"};
        String [] nombresActuales = {"java", "junit", "jon server"};
        
        assertArrayEquals(nombresEsperados, nombresActuales, "Fallo - no son iguales");
    }
    
    @Test
    public void testAssertArrayEquals3(){
        int [] nombresEsperados = {1, 4, 6};
        int [] nombresActuales = {1, 4, 5};
        
        assertArrayEquals(nombresEsperados, nombresActuales, "Fallo - no son iguales");
    }
    
    @Test
    public void testAssertArrayEquals4(){
        boolean [] nombresEsperados = {false, true, true};
        boolean [] nombresActuales = {true, true, true};
        
        assertArrayEquals(nombresEsperados, nombresActuales, "Fallo - no son iguales");
    }
    
    
    
}
