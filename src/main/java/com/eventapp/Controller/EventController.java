package com.eventapp.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Use Controller for Thymeleaf
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventapp.entity.EventRegistration;
import com.eventapp.repo.EventRepo;
import com.eventapp.service.EventService;


@Controller // Change to Controller for Thymeleaf views
public class EventController {

    @Autowired
    private EventService service;
//    @Autowired
//    private EventRepo eventRepo;

    @GetMapping("/")
    public String showForm(Model model) {
        // Providing an empty EventRegistration object for form binding
        model.addAttribute("eventRegistration", new EventRegistration());
        return "index";
    }

    @GetMapping("/register")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/dashboard")
    public String showBookings(Model model) {
        var events = service.getAllEvents();
        model.addAttribute("events", events);
        return "dashboard";
    }

    @PostMapping("/register")
    public String registerEvent(@ModelAttribute EventRegistration eventRegistration, BindingResult bindingResult,
            RedirectAttributes redirectAttributes)  {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Failed to register event. Please correct the errors.");
            return "redirect:/register";
        }

        try {
        	
            // Save the registration data
            service.saveEvent(eventRegistration);
            redirectAttributes.addFlashAttribute("success", "Event successfully registered!");
            return "redirect:/register";  // Redirect to clear form data and show flash message
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred during registration. Please try again.");
            return "redirect:/register";
        }
    }
}
