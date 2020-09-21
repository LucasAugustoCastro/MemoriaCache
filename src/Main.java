public class Main {
    public static void main(String[] args) {
        IO es = new IO(System.out);
        RAM ram = new RAM(16777216, 64);
        Cache cache = new Cache(128, 64, ram);
        CPU cpu = new CPU(cache, es, 0);

        ram.set(0, (short)1080);
        ram.set(1, (short)7800);

        cpu.run();

    }
}