package gitlab.common;

public class Global_VARS {
    public static final String REMOTE_CONFIG_FILE = "src/test/resources/remoteConfiguration.properties";

    // Path for Reporting
    public static final String PATH_SUREFIRE_REPORTS = "target/surefire-reports/";

    public static String login = System.getProperty("login", "Waters");
    public static String password = System.getProperty("password", "User135");
    public static String aDriverType = System.getProperty("driverType", "FIREFOX-REMOTE");


}
