public class Main {
    public static void main(String[] args) {
        int k = 64;
        int tCACHE = 8 * 1024;
        int tRAM = 16*1024*1024;

        IO es = new IO(System.out);
        RAM ram = new RAM(tRAM, k);
        Cache cache = new Cache(tCACHE, k, ram);
        CPU cpu = new CPU(cache, es, 0);

        ram.set(0, (short)1080);
        ram.set(1, (short)7800);

        cpu.run();

    }
}