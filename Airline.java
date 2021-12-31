public class Airline {
    //Declaring attributes
    private String twoDigitCode;
    private String name;
    private String originCountry;
    private String website;
    
    //----------------------------------------------------------
    public Airline(String twoDigitCode, String name, String originCountry, String website) {
        this.twoDigitCode = twoDigitCode;
        this.name = name;
        this.originCountry = originCountry;
        this.website = website;
    }
    //----------------------------------------------------------
    public String getTwoDigitCode() {
        return twoDigitCode;
    }
    //----------------------------------------------------------
    public void setTwoDigitCode(String twoDigitCode) {
        this.twoDigitCode = twoDigitCode;
    }
    //----------------------------------------------------------
    public String getName() {
        return name;
    }
    //----------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }
    //----------------------------------------------------------
    public String getCountry() {
        return originCountry;
    }
    //----------------------------------------------------------
    public void setCountry(String originCountry) {
        this.originCountry = originCountry;
    }
    //----------------------------------------------------------
    public String getWebsite() {
        return website;
    }
    //----------------------------------------------------------
    public void setWebsite(String website) {
        this.website = website;
    }
    //----------------------------------------------------------
    @Override
    public String toString() {
        return String.format("%-13s%-5s%-9s%-15s%-5s%-5s%-5s%s"
                ,"Airline No.:",getTwoDigitCode()
                ,"Airline:",getName()
                ,"Hob:",getCountry()
                ,"URL:",getWebsite());
    }
}
