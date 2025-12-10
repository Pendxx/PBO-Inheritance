public class Motor extends Kendaraan
{
    public Motor(String merk, String platNomor)
    {
        super(merk, platNomor);
    }

    @Override
    public String getInfo()
    {
        String status = isTersedia ? "[Tersedia]" : "[Disewa]";
        return status + " Motor " + merk + " (" + platNomor + ")";
    }
}
