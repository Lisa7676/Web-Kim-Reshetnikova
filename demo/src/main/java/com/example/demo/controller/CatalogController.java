package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.net.URL;


@Controller
public class CatalogController {

    @GetMapping("/catalog")

    public ModelAndView getCard() {
        List<String> productName = Arrays.asList("Поводок-рулетка красный Flexi classic tape р.s 5м до 15кг", "Адресник силуэт джек-рассел Zooone v.i.pet со стразами гравировка 30х25мм",
                "Рулетка-трос Triol 8м до 20кг fd 9117-8", "Ошейник кожаный однослойный натуральный Аркон с украшениями 25мм/40-54см о25",
                "Лежак прямоугольный темно-синий Дарэлл оксфорд с подушкой 45х33х15см №0", "Домик трапеция Dogman бязь большая");
        List<Integer> productPrice = Arrays.asList(2085, 140, 770, 475, 504, 1491);
        List<String> productImg = Arrays.asList("https://moizver.com/upload/resize_cache/iblock/0d9/400_400_140cd750bba9870f18aada2478b24840a/0d9db94daeae09cb4e5f3698b19ff5fc.jpeg",
                "https://moizver.com/upload/resize_cache/iblock/067/400_400_140cd750bba9870f18aada2478b24840a/06796fc7ad4511a14eb2fb4d27968c84.jpg",
                "https://moizver.com/upload/iblock/e44/e44b118fd0db50e9f39bb21eb6cb1db8.jpg",
                "https://moizver.com/upload/resize_cache/iblock/b36/400_400_140cd750bba9870f18aada2478b24840a/b36134501e8170a96863f16b29cad9b9.jpg",
                "https://moizver.com/upload/resize_cache/iblock/4da/400_400_140cd750bba9870f18aada2478b24840a/4da378f7bb09b0a8f13390ed45499bc1.jpg",
                "https://moizver.com/upload/resize_cache/iblock/efc/400_400_140cd750bba9870f18aada2478b24840a/efc59990f2bb0728c4ea339cd08c8cdc.jpg");
        ModelAndView modelAndView = new ModelAndView("catalog-main");
        modelAndView.addObject("productName", productName);
        modelAndView.addObject("productPrice", productPrice);
        modelAndView.addObject("productImg", productImg);
        return modelAndView;

    }

}
