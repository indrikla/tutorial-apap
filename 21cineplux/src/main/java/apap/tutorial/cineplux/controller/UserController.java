package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.passay.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value= "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model,
                                 RedirectAttributes redirAttrs) {
        List<Rule> rules = new ArrayList<>();
        rules.add(new LengthRule(8,30));
        rules.add(new WhitespaceRule());
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

        PasswordValidator validator = new PasswordValidator(rules);
        PasswordData password = new PasswordData(user.getPassword());
        RuleResult result = validator.validate(password);

        if(result.isValid()){
            userService.addUser(user);
            model.addAttribute("user", user);
            return "redirect:/";
        } else {
            redirAttrs.addFlashAttribute("message", validator.getMessages(result));
            return "redirect:/user/add";
        }
    }
    @PostMapping(value= "/delete")
    private String deleteUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.deleteUser(user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    private String listUser(Model model) {
        List<UserModel> listUser = userService.getListUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/update/password")
    @PreAuthorize("isAuthenticated()")
    public String changeUserPassword() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        System.out.println(SecurityContextHolder.getContext());
        return "update-password";
    }

    @PostMapping("/update/password")
    @PreAuthorize("isAuthenticated()")
    public String changeUserPassword(Model model,
                                     @RequestParam("newConfirmPassword") String newConfirmPassword,
                                     @RequestParam("newPassword") String newPassword,
                                     @RequestParam("oldPassword") String oldPassword,
                                     RedirectAttributes redirAttrs) {
        UserModel user = userService.findUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());

        if (!userService.checkIfValidOldPassword(user, oldPassword)) {
            redirAttrs.addFlashAttribute("message", "Password Lama salah");
            return "redirect:/user/update/password";
        }

        if (!newPassword.equals(newConfirmPassword)) {
            redirAttrs.addFlashAttribute("message", "Password Baru berbeda");
            return "redirect:/user/update/password";
        }

        List<Rule> rules = new ArrayList<>();
        rules.add(new LengthRule(8,30));
        rules.add(new WhitespaceRule());
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

        PasswordValidator validator = new PasswordValidator(rules);
        PasswordData password = new PasswordData(newConfirmPassword);
        RuleResult result = validator.validate(password);

        if(result.isValid()){
            userService.changeUserPassword(user, newPassword);
            model.addAttribute("message", "Berhasil mengganti password");
            return "update-password-result";
        } else {
            redirAttrs.addFlashAttribute("message", validator.getMessages(result));
            return "redirect:/user/update/password";
        }
    }
}
