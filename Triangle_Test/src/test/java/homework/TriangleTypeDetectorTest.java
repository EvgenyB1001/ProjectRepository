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
    private static final String ILLEGAL = "illegal";
    private static final String ISOSCELES = "isosceles";
    private static final String EQUILATERAL = "equilateral";
    private static final String NORMAL = "normal";
    private static final String SIDE_A = "side_a";
    private static final String SIDE_B = "side_b";
    private static final String SIDE_C = "side_c";


    @BeforeTest
    public void setUp() {
        detector = new TriangleTypeDetector();
    }

    @DataProvider(name = "illegal from XML")
    public Object[][] readIllegalValuesXml() throws Exception {
        File inputFile = new File(System.getProperty("user.dir") + "/Data_Provider.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(inputFile);
        NodeList list = document.getElementsByTagName(ILLEGAL);
        Object[][] result = new BigDecimal[list.getLength()][];
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            result[i] = new BigDecimal[]{
                    map.getNamedItem(SIDE_A) == null ?
                            null : new BigDecimal(map.getNamedItem(SIDE_A).getNodeValue()) ,
                    map.getNamedItem(SIDE_B) == null ?
                            null : new BigDecimal(map.getNamedItem(SIDE_B).getNodeValue()),
                    map.getNamedItem(SIDE_C) == null ?
                            null : new BigDecimal(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
        }

    @DataProvider(name = "isosceles from XML")
    public Object[][] readIsoscelesValuesXml() throws Exception {
        File inputFile = new File(System.getProperty("user.dir") + "/Data_Provider.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(inputFile);
        NodeList list = document.getElementsByTagName(ISOSCELES);
        Object[][] result = new BigDecimal[list.getLength()][];
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            result[i] = new BigDecimal[]{
                    new BigDecimal(map.getNamedItem(SIDE_A).getNodeValue()),
                    new BigDecimal(map.getNamedItem(SIDE_B).getNodeValue()),
                    new BigDecimal(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @DataProvider(name = "normal from XML")
    public Object[][] readNormalValuesXml() throws Exception {
        File inputFile = new File(System.getProperty("user.dir") + "/Data_Provider.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(inputFile);
        NodeList list = document.getElementsByTagName(NORMAL);
        Object[][] result = new BigDecimal[list.getLength()][];
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            result[i] = new BigDecimal[]{
                    new BigDecimal(map.getNamedItem(SIDE_A).getNodeValue()),
                    new BigDecimal(map.getNamedItem(SIDE_B).getNodeValue()),
                    new BigDecimal(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }
    @DataProvider(name = "equilateral from XML")
    public Object[][] readEquilateralValuesXml() throws Exception {
        File inputFile = new File(System.getProperty("user.dir") + "/Data_Provider.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(inputFile);
        NodeList list = document.getElementsByTagName(EQUILATERAL);
        Object[][] result = new BigDecimal[list.getLength()][];
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            result[i] = new BigDecimal[]{
                    new BigDecimal(map.getNamedItem(SIDE_A).getNodeValue()),
                    new BigDecimal(map.getNamedItem(SIDE_B).getNodeValue()),
                    new BigDecimal(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
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