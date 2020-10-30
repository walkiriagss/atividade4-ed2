/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade04;

import Classes.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author izabe
 */
public class Atividade04 {
    
    private static final int M = 300;
    private static final int N = 1000;
    
    static void comAvl(int[] vet,ArquivoSaida arqSaida,String tV){
        ArvoreAVL av = new ArvoreAVL();
        long tempo;
        
        long inicio = System.currentTimeMillis();
        for (int i=0;i<N;i++){
            av.inserir(vet[i]);
        }
        
        for (int i=0;i<M;i++){
            av.busca(av.getRaiz(), i);
        }
        long fim  = System.currentTimeMillis();
        
        tempo = fim - inicio;
        Saida s = new Saida("Árvore AVL",M,N,tV,av.getCompChave(),av.getAltura(av.getRaiz()),tempo);
        arqSaida.addSaida(s);
    }
    
    static void semAvl(int[] vet,ArquivoSaida arqSaida,String tV){
        ArvoreBB av = new ArvoreBB();
        long tempo;
        
        long inicio = System.currentTimeMillis();
        for (int i=0;i<N;i++){
            av.inserir(vet[i]);
        }
        
        for (int i=0;i<M;i++){
            av.busca(av.getRaiz(), vet[ThreadLocalRandom.current().nextInt(N-1)]);
        }
        long fim  = System.currentTimeMillis();
        
        tempo = fim - inicio;
        Saida s = new Saida("Árvore Binária de Busca",M,N,tV,av.getCompChave(),av.getAltura(av.getRaiz()),tempo);
        arqSaida.addSaida(s);
    }
    
    static void ordena(int[] vet){
        Arrays.sort(vet);
    }
    
    static void montaArray(int [] vet){
        for (int i=0; i<N; i++){            
            vet[i] = ThreadLocalRandom.current().nextInt(N*10);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] vet = new int[N];
        montaArray(vet);
        
        ArquivoSaida arqSaida = new ArquivoSaida();
        
        String tV = "Aleatórios";
        
        comAvl(vet,arqSaida,tV);
        semAvl(vet,arqSaida,tV);
        
        ordena(vet);
        
        tV = "Ordenados";
        
        comAvl(vet,arqSaida,tV);
        semAvl(vet,arqSaida,tV);
        
        arqSaida.gravaSaidas();
        
        
    }
    
}
