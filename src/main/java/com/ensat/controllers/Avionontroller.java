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
 * avion controller.
 */
@Controller
@RequestMapping(value = "/admin/")
public class Avionontroller {

	@Autowired
    private AvionService avionService;
	
	@Autowired
    private AppareilService appareilService;

	/**
     * List all avions.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "avions", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("avions", avionService.listAllAvions());
        return "admin/avion/avions";
    }
    

    // Afficher le formulaire de modification du avion
    @RequestMapping("avion/edit/{imm}")
    public String edit(@PathVariable String imm, Model model) {
    	Avion avion = avionService.findByImm(imm);
    	model.addAttribute("allAppreils", appareilService.listAllAppareils());
        model.addAttribute("avion", avion);
        return "admin/avion/avionedit";
    }

    /**
     * New avion.
     *
     * @param model
     * @return
     */
    @RequestMapping("avion/new")
    public String newavion(Model model) {
    	model.addAttribute("allAppreils", appareilService.listAllAppareils());
        model.addAttribute("avion", new Avion());
        return "admin/avion/avionnew";
    }

    /**
     * Save avion to database.
     *
     * @param avion
     * @return
     */
    @RequestMapping(value = "avion", method = RequestMethod.POST)
    public String saveavion(@Valid @ModelAttribute("avion")  Avion avion, BindingResult result, Model model) {
    	if (result.hasErrors()) {
            return "admin/avion/avionform";
        }
    	Appareil appareil = appareilService.findByCode(avion.getAppareil());
    	avion.setTuaff(appareil.getTuaff());
    	avion.setType(appareil.getType());
    	avion.setCapacite(appareil.getSo());
        avionService.saveAvion(avion);
        return "redirect:/admin/avions";
    }

    /**
     * Delete avion by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("avion/delete/{imm}")
    public String delete(@PathVariable String imm) {
        avionService.deleteAvion(avionService.findByImm(imm));
        return "redirect:/admin/avions";
    }

}
