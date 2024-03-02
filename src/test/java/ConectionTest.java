import com.escuelaing.principal.HttpConection;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
public class ConectionTest {

    @Test
    public void testHttpConnection() throws IOException {

        String searchFilm = "Aquaman";

        HttpConection conexion = new HttpConection();


        String response1 = conexion.ResponseRequest(searchFilm);

        String response2 = conexion.ResponseRequest(searchFilm);

        Assert.assertEquals(response1,response2);



    }
}
