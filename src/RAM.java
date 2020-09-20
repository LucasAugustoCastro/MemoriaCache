public class RAM {
    Integer[] array;

    public RAM(Integer lenght) {
        this.array = new Integer[lenght];
    }

    public Integer get(int address) {
        return this.array[address];
    }

    public void set(int position, int word) {
        array[position] = word;
    }

    public Integer getLenght(){
        return array.length;
    }
}