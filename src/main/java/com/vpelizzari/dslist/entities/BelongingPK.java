/*package com.vpelizzari.dslist.entities;

import com.vpelizzari.dslist.entities.Game;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable //usado para fazer o encapsulamento dos dois atributos (game, gameList) em um só, para ser usado no Belonging
public class BelongingPK { //classe auxiliar da Belonging - pois o Belonging pode ter apenas uma referência (atributo), o ID

    //criando referências
    @ManyToOne //configuração JPD - mapeamento Objeto-relacional
    @JoinColumn(name = "game_id") //configurando nome da chave estrangeira
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gameList;

    public BelongingPK(){

    }

    public BelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList list) {
        this.gameList = list;
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, gameList);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BelongingPK other = (BelongingPK) obj;
        return Objects.equals(game, other.game) && Objects.equals(gameList, other.gameList);
    }
}*/
package com.vpelizzari.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gameList;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList list) {
        this.gameList = list;
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, gameList);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BelongingPK other = (BelongingPK) obj;
        return Objects.equals(game, other.game) && Objects.equals(gameList, other.gameList);
    }
}
