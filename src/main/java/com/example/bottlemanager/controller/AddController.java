//package com.example.bottlemanager.controller;
//
//import com.example.bottlemanager.model.Bottle;
//import com.example.bottlemanager.service.BottleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/addnewbottle")
//public class AddController {
//
//    private BottleService bottleService;
//
//    @Autowired(required = true)
//    @Qualifier(value = "bottleService")
//    public void setBottleService(BottleService bottleService) {
//        this.bottleService = bottleService;
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String signup(ModelMap model) {
//        model.put("bottle", new Bottle());
//        return "bottles";
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public String processSignup(@Valid final Bottle bottle, final BindingResult result) {
//        if (result.hasErrors()) {
//            return "bottles";
//        }
//                if (bottle.getId() == 0) {
//            this.bottleService.addBottle(bottle);
//        } else {
//            this.bottleService.updateBottle(bottle);
//        }
//        return "bottles";
//    }
//}
