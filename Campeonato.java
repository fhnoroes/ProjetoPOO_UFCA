/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.miniprojetopoo;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Acer
 */
public class Campeonato {
    ArrayList<Clube> clubes = new ArrayList();
    String nome_campeonato;
    ArrayList<Clube> classiclubes = new ArrayList();
    
    
    public Campeonato(String nome_campeonato){
        this.nome_campeonato = nome_campeonato;
    }
    
    public void adicionar_clube(Clube clube){
        this.clubes.add(clube);
    }
  
    public void mostrar_clube() {
        System.out.println("\n");
        System.out.println("Times adicionados ao "+this.nome_campeonato+":");
        System.out.println("-------------------------------------------");
        if(this.clubes.size()<1){
            System.out.println("Nenhuma equipe foi adicionada ao campeonato.");
        }else{
        for (Clube clube: clubes) {
            System.out.println(clube.nome_clube);
        }
    }
    }
     public void jogar_partida(Clube m, Clube v){
         Random aleatorio = new Random();
         int golm = aleatorio.nextInt(5);
         int golv = aleatorio.nextInt(5);

         System.out.println(m.nome_clube+" "+golm+"x"+golv+" "+v.nome_clube);
         System.out.println("--");
         if(golm>golv){
             m.ganhar(golm-golv);
             v.perder(golv-golm);
         }else if(golm<golv){
             m.perder(golm-golv);
             v.ganhar(golv-golm);
         }else{
             m.empatar();
             v.empatar();
         }
          
   }
     public void jogar_campeonato(){
        int x = 0;
        int y = x+1;
        int tamanhoLista = this.clubes.size();
        if(tamanhoLista<2){
            System.out.println("Adicione clubes no campeonato. Mínimo para jogá-lo é duas equipes.");
        }else{
        System.out.println("\n");
        System.out.println("Partidas do campeonato "+this.nome_campeonato);
        System.out.println("-------------------------------------------");
        while(x<tamanhoLista){
            while(y<tamanhoLista){
                this.jogar_partida(this.clubes.get(x),this.clubes.get(y));
                this.jogar_partida(this.clubes.get(y),this.clubes.get(x));
                y++;
        }
        x++;
        y=x+1;
        }
        this.getClassificacao();
        this.getCampeao();
     }
     }
    
     public void getCampeao(){
        int maiorPontuação = 0;
        String nomeCampeão = "";
        int tamanhoLista = this.clubes.size();
        int indice = 0;
        boolean haCampeao = true;
        for(int i=0;i<tamanhoLista;i++){
            if(i==0){
                maiorPontuação = this.clubes.get(i).pontos_clube;
                nomeCampeão =  this.clubes.get(i).nome_clube;
                
            }else{
                if(this.clubes.get(i).pontos_clube>maiorPontuação){
                    maiorPontuação = this.clubes.get(i).pontos_clube; 
                    nomeCampeão =  this.clubes.get(i).nome_clube;
                    indice = i;
                    haCampeao = true;

                }else if(this.clubes.get(i).pontos_clube == maiorPontuação){
                    if(this.clubes.get(i).saldo_gols>this.clubes.get(indice).saldo_gols){
                        maiorPontuação = this.clubes.get(i).pontos_clube; 
                        nomeCampeão =  this.clubes.get(i).nome_clube;
                        haCampeao = true;
               
                    }else if(this.clubes.get(i).saldo_gols == this.clubes.get(indice).saldo_gols){
                        haCampeao = false;
                    }
                }
            }
        }
        
        System.out.println("\n");
        System.out.println("Campeão do "+this.nome_campeonato);
        System.out.println("-------------------------------------------");
        if(haCampeao!=false){
            System.out.println("Maior pontuação: "+maiorPontuação+" e o campeão é: "+nomeCampeão);
            System.out.println("Parabéns, "+nomeCampeão+"!!!");
        }else{
            System.out.println("Não há um campeão, pois há mais de uma equipe com a mesma quantidade de pontos e saldo.");
            System.out.println("Maior pontuação: "+maiorPontuação+" e o maior saldo de gols foi: "+this.clubes.get(indice).saldo_gols);
        }
     }
     
     private void getClassificacao(){
        int tamanhoLista = this.clubes.size();
        for(int i=0;i<tamanhoLista;i++){
            //verifica se é a primeira ocorrência e adiciona o elemento na classificação
            if(i==0){
                this.classiclubes.add(this.clubes.get(i)); 
            }else{
               int tamanhoLista2 = this.classiclubes.size();
               //usei j=tamanhoLista2 e x=tamanhoLista2 para sair dos loopins dos for
               for(int j = 0;j<tamanhoLista2;j++){
                   //verifica se a pontuação do clube é maior do que o que está na classificação
                   if(this.clubes.get(i).pontos_clube>this.classiclubes.get(j).pontos_clube){
                        this.classiclubes.add(j,this.clubes.get(i)); 
                        j = tamanhoLista2;
                   //validação para caso a pontuação seja igual do que o que já está adicionado na classificação
                   }else if(this.clubes.get(i).pontos_clube==this.classiclubes.get(j).pontos_clube ){
                       for(int x=j;x<tamanhoLista2;x++){
                           //no caso de pontuação igual verifica se o saldo de gols é maior ou igual a algum elemento que vem depois
                           if(this.clubes.get(i).saldo_gols>this.classiclubes.get(x).saldo_gols || this.clubes.get(i).saldo_gols==this.classiclubes.get(j).saldo_gols){
                           this.classiclubes.add(x,this.clubes.get(i)); 
                           x = tamanhoLista2;
                           j = tamanhoLista2; 
                           //em caso de ser o último elemento e não ter ninguém com saldo menor ou igual, adiciona no final da classifição
                           }else if(x==tamanhoLista2-1){
                               this.classiclubes.add(this.clubes.get(i));
                               j = tamanhoLista2; 
                           }
                       }
                   //verifica se o clube adicionado é o último e tem uma pontuação menor do que o que está na classificação
                   }else if(this.clubes.get(i).pontos_clube<this.classiclubes.get(j).pontos_clube && j==tamanhoLista2-1){
                       this.classiclubes.add(this.clubes.get(i));
                   }
               }
            }
     }
       int cont = 0; 
       System.out.println("\n");
       System.out.println("Classificação "+this.nome_campeonato);
       System.out.println("-------------------------------------------");
       for (Clube clube: classiclubes) {
            cont++;
            System.out.println(cont+"º "+clube.nome_clube+" -- "+"pts."+clube.pontos_clube+" -- "+"saldo."+clube.saldo_gols);
        } 
     }
}