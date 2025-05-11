package com.example2.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculadoraController {

    @Autowired
    private PostfixCalculatorService service;

 // Página inicial com formulário
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Processa a expressão enviada pelo formulário
    @PostMapping("/calcular")
    public String calcular(@RequestParam String expressao, Model model) {
        try {
            double resultado = service.calcularExpressao(expressao);
            model.addAttribute("resultado", resultado);
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
        }
        return "index";
    }
}