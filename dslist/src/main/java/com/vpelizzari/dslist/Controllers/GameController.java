package com.vpelizzari.dslist.Controllers;

import com.vpelizzari.dslist.Services.GameService;
import com.vpelizzari.dslist.dto.GameMinDTO;
import com.vpelizzari.dslist.entities.Game;
import com.vpelizzari.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //definindo como controlador
@RequestMapping(value = "/games") //mapeando os recursos - definindo o valor como "/games" - aquilo que vem no final do link (/produtos, /clientes...)
public class GameController {

    //puxando uma instância, e injetando a instância do GameService dentro do GameController
    @Autowired
    private GameService gameService;

    //buscar todos os "games"
    /*@GetMapping // mapeando solicitações HTTP GET em métodos manipuladores específicos
    public List<Game> findAll() {
        List<Game> result = gameService.findAll();
        return result;
    }*/

    //apresenta games simplificado
    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
