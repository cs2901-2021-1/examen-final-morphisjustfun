package cs.lab;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;


class CSTranslatorTest {
    static final Logger logger = Logger.getLogger(Main.class.getName());

    @Test
    public void test1(){
        assertEquals(3, 3);
    }
};
