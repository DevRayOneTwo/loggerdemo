package ru.devray.schools.loggerdemo.vegetablebase.stores;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.devray.schools.loggerdemo.vegetablebase.Box;
import ru.devray.schools.loggerdemo.vegetablebase.food.GreenFood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Store {

    static final Logger LOG = LogManager.getRootLogger();

    public StoreBrand brand;
    public int id;
    public List<Box<GreenFood>> localStorage;
    public HashMap<String, Integer> storageStatistics;

    public Store(StoreBrand brand) {
        this.brand = brand;
        this.id = (int)(Math.random() * 100000);
        this.localStorage = new ArrayList<>();
        this.storageStatistics = new HashMap<>();
        LOG.debug("Создан объект магазина с id = " + id);
    }

}
