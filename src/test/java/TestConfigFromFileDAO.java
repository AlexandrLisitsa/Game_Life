import config.ConfigFiled;
import handler.ConfigFieldFromFileDAO;
import org.junit.Assert;
import org.junit.Test;

public class TestConfigFromFileDAO {

    @Test
    public void testGetConfig (){
        ConfigFieldFromFileDAO configFromFileDAO = new ConfigFieldFromFileDAO();
        ConfigFiled config = configFromFileDAO.getConfig();
        Assert.assertEquals(config.getWidth(),12);
        Assert.assertEquals(config.getHeight(),7);
        Assert.assertNotNull(config.getCells());
    }
}
