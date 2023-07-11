package com.vpelizzari.dslist.Services;

import com.vpelizzari.dslist.dto.GameMinDTO;
import com.vpelizzari.dslist.entities.Game;
import com.vpelizzari.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //ou pode ser o @Service
//usado para injetar dependências de componentes
public class GameService {

    //puxando uma instância, e injetando a instância do GameRepository dentro do GameService
    @Autowired
    private GameRepository gameRepository;

    //buscar todos os "games"
    /*public List<Game> findAll(){
        //buscando os dados do DB
        List<Game> result = gameRepository.findAll();
        return result;
    }*/

    //apresenta games simplificado
    /*public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }*/

    //apresenta games simplificado
    public List<GameMinDTO> findAll(){
        //buscando os dados do DB
        List<Game> result = gameRepository.findAll();
        //transformando a lista de games completa em uma lista de games simplificada
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); //stream - lib que permite fazer operações com sequencias de dados
        return dto;
    }
}
