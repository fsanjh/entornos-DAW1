
import com.mycompany.poo10_rectangulo.Rectangulo;
/*import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;*/
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nocturno
 */
public class RectanguloTest {
    @Test
    void testAncho(){
        int ancho = 20;
        Rectangulo rect = new Rectangulo (ancho, 40);
        assertEquals(ancho, rect.getAncho());
    
    }
    
    @Test
    void testLargo(){
        int largo = 40;
        Rectangulo rect = new Rectangulo (20, largo);
        assertEquals(largo, rect.getLargo());
    
    }
    
    @Test
    void testArea(){
        int area = 20 * 40;
        Rectangulo rect = new Rectangulo (20, 40);
        assertEquals(area, rect.getArea());
    
    }
    
}
