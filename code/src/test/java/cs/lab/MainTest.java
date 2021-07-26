package cs.lab;

import org.testng.annotations.Test;

import cs.lab.utils.Reverse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



class CSTranslatorTest {
    @Test
    public void test1(){
        var data = new DataVacunacion("Actual");
        var centro = new CentroVacunacion("Grau");
        data.darAlta(centro);
        assertEquals(1,data.getCentrosVacunacion().size());
    }

    @Test
    public void test2(){
        assertEquals("abc",Reverse.reverse("cba"));
    }

    @Test
    public void test3(){
        var data = new DataVacunacion("Actual");
        assertEquals(7,data.getGruposEdad().grupos.size());
    }
    @Test
    public void test4(){
        var data = new DataVacunacion("Actual");
        assertEquals(7,data.getAvanceVacunacionCompleto().grupos.size());
    }
    @Test
    public void test5(){
        var data = new DataVacunacion("Actual");
        assertEquals(7,data.getAvanceVacunacion().grupos.size());
    }
};
