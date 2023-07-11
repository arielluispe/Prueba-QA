import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\luisa\\OneDrive\\Documentos\\CV\\Trabajo\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        // Encontrar y hacer clic en el enlace "Deliver to" (Choose your delivery location)
        WebElement deliverToLink = driver.findElement(By.id("nav-global-location-popover-link"));
        deliverToLink.click();

        // Esperar a que aparezca el cuadro de diálogo de cambio de ubicación
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Encontrar y hacer clic en el campo de entrada de dirección
        WebElement addressInput = driver.findElement(By.id("GLUXZipUpdateInput"));
        addressInput.clear();
        addressInput.sendKeys("10001");

        // Presionar la tecla "Enter" para aplicar la dirección
        addressInput.sendKeys(Keys.ENTER);

        // Esperar a que la página se cargue con la nueva ubicación
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificar que la ubicación se haya cambiado correctamente a la dirección "10001"
        WebElement selectedLocation = driver.findElement(By.id("glow-ingress-line2"));
        String selectedLocationText = selectedLocation.getText();
        assert selectedLocationText.contains("10001") : "Error: La ubicación seleccionada no es la dirección '10001'. Ubicación actual: " + selectedLocationText;

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 13 Pro Max Color Plateado de 512GB");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.RETURN);

        driver.quit();
        
        System.out.println("El test ha finalizado exitosamente.");
    }
}
	

