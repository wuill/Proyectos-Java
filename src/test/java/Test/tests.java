package Test;

import Pages.BuscarLIbro;
import Pages.Registro;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tests {
    WebDriver driver;
    Registro objregistro;
    BuscarLIbro objbuscarlibro;
    @BeforeTest
    // Metodo que inicializa el navegador y abre la URL
    public  void Setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://librerianacional.com/");
    }
    // metodo que cierra el navegador despues de cada testcase
   /* @AfterTest
   public  void tearDown (){
        driver.quit();
    }*/

    @Test(priority = 0)
    public void GotoLogin () throws InterruptedException {
        Thread.sleep(2000);
        objregistro = new Registro(driver);
        objregistro.EnviardatosForm("wuillam8@gmial.com", "Franciscos", "Gomez", "80747223",
                "3122254558", "2242429", "123455FE", "123455FE");

    }
    @Test (priority = 1)
    public void BusquedaLibro () throws InterruptedException{
        objbuscarlibro = new BuscarLIbro(driver);
        objbuscarlibro.BusquedaItem("BUHOS");

    }
}
