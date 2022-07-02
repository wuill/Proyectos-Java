package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BuscarLIbro {
    WebDriver driver;

    By buscarLibro = By.xpath("/html/body/app-root/app-header/header/div[3]/div/div/div[3]/div/div[1]/form/div[2]/input[2]");
    By resultadoBusqueda = By.xpath("/html/body/app-root/div/app-libros/div[3]/div/div/div[3]/div[2]/div/div/div/div/div[1]/a");
    By CampoApellido = By.xpath("//*[@id=\"apellid");
    String expectecResult = null; // variables utilizadas para comprobar la ingreso de loging almacena el titulo de bienvenida
    String actalresult = null;


    public BuscarLIbro (WebDriver driver) {
        this.driver = driver;
    }
    // metodo para buscar libro
    public void clicMicuenta(String busqueda) {
        driver.findElement(buscarLibro).sendKeys(busqueda);
    }
    // metodo que hace lick opción Registrarme
    public String  getTituResultado() {
        return  driver.findElement(resultadoBusqueda).getText();
    }
    // Metodo que comprueba si el ingreso fue correcto para ello compara el titulo de bienvenida
    public  void ComprobarIgreso () {
        expectecResult = "BUHOS";
        actalresult = getTituResultado();
        Assert.assertEquals(actalresult, expectecResult, "Escenario Fallido");
    }
    // metodo que implementa los demás metodos para enviar los datos del formulario
    public void BusquedaItem(String busqueda) throws InterruptedException {
        this.clicMicuenta(busqueda);
        this.getTituResultado();
    }
}
