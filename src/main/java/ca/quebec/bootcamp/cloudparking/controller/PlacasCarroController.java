package ca.quebec.bootcamp.cloudparking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("informacoes")
public class PlacasCarroController {

    @GetMapping("/placa")
    public String getInformacoesPlaca(){
        return "BMW";
    }
}
