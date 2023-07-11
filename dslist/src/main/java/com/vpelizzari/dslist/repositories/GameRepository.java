package com.vpelizzari.dslist.repositories;

import com.vpelizzari.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> { //para extender a classe JpaRepository, é necessário colocar o tipo da entidade (Game) e o tipo do ID da entidade (Long)
}
