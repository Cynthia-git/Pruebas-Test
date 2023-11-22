package final_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Prueba {

	ChromeDriver driver;
    String url = "http://127.0.0.1:8000/";
    @Test(priority = -100)
    public void invocarNavegador() {
        //Cambiar esta ruta por la ruta donde tienes el chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\herna\\eclipse-workspace\\prueba_perfil_docente\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //instancia
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }
    
    @Test(priority = 1)
    public void verificarLoginAseisNew() {
        //para identificar elementos como el id, Selenium provee una interfaz llamada WebElement
        WebElement userEmail = driver.findElement(By.name("email")); //locator 
        WebElement userPassword = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        userEmail.sendKeys("docente2@ues.edu.sv");
        userPassword.sendKeys("Minerva.23");
        loginButton.click();
    }
    
    @Test(priority = 2)
    public void editar() {
        try {
            TimeUnit.SECONDS.sleep(10);

            // Encuentra el botón de noticias y haz clic
            WebElement btnNoticias = driver.findElement(By.xpath("//a[@href='http://127.0.0.1:8000/Docente/indexperfilDocente']"));
            btnNoticias.click();

            TimeUnit.SECONDS.sleep(10);

            // Encuentra el elemento que necesitas hacer scroll y clic
            WebElement elemento = driver.findElement(By.id("btn-editarPerfilDocente"));

            // Haz scroll hasta el elemento
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);

            // Espera un momento para asegurarte de que el scroll se complete (puedes ajustar este tiempo según sea necesario)
            TimeUnit.SECONDS.sleep(2);

            // Ahora puedes hacer clic en el elemento
            elemento.click();

            TimeUnit.SECONDS.sleep(5);

            // Realiza las acciones restantes de tu código
            WebElement input = driver.findElement(By.id("campo1"));
            input.clear();
            input.sendKeys("Pablo Alborán");

            WebElement inputSelect = driver.findElement(By.id("especialidadDocenteSelector"));
            Select select = new Select(inputSelect);
            select.selectByValue("1");

            WebElement inputDescripcion = driver.findElement(By.id("campo3"));
            inputDescripcion.clear();
            inputDescripcion.sendKeys("Soy full stack");

            WebElement element = driver.findElement(By.id("btn-GuardarCambiosActulizados"));
            element.click();
        } catch (InterruptedException e) {
            System.out.print(e);
        }
    }
}
