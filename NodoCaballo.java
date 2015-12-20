
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alejandro
 */
public class NodoCaballo{
    int f;
    int c;
    boolean visitado;

    public NodoCaballo(int f, int c) {
        setF(f);
        setC(c);
        setVisitado(false);
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    @Override
    public String toString() {
        return "NodoCaballo{" + "f=" + f + ", c=" + c + ", visitado=" + visitado + '}';
    }

    
}
