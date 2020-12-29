package Controller;

import Entity.Alexandria07103_AkunEntity;

public class Alexandria07103_AkunController {

    public Alexandria07103_AkunController() {
    }
    public Alexandria07103_AkunEntity getDataAkun(int index) {
        return Alexandria07103_AllObjectModel.akunModel.getAkunEntityArrayList(index);
    }
    public void insert(String nama, String password, int umur, String email,int uangR) {
        Alexandria07103_AkunEntity akun = new Alexandria07103_AkunEntity();
        akun.setEmail(email);
        akun.setUsername(nama);
        akun.setUangR(uangR);
        akun.setPassword(password);
        akun.setUmur(umur);
        Alexandria07103_AllObjectModel.akunModel.insert(akun);
    }
    
    public int cekdataAkun(String nama,String password){
        int cekdata = Alexandria07103_AllObjectModel.akunModel.cekdata(nama, password);
        return cekdata;
    }
    public void delete(int index){
        Alexandria07103_AllObjectModel.akunModel.delete(index);
    }
    public boolean cekKosong(boolean cek){
        boolean cekakun = Alexandria07103_AllObjectModel.akunModel.cekempty(cek);
        return cekakun;
    }
    
}
