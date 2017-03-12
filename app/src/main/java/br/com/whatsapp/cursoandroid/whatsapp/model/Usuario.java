package br.com.whatsapp.cursoandroid.whatsapp.model;

import com.google.firebase.database.Exclude;

/**
 * Created by Melqui on 20/02/2017.
 */

public class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;

    public  Usuario(){

    }

    @Exclude
    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
