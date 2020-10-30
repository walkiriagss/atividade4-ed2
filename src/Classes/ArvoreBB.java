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
public class ArvoreBB {
    
    private NoAVL raiz;
    private int compChave;
    
    public ArvoreBB(){
        this.compChave = 0;
    }
    
    //INSERÇÃO
    public void inserir(int info) {
		NoAVL no = new NoAVL(info);
		auxInserir(this.getRaiz(), no);
    }
    
    public void auxInserir(NoAVL comparar, NoAVL inserir) {

        if (comparar == null) {
                this.raiz = inserir;

        } else {
            
            compChave++;
            if (inserir.getInfo() < comparar.getInfo()) {

                if (comparar.getEsq() == null) {
                     comparar.setEsq(inserir);
                     inserir.setPai(comparar);

                } else {
                     auxInserir(comparar.getEsq(), inserir);
                }
            
            compChave++;    
            } else if (inserir.getInfo() > comparar.getInfo()) {

                if (comparar.getDir() == null) {
                     comparar.setDir(inserir);
                     inserir.setPai(comparar);

                } else {
                     auxInserir(comparar.getDir(), inserir);
                }

            } else {
                 // O nó já existe
            }
        }
    }
    
    public void remover(int info) {
        
        NoAVL no = this.getRaiz();
        busca (no,info);
        removerNoEncontrado(no);
        
    }
    
    public void removerNoEncontrado(NoAVL remover) {
        NoAVL r;

        if (remover.getEsq() == null || remover.getDir() == null) {

            if (remover.getPai() == null) {
                 this.raiz = null;
                 remover = null;
                 return;
            }
            r = remover;

        } else {
             r = SetSucessor(remover);
             remover.setInfo(r.getInfo());
        }

        NoAVL p;
        if (r.getEsq() != null) {
             p = r.getEsq();
        } else {
            p = r.getDir();
        }

        if (p != null) {
             p.setPai(r.getPai());
        }

        if (r.getPai() == null) {
             this.raiz = p;
        } else {
             if (r == r.getPai().getEsq()) {
                 r.getPai().setEsq(p);
             } else {
                 r.getPai().setDir(p);
             }
        }
        r = null;
    }
    
    public NoAVL SetSucessor(NoAVL q) {
             if (q.getDir() != null) {
                 NoAVL r = q.getDir();
                 while (r.getEsq() != null) {
                     r = r.getEsq();
                 }
                return r;
             } else {
                 NoAVL p = q.getPai();
                 while (p != null && q == p.getDir()) {
                     q = p;
                     p = q.getPai();
                 }
                 return p;
             }
    }
    
    public void busca(NoAVL no,int info){
        
        if (no == null) {
            return;
        }
        
        compChave++;
        if (no.getInfo() > info) {
             busca(no.getEsq(), info);
        
        compChave++;     
        } else if (no.getInfo() < info) {
             busca(no.getDir(), info);
        
        compChave++;
        } else if (no.getInfo() == info) {
             return;
        }
    }
    
    public int getAltura(NoAVL no){
        
        //vendo se não tem nó
        if (no==null){
            return -1;
        }
        
        // vendo se é uma folha
        if (no.getEsq()==null && no.getDir()==null){
            return 0;
        } else if (no.getEsq() == null){ // vendo se subarvore a esquerda é vazia
            return 1 + getAltura(no.getDir());
        } else if (no.getDir() == null){ // vendo se subarvore a direita é vazia
            return 1 + getAltura(no.getEsq());
        } else { // tem subarvore dos dois lados
            return 1 + Math.max( getAltura(no.getEsq()) , getAltura(no.getDir()) );
        }
        
    }

    /**
     * @return the compChave
     */
    public int getCompChave() {
        return compChave;
    }

    /**
     * @return the raiz
     */
    public NoAVL getRaiz() {
        return raiz;
    }
    
    
}
