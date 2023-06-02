package com.sheryians.major.controller;

import com.sheryians.major.dto.LoginData;
import com.sheryians.major.model.Product;
import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping({"/","/home"})
    public String home(Model model){
       return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProducts());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(@PathVariable int id, Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getProductByCategoryId(id));
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(@PathVariable long id, Model model){
        model.addAttribute("product",productService.getProductById(id).get());
        return "viewProduct";
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        return "login";
    }

    @GetMapping("/process")
    public String processForm(@Valid @ModelAttribute ("loginData")LoginData loginData, BindingResult result){
        if(result.hasErrors()){
            System.out.println(result);
        }
        System.out.println(loginData);
        return "success";
    }


}
