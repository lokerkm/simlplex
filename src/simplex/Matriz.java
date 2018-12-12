package simplex;

import java.util.ArrayList;

public class Matriz {

    float[][] quadro;
    float[][] coeficientes;
    float[][] folgas;
    float[][] artificiais;
    float[] b;
    public static final int M = 9999;
    ArrayList<String> basicas;
    public boolean degenerescencia = false;

    public Matriz(ArrayList<Restricao> restricoes, float[] funcaoOtimizadora) {
        basicas = new ArrayList<>();
        coeficientes = new float[restricoes.size() + 1][Restricao.qntVariaveis]; //+1 por conta da linha do z(funcao otimizadora) 
        setCoeficientes(restricoes, funcaoOtimizadora); //monta as equaçoes + a linha z
        folgas = new float[restricoes.size() + 1][restricoes.size()];
        setFolgas(restricoes);
        artificiais = new float[restricoes.size() + 1][restricoes.size()];
        setArtificiais(restricoes);
        b = new float[restricoes.size() + 1];
        setB(restricoes);

        setQuadro(restricoes.size() + 1, Restricao.qntVariaveis + 2 * restricoes.size() + 1); //( restriçoes + linha z, qnt variaveis + folgas + artificiais + b)
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
                    coeficientes[i][j] = -funcaoOtimizadora[j];
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
            for (int j = 0; j < restricoes.size(); j++) {
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
            for (int j = 0; j < restricoes.size(); j++) {//yrjetyj
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
        b[i] = 0;

    }

    public void setBasicas(ArrayList<Restricao> restricoes) {       //basicas  primeira coluna
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
                    b[b.length - 1] -= b[j] * M;
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
                            int hij = j - coeficientes[0].length - folgas[0].length;
                            quadro[i][j] = artificiais[i][j - coeficientes[0].length - folgas[0].length];
                        } else {
                            quadro[i][j] = b[i];
                        }
                    }
                }
            }

        }
    }

    public int getColunaMenorValorZ(ArrayList<Restricao> restricoes) {    //mudar public
        int numeroColunas = Restricao.qntVariaveis + 2 * restricoes.size() + 1;

        float menor = 1;

        for (int p = 0; p < basicas.size(); p++) {

            if (quadro[restricoes.size()][p] < 0) {
                menor = this.quadro[restricoes.size()][p];
                break;
            }
        }
        if (menor == 1) {
            return -1;
        }
        int j = 0;
        for (int i = 0; i < numeroColunas - 1; i++) {  //-1 tirando o b
            if (this.quadro[restricoes.size()][i] <= menor && this.quadro[restricoes.size()][i] != 0) {
                menor = this.quadro[restricoes.size()][i];
                j = i;
            }
        }

//        for (int i = 0; i < coluna.length; i++) {
//            System.out.println(coluna[i]);
//        }
        return j;
    }

    public int getLinhaMenorPP(int coluna) {

//fazer casos particulares 
        float colunaPivo[] = new float[quadro.length];
        for (int i = 0; i < quadro.length; i++) {
            colunaPivo[i] = this.quadro[i][coluna];
        }

        float pp[] = new float[b.length - 1];
        float menor;

        for (int i = 0; i < b.length - 1; i++) {

            pp[i] = b[i] / colunaPivo[i];

        }
        menor = -1;
        int p;
        for (p = 0; p < basicas.size(); p++) {

            if (pp[p] > 0) {
                menor = pp[p];
                break;
            }
        }
        int linha = p;
        if (menor == -1) {
            return -1;
        }
        for (int i = 0; i < pp.length; i++) {
            if (pp[i] < menor && pp[i] > 0) {
                if (pp[i] != Float.POSITIVE_INFINITY || pp[i] != Float.NEGATIVE_INFINITY) {
                    menor = pp[i];
                    linha = i;
                }

            }
        }

//        for (int i = 0; i < quadro[0].length; i++) {
//            System.out.println(this.quadro[linha][i]);
//            
//        }
        return linha;
    }

    public void interacao(int linha, int coluna) { //linha pivo e coluna pivo

        if (coluna < this.getCoeficientes()[0].length) {
            this.basicas.set(basicas.indexOf(basicas.get(linha)), "x" + (coluna + 1));
        } else if (coluna < (this.getCoeficientes()[0].length + this.getFolgas()[0].length)) {
            this.basicas.set(basicas.indexOf(basicas.get(linha)), "f" + ((coluna + 1) - this.getCoeficientes()[0].length));
        } else {
            this.basicas.set(basicas.indexOf(basicas.get(linha)), "a" + ((coluna + 1) - this.getCoeficientes()[0].length - this.getFolgas()[0].length));
        }

        //System.out.println("______________________" + basicas.indexOf(basicas.get(linha)));
        float num = this.quadro[linha][coluna];
        for (int i = 0; i < quadro[0].length; i++) {
            this.quadro[linha][i] = this.quadro[linha][i] / num;

        }

        for (int i = 0; i < quadro.length; i++) {
            float num1 = this.quadro[i][coluna];
            if (i != linha) {
                for (int j = 0; j < quadro[0].length; j++) {

                    // if (this.quadro[i][j] != 0) {
                    this.quadro[i][j] = this.quadro[i][j] - (num1 * this.quadro[linha][j]);

                    //}
                }

            }
        }
        for (int i = 0; i < this.quadro.length - 1; i++) {
            this.b[i] = this.quadro[i][this.quadro[0].length - 1];
            //System.out.println(this.b[i]);
        }

    }

    public void resolveSimplex(ArrayList<Restricao> restricoes) {
        this.isAjustado();
        while (verificaLinhaZ() == false) {
            this.interacao(this.getLinhaMenorPP(this.getColunaMenorValorZ(restricoes)), this.getColunaMenorValorZ(restricoes));

            if (verificaOtimoNaoFinito(this.getColunaMenorValorZ(restricoes))) {
                break;
            }

        }

    }

    public boolean verificaLinhaZ() {
        for (int i = 0; i < quadro[0].length - 1; i++) {
            if (quadro[quadro.length - 1][i] < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean verificaMultiplasSolucoes() {
        for (int i = this.getCoeficientes()[0].length; i < this.getCoeficientes()[0].length + this.getFolgas()[0].length; i++) {
            for (int j = 0; j < this.quadro.length - 1; j++) {
                //int coluna = this.getCoeficientes().length
                //System.out.println("f" + (i - this.getCoeficientes()[0].length+1));
                //System.out.println(quadro[this.quadro.length-1][i]);

                if (quadro[j][i] > 0 && !this.basicas.contains("f" + (i - this.getCoeficientes()[0].length + 1)) && quadro[this.quadro.length - 1][i] == 0) {
                    return true;
                }
                //System.out.println(quadro[j][i]);
            }

        }
        return false;
    }

    public boolean verificaOtimoNaoFinito(int coluna) {
        //float colunaPivo[] = new float[quadro.length];
        for (int i = 0; i < quadro.length; i++) {
            if ((int) this.quadro[i][coluna] > 0) { //ta arredondando, usar o casting pra int
                return false;
            }

        }
        return true;
    }

    public void verificaDegenerescencia(float pp[]) {
        for (int i = 0; i < pp.length; i++) {
            for (int j = 0; j < pp.length; j++) {

                if (pp[i] != Float.POSITIVE_INFINITY || pp[i] != Float.NEGATIVE_INFINITY) {

                    if (i != j && pp[i] == pp[j]) {
                        this.degenerescencia = true;
                    }
                }

            }
        }
    }
}
