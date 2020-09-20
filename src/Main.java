public class Main {
    public static void main(String[] args) {
//        IO es = new IO(System.out);
//        RAM ram = new RAM(128);
        Cache cache = new Cache("101010101010101010101010", 128, 64);
        cache.printCacheLines();
        //        CPU cpu = new CPU(cache, es, 70);

//        cache.set(70, 10);
//        cache.set(71, 15);

//        cpu.run();
    }
}