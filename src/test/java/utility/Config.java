package utility;


public class Config {
    public static final String base_url = "http://localhost:3000";
    public static final String admin_url="http://localhost:3001";
    public static final String login_url = base_url + "/login";
    public static final String signup_url = base_url + "/signin";
    public static final String complain_url = base_url + "/complain";
    public static final String form_url = base_url + "/form";


    //public static final String admin_url = base_url;
    //public static final String dashboard_url = base_url + "/dashboard";
    public static final String user_url = admin_url + "/users";
    public static final String comp_url = admin_url + "/complaints";
//    public static final String user_url = base_url + "/users";
//    public static final String comp_url = base_url + "/complaints";
  //  public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe";


    }


