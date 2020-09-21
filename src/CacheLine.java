public class CacheLine {
    private int tag;
    private boolean modif;
    private short[] palavras;

    public CacheLine(int k) {
        this.tag = -1;
        this.modif = false;
        this.palavras = new short[k];
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setModif(boolean modif) {
        this.modif = modif;
    }

    public void setPalavras(short[] palavras) {
        this.palavras = palavras;
    }

    public void setPalavra(int w, short palavra) { this.palavras[w] = palavra; }

    public int getTag() {
        return tag;
    }

    public boolean getModif() {
        return modif;
    }

    public short[] getPalavras() {
        return palavras;
    }
    public int getPalavrasSize() {
        return palavras.length;
    }

    public short getPalavra(int w) {
        return palavras[w];
    }
}
