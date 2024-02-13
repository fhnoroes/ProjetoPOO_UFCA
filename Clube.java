/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniprojetopoo;

/**
 *
 * @author Acer
 */
public class Clube {
    
    String nome_clube;
    int saldo_gols;
    int pontos_clube;
    
    public Clube(String nome_clube){
        this.nome_clube = nome_clube;
        this.saldo_gols = 0;
        this.pontos_clube = 0;
        
        
    }
    public void ganhar(int saldo_jogo){
        this.saldo_gols += saldo_jogo;
        this.pontos_clube += 3;
        
    }
    
    public void empatar(){
        this.pontos_clube+=1;
    }
    
    public void perder(int saldo_jogo){
        this.saldo_gols += saldo_jogo;
        
    }
    
    public int getPontos(){
        return this.pontos_clube;
    }
    public int getSaldo(){
        return this.saldo_gols;
    }
}
