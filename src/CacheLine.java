public class CacheLine {
    private Integer tag;
    private Integer modif;
    private String[] palavras;

    public CacheLine(int k) {
        this.tag = null;
        this.modif = null;
        this.palavras = new String[k];
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setModif(int modif) {
        this.modif = modif;
    }

    public void setPalavras(String[] palavras) {
        this.palavras = palavras;
    }

    public int getTag() {
        return tag;
    }

    public int getModif() {
        return modif;
    }

    public String[] getPalavras() {
        return palavras;
    }
    public int getPalavrasSize() {
        return palavras.length;
    }

    public String getPalavra(int w) {
        return palavras[w];
    }
}
