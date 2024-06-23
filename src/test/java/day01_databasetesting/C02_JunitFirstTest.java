package day01_databasetesting;

import org.junit.Assert;
import org.junit.Test;

public class C02_JunitFirstTest {

    @Test
    public void test1(){
        /* assertEquals(expectedData,actualData); Parantez icinde belirtilen iki degerin esit olup olmadigini kontrol
        eder. Esitse test gecer, degilse test kalir.       */

        String expectedData="selenium";
        String actualData="selenium";
        Assert.assertEquals(expectedData,actualData);
    }

    @Test
    public void test2(){
        /* assertTrue(boolean)); Bir kosulun true olup olmadigini kontrol eder.
        Parantez icindeki deger true ise test gecer, false ise test kalir.         */

        Assert.assertTrue("selenium".contains("e"));        //pass
    }

    @Test
    public void test3(){
        /* assertFalse(BOOLEAN); Bir kosulun false olup olmadigini kontrol eder.
         Eger parantez icindeki deger false ise test gecer true ise test kalir.      */

        Assert.assertFalse("JAVA".contains("E"));            //PASS
        Assert.assertFalse("SELENIUM".contains("E"));        //FAIL
    }

    @Test
    public void test4(){
        /*Assert.assertNotEquals() parantez icinde belirtilen parametreler esit degilse test gecer, esitse test kalir.*/

        Assert.assertNotEquals("selenium","java");                 //pass

        System.out.println("bu mesaji konsolda görebileceğiz cunku fail yok");

        Assert.assertNotEquals("selenium","selenium");             //fail

        System.out.println("bu mesaji konsolda göremeyeceğiz");

    }
}











