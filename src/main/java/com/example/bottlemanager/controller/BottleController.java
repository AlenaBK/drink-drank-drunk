package com.example.bottlemanager.controller;


import com.example.bottlemanager.model.Bottle;
import com.example.bottlemanager.service.BottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class BottleController {
    private BottleService bottleService;

    @Autowired(required = true)
    @Qualifier(value = "bottleService")
    public void setBottleService(BottleService bottleService) {
        this.bottleService = bottleService;
    }

    @RequestMapping(value = "bottles", method = RequestMethod.GET)
    public String listBottles(Model model) {
        model.addAttribute("bottle", new Bottle());
        model.addAttribute("listBottles", this.bottleService.listBottles());
        return "bottles";
    }

    @RequestMapping(value = "/bottles/add", method = RequestMethod.POST)
    public String addBottle(@ModelAttribute("bottle") @Valid Bottle bottle, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/bottledata";
        }
        if (bottle.getId() == 0) {
            this.bottleService.addBottle(bottle);
        } else {
            this.bottleService.updateBottle(bottle);
        }
        return "redirect:/bottles";
    }


    @RequestMapping("/remove/{id}")
    public String removeBottle(@PathVariable("id") int id) {
        this.bottleService.removeBottle(id);

        return "redirect:/bottles";
    }

    @RequestMapping("edit/{id}")
    public String editBottle(@PathVariable("id") int id, Model model) {
        model.addAttribute("bottle", this.bottleService.getBottleById(id));
        model.addAttribute("listBottles", this.bottleService.listBottles());

        return "bottles";
    }

    @RequestMapping("bottledata/{id}")
    public String bottleData(@PathVariable("id") int id, Model model) {
        model.addAttribute("bottle", this.bottleService.getBottleById(id));

        return "bottledata";
    }
}
