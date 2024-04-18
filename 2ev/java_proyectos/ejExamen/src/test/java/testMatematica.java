
import com.mycompany.ejexamen.Matematica;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fsanj
 */
public class testMatematica{
    Matematica m1 = new Matematica(5, 3);
    Matematica m2 = new Matematica(3, 5);
    
    @Test
    @BeforeEach
    public void testConstructor(){
        assertNotNull(m1);
        assertNotNull(m2);
    }
    
    @Test
    public void testSumar(){
        assertEquals(8, m1.sumar());
    }
    
    @Test
    public void testMultiplicar(){
        assertEquals(15, m1.multiplicacion());
    }
    
    @Test
    public void testRestar1(){
        assertEquals(2, m1.restar());
    }
    
    @Test
    public void testRestar2(){
        assertEquals(0, m2.restar());
    }
    
    
    
    
}
