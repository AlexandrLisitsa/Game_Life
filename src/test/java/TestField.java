import handler.impl.ConfigFromFileDAO;
import models.Field;
import org.junit.Assert;
import org.junit.Test;

public class TestField {

    @Test
    public void testFiledDefaultConstructor(){
        Field field = new Field();
        Assert.assertNotNull(field.getCurrentGeneration());
        Assert.assertNotNull(field.getSecondGeneration());
        Assert.assertNotNull(field.getConfigFiled());
        Assert.assertEquals(field.getConfigFiled().getHeight(),7);
        Assert.assertEquals(field.getConfigFiled().getWidth(),12);
    }

    @Test
    public void testFieldParamConstructor(){
        Field field = new Field(new ConfigFromFileDAO().getConfig());
        Assert.assertNotNull(field.getCurrentGeneration());
        Assert.assertNotNull(field.getSecondGeneration());
        Assert.assertNotNull(field.getConfigFiled());
        Assert.assertEquals(field.getConfigFiled().getHeight(),7);
        Assert.assertEquals(field.getConfigFiled().getWidth(),12);
    }

}
