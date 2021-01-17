package utilities;

public class BrowserUtils {

    // will be used to pause our test
    public static void wait (int seconds) {
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
