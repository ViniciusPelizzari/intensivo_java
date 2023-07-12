package com.vpelizzari.dslist.Controllers;

import com.vpelizzari.dslist.Services.GameListService;
import com.vpelizzari.dslist.Services.GameService;
import com.vpelizzari.dslist.dto.GameDTO;
import com.vpelizzari.dslist.dto.GameListDTO;
import com.vpelizzari.dslist.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //definindo como controlador
@RequestMapping(value = "/lists") //mapeando os recursos - definindo o valor como "/games" - aquilo que vem no final do link (/produtos, /clientes...)
public class GameListController {

    //puxando uma instância, e injetando a instância do GameService dentro do GameController
    @Autowired
    private GameListService gameListService;

    //buscar todos os "games"
    /*@GetMapping // mapeando solicitações HTTP GET em métodos manipuladores específicos
    public List<Game> findAll() {
        List<Game> result = gameService.findAll();
        return result;
    }*/

    //apresenta games simplificado
    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
