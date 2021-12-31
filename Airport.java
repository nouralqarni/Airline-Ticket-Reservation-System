public class Airport {
    //Declaring attributes
    private String threeDigitCode;
    private String city;
    private String name;
    
    //----------------------------------------------------------
    public Airport(String threeDigitCode, String city, String name) {
        this.threeDigitCode = threeDigitCode;
        this.city = city;
        this.name = name;
    }
    //----------------------------------------------------------
    public String getThreeDigitCode() {
        return threeDigitCode;
    }
    //----------------------------------------------------------
    public void setThreeDigitCode(String threeDigitCode) {
        this.threeDigitCode = threeDigitCode;
    }
    //----------------------------------------------------------
    public String getCity() {
        return city;
    }
    //----------------------------------------------------------
    public void setCity(String city) {
        this.city = city;
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
    @Override
    public String toString() {
        return String.format("%-14s%-6s%-6s%-13s%-6s%s"
                ,"Airport Code:",getThreeDigitCode()
                ,"City:",getCity()
                ,"Name:",getName());
    }
}
