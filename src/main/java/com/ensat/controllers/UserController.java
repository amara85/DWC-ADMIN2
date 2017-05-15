package com.ensat.controllers;

import com.ensat.entities.User;
import com.ensat.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User controller.
 */
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * List all Users.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "admin/utilisateurs", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.listAllUsers());
        System.out.println("Returning users:");
        return "app1/user/users";
    }

    /**
     * View a specific User by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("admin/utilisateur/{username}")
    public String showUser(@PathVariable String username, Model model) {
        model.addAttribute("utilisateur", userService.findByUsername(username));
        return "app1/user/usershow";
    }

    // Afficher le formulaire de modification du User
    @RequestMapping("admin/utilisateur/edit/{username}")
    public String edit(@PathVariable String username, Model model) {
        model.addAttribute("utilisateur", userService.findByUsername(username));
        return "app1/user/userform";
    }

    /**
     * New User.
     *
     * @param model
     * @return
     */
    @RequestMapping("admin/utilisateur/new")
    public String newUser(Model model) {
        model.addAttribute("utilisateur", new User());
        return "app1/user/userform";
    }

    /**
     * Save User to database.
     *
     * @param User
     * @return
     */
    @RequestMapping(value = "admin/utilisateur", method = RequestMethod.POST)
    public String saveUser(User utilisateur) {
        userService.saveUser(utilisateur);
        return "redirect:/admin/utilisateur/" + utilisateur.getUsername();
    }

    /**
     * Delete User by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("admin/utilisateur/delete/{username}")
    public String delete(@PathVariable String username) {
        userService.deleteUser(userService.findByUsername(username));
        return "redirect:/admin/utilisateurs";
    }

}