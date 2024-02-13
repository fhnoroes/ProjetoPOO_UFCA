
package com.mycompany.miniprojetopoo;



public class Clube {
    
    public String nome_clube;
    public int saldo_gols;
    public int pontos_clube;
    
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
