public abstract class Kendaraan
{
    protected String merk;
    protected String platNomor;
    protected boolean isTersedia;

    public Kendaraan(String merk, String platNomor)
    {
        this.merk = merk;
        this.platNomor = platNomor;
        this.isTersedia = true;
    }

    public void sewa() {
        this.isTersedia = false;
    }

    public void kembalikan() {
        this.isTersedia = true;
    }
    
    public boolean getStatus() {
        return isTersedia;
    }

    public abstract String getInfo();
}
