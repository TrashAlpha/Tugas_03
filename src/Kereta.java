public class Kereta {
    private static final int batasTiketKomuter = 1000;
    private String namaKereta;
    private int sisaTiket;
    private Ticket tiket;

    public Kereta(){
        tiket = new Ticket(); // objek Ticket untuk kereta komuter
        namaKereta = "komuter"; // menginisialisasi nama kereta sebagai "komuter"
    }

    public Kereta(String namaKereta, int jumlahTiket){
        this.namaKereta = namaKereta; // menginisialisasi nama kereta sesuai parameter
        this.sisaTiket = jumlahTiket; // menginisialisasi sisa tiket sesuai parameter
        tiket = new Ticket(namaKereta, jumlahTiket); // pbjek Ticket untuk kereta KAJJ
    }

    // method untuk menambah tiket kereta komuter
    public void tambahTiket(String namaPenumpang){
        if (tiket.getNamaPenumpang().length < batasTiketKomuter) { // program dijalankan jika jumlah penumpang masih dibawah batas tiket
            String[] penumpang = tiket.getNamaPenumpang(); // membuat array untuk nama penumpang yang sudah ada
            String[] newPenumpang = new String[penumpang.length + 1]; // membuat array baru dengan ukuran lebih besar
            System.arraycopy(penumpang, 0, newPenumpang, 0, penumpang.length); // mengcopy data array lama ke array baru
            newPenumpang[penumpang.length] = namaPenumpang; // menambah nama penumpang baru ke array yang baru
            tiket.setNamaPenumpang(newPenumpang); // mengupdate array nama penumpang pada objek Ticket
            System.out.println("==================================================");
            System.out.println("Tiket berhasil dipesan");
        } else { // apabila jumlah penumpang diluar batas tiket, maka akan dijalankan program berikut
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    // method untuk menambah tiket kereta KAJJ
    public void tambahTiket(String namaPenumpang, String asalPenumpang, String tujuanPenumpang){
        // apabila asal dan tujuan tidak terisi maka program dibawahnya akan dijalankan
        if (asalPenumpang == null || tujuanPenumpang == null) {
            System.out.println("Maaf, penumpang KAJJ harus memiliki asal dan tujuan");
            return;
        }

        // program berjalan apabila tiket masih ada
        if (tiket.getNamaPenumpang().length < sisaTiket){
            // untuk menambah nama penumpang (cara kerja sama dengan menambah penumpang pada method tambahTiket untuk kereta komuter)
            String[] penumpang = tiket.getNamaPenumpang();
            String[] newPenumpang = new String[penumpang.length + 1];
            System.arraycopy(penumpang, 0, newPenumpang, 0, penumpang.length);
            newPenumpang[penumpang.length] = namaPenumpang;
            tiket.setNamaPenumpang(newPenumpang);

            // untuk menambah asal penumpang (cara kerja sama dengan menambah penumpang pada method tambahTiket untuk kereta komuter)
            String[] asal = tiket.getAsal();
            String[] newAsal = new String[asal.length + 1];
            System.arraycopy(asal, 0, newAsal, 0, asal.length);
            newAsal[asal.length] = asalPenumpang;
            tiket.setAsal(newAsal);

            // untuk menambah tujuan dari penumpang (cara kerja sama dengan menambah penumpang pada method tambahTiket untuk kereta komuter)
            String[] tujuan = tiket.getTujuan();
            String[] newTujuan = new String[tujuan.length + 1];
            System.arraycopy(tujuan, 0, newTujuan, 0, tujuan.length);
            newTujuan[tujuan.length] = tujuanPenumpang;
            tiket.setTujuan(newTujuan);

            System.out.println("==================================================");
            if((sisaTiket - tiket.getNamaPenumpang().length) < 30){ // untuk menampilkan sisa tiket jika jumlah tiket yang tersedia kurang dari 30
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + (sisaTiket - tiket.getNamaPenumpang().length));
            }else System.out.println("Tiket berhasil dipesan");
        } else { // apabila jumlah penumpang melebihi jumlah tiket yang tersedia, maka akan dijalankan program berikut
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    // method untuk menampilkan tiket yang sudah dipesan
    public void tampilkanTiket(){
        if(namaKereta.equals("komuter")){ // dijalankan apabila kereta merupakan kereta komuter
            String[] namaKomuter = tiket.getNamaPenumpang();
            if(namaKomuter != null && namaKomuter.length > 0){ // apabila ada penumpang, maka program dibawahnya akan dijalanlankan
                System.out.println("==================================================");
                System.out.println("Daftar penumpang kereta api " + namaKereta +": ");
                System.out.println("----------------------------");
                if (namaKomuter.length > 970 && namaKomuter.length < batasTiketKomuter) { //apabila sisa tiket lebih kecil dari 30 maka akan di print sisa tiketnya
                System.out.println("Sisa tiket komuter: " + (batasTiketKomuter - namaKomuter.length));
                }
                for (String nama : namaKomuter) { // for-each loop untuk menampilkan nama penumpang
                System.out.println("Nama: " + nama);
                }
            }   
        }else{ // jika kereta bukan komuter maka program berikut akan dijalankan
            String[] namaKAJJ = tiket.getNamaPenumpang();
            if (namaKAJJ != null && namaKAJJ.length > 0) { // apabila ada penumpang, maka program dibawahnya akan dijalanlankan
                System.out.println("==================================================");
                System.out.println("Daftar penumpang kereta api " + namaKereta + ": ");
                for (int i = 0; i < namaKAJJ.length; i++) { // for loop untuk menampilkan nama, asal, dan tujuan penumpang
                    System.out.println("----------------------------");
                    System.out.println("Nama: " + namaKAJJ[i]);
                    System.out.println("Asal: " + tiket.getAsal()[i]);
                    System.out.println("Tujuan: " + tiket.getTujuan()[i]);
                }
                System.out.println("----------------------------");
            } 
        }
    }
}
