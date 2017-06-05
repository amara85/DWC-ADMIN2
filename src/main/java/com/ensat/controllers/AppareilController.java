package com.ensat.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.Appareil;
import com.ensat.entities.Avion;
import com.ensat.services.AppareilService;
import com.ensat.services.AvionService;

/**
 * Appareil controller.
 */
@Controller
@RequestMapping(value = "/admin")
public class AppareilController {

	@Autowired
    private AppareilService appareilService;
	
	@Autowired
    private AvionService avionService;

	/**
     * List all Appareils.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "appareils", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("appareils", appareilService.listAllAppareils());
        return "admin/appareil/appareils";
    }
    

    // Afficher le formulaire de modification du Appareil
    @RequestMapping("appareil/edit/{appareilCode}")
    public String edit(@PathVariable String appareilCode, Model model) {
    	Appareil appareil = appareilService.findByCode(appareilCode);
        model.addAttribute("appareil", appareil);
        return "admin/appareil/appareiledit";
    }

    /**
     * New Appareil.
     *
     * @param model
     * @return
     */
    @RequestMapping("appareil/new")
    public String newAppareil(Model model) {
        model.addAttribute("appareil", new Appareil());
        return "admin/appareil/appareilnew";
    }

    /**
     * Save Appareil to database.
     *
     * @param Appareil
     * @return
     */
    @RequestMapping(value = "appareil", method = RequestMethod.POST)
    public String saveAppareil(@Valid @ModelAttribute("appareil")  Appareil appareil, BindingResult result, Model model) {
    	if (result.hasErrors()) {
            return "admin/appareil/appareilform";
        }
    	Appareil ancien = appareilService.findById(appareil.getId());
    	Iterable<Avion> avions = avionService.findByAppareil(ancien.getCode());
    	avionService.updateAvions(avions, appareil);
        appareilService.saveAppareil(appareil);
        return "redirect:/admin/appareils";
    }

    /**
     * Delete Appareil by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("appareil/delete/{appareilCode}")
    public String delete(@PathVariable String appareilCode) {
        appareilService.deleteAppareil(appareilService.findByCode(appareilCode));
        return "redirect:/admin/appareils";
    }

}
