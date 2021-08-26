package ru.devray.schools.loggerdemo.vegetablebase;

import org.junit.jupiter.api.*;
import ru.devray.schools.loggerdemo.vegetablebase.food.GreenFood;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleTest {

    static GreenFoodBase base;

    @DisplayName("sdfsfd")
    @BeforeAll
    public static void setUp(){
        base = new GreenFoodBase();
        System.out.println("in before all");
    }

    @Tags(
            {@Tag("smoke"),
             @Tag("integration-testing")}
    )
    @Tag("smoke")
    @Test
    void testGreenFoodGeneration(){
        System.out.println("test call");
        List<GreenFood> list = base.generateGreenFoods();
        Assertions.assertNotNull(list);
    }

    @Test
    public void testGreenFoodListLength(){
        System.out.println("test call111231243254325w52543");
        List<GreenFood> list = base.generateGreenFoods();
        Assertions.assertTrue(list.size() >= 30);
    }

    @Test
    public void testGreenFoodListLengthAnother(){
        System.out.println("test call");
        List<GreenFood> list = base.generateGreenFoods();
        Assertions.assertTrue(list.size() >= 30);
    }

    @Disabled
    @Test
    public void testGreenFoodListLengthAnother2(){
        base = null;
    }


    //FAILED
    @Test
    public void testThatShouldThrowException(){
        Assertions.assertThrows(
                RuntimeException.class,
                () -> {
                    generateException();
                }
        );
    }

    public static void generateException(){
        throw new StackOverflowError();
    }

    //BROKEN
    @Test
    public void brokenTest(){
        String s = null;
        s.toLowerCase();
        Assertions.assertTrue(s != null);
    }

}
