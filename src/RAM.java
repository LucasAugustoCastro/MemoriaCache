public class RAM {
    short[] array;
    int blocksize;

    public RAM(Integer lenght, int blocksize) {
        this.array = new short[lenght];
        this.blocksize = blocksize;
    }

    public short get(int address) {
        return this.array[address];
    }

    public void set(int position, short word) {
        array[position] = word;
    }

    public int getLenght(){
        return array.length;
    }

    public int getBlocksize() {
        return blocksize;
    }

    public void setBlocksize(int blocksize) {
        this.blocksize = blocksize;
    }

    public short[] getBlock(int x) {
        short[] block = new short[blocksize];
        for(int i = x; i < x + blocksize; i++){
            block[i - x] = get(i);
        }
        return block;
    }

    public short[] setBlock(int blockStart, short[] palavras) {
        short[] block = new short[blocksize];
        for(int i = blockStart; i < blockStart + blocksize; i++){
            set(i, palavras[i - blockStart]);
            block[i] = get(i);
        }
        return block;
    }
}