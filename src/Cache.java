public class Cache {
    private CacheLine[] cacheLines;
    private RAM ram;
    private int cacheMiss, nbits_x, nbits_s, nbits_t, nbits_r, nbits_w;


    public Cache(int tCACHE, int k, RAM ram) {
        this.ram = ram;
        this.cacheLines = new CacheLine[tCACHE/k];
        for(int i = 0; i < (tCACHE/k); i++){
            this.cacheLines[i] = new CacheLine(k);
        }


        // Fazendo calculo do tamanho dos s, t, r, w
        this.nbits_x = nbits(ram.getLenght());
        this.nbits_w = nbits(k);
        this.nbits_s = nbits_x - nbits_w;
        this.nbits_r = nbits(tCACHE/k);
        this.nbits_t = nbits_s - nbits_r;

    }

    /**
     * Função para calcular o numero de bits de um numero
     * @param v Número para calculo de bits
     * @return Número de bits
     */
    public int nbits(int v) {
        int cont = 0;
        while (v > 0) {
            v = v >> 1;
            ++cont;
        }
        return cont-1;
    }

    /**
     * Verifica caso a tag seja diferente, caso seja ira trazer o bloco na ram e armazenar na cache, após armazenar
     * ira retornar o valor pedido
     * @param x Endereço requerido pela cpu
     * @return Valor pedido
     */
    public short get(int x){
        int[] strw = filterSTRW(x);

        // Verifica se a tag é diferente, caso seja ira dar cache miss e chamar a função getRamBlockTo, para buscar o bloco e salvar na ram
        if(cacheLines[strw[2]].getTag() != strw[1]){
            System.out.println("Cache miss: " + this.cacheMiss++ );
            getRamBlockTo(strw, x);
        }

        // retorna valor salvo na cache
        return cacheLines[strw[2]].getPalavra(strw[3]);
    }

    /**
     * Seta o valor na cache, muda o modif para true
     * @param x Endereço requerido pela cpu
     * @param palavra valor para armazenar
     */
    public void set(int x, short palavra) {
        int[] strw = filterSTRW(x);

        // Verifica se a tag é diferente, caso seja ira dar cache miss e chamar a função getRamBlockTo, para buscar o bloco e salvar na ram
        if(cacheLines[strw[2]].getTag() != strw[1]){
            System.out.println("Cache miss: "+ this.cacheMiss++);
            getRamBlockTo(strw, x);
        }

        // seta o novo valor na cache trocando o valor do modif pra true
        cacheLines[strw[2]].setPalavra(strw[3], palavra);
        cacheLines[strw[2]].setModif(true);
    }

    /**
     * Pegar o s, t, r, w da endereço x passado
     * @param x Endereço requerido pela cpu
     * @return Uma array contendo s, t, r, w
     */
    public int[] filterSTRW(int x){
        int s = x >> nbits_w;
        int w = x & ((1<<nbits_w)-1);
        int r = s & ((1<<nbits_r)-1);
        int t = s >> nbits_r;
        int[] retur = {s, t, r, w};
        return retur;
    }

    /**
     * Busca o bloco na cache, caso na ram o bloco a ser substituido tenha o modif como true ele salva na ram antes de
     * substituir pelo novo bloco
     * @param strw array com cada valor do s, t, r, w
     * @param x Endereço requerido pela cpu
     */
    public void getRamBlockTo(int[] strw, int x) {
        int s = strw[0];

        // verifica se modif é true
        if(cacheLines[strw[2]].getModif()){
            // caso seja seta na ram o valor modificado
            this.ram.setBlock(s << nbits_w, cacheLines[strw[2]].getPalavras());
        }

        // seta na cache o bloco da ram e a tag referente
        short[] block = ram.getBlock(s << nbits_w);
        cacheLines[strw[2]].setTag(strw[1]);
        cacheLines[strw[2]].setPalavras(block);
    }

}