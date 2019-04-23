package handler.impl;

import handler.IterationHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IterationProviderFromConfig implements IterationHandler {
    @Override
    public int getIterationCount() {
        Properties properties = new Properties();
        try(InputStream is = ConfigFromFileDAO.class.getClassLoader().getResourceAsStream("gameConfig.properties")){
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(properties.getProperty("iteration_count"));
    }
}
