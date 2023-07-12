package com.vpelizzari.dslist.Services;

import com.vpelizzari.dslist.dto.GameDTO;
import com.vpelizzari.dslist.dto.GameMinDTO;
import com.vpelizzari.dslist.entities.Game;
import com.vpelizzari.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List; //boa prática - colocar em todo método da classe SERVICE, para que ele fique @Transactional(readOnly = true) - do SPRING
//@Transactional(readOnly = true) -  é usada em métodos ou classes para indicar que a transação associada a eles é apenas para leitura. Isso significa que esses métodos ou classes não farão nenhuma modificação nos dados persistidos
@Component //ou pode ser o @Service
//usado para injetar dependências de componentes
public class GameService {

    //puxando uma instância, e injetando a instância do GameRepository dentro do GameService
    @Autowired
    private GameRepository gameRepository;

    //buscar todos os "games"
    /*@Transactional(readOnly = true)
    public List<Game> findAll(){
        //buscando os dados do DB
        List<Game> result = gameRepository.findAll();
        return result;
    }*/

    //apresenta games simplificado
    /*@Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }*/

    //apresenta games simplificado
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        //buscando os dados do DB
        List<Game> result = gameRepository.findAll();
        //transformando a lista de games completa em uma lista de games simplificada
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); //stream - lib que permite fazer operações com sequencias de dados
        return dto;
    }

    //buscando pelo ID
    @Transactional(readOnly = true)
    public GameDTO findById(@PathVariable Long listId) {
        Game result = gameRepository.findById(listId).get(); //.get() - usado pq o findById retorna um OPTIONAL, e para retornar um game específico é usado o .get()
        return new GameDTO(result); //transformando o Game em um GameDTO
    }
}
