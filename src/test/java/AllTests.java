import org.example.LoginTest;
import org.example.PhotosTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({PhotosTest.class, LoginTest.class})
public class AllTests {}