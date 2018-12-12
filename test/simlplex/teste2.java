package simlplex;

import java.util.ArrayList;
import simplex.Matriz;
import simplex.Restricao;

public class teste2 {
    
    public Matriz matriz;
    
    public static void main(String[] args) {
//        float[] c1 = {1.0f, 2.0f, 3.0f};
//        float[] c2 = {10.0f, 20.0f, 30.0f};
//        float[] c3 = {100.0f, 200.0f, 300.0f};
//        float[] c4 = {-5.0f, -6.0f, -7.0f};
//        Restricao.setQntVariaveis(3);
//        Restricao r1 = new Restricao( c1, "teste", ">=", 4);
//        Restricao r2 = new Restricao( c2, "teste", ">=", 40);
//        Restricao r3 = new Restricao( c3, "teste", ">=", 400);

        float[] c1 = {1.0f, 6.0f};
        float[] c2 = {4.0f, 3.0f};
        float[] c3 = {1.0f, 2.0f};
        float[] c4 = {15.0f, 32.0f};
        Restricao.setQntVariaveis(2);
        Restricao r1 = new Restricao(c1, "teste", ">=", 7);
        Restricao r2 = new Restricao(c2, "teste", ">=", 12);
        Restricao r3 = new Restricao(c3, "teste", "=", 18);
        
        ArrayList<Restricao> restricoes = new ArrayList<>();
        
        restricoes.add(r1);
        restricoes.add(r2);
        restricoes.add(r3);
        Matriz matriz = new Matriz(restricoes, c4);
//        String str = "\t";
//        for (int i = 0; i < matriz.getCoeficientes()[0].length; i++) {
//            str += "x" + (i + 1) + "\t";
//        }
//        for (int i = 0; i < matriz.getFolgas()[0].length; i++) {
//            str += "f" + (i + 1) + "\t";
//        }
//        for (int i = 0; i < matriz.getArtificiais()[0].length; i++) {
//            str += "a" + (i + 1) + "\t";
//        }
//        str += "b\n";
//        for (int i = 0; i < matriz.getQuadro().length; i++) {
//            str += matriz.getBasicas().get(i) + "\t";
//            for (int j = 0; j < matriz.getQuadro()[0].length; j++) {
//                str += matriz.getQuadro()[i][j] + "\t";
//            }
//            str += "\n";
//        }
//        System.out.println(str);
//        System.out.println("--------------------");
//        matriz.isAjustado();
//        str = "\t";
//        for (int i = 0; i < matriz.getCoeficientes()[0].length; i++) {
//            str += "x" + (i + 1) + "\t";
//        }
//        for (int i = 0; i < matriz.getFolgas()[0].length; i++) {
//            str += "f" + (i + 1) + "\t";
//        }
//        for (int i = 0; i < matriz.getArtificiais()[0].length; i++) {
//            str += "a" + (i + 1) + "\t";
//        }
//        str += "b\n";
//        for (int i = 0; i < matriz.getQuadro().length; i++) {
//            str += matriz.getBasicas().get(i) + "\t";
//            for (int j = 0; j < matriz.getQuadro()[0].length; j++) {
//                str += matriz.getQuadro()[i][j] + "\t";
//            }
//            str += "\n";
//        }
//        System.out.println(str);

        //matriz.getLinhaMenorPP(matriz.getColunaMenorValorZ(restricoes));
//        imprimir(matriz);
        matriz.isAjustado();
        imprimir(matriz);
matriz.resolveSimplex(restricoes);
        imprimir(matriz);
//        matriz.interacao(matriz.getLinhaMenorPP(matriz.getColunaMenorValorZ(restricoes)), matriz.getColunaMenorValorZ(restricoes));
//      imprimir(matriz);
//        matriz.interacao(matriz.getLinhaMenorPP(matriz.getColunaMenorValorZ(restricoes)), matriz.getColunaMenorValorZ(restricoes));
//      imprimir(matriz);
//        matriz.interacao(matriz.getLinhaMenorPP(matriz.getColunaMenorValorZ(restricoes)), matriz.getColunaMenorValorZ(restricoes));
//      imprimir(matriz);
     

    }
    
    public static void imprimir(Matriz matriz) {
        
        String str = "\t";
        for (int i = 0; i < matriz.getCoeficientes()[0].length; i++) {
            str += "x" + (i + 1) + "\t";
        }
        for (int i = 0; i < matriz.getFolgas()[0].length; i++) {
            str += "f" + (i + 1) + "\t";
        }
        for (int i = 0; i < matriz.getArtificiais()[0].length; i++) {
            str += "a" + (i + 1) + "\t";
        }
        str += "b\n";
        for (int i = 0; i < matriz.getQuadro().length; i++) {
            str += matriz.getBasicas().get(i) + "\t";
            for (int j = 0; j < matriz.getQuadro()[0].length; j++) {
                str += matriz.getQuadro()[i][j] + "\t";
            }
            str += "\n";
        }
        System.out.println(str);
        System.out.println("--------------------");
//        matriz.isAjustado();
//        str = "\t";
//        for (int i = 0; i < matriz.getCoeficientes()[0].length; i++) {
//            str += "x" + (i + 1) + "\t";
//        }
//        for (int i = 0; i < matriz.getFolgas()[0].length; i++) {
//            str += "f" + (i + 1) + "\t";
//        }
//        for (int i = 0; i < matriz.getArtificiais()[0].length; i++) {
//            str += "a" + (i + 1) + "\t";
//        }
//        str += "b\n";
//        for (int i = 0; i < matriz.getQuadro().length; i++) {
//            str += matriz.getBasicas().get(i) + "\t";
//            for (int j = 0; j < matriz.getQuadro()[0].length; j++) {
//                str += matriz.getQuadro()[i][j] + "\t";
//            }
//            str += "\n";
//        }
//        System.out.println(str);

    }
}
