import core.App;

public class Main {

    public static void main(String[] args) {
        App app = new App();
        app.loadProperties();
        app.parseCommands();
    }
}
