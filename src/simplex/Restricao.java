package simplex;

public class Restricao {

    private float[] coeficientes; //posiçao dele no vetor
    private float folga;
    private float b;
    private float artificial;
    private String tipo;
    private String relacao;
    static int qntVariaveis = 0;

    public Restricao() {
    }

    public Restricao(float[] coeficientes, String tipo, String relacao, float b) {
        
        this.coeficientes = new float[qntVariaveis];
        this.coeficientes = coeficientes;
        this.tipo = tipo;
        this.b = b;
        this.relacao = relacao;
        switch (relacao) {
            case ">=":
                this.artificial = 1;
                this.folga = -1;
                break;
            case "=":
                this.artificial = 1;
                this.folga = 0;
                break;
            case "<=":
                this.artificial = 0;
                this.folga = 1;
                break;
            default:
                break;
        }
    }

    public float[] getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(float[] coeficientes) {
        this.coeficientes = coeficientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }

    public float getFolga() {
        return folga;
    }

    public void setFolga(float folga) {
        this.folga = folga;
    }

    public float getArtificial() {
        return artificial;
    }

    public void setArtificial(float artificial) {
        this.artificial = artificial;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public static int getQntVariaveis() {
        return qntVariaveis;
    }

    public static void setQntVariaveis(int qntVariaveis) {
        Restricao.qntVariaveis = qntVariaveis;
    }

}
