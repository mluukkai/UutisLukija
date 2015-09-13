
import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;
import com.mycompany.uutislukija.Lukija;
import com.mycompany.uutislukija.Main;
import static com.mycompany.uutislukija.Main.komennot;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class MainTest {
    
    Lukija lukija = new Lukija();
    static HackerPaivanUutiset hakija;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setOut(new PrintStream(outContent));
        hakija = Mockito.mock(HackerPaivanUutiset.class);
        when(hakija.haeSuosituinUutinen()).thenReturn("Suosituin uutinen");
        when(hakija.haeViimeisinUutinen()).thenReturn("Viimeisin uutinen");
    }
    @AfterClass
    public static void tearDownClass() {
        System.setOut(null);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testaaViimeisin(){
        String[] taulukko = new String[1];
        taulukko[0] = "viimeisin";
        String viimeisin = lukija.lue(taulukko, hakija);
        assertEquals(viimeisin, "Viimeisin uutinen");
    }
    
    @Test
    public void testaaSuosituin(){
        String[] taulukko = new String[1];
        taulukko[0] = "suosituin";
        String viimeisin = lukija.lue(taulukko, hakija);
        assertEquals(viimeisin, "Suosituin uutinen");
    }
    
    @Test
    public void testaaInvalidiSyöte(){
        String[] taulukko = new String[1];
        taulukko[0] = "asd";
        String viimeisin = lukija.lue(taulukko, hakija);
        assertEquals(viimeisin, "Et antanut komentoa. Käytettävissä olevat komennot: " + komennot());
    }
    
    @Test
    public void testaaTyhjäSyöte(){
        String[] taulukko = new String[1];
        taulukko[0] = "";
        String viimeisin = lukija.lue(taulukko, hakija);
        assertEquals(viimeisin, "Et antanut komentoa. Käytettävissä olevat komennot: " + komennot());
    }
    
    @Test
    public void testaaMain(){
        Main.main(new String[] {"asd"});
        assertEquals("Et antanut komentoa. Käytettävissä olevat komennot: " + komennot() + "\n", outContent.toString());
    }
}
