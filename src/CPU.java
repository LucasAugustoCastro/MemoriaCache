public class CPU {
//    Cache cache;
//    IO es;
//    int pc;
//
//    public CPU(Cache cache, IO es, int pc) {
//        this.cache = cache;
//        this.es = es;
//        this.pc = pc;
//    }
//
//    public void run() {
//        int inferiorLimit = cache.get(pc);
//        int superiorLimit = cache.get(pc + 1);
//
//
//        int count = 0;
//        for(int i = inferiorLimit; i < superiorLimit; i++) {
//            cache.set(i, count);
//            count += 1;
//        }
//
//        for (int i = inferiorLimit; i < superiorLimit; i++) {
//            es.write(cache.get(i));
//        }
//    }
}