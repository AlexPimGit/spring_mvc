package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller//
@RequestMapping("/")
public class CarController {
    @RequestMapping(value = "cars", method = RequestMethod.GET)//Value — это адрес в браузере; Method — метод запроса
    public String printCars(ModelMap model) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1,"Porshe",100));
        carList.add(new Car(2,"Lada",8));
        carList.add(new Car(3,"Moskvich",50));
        model.addAttribute("carList", carList);
        return "cars";//вернет строку-название jsp страницы
    }
}
