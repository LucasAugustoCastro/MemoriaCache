public class Cache {
    private CacheLine[] cacheLines;
    private RAM ram;
    private int cacheMiss;


    public Cache(int cacheSize, int cacheLineSize, RAM ram) {
        this.ram = ram;
        this.cacheLines = new CacheLine[cacheSize];
        for(int i = 0; i <= cacheSize-1; i++){
            this.cacheLines[i] = new CacheLine(cacheLineSize);
        }

    }

    public short get(int x){
        int[] strw = filterSTRW(x);
        if(cacheLines[strw[2]].getTag() != strw[1]){
            System.out.println("Cache miss: " + this.cacheMiss++ );
            getRamBlockTo(strw, x);
        }
        return cacheLines[strw[2]].getPalavra(strw[3]);
    }

    public void set(int x, short palavra) {
        int[] strw = filterSTRW(x);
        if(cacheLines[strw[2]].getTag() != strw[1]){
            System.out.println("Cache miss: "+ this.cacheMiss++);
            getRamBlockTo(strw, x);
        }
        cacheLines[strw[2]].setPalavra(strw[3], palavra);
        cacheLines[strw[2]].setModif(true);
    }

    /**
     * Pegar o s, t, r, w da endereço x passado
     * @param x Endereço requerido pela cpu
     * @return Uma array contendo s, t, r, w
     */
    public int[] filterSTRW(int x){
        int s = x >> 6;
        int w = x & ((1<<6)-1);
        int r = s & ((1<<7)-1);
        int t = s >> 7;
        int[] retur = {s, t, r, w};
        return retur;
    }

    public void getRamBlockTo(int[] strw, int x) {
        int s = strw[0];
        if(cacheLines[strw[2]].getModif()){
            this.ram.setBlock(x, cacheLines[strw[2]].getPalavras());
        }

        short[] block = ram.getBlock(s << 6);
        cacheLines[strw[2]].setTag(strw[1]);
        cacheLines[strw[2]].setPalavras(block);
    }


    public void printCacheLines(){
        for(int i =0; i < cacheLines.length; i++){

            System.out.println(i + " :"  +cacheLines[i].getPalavrasSize());

        }
    }


}