public class Cache {
    CacheLine[] cacheLines;
    private String x;
    private String w;
    private String r;
    private String t;
    private String s;

    public Cache(String x, int cacheSize, int cacheLineSize) {
        this.cacheLines = new CacheLine[cacheSize];
        for(int i = 0; i <= cacheSize-1; i++){
            this.cacheLines[i] = new CacheLine(cacheLineSize);
        }
        this.x = x;
        this.t = x.substring(0, 11);
        this.r = x.substring(11, 18);
        this.w = x.substring(18);
        this.s = t + r;

    }

    public void filterSTRW(int x){

    }

    public void printCacheLines(){
        for(int i =0; i < cacheLines.length; i++){

            System.out.println(i + " :"  +cacheLines[i].getPalavrasSize());

        }
        System.out.println(x + " - " + t + " - " + r + " - " + w + " - " + s );
    }


}