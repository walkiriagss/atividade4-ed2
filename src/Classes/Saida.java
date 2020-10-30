/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author izabe
 */
public class Saida {
    
    private String tipoHeap;
    private String valordeM;
    private String valordeN;
    private String tipoValor;
    private String compChave;
    private String altura;
    private String tempo;
   

    
    /**
     * Construtor vazio da classe Saida
     */
    public Saida(){
        
    }
    
    
    public Saida (String tipoHeap, int valordeM, int valordeN,String tipoValor, int compChave, int altura, double tempo){
        
        this.tipoHeap = tipoHeap;
        this.valordeM = Integer.toString(valordeM);
        this.valordeN = Integer.toString(valordeN);
        this.tipoValor = tipoValor;
        this.compChave = Integer.toString(compChave);
        this.altura = Integer.toString(altura);
        this.tempo = Double.toString(tempo);
        
    }

    /**
     * @return the tipoHeap
     */
    public String getTipoHeap() {
        return tipoHeap;
    }

    /**
     * @return the valordeM
     */
    public String getValordeM() {
        return valordeM;
    }

    /**
     * @return the valordeN
     */
    public String getValordeN() {
        return valordeN;
    }

    /**
     * @return the tipoValor
     */
    public String getTipoValor() {
        return tipoValor;
    }

    /**
     * @return the compChave
     */
    public String getCompChave() {
        return compChave;
    }

    /**
     * @return the altura
     */
    public String getAltura() {
        return altura;
    }

    /**
     * @return the tempo
     */
    public String getTempo() {
        return tempo;
    }

    

}
