package com.vpelizzari.dslist.repositories;

import com.vpelizzari.dslist.entities.Game;
import com.vpelizzari.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> { //para extender a classe JpaRepository, é necessário colocar o tipo da entidade (Game) e o tipo do ID da entidade (Long)

    //atualizando a posição dos jogos na lista - DB
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
