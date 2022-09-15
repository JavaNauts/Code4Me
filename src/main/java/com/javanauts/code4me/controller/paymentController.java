package com.javanauts.code4me.controller;

import com.javanauts.code4me.service.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class paymentController {

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

//Test CC info
    //#4032 0364 7603 7336
    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
        return "checkout";
    }

}
