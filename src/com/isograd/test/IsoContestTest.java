import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.isograd.exercise.*;

import static org.junit.Assert.assertEquals;

public class IsoContestTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testIsoContest1() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();

        URL pathInput = classLoader.getResource(String.format("input%d.txt", 1));
        if (pathInput == null) {
            return;
        }
        String output = initTest(1);
        IsoContest.main(new String[0]);
        assertEquals(output, getOutput());
    }

    @Test
    public void testIsoContest2() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();

        URL pathInput = classLoader.getResource(String.format("input%d.txt", 2));
        if (pathInput == null) {
            return;
        }
        String output = initTest(2);
        IsoContest.main(new String[0]);
        assertEquals(output, getOutput());
    }

    @Test
    public void testIsoContest3() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();

        URL pathInput = classLoader.getResource(String.format("input%d.txt", 3));
        if (pathInput == null) {
            return;
        }
        String output = initTest(3);
        IsoContest.main(new String[0]);
        assertEquals(output, getOutput());
    }

    @Test
    public void testIsoContest4() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();

        URL pathInput = classLoader.getResource(String.format("input%d.txt", 4));
        if (pathInput == null) {
            return;
        }
        String output = initTest(4);
        IsoContest.main(new String[0]);
        assertEquals(output, getOutput());
    }

    @Test
    public void testIsoContest5() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();

        URL pathInput = classLoader.getResource(String.format("input%d.txt", 5));
        if (pathInput == null) {
            return;
        }
        String output = initTest(5);
        IsoContest.main(new String[0]);
        assertEquals(output, getOutput());
    }

    @Test
    public void testIsoContest6() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();

        URL pathInput = classLoader.getResource(String.format("input%d.txt", 6));
        if (pathInput == null) {
            return;
        }
        String output = initTest(6);
        IsoContest.main(new String[0]);
        assertEquals(output, getOutput());
    }

    @Test
    public void testIsoContest7() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();

        URL pathInput = classLoader.getResource(String.format("input%d.txt", 7));
        if (pathInput == null) {
            return;
        }
        String output = initTest(7);
        IsoContest.main(new String[0]);
        assertEquals(output, getOutput());
    }

    @Test
    public void testIsoContest8() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();

        URL pathInput = classLoader.getResource(String.format("input%d.txt", 8));
        if (pathInput == null) {
            return;
        }
        String output = initTest(8);
        IsoContest.main(new String[0]);
        assertEquals(output, getOutput());
    }

    @Test
    public void testIsoContest9() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();

        URL pathInput = classLoader.getResource(String.format("input%d.txt", 9));
        if (pathInput == null) {
            return;
        }
        String output = initTest(9);
        IsoContest.main(new String[0]);
        assertEquals(output, getOutput());
    }

    @Test
    public void testIsoContest10() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();

        URL pathInput = classLoader.getResource(String.format("input%d.txt", 10));
        if (pathInput == null) {
            return;
        }
        String output = initTest(10);
        IsoContest.main(new String[0]);
        assertEquals(output, getOutput());
    }

    public String initTest(int i) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URL pathInput = classLoader.getResource(String.format("input%d.txt", i));
        String input = readFile(pathInput.getPath(), StandardCharsets.UTF_8);
        provideInput(input);

        URL pathOutput = classLoader.getResource(String.format("output%d.txt", i));
        return readFile(pathOutput.getPath(), StandardCharsets.UTF_8);
    }
}