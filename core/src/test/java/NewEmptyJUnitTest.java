/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.ams.character.Body;
import com.ams.character.BodyType;


/**
 *
 * @author noah
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void basicbodytest(){
        Body testbody =  new Body("Joe's Body", "human");
        assert(testbody.getName().equals("Joe's Body"));
        testbody.setName("Alan");
        assert(testbody.getName().equals("Alan"));
    }
    
    @Test
    public void basicbodyparttest(){
        Body testbody =  new Body("Joe's Body", "human");
        assert(testbody.getName().equals("Joe's Body"));
        testbody.setName("Alan");
        assert(testbody.getName().equals("Alan"));
    }
    
    @Test
    public void success(){
        assert(true);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
