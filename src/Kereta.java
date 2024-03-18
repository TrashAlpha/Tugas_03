public class Kereta {
    private static final int batasTiketKomuter = 1000;
    private String namaKereta;
    private int sisaTiket;
    private Ticket tiket;

    public Kereta(){
        tiket = new Ticket();
        namaKereta = "komuter";
    }

    public Kereta(String namaKereta, int jumlahTiket){
        this.namaKereta = namaKereta;
        this.sisaTiket = jumlahTiket;
        tiket = new Ticket(namaKereta, jumlahTiket);
    }

    public void tambahTiket(String namaPenumpang){
        if (tiket.getNamaPenumpang().length < batasTiketKomuter) {
            String[] penumpang = tiket.getNamaPenumpang();
            String[] newPenumpang = new String[penumpang.length + 1];
            System.arraycopy(penumpang, 0, newPenumpang, 0, penumpang.length);
            newPenumpang[penumpang.length] = namaPenumpang;
            tiket.setNamaPenumpang(newPenumpang);
            System.out.println("==================================================");
            System.out.println("Tiket berhasil dipesan");
        } else {
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    public void tambahTiket(String namaPenumpang, String asalPenumpang, String tujuanPenumpang){
        if (asalPenumpang == null || tujuanPenumpang == null) {
            System.out.println("Maaf, penumpang KAJJ harus memiliki asal dan tujuan");
            return;
        }

        if (tiket.getNamaPenumpang().length < sisaTiket){
            String[] penumpang = tiket.getNamaPenumpang();
            String[] newPenumpang = new String[penumpang.length + 1];
            System.arraycopy(penumpang, 0, newPenumpang, 0, penumpang.length);
            newPenumpang[penumpang.length] = namaPenumpang;
            tiket.setNamaPenumpang(newPenumpang);

            String[] asal = tiket.getAsal();
            String[] newAsal = new String[asal.length + 1];
            System.arraycopy(asal, 0, newAsal, 0, asal.length);
            newAsal[asal.length] = asalPenumpang;
            tiket.setAsal(newAsal);

            String[] tujuan = tiket.getTujuan();
            String[] newTujuan = new String[tujuan.length + 1];
            System.arraycopy(tujuan, 0, newTujuan, 0, tujuan.length);
            newTujuan[tujuan.length] = tujuanPenumpang;
            tiket.setTujuan(newTujuan);

            System.out.println("==================================================");
            if((sisaTiket - tiket.getNamaPenumpang().length) < 30){
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + (sisaTiket - tiket.getNamaPenumpang().length));
            }else System.out.println("Tiket berhasil dipesan");
        } else {
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    public void tampilkanTiket(){
        if(namaKereta.equals("komuter")){
            String[] namaKomuter = tiket.getNamaPenumpang();
            if(namaKomuter != null && namaKomuter.length > 0){
                System.out.println("==================================================");
                System.out.println("Daftar penumpang kereta api " + namaKereta +": ");
                if (namaKomuter.length > 970 && namaKomuter.length < batasTiketKomuter) {
                System.out.println("Sisa tiket komuter: " + (batasTiketKomuter - namaKomuter.length));
                }
                for (String nama : namaKomuter) {
                System.out.println("Nama: " + nama);
                }
            }   
        }else{
            String[] namaKAJJ = tiket.getNamaPenumpang();
            if (namaKAJJ != null && namaKAJJ.length > 0) {
                System.out.println("==================================================");
                System.out.println("Daftar penumpang kereta api " + namaKereta + ": ");
                for (int i = 0; i < namaKAJJ.length; i++) {
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
