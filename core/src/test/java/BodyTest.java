import com.ams.character.Body;
import org.junit.Test;

/**
 *
 * @author noah
 */
public class BodyTest {
    @Test
    public void bodyHasAName(){
        Body testbody =  new Body("Joe's Body", "human");
        assert(testbody.getName().equals("Joe's Body"));
        testbody.setName("Alan");
        assert(testbody.getName().equals("Alan"));
    }
}
