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
public class ArvoreAVL {
    
    private NoAVL raiz;
    boolean precisaBalancear; // default é false
    private int compChave;
    
    public ArvoreAVL(){
        this.precisaBalancear = false;
        this.compChave = 0;
    }
    
    
    
    //INSERÇÃO
    public void inserir(int info) {
		NoAVL no = new NoAVL(info);
		inserirAVL(this.getRaiz(), no);
    }
    
    public void inserirAVL(NoAVL comparar, NoAVL inserir) {

        if (comparar == null) {
                this.raiz = inserir;

        } else {
            
            compChave++;
            if (inserir.getInfo() < comparar.getInfo()) {

                if (comparar.getEsq() == null) {
                     comparar.setEsq(inserir);
                     inserir.setPai(comparar);
                     isBalanced(comparar);

                } else {
                     inserirAVL(comparar.getEsq(), inserir);
                }
              
              compChave++;  
            } else if (inserir.getInfo() > comparar.getInfo()) {

                if (comparar.getDir() == null) {
                     comparar.setDir(inserir);
                     inserir.setPai(comparar);
                     isBalanced(comparar);

                } else {
                     inserirAVL(comparar.getDir(), inserir);
                }

            } else {
                 // O nó já existe
            }
        }
	}
    
    
    //REMOÇÃO
        
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
             isBalanced(r.getPai());
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
    
    //BUSCA
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
    
    //BALANCEAMENTO    
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

    private void setBalance(NoAVL no){
        int fBalance = getAltura(no.getDir()) - getAltura(no.getEsq());
        no.setfBalance(fBalance);
    }

    public void isBalanced(NoAVL no){
        setBalance(no);
        int fp = no.getfBalance();
        
        if (fp == -2){
            if (getAltura(no.getEsq().getEsq()) >= getAltura(no.getEsq().getDir())){
                no = rotSimplesDir(no);
            } else {
                no = rotDuplaEsqDir(no);
            }
        } else if (fp == 2){
            if (getAltura(no.getDir().getDir()) >= getAltura(no.getDir().getEsq())){
                no = rotSimplesEsq(no);
            } else {
                no = rotDuplaDirEsq(no);
            }
        }
        
        if (no.getPai() != null){
            isBalanced(no.getPai());
        } else {
            this.raiz = no;
        }
        
    }
    
    // ROTAÇÕES     
    public NoAVL rotSimplesEsq(NoAVL p){
        
        NoAVL q = p.getDir();
        q.setPai(p.getPai());
        
        p.setDir(q.getEsq());
        
        if (p.getDir()!=null){
            p.getDir().setPai(p);
        }
        
        q.setEsq(p);
        p.setPai(q);
        
        if (q.getPai() != null){
            if (q.getPai().getDir() == p){
                q.getPai().setDir(q);
            } else if (q.getPai().getEsq() == p){
                q.getPai().setEsq(q);
            }
        }
        
        setBalance(p);
        setBalance(q);
        
        return q;

    }
    
    public NoAVL rotSimplesDir(NoAVL p){
        
        NoAVL q = p.getEsq();
        q.setPai(p.getPai());
        
        p.setEsq(q.getDir());
        
        if (p.getEsq() != null){
            p.getEsq().setPai(p);
        }
        
        q.setDir(p);
        p.setPai(q);
        
        if (q.getPai() != null){
            if (q.getPai().getDir() == p){
                q.getPai().setDir(q);
            } else if (q.getPai().getEsq() == p){
                q.getPai().setEsq(q);
            }
        }
        
        setBalance(q);
        setBalance(p);
        
        return q;
    }
    
    public NoAVL rotDuplaEsqDir(NoAVL p){
        p.setEsq(rotSimplesEsq(p.getEsq()));
        return rotSimplesDir(p);
    }
    
    public NoAVL rotDuplaDirEsq(NoAVL p){
        p.setDir(rotSimplesDir(p.getDir()));
        return rotSimplesEsq(p);
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
 