package ru.devray.schools.loggerdemo.vegetablebase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.devray.schools.loggerdemo.vegetablebase.food.GreenFood;

import java.util.List;

public class SimpleTest2 {

    @Test
    @DisplayName("Сгенерированный список фруктов и овощей сгенерировался не пустым.")
    void testGreenFoodGeneration(){
        //1. набор шагов
        GreenFoodBase base = new GreenFoodBase();
        List<GreenFood> list = base.generateGreenFoods();

        Assertions.assertNotNull(list);
    }

    @Test
    @DisplayName("Проверка того, что минимальная длина сгенерированного списка овощей и фруктов = 30")
    public void testGreenFoodListLength(){
        //1. набор шагов
        GreenFoodBase base = new GreenFoodBase();
        List<GreenFood> list = base.generateGreenFoods();

        Assertions.assertTrue(list.size() >= 30);
    }

}
