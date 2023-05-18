package testng_knowledge;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_TestNG_Annotations {

    @BeforeMethod
    public void setUp(){
        System.out.println("All the setups");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("All the post conditions");
    }

    @Test
    public void test1(){
        System.out.println("This is test1");
    }

    @Test
    public void test2(){
        System.out.println("This is test2");
    }

    @Test
    public void test3(){
        System.out.println("This is test3");
    }

}
