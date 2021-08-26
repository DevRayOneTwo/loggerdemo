package ru.devray.schools.loggerdemo.vegetablebase;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.devray.schools.loggerdemo.vegetablebase.food.*;
import ru.devray.schools.loggerdemo.vegetablebase.stores.Store;
import ru.devray.schools.loggerdemo.vegetablebase.stores.StoreDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GreenFoodBase {

    static final Logger LOG = LogManager.getRootLogger();

    List<Box<GreenFood>> baseStorage;

    public void initializeStartingSupplies(){

        generateGreenFoods().stream().map((g)->{
            Random random = new Random();
            Store randomStore = StoreDatabase.allStores.get(random.nextInt(StoreDatabase.allStores.size()));
            Box box = new Box(randomStore.id, randomStore.brand, g);
            LOG.trace("Сгенерирована коробка: " + box.toString());
            //System.out.println("Сгенерирована коробка: " + box.toString());
            return box;
        });
    }

    public List<GreenFood> generateGreenFoods(){
        List<GreenFood> generatedFood = new ArrayList<>();

        Random random = new Random();
        int greenFoodsCount = random.nextInt(30) + 30;
        LOG.info(String.format("Будет сгенерировано %d партий растительных продуктов.", greenFoodsCount));

        for(int i=0; i<greenFoodsCount; i++) {
            int greenFoodChoice = random.nextInt(4);
            double price = random.nextDouble() * 30 + 10;
            double mass = random.nextDouble() * 5 + 20;

            GreenFood greenFood;
            switch (greenFoodChoice) {
                case 0:
                    greenFood = new Apple(price, mass);
                    break;
                case 1:
                    greenFood = new Banana(price, mass);
                    break;
                case 2:
                    greenFood = new Cabbage(price, mass);
                    break;
                case 3:
                default:
                    greenFood = new Potato(price, mass);
                    break;
            }
            LOG.trace("Сгенерирована еда:"+greenFood);
            generatedFood.add(greenFood);
        }

        return generatedFood;
    }
}
