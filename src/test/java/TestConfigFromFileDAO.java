import config.ConfigFiled;
import handler.ConfigFromFileDAO;
import org.junit.Assert;
import org.junit.Test;

public class TestConfigFromFileDAO {

    @Test
    public void testGetConfig (){
        ConfigFromFileDAO configFromFileDAO = new ConfigFromFileDAO();
        ConfigFiled config = configFromFileDAO.getConfig();
        Assert.assertEquals(config.getWidth(),12);
        Assert.assertEquals(config.getHeight(),7);
        Assert.assertNotNull(config.getCells());
    }
}
