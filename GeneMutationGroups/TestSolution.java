import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSolution {

    @Test
    public void test1() {
        String[] genes = {"ACGT", "ACCT", "AGGT", "TTTT", "TTTG"};
        Solution solver = new Solution();
        int result = solver.solve(genes);
        int expected = 2;
        assertEquals(result, expected);
    }
}
