import configuration.YamlReader;

public class Run {

    public static void main(String[] args) {
        YamlReader.setPropertiesFromYamlEnvironment();
        System.out.println(System.getProperty("appUrl"));
    }
}
