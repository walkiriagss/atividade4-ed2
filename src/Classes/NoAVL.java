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
public class NoAVL {
    
    private int info;
    private NoAVL esq;
    private NoAVL dir;
    private NoAVL pai;
    private int fBalance;
    
    public NoAVL(int info){
        this.fBalance = 0;
        this.info = info;
        this.dir = null;
        this.esq = null;
        this.pai = null;
    }
    
    

    /**
     * @return the info
     */
    public int getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(int info) {
        this.info = info;
    }

    /**
     * @return the esq
     */
    public NoAVL getEsq() {
        return esq;
    }

    /**
     * @param no
     */
    public void setEsq(NoAVL no) {
        this.esq = no;
    }

    /**
     * @return the dir
     */
    public NoAVL getDir() {
        return dir;
    }

    /**
     * @param no
     */
    public void setDir(NoAVL no) {
        this.dir = no;
    }

    /**
     * @return the fBalance
     */
    public int getfBalance() {
        return fBalance;
    }

    /**
     * @param fBalance the fBalance to set
     */
    public void setfBalance(int fBalance) {
        this.fBalance = fBalance;
    }

    /**
     * @return the pai
     */
    public NoAVL getPai() {
        return pai;
    }

    /**
     * @param pai the pai to set
     */
    public void setPai(NoAVL pai) {
        this.pai = pai;
    }
    
    
}
