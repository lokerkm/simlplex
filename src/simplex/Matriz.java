package simplex;

import java.util.ArrayList;

public class Matriz {

    float[][] quadro;
    float[][] coeficientes;
    float[][] folgas;
    float[][] artificiais;
    float[] b;
    public static final int M = 9;
    ArrayList<String> basicas;

    public Matriz(ArrayList<Restricao> restricoes, float[] funcaoOtimizadora) {
        basicas = new ArrayList<>();
        coeficientes = new float[restricoes.size() + 1][Restricao.qntVariaveis];
        setCoeficientes(restricoes, funcaoOtimizadora);
        folgas = new float[restricoes.size() + 1][restricoes.size()];
        setFolgas(restricoes);
        artificiais = new float[restricoes.size() + 1][restricoes.size()];
        setArtificiais(restricoes);
        b = new float[restricoes.size() + 1];
        setB(restricoes);

        setQuadro(restricoes.size() + 1, Restricao.qntVariaveis + 2 * restricoes.size() + 1);
        setBasicas(restricoes);
    }

    public float[][] getQuadro() {
        return quadro;
    }

    public void setQuadro(int linhas, int colunas) {
        quadro = new float[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (j < coeficientes[0].length) {
                    quadro[i][j] = coeficientes[i][j];
                } else {
                    if (j < coeficientes[0].length + folgas[0].length) {
                        quadro[i][j] = folgas[i][j - coeficientes[0].length]; //
                    } else {
                        if (j < coeficientes[0].length + folgas[0].length + artificiais[0].length) {
                            quadro[i][j] = artificiais[i][j - coeficientes[0].length - folgas[0].length];
                        } else {
                            quadro[i][j] = b[i];
                        }
                    }
                }
            }

        }
    }

    public float[][] getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(ArrayList<Restricao> restricoes, float[] funcaoOtimizadora) {
        for (int i = 0; i <= restricoes.size(); i++) {
            for (int j = 0; j < Restricao.qntVariaveis; j++) {
                if (i == restricoes.size()) {
                    coeficientes[i][j] = funcaoOtimizadora[j];
                } else {
                    coeficientes[i][j] = restricoes.get(i).getCoeficientes()[j];
                }
            }

        }

    }

    public float[][] getFolgas() {
        return folgas;
    }

    public void setFolgas(ArrayList<Restricao> restricoes) {
        for (int i = 0; i <= restricoes.size(); i++) {
            for (int j = 0; j < Restricao.qntVariaveis; j++) {
                if (i == restricoes.size()) {
                    folgas[i][j] = 0;
                } else {
                    if (j == i) {                                           //f1  f2  f3
                        folgas[i][j] = restricoes.get(i).getFolga();        // 1  0   0 
                    } else {                                                // 0  1   0
                        folgas[i][j] = 0;                                   // 0  0   1
                    }                                                       // 0  0   0
                }
            }

        }
    }

    public float[][] getArtificiais() {
        return artificiais;
    }

    public void setArtificiais(ArrayList<Restricao> restricoes) {
        for (int i = 0; i <= restricoes.size(); i++) {
            for (int j = 0; j < Restricao.qntVariaveis; j++) {
                if (i == restricoes.size()) {
                    if (restricoes.get(j).getRelacao().equals("<=")) {
                        artificiais[i][j] = 0;
                    } else {
                        artificiais[i][j] = M;
                    }

                } else {
                    if (j == i) {
                        artificiais[i][j] = restricoes.get(i).getArtificial();
                    } else {
                        artificiais[i][j] = 0;
                    }
                }
            }

        }
    }

    public float[] getB() {
        return b;
    }

    public void setB(ArrayList<Restricao> restricoes) {
        int i;
        for (i = 0; i < restricoes.size(); i++) {
            b[i] = restricoes.get(i).getB();
        }
        b[i]=0;

    }

    public void setBasicas(ArrayList<Restricao> restricoes) {       //basicas sao a primeira coluna
        for (int i = 0; i < restricoes.size(); i++) {
            if (restricoes.get(i).getRelacao().equals("=")) {
                basicas.add("a" + (i + 1));
            }
            if (restricoes.get(i).getRelacao().equals("<=")) {
                basicas.add("f" + (i + 1));
            }
            if (restricoes.get(i).getRelacao().equals(">=")) {
                basicas.add("a" + (i + 1));
            }
        }
        basicas.add("z");
    }

    public ArrayList<String> getBasicas() {
        return basicas;
    }

    public void isAjustado() {
        for (int i = 0; i < artificiais[0].length; i++) {
            if (artificiais[artificiais.length - 1][i] != 0) {
                ajustar();
            }
        }
    }

    private void ajustar() {
        for (int i = 0; i < artificiais.length; i++) {
            for (int j = 0; j < artificiais[0].length; j++) {
                if (artificiais[i][j] == 1) {
                    artificiais[artificiais.length - 1][j] -= artificiais[i][j] * M;
                    for (int k = 0; k < coeficientes[0].length; k++) {
                        coeficientes[coeficientes.length - 1][k] -= coeficientes[i][k] * M;
                    }

                    for (int k = 0; k < folgas[0].length; k++) {
                        folgas[folgas.length - 1][k] -= folgas[i][k] * M;
                    }
                    b[b.length-1] -= b[j] * M;
                }
            }
        }
        atualizaQuadro();
    }

    private void atualizaQuadro() {
        for (int i = 0; i < quadro.length; i++) {
            for (int j = 0; j < quadro[0].length; j++) {
                if (j < coeficientes[0].length) {
                    quadro[i][j] = coeficientes[i][j];
                } else {
                    if (j < coeficientes[0].length + folgas[0].length) {
                        quadro[i][j] = folgas[i][j - coeficientes[0].length];
                    } else {
                        if (j < coeficientes[0].length + folgas[0].length + artificiais[0].length) {
                            quadro[i][j] = artificiais[i][j - coeficientes[0].length - folgas[0].length];
                        } else {
                            quadro[i][j] = b[i];
                        }
                    }
                }
            }

        }
    }
}
