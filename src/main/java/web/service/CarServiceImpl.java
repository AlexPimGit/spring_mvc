package web.service;


import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1, "Porshe", 100));
        carList.add(new Car(2, "Lada", 8));
        carList.add(new Car(3, "Moskvich", 50));
        carList.add(new Car(4, "Geely", 15));
        return carList;
    }
}
