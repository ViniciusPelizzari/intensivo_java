package com.vpelizzari.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    //criando referências
    @EmbeddedId //para fazer a referência ao BelongingPK como se fosse apenas um atributo (são dois: game, gameList), mas está sendo anotada pelo Embeddable
    private BelongingPK id = new BelongingPK(); //instanciando objeto

    private Integer position;

    public Belonging(){

    }

    public Belonging(Game game, GameList list, Integer position) { //original = BelongingPK id, Integer position - foi modificado
        id.setGame(game);
        id.setGameList(list);
        this.position = position;
    }

    public void setGame(Game game) {
        id.setGame(game);
    }

    public Game getGame() {
        return id.getGame();
    }

    public void setList(GameList list) {
        id.setGameList(list);
    }

    public GameList getList() {
        return id.getGameList();
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Belonging other = (Belonging) obj;
        return Objects.equals(id, other.id);
    }
}
