package com.ensat.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.services.DimtempsService;

/**
 * User controller.
 */
@Controller
public class RecetmoyController {
    
    @Autowired
    private DimtempsService dimtempsService;

    
    /**
     * retourner vue génerer recettes moyennes
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "admin/generer-recet-moy", method = RequestMethod.GET)
    public String genererRecetMoyVue(Model model) {
    	List<Integer> annees = dimtempsService.returnDistinctAnnee();
        model.addAttribute("annees", annees);
        return "admin/recetmoy/genererrecetmoy";
    }

    /**
     * Génerer les recettes moyennes
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "admin/generer-recet-moy", method = RequestMethod.POST)
    public String genererRecetMoy(Model model, HttpServletRequest request) {
    	String annee = request.getParameter("annee");
    	System.out.println("annee: "+annee);
    	List<Integer> annees = dimtempsService.returnDistinctAnnee();
        model.addAttribute("annees", annees);
        return "admin/recetmoy/genererrecetmoy";
    }


}
