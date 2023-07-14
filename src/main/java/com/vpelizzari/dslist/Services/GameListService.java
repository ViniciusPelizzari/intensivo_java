package com.vpelizzari.dslist.Services;

import com.vpelizzari.dslist.Projections.GameMinProjection;
import com.vpelizzari.dslist.dto.GameDTO;
import com.vpelizzari.dslist.dto.GameListDTO;
import com.vpelizzari.dslist.dto.GameMinDTO;
import com.vpelizzari.dslist.entities.Game;
import com.vpelizzari.dslist.entities.GameList;
import com.vpelizzari.dslist.repositories.GameListRepository;
import com.vpelizzari.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional(readOnly = true) -  é usada em métodos ou classes para indicar que a transação associada a eles é apenas para leitura. Isso significa que esses métodos ou classes não farão nenhuma modificação nos dados persistidos
@Component //ou pode ser o @Service
//usado para injetar dependências de componentes
public class GameListService {

    //puxando uma instância, e injetando a instância do GameRepository dentro do GameService
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    //buscar todos os "games"
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    //movimentar a posição dos jogos na lista
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> moveList = gameRepository.searchByList(listId); //pegando a lista
        GameMinProjection obj = moveList.remove(sourceIndex); //removendo objeto da posição inicial (posição de origem)
        moveList.add(destinationIndex, obj); //adicionando objeto na nova posição

        int minimo = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        //lógica = se o "sourceIndex" for menor que o "destinationIndex" o mínimo é o "sourceIndex", caso contrário (:) é o "destinationIndex"
        int maximo = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        //lógica = se o "sourceIndex" for menor que o "destinationIndex" o máximo é o "destinationIndex", caso contrário (:) é o "sourceIndex"

        for(int i = minimo; i <= maximo; i++){
            gameListRepository.updateBelongingPosition(listId, moveList.get(i).getId(), i); //(lista, posição do jogo.pegando id, posição do jogo)
        }
    }
}
