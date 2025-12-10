public class Mobil extends Kendaraan
{
    public Mobil(String merk, String platNomor)
    {
        super(merk, platNomor);
    }

    @Override
    public String getInfo()
    {
        String status = isTersedia ? "[Tersedia]" : "[Disewa]";
        return status + " Mobil " + merk + " (" + platNomor + ")";
    }
}
