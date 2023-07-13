package com.vpelizzari.dslist.Projections;

public interface GameMinProjection { //necessário colocar métodos get correspondente a consulta sql que está no GameRepository

    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
