package com.vpelizzari.dslist.Controllers;

import java.util.List;

import com.vpelizzari.dslist.Services.GameService;
import com.vpelizzari.dslist.dto.GameDTO;
import com.vpelizzari.dslist.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //definindo como controlador
@RequestMapping(value = "/games") //mapeando os recursos - definindo o valor como "/games" - aquilo que vem no final do link (/produtos, /clientes...)
public class GameController {

    //puxando uma instância, e injetando a instância do GameService dentro do GameController
    @Autowired
    private GameService gameService;

    //apresenta o game buscado pelo id
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) { //configurando para que o ID da requisição do Postman seja correspondente
        GameDTO result = gameService.findById(id);
        return result;
    }

    //apresenta games simplificado
    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
