import com.google.inject.Guice;
import com.google.inject.Injector;
import services.GridService;
import services.UserInputService;
import wiring.AsciiGridModule;

public class Bootstrap {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AsciiGridModule());
        injector.getInstance(UserInputService.class).init();
    }
}
