package com.vpelizzari.dslist.Controllers;

import com.vpelizzari.dslist.Services.GameListService;
import com.vpelizzari.dslist.Services.GameService;
import com.vpelizzari.dslist.dto.GameDTO;
import com.vpelizzari.dslist.dto.GameListDTO;
import com.vpelizzari.dslist.dto.GameMinDTO;
import com.vpelizzari.dslist.dto.ReplacementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //definindo como controlador
@RequestMapping(value = "/lists") //mapeando os recursos - definindo o valor como "/games" - aquilo que vem no final do link (/produtos, /clientes...)
public class GameListController {

    //puxando uma instância, e injetando a instância do GameService dentro do GameController
    @Autowired
    private GameListService gameListService;
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
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    //apresenta game por id
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void moveGame(@PathVariable Long listId, @RequestBody ReplacementDTO body) { //@RequestBody - para o framework mapear o JSON | ReplacementDTO body faz parte da requisição POST do Postman, em que passará o sourceIndex e o destinationIndex atráves do JSON
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
