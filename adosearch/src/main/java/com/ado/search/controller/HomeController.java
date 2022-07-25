/*
 * 
 */
package com.ado.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeController.
 */
@Controller
public class HomeController
{

    /**
     * Home.
     *
     * @return the string
     */
    @RequestMapping("/home")
    public String home()
    {
        return "redirect:/swagger-ui/";
    }

}
