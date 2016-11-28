package homework;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;

public class TriangleTypeDetectorTest {

    TriangleTypeDetector detector;
    ReaderXML readerXML = new ReaderXML();
    private final String FILE_PATH = System.getProperty("user.dir") + "/Data_Provider.xml";
    private static final String ILLEGAL = "illegal";
    private static final String ISOSCELES = "isosceles";
    private static final String EQUILATERAL = "equilateral";
    private static final String NORMAL = "normal";
    private static final String[] SIDES = {"side_a", "side_b", "side_c"};


    @BeforeTest
    public void setUp() {
        detector = new TriangleTypeDetector();
    }

    @DataProvider(name = "illegal from XML")
    public Object[][] readIllegalValuesXml() throws Exception {
        return readerXML.read(FILE_PATH, ILLEGAL, SIDES);
    }

    @DataProvider(name = "isosceles from XML")
    public Object[][] readIsoscelesValuesXml() throws Exception {
        return readerXML.read(FILE_PATH, ISOSCELES, SIDES);
    }

    @DataProvider(name = "normal from XML")
    public Object[][] readNormalValuesXml() throws Exception {
        return readerXML.read(FILE_PATH, NORMAL, SIDES);
    }
    @DataProvider(name = "equilateral from XML")
    public Object[][] readEquilateralValuesXml() throws Exception {
        return readerXML.read(FILE_PATH, EQUILATERAL, SIDES);
    }

    @Test(dataProvider = "illegal from XML", expectedExceptions = Exception.class)
    public void testNegativeSetIllegalSides(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        detector.detectTriangle(a, b, c);
    }

    @Test(dataProvider = "isosceles from XML")
    public void testPositiveDetectIsoscelesTriangle(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        Assert.assertEquals(detector.detectTriangle(a, b, c), "Triangle is isosceles");
    }

    @Test(dataProvider ="equilateral from XML")
    public void testPositiveDetectEquilateralTriangle(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        Assert.assertEquals(detector.detectTriangle(a, b, c), "Triangle is equilateral");
    }

    @Test(dataProvider = "normal from XML")
    public void testPositiveDetectNormalTriangle(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        Assert.assertEquals(detector.detectTriangle(a, b, c), "Triangle is normal");
    }
}