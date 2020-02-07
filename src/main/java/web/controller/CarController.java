package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private List<Car> carList;

    @RequestMapping(value = "cars", method = RequestMethod.GET)//Value — это адрес в браузере; Method — метод запроса
        public String printCars(ModelMap model) {
        model.addAttribute("carList", carList);
        return "cars";//вернет строку-название jsp страницы
    }
}
