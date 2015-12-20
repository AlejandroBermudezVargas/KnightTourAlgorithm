import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class KnightTour extends JFrame {

    private int tamanno;
    private Pila pila;
    private NodoCaballo[][] matrizNodos;
    private ImageIcon imagen = new ImageIcon("horse35.png");
    private JPanel[][] tablero;
    JLabel[][] caballos;

    public KnightTour(int ptamanno, int f, int c) {
        setTamanno(ptamanno);
        pila = new Pila();
        matrizNodos = new NodoCaballo[tamanno][tamanno];
        tablero = new JPanel[tamanno][tamanno];
        caballos = new JLabel[tamanno][tamanno];
        iniciarEtiquetas();
        colorearPaneles();
        entorno();
        llenarMatrizNodos();
        if(f<tamanno && c < tamanno)//Posicion inicial
            pila.push(matrizNodos[f][c]);
        else
            pila.push(matrizNodos[0][0]);
        correr();
    }

    private void llenarMatrizNodos() {
        for (int i = 0; i < tamanno; i++) {
            for (int j = 0; j < tamanno; j++) {
                matrizNodos[i][j] = new NodoCaballo(i, j);
            }
        }
    }

    private void correr() {
        NodoCaballo resp = (NodoCaballo) pila.pop();
        while (resp != null) {
            if (!resp.visitado) {
                matrizNodos[resp.getF()][resp.getC()].setVisitado(true);
                //Abajo
                if (resp.getF() + 2 < tamanno && resp.getC() + 1 < tamanno)//movemos abajo derecha
                {
                    pila.push(matrizNodos[resp.getF() + 2][resp.getC() + 1]);
                }
                if (resp.getF() + 2 < tamanno && resp.getC() - 1 >= 0)//movemos abajo izquierda
                {
                    pila.push(matrizNodos[resp.getF() + 2][resp.getC() - 1]);
                }

                //Arriba
                if (resp.getF() - 2 >= 0 && resp.getC() + 1 < tamanno)//movemos arriba derecha
                {
                    pila.push(matrizNodos[resp.getF() - 2][resp.getC() + 1]);
                }

                if (resp.getF() - 2 >= 0 && resp.getC() - 1 >= 0)//movemos arriba izquierda
                {
                    pila.push(matrizNodos[resp.getF() - 2][resp.getC() - 1]);
                }

                //Derecha
                if (resp.getC() + 2 < tamanno && resp.getF() + 1 < tamanno)//Derecha abajo
                {
                    pila.push(matrizNodos[resp.getF() + 1][resp.getC() + 2]);
                }

                if (resp.getC() + 2 < tamanno && resp.getF() - 1 >= 0)//Derecha arriba
                {
                    pila.push(matrizNodos[resp.getF() - 1][resp.getC() + 2]);
                }

                //Izquierda
                if (resp.getC() - 2 >= 0 && resp.getF() + 1 < tamanno)//Izquierda abajo
                {
                    pila.push(matrizNodos[resp.getF() + 1][resp.getC() - 2]);
                }

                if (resp.getC() - 2 >= 0 && resp.getF() - 1 >= 0)//Izquierda arriba
                {
                    pila.push(matrizNodos[resp.getF() - 1][resp.getC() - 2]);
                }

            }
            
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            colocarImagenes();
            resp = (NodoCaballo) pila.pop();
        }
        
        JOptionPane.showMessageDialog(null, "Hemos terminado");
        System.exit(0);
    }

    private boolean terminamos() {
        boolean terminamos = true;
        for (int i = 0; i < tamanno; i++) {
            for (int j = 0; j < tamanno; j++) {
                if (!matrizNodos[i][j].visitado) {
                    terminamos = false;
                }
            }
        }
        return terminamos;
    }

    private void colocarImagenes() {
        removerAnteriores();
        for (int i = 0; i < tamanno; i++) {
            for (int j = 0; j < tamanno; j++) {
                if (matrizNodos[i][j].visitado)
                    caballos[i][j].setIcon(imagen);
            }
        }
    }

    private void removerAnteriores() {
        for (int i = 0; i < tamanno; i++) {
            for (int j = 0; j < tamanno; j++) {
                caballos[i][j].setIcon(null);
            }
        }
    }

    private void iniciarEtiquetas() {
        for (int i = 0; i < tamanno; i++) {
            for (int j = 0; j < tamanno; j++) {
                caballos[i][j] = new JLabel();
            }
        }
    }

    private void colorearPaneles() {
        for (int i = 0; i < tamanno; i++) {
            for (int j = 0; j < tamanno; j++) {
                tablero[i][j] = new JPanel();
                if ((i + j) % 2 == 0) {
                    tablero[i][j].setBackground(Color.black);
                } else {
                    tablero[i][j].setBackground(Color.red);
                }
                tablero[i][j].add(caballos[i][j]);
            }
        }
    }

    private void entorno() {
        this.setBounds(0, 0, 700, 700);
        this.setLayout(new GridLayout(tamanno, tamanno));
        for (int i = 0; i < tamanno; i++) {
            for (int j = 0; j < tamanno; j++) {
                add(tablero[i][j]);
            }
        }
        this.setVisible(true);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < tamanno; i++) {
            for (int j = 0; j < tamanno; j++) {
                if (matrizNodos[i][j].isVisitado()) {
                    result = result + "1";
                } else {
                    result = result + "0";
                }
            }
            result = result + "\n";
        }
        return result;
    }

    public void setTamanno(int ptamanno) {
        this.tamanno = ptamanno;
    }
    
    public static void main(String[] args) {
        if(args.length>0 && args.length<=3)
        new KnightTour(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        else{
            System.out.println("Debes de mandar tamano del tablero ejemplo: 8, esto seria  un tablero de 8x8");
            System.out.println("Despues debes de mandar f y c para la posicion inicial ejemplo: 5 2");
            System.out.println("No envies una posicion mayor al tamanno del tablero sino coomenzara en la posicion: 00");
        }
    }

}
