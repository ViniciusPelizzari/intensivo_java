package com.vpelizzari.dslist.Services;

import com.vpelizzari.dslist.dto.GameMinDto;
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
    public List<Game> findAll(){
        //buscando os dados do DB
        /*var result = gameRepository.findAll();*///mesma coisa
        List<Game> result= gameRepository.findAll();
        return result;
    }
}
