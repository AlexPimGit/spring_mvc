package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller//
@RequestMapping("/")
public class CarController {
    @Autowired
    private CarServiceImpl carService;

    @RequestMapping(value = "cars", method = RequestMethod.GET)//Value — это адрес в браузере; Method — метод запроса
        public String printCars(ModelMap model) {
        model.addAttribute("carList", carService.getCars());
        return "cars";//вернет строку-название jsp страницы
    }
}
