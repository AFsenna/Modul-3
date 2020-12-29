package Main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import Controller.*;

public class Alexandria07103_Main {
    
    private static Alexandria07103_GameController game = new Alexandria07103_GameController();
    private static Alexandria07103_AkunController akun = new Alexandria07103_AkunController();
    private static Scanner input = new Scanner(System.in);
    private static Random rand = new Random();
    private static String kembali;
    private static int cekdata,cekH,loop,loopP;
    
    public static void main(String[] args){
        Alexandria07103_Main main = new Alexandria07103_Main();
        String jawab;
        int pil;
        boolean cek=false;
        game.dataToko();
        game.dataArena();
        do{  
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Selamat Datang Pada Monster Arena~!");
            System.out.println("Sudah memiliki akun?");
            System.out.println("a. sudah");
            System.out.println("b. belum");
            do{
            System.out.print("Pilihan = ");
            jawab = input.next();
            }while(!"a".equals(jawab)&&!"b".equals(jawab));
            if("b".equals(jawab)){
                main.Daftar();
            }
            else if("a".equals(jawab)){
                cek = akun.cekKosong(cek);
                if(cek==false){
                    main.Login();
                    System.out.println("Ingin hapus akun atau kembali ke tampilan awal?");
                    System.out.println("a. kembali");
                    System.out.println("b. hapus");
                    System.out.println("c. keluar");
                    do{
                        System.out.print("Pilihan = ");
                        kembali = input.next();
                    }while(!"a".equals(kembali)&&!"b".equals(kembali)&&!"c".equals(kembali));
                    System.out.println();
                    if("c".equals(kembali)){
                        System.out.println("byee~~");
                        System.out.println();
                        break;
                    }
                    else if("b".equals(kembali)){
                        akun.delete(cekdata);
                        System.out.println("Akun sudah terhapus\n");
                    }
                }
                else if(cek==true){
                    System.out.println("BELUM ADA AKUN YANG TERDAFTAR\n");
                    break;
                }
            }
        }while ("a".equals(kembali)||"b".equals(kembali)||"b".equals(jawab));
    }
    
    void Daftar(){
        System.out.println("\nBergabunglah bersama kami~");
        try{
        System.out.print("Masukkan Username      : ");
        String username = input.next();
        System.out.print("Masukkan Password      : ");
        String password = input.next();
        System.out.print("Masukkan Umur          : ");
        int umur = input.nextInt();
        System.out.print("Masukkan Email         : ");
        String email = input.next();
        System.out.println("\n Anda Mendapatkan Uang Sebanyak 5.000 !!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        akun.insert(username,password,umur,email,5000);
        }catch(InputMismatchException e){
            System.out.println("Format yang anda masukkan salah !!");
            System.out.println("pendaftaran gagal~\n");
        }
        input.nextLine();
    }
    
    void Login(){
        boolean ada;
        int loopL = 0;
        System.out.println("\nlogin dulu ya!");
        System.out.print("Masukkan Username      : ");
        String nama = input.next();
        System.out.print("Masukkan Password      : ");
        String password = input.next();
        try {
            cekdata = akun.cekdataAkun(nama,password);
        }catch (Exception e){
            System.out.println("\nUsername atau Password Salah !!!\n");
        }
        System.out.println("\n~~~~Selamat datang "+akun.getDataAkun(cekdata).getUsername()+"~~");
        do{  
            try{
                int pilihan;
                System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");  
                System.out.println("1. Shop");
                System.out.println("2. Arena");
                System.out.println("3. Akun");
                System.out.println("4. Exit");
                System.out.print("Kemana kita akan pergi? no ");
                pilihan = input.nextInt();
                switch(pilihan){
                    case 1 :
                        Shop();
                        break;
                    case 2 :
                        Arena();
                        break;
                    case 3:
                        Akun();
                        break;
                    default:
                        loopL=1;
                        break;
                };  
            }catch(InputMismatchException e){
                System.out.println("\nFormat yang anda masukkan salah !!\n");
            }
            input.nextLine();
        }while(loopL!=1);  
    }
      
    void Shop(){
        int nomer,hasil,hasilP,uang,idx,idxP,pilih;
        String jawab;
        System.out.println("$$$$$$$$$$ WELCOME TO STORE $$$$$$$$$$\n");
        System.out.println("Uang anda saat ini : "+akun.getDataAkun(cekdata).getUangR());        
        System.out.println("1. Spin Gacha");
        System.out.println("2. Buy Potion");
        System.out.print("Mau beli no berapa? no ");
        nomer=input.nextInt();
        switch(nomer){
            case 1 :
                if(akun.getDataAkun(cekdata).getUangR()<2500){
                    System.out.println("Uang anda tidak cukup untuk gacha");
                }
                else{
                    System.out.println("Lakukan gacha? (2500/spin)");
                    jawab = input.next();
                    while("ya".equals(jawab)){
                        hasil = rand.nextInt(100);
                        idx = hasil%4;
                        System.out.println("\nAnda Mendapatkan hero "+game.showHero(idx).getNama());
                        System.out.println("BIODATA HERO");
                        System.out.println(" Health : "+game.showHero(idx).getHealth());
                        System.out.println(" Power  : "+game.showHero(idx).getPower());
                        System.out.println(" Role   : "+game.showHero(idx).getRole()+"\n");
                        game.getDataHero(loop).setIndex(idx);
                        game.getDataHero(loop).setIndexAkun(cekdata);
                        loop++;
                        akun.getDataAkun(cekdata).setLoop(loop);
                        uang = akun.getDataAkun(cekdata).getUangR()-2500;
                        akun.getDataAkun(cekdata).setUangR(uang);
                        break;
                    }        
                }
                break;
            case 2 :
                if(akun.getDataAkun(cekdata).getUangR()<1500){
             System.out.println("Uang anda tidak cukup untuk membeli Potion");
                }
                else{
                    System.out.println("Beli potion? (1500/purchase)");
                    jawab=input.next();
                    while("ya".equals(jawab)){
                        hasilP = rand.nextInt(100);
                        idxP = hasilP%3;
                        System.out.println("\nPotion yang didapat");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println(" Potion  : "+game.getDataItem(idxP).getNama());
                        System.out.println(" Atribut : + Health "+game.getDataItem(idxP).getHealth());
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        game.getDataItem(loopP).setIdx(idxP);
                        game.getDataItem(loopP).setIndexAkun(cekdata);
                        loopP++;
                        akun.getDataAkun(cekdata).setLoopP(loopP);
                        break;
                    }
                    if("ya".equals(jawab)){
                        uang = akun.getDataAkun(cekdata).getUangR()-1500;
                        akun.getDataAkun(cekdata).setUangR(uang);
                    }   
                }
                break;
        }
    }
    
    void pickhero(){
        int pilih,loopcek=0;
        System.out.println("Hero yang dimiliki : ");
        for(int i=0;i<akun.getDataAkun(cekdata).getLoop();i++){
            if(game.getDataHero(i).getIndexAkun() == cekdata){
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(" No Hero       : "+game.getDataHero(game.showHero(i).getIndex()).getNoHero());
                System.out.println(" Nama Hero     : "+game.getDataHero(game.showHero(i).getIndex()).getNama());
                System.out.println(" Power         : "+game.getDataHero(game.showHero(i).getIndex()).getPower());
                System.out.println(" Health        : "+game.getDataHero(game.showHero(i).getIndex()).getHealth());
                System.out.println(" Role          : "+game.getDataHero(game.showHero(i).getIndex()).getRole());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }
        do{
            System.out.print("no hero yang digunakan = ");
            pilih=input.nextInt();
            System.out.println();
            for(int i=0;i<akun.getDataAkun(cekdata).getLoop();i++){
                if(game.showHero(game.showHero(i).getIndex()).getNoHero()==pilih){
                    loopcek=1;
                    break;
                }else{
                    System.out.println("Hero tidak ada ulangi inputan");
                }   
            }
        }while(loopcek!=1);
        cekH = pilih-1;
    }
    
    void Arena(){
        if(loop==0){
            System.out.println("Tidak memiliki hero untuk masuk ke arena");
        }
        else{
            int hasil2,no,uangNew,pilih;
            int darahH,darahM,pilihP,newHealth;
            boolean fight=true;
            System.out.println("----------WELCOME TO ARENA "+akun.getDataAkun(cekdata).getUsername()+" ~!----------");
            hasil2 = rand.nextInt(100);
            no = hasil2%4;
            System.out.println("\n"+game.showMonster(no).getKarakterM()+"\n");
            System.out.println(game.showMonster(no).getNama()+" Has Arrived\n");
            System.out.println("------STATS------");
            System.out.println("Power  : "+game.showMonster(no).getPower());
            System.out.println("Health : "+game.showMonster(no).getHealth());
            System.out.println("\n###############################################\n");
            pickhero();
            System.out.println("---STATS HERO---");
            System.out.println("Nama   : "+game.showHero(cekH).getNama());
            System.out.println("Power  : "+game.showHero(cekH).getPower());
            System.out.println("Health : "+game.showHero(cekH).getHealth());
            System.out.println("\n###############################################\n");
            do {
                System.out.println("1. Attack");
                System.out.println("2. Use Potion");
                System.out.println("3. Go to Shop");
                System.out.println("4. Surrender");
                System.out.println("5. Change hero");
                System.out.print("Apa pilihannya? no ");
                pilih = input.nextInt();
                System.out.println();
                if(pilih == 4){
                    System.out.println("losers（＞ｙ＜）");
                    break;
                }
                else if(pilih==5){
                    pickhero();
                }
                else if(pilih == 2){
                    if(akun.getDataAkun(cekdata).getLoopP()!=0){
                        System.out.println("Potion yang dimiliki : ");
                        for(int i=0;i<akun.getDataAkun(cekdata).getLoopP();i++){
                            if(game.getDataItem(i).getIndexAkun() == cekdata){
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println(" Potion  : "+game.getDataItem(game.showItem(i).getIdx()).getNama());
                                System.out.println(" Atribut : + Health "+game.getDataItem(game.showItem(i).getIdx()).getHealth());
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            }
                        }
                        System.out.println("Ingin menambah berapa Health?");
                        pilihP=input.nextInt();
                        newHealth = game.showHero(cekH).getHealth() + pilihP;
                        game.getDataHero(cekH).setHealth(newHealth);
                    }else{
                        System.out.println("Belum ada potion");
                    }
                }
                else if(pilih == 3){
                    Shop();
                }
                else{
                    switch(pilih){
                        case 1:
                            System.out.println(game.showHero(cekH).getNama()+" VS "+game.showMonster(no).getNama());
                            System.out.println("Health hero     : "+game.showHero(cekH).getHealth());
                            System.out.println("Power hero      : "+game.showHero(cekH).getPower());
                            int healthM = game.showMonster(no).getHealth();
                            int powerM = game.showMonster(no).getPower();
                            System.out.println("Health Monster  : "+healthM);
                            System.out.println("Power Monster   : "+powerM);
                            System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                            System.out.println("Hero memberikan damage sebesar    : "+game.showHero(cekH).getPower());
                            darahM = healthM - game.showHero(cekH).getPower();
                            if(darahM>0){
                                System.out.println("Health monster saat ini           : "+darahM);
                                game.getDataMonster(no).setHealth(darahM);
                            }
                            if(darahM <= 0){
                                System.out.println("Health monster saat ini           : 0");
                                System.out.println("\n***Hasil pertarungan = Monster Kalah***");
                                uangNew = akun.getDataAkun(cekdata).getUangR() + game.showMonster(no).getUangM();
                                akun.getDataAkun(cekdata).setUangR(uangNew);
                                fight=false;
                            }
                            else{
                                System.out.println("Monster memberikan damage sebesar : "+powerM);
                                darahH = game.showHero(cekH).getHealth() - powerM;
                                if(darahH>0){
                                    System.out.println("Health hero saat ini              : "+darahH);
                                    game.getDataHero(cekH).setHealth(darahH);
                                }
                                else if(darahH <=0){
                                    System.out.println("Health hero saat ini              : 0");
                                    System.out.println("\n@@@Hasil pertarungan = Hero Kalah@@@");
                                    fight=false;
                                }
                            }
                        break;
                    }
                }
            }while(fight==true);
            game.setstatsMonster();
            game.setstatsHero();
        } 
    }
    
    void Akun(){
        String jawab;
        int pil;
        try{
        System.out.println("1. Inventory");
        System.out.println("2. Data Akun");
        System.out.print("Ingin lihat yang mana? ");
        pil = input.nextInt();
        switch(pil){
            case 1 :
                System.out.println("\nHero yang dimiliki  : ");
                if(akun.getDataAkun(cekdata).getLoop()==0){
                    System.out.println("Belum punya hero");
                }
                for(int i=0;i<akun.getDataAkun(cekdata).getLoop();i++){
                    if(game.getDataHero(i).getIndexAkun() == cekdata){
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println(" No Hero       : "+game.getDataHero(game.showHero(i).getIndex()).getNoHero());
                        System.out.println(" Nama Hero     : "+game.getDataHero(game.showHero(i).getIndex()).getNama());
                        System.out.println(" Power         : "+game.getDataHero(game.showHero(i).getIndex()).getPower());
                        System.out.println(" Health        : "+game.getDataHero(game.showHero(i).getIndex()).getHealth());
                        System.out.println(" Role          : "+game.getDataHero(game.showHero(i).getIndex()).getRole());
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                }
                System.out.println("\nPotion yang dimiliki : ");
                if(akun.getDataAkun(cekdata).getLoopP()!=0){
                    for(int i=0;i<akun.getDataAkun(cekdata).getLoopP();i++){
                        if(game.getDataItem(i).getIndexAkun() == cekdata){
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println(" Potion  : "+game.getDataItem(game.showItem(i).getIdx()).getNama());
                            System.out.println(" Atribut : + Health "+game.getDataItem(game.showItem(i).getIdx()).getHealth());
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        }
                    }
                }else{
                    System.out.println("Belum ada potion");
                }
                break;
            case 2 :
                System.out.println("\nData Akun");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(" Username      : "+akun.getDataAkun(cekdata).getUsername());
                System.out.println(" Password      : "+akun.getDataAkun(cekdata).getPassword());
                System.out.println(" Email         : "+akun.getDataAkun(cekdata).getEmail());
                System.out.println(" Uang          : "+akun.getDataAkun(cekdata).getUangR());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                break;
            default :
                System.out.println("\nPilihan salah");
        }
        }catch(InputMismatchException e){
            System.out.println("\nFormat pengisian salah!!\n");   
        }
    }   
}