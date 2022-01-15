/*
 * 
 */
package com.freenow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeController.
 */
@Controller
@ApiIgnore
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
