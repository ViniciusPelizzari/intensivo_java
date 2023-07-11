package com.vpelizzari.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity //configurar a classe para que ela seja igual/correspondente a uma tabela no DB
@Table(name = "tb_game") //@Table - cria a tabela | (name = "") - defini o nome da tabela
public class Game {

    @Id //configurando para o ID ser PRIMARY KEY no DB
    @GeneratedValue(strategy = GenerationType.IDENTITY) //configurando para o ID ser auto incrementado pelo DB | (strategy = GenerationType.IDENTITY) - forma de mostrar ao DB como gerar o ID
    private Long id;
    private String title;
    @Column(name = "game_year") //YEAR é uma palavra reservado no SQL, por isto está sendo mudado o nome da coluna no DB
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    //ERRO na inserção da SHORTDESCRIPTION ao DB por ser longa e npor não tem nada indicando seu tamanho, o SQL só aceita String (que está em VARCHAR) em até 255 Caracteres
    @Column(columnDefinition = "TEXT") //alterando a definição da columa, de VARCHAR para TEXTO
    private String shortDescription;

    //ERRO na inserção da LONGDESCRIPTION ao DB por ser longa e npor não tem nada indicando seu tamanho, o SQL só aceita String (que está em VARCHAR) em até 255 Caracteres
    @Column(columnDefinition = "TEXT") //alterando a definição da columa, de VARCHAR para TEXTO
    private String longDescription;

    public Game(){

    }

    public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }


    //equals and hashCode = usado para comparar mais de um objeto (diversos games)
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
        Game other = (Game) obj;
        return Objects.equals(id, other.id);
    }
}
