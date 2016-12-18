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

public class TriangleTypeDetectorTest {

    TriangleTypeDetector detector;
    private static final String ILLEGAL = "illegal";
    private static final String ISOSCELES = "isosceles";
    private static final String EQUILATERAL = "equilateral";
    private static final String LEGAL = "legal";
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
        Object[][] result = new Double[list.getLength()][];
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            result[i] = new Double[]{
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
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
        Object[][] result = new Double[list.getLength()][];
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            result[i] = new Double[]{
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @DataProvider(name = "legal from XML")
    public Object[][] readLegalValuesXml() throws Exception {
        File inputFile = new File(System.getProperty("user.dir") + "/Data_Provider.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(inputFile);
        NodeList list = document.getElementsByTagName(LEGAL);
        Object[][] result = new Double[list.getLength()][];
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            result[i] = new Double[]{
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
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
        Object[][] result = new Double[list.getLength()][];
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap map = list.item(i).getAttributes();
            result[i] = new Double[]{
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @Test(dataProvider = "illegal from XML", expectedExceptions = Exception.class)
    public void testNegativeSetIllegalSides(double a, double b, double c) throws Exception {
        detector.detectTriangle(a, b, c);
    }

    @Test(dataProvider = "legal from XML")
    public void testPositiveSetLegalSides(double a, double b, double c) throws Exception {
        detector.detectTriangle(a, b, c);
    }

    @Test(dataProvider = "isosceles from XML")
    public void testPositiveDetectIsoscelesTriangle(double a, double b, double c) throws Exception {
        Assert.assertEquals(detector.detectTriangle(a, b, c), "Triangle is isosceles");
    }

    @Test(dataProvider ="equilateral from XML")
    public void testPositiveDetectEquilateralTriangle(double a, double b, double c) throws Exception {
        Assert.assertEquals(detector.detectTriangle(a, b, c), "Triangle is equilateral");
    }

    @Test
    public void testPositiveDetectNormalTriangle() throws Exception {
        Assert.assertEquals(detector.detectTriangle(3.0, 4.0, 5.0), "Triangle is normal");
    }
}