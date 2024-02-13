/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniprojetopoo;

/**
 *
 * @author Acer
 */
public class Teste {
     public static void main (String [ ] args){
         Clube f = new Clube("Flamengo");
         Clube v = new Clube("Vasco");
         Clube p = new Clube("Palmeiras");
         Clube c = new Clube("Ceará");
         
         Campeonato camp = new Campeonato("Brasileirão");
         camp.adicionar_clube(f);
         camp.adicionar_clube(v);
         camp.adicionar_clube(p);
         camp.adicionar_clube(c);
         camp.mostrar_clube(); 
        camp.jogar_campeonato();
        camp.getClassificacao();

      
    }
    
}
