import handler.impl.IterationProviderFromConfig;
import org.junit.Assert;
import org.junit.Test;

public class TestIterationProvider {
    @Test
    public void testGetIteration(){
        Assert.assertEquals(new IterationProviderFromConfig().getIterationCount(),10);
    }
}
