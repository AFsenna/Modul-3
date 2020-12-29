package Entity;

public class Alexandria07103_ItemEntity extends Alexandria07103_GameAbstractEntity{
    private int harga,idx,indexAkun;
    public Alexandria07103_ItemEntity(String nama, int health,int power,int harga) {
        super(nama,health,power);
        this.harga=harga;
    }
    
    public Alexandria07103_ItemEntity(int idx,int indexAkun){
        this.idx=idx;
        this.indexAkun=indexAkun;
    }

    public int getIndexAkun() {
        return indexAkun;
    }

    public void setIndexAkun(int indexAkun) {
        this.indexAkun = indexAkun;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
    
    public int getHarga() {
        return harga;
    }

        @Override
    public int getHealth() {
        return health;}
}
