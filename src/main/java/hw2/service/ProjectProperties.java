package hw2.service;

import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {
    private Properties props;
    private String propFileName = "test.properties";

    public ProjectProperties(){
        props = new Properties();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties(){
        return props;
    }
}
