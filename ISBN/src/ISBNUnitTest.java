import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import org.junit.jupiter.api.Timeout;

class ISBNUnitTest extends TestCase {
   public String unnomalizedData = "juhgftr-dd-ddg";
   public String expectedNormalizedData ="juhgftrddddg";
   public ISBN isbn = new ISBN();

    @Test
    public void whenThis_thenThat() {
        assertTrue(true);
    }
    // @Replace "-" by string without "-"
    @Test
    public void NormalizeTest() {
        assertEquals(this.expectedNormalizedData, isbn.Normalize(this.unnomalizedData) );
    }

    @Test
    // @Timeout checking for ISBN validation must reach the rate of 5000 per second
    public void testIfExecutionTimingIsExcedeeded() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
    }

    class ISBNumber extends TestCase {
        @Test
        public static void main(String[] args) throws IOException {
            long isbnNumber;
            int s = 0, i, t, d, dNumber;
            String st;

            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            System.out.print("Input a 10-digit ISBN number: ");
            isbnNumber = Long.parseLong(br.readLine());

            // check the length is 10
            st = "" + isbnNumber;
            if (st.length() != 10) {
                System.out.println("Illegal ISBN");
                return;
            }

            s = 0;
            for (i = 0; i < st.length(); i++) {
                d = Integer.parseInt(st.substring(i, i + 1));
                dNumber = i + 1;
                t = dNumber * d;
                s += t;
            }

            // check the number s is divisible by 11 or not
            if ((s % 11) != 0)
                System.out.println("Illegal ISBN");
            else
                System.out.println("Legal ISBN");
        }
    }
}
