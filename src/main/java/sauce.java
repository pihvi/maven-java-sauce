import com.thoughtworks.selenium.*;

@SuppressWarnings("deprecation")
public class sauce extends SeleneseTestCase {
	private static final String username = "smith";
	private static final String accessKey = "smith requires no keys";

	@Override
	public void setUp() {
        selenium = new DefaultSelenium(
                "ondemand.saucelabs.com",
                80,
                "{\"username\": \""+username+"\"," +
                "\"access-key\": \""+accessKey+"\"," +
                "\"os\": \"Windows 2003\"," +
                "\"browser\": \"firefox\"," +
                "\"browser-version\": \"3.\"," +
                "\"name\": \"JDave.org title test\"}",
                "http://jdave.org/");
        selenium.start();
    }
    
	public void testSauce() throws Exception {
        selenium.open("/");
        assertEquals("JDave", selenium.getTitle());
    }

    @Override
	public void tearDown() {
        selenium.stop();
    }
}