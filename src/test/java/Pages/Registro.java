package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.text.html.parser.Entity;

public class Registro {
    WebDriver driver;

    // se declarar los localizadores de registrol
    By LinkMicuenta = By.xpath("/html/body/app-root/app-header/header/div[2]/div/div/div[2]/div/menu-login-header/div/div/div/button");
    By LinkRegistrarme = By.xpath("/html/body/app-root/app-header/header/div[2]/div/div/div[2]/div/menu-login-header/div/div/div/div/a[2]");
    By CampoCorreo = By.xpath("//*[@id=\"email\"]");
    By CampoNombre = By.xpath("//*[@id=\"nombres\"]");
    By CampoApellido = By.xpath("//*[@id=\"apellidos\"]");
    By CampoSelectDoc= By.xpath("/html/body/app-root/div/app-login/div/div/div/div[2]/app-registro/div/div[2]/div/form/div[5]/select");
    By CampoNuDocumento= By.xpath("//*[@id=\"identificacion\"]");
    By CampoCel = By.id("telefono_movil");
    By CampoTelefono = By.xpath("//*[@id=\"telefono\"]");
    By CampoContrasena = By.id("contrasena");
    By CampoRepitContrasena = By.id("repeatContrasena");
    By CheckTernimos = By.xpath("/html/body/app-root/div/app-login/div/div/div/div[2]/app-registro/div/div[2]/div/form/div[12]/div[1]/label");
    By BTNregistrar= By.xpath("/html/body/app-root/div/app-login/div/div/div/div[2]/app-registro/div/div[2]/div/form/div[13]/button");

    By TituloResgistro = By.xpath("/html/body/app-root/div/app-mi-cuenta/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]");
    String expectecResult = null; // variables utilizadas para comprobar la ingreso de loging almacena el titulo de bienvenida
    String actalresult = null;

    public Registro (WebDriver driver) {
        this.driver = driver;
    }
    // metodo que hace clic BTN login
    public void clicMicuenta() {
        driver.findElement(LinkMicuenta).click();
    }
    // metodo que hace lick opción Registrarme
    public void clicRegistrarme () throws InterruptedException {
        driver.findElement(LinkRegistrarme).click();
    }
// metodo que llena el nombre
    public void llenarCorreo (String email) {
        driver.findElement(CampoCorreo).sendKeys(email);
    }
    // metodo que llena el Nombre
    public void llenarNombre (String nombre) {
        driver.findElement(CampoNombre).sendKeys(nombre);
    }
    // metodo que llena el Apellido
    public void llenarApellido (String apellido) throws InterruptedException {
        driver.findElement(CampoApellido).sendKeys(apellido);
    }
    // metodo que selecciona el tipo de documento
    public void SeleTipoDocument () throws InterruptedException {
        Select Doc = new Select(driver.findElement(CampoSelectDoc));
        Doc.selectByVisibleText("Cédula de ciudadanía");
    }
    // metodo que llena el num documento
    public void llenarNunDocumento (String documento) {
        driver.findElement(CampoNuDocumento).sendKeys(documento);
    }
    // metodo que llena celular
    public void llenarcelular (String celudar) {
        driver.findElement(CampoCel).sendKeys(celudar);
    }
    // metodo que llena tel Fijo
    public void llenaTelefonoFijo (String Telfijo) {
        driver.findElement(CampoTelefono).sendKeys(Telfijo);
    }
    // metodo que llena la contraseña
    public void llenaContrasena (String password) {
        driver.findElement(CampoContrasena).sendKeys(password);
    }
    // metodo que llena la confirma contraseña
    public void llenaContrasenaConfir (String passwordRepit) {
        driver.findElement(CampoRepitContrasena).sendKeys(passwordRepit);
    }
    // metodo que marca ckec
    public void marcaCheck () {
        driver.findElement(CheckTernimos).click();
    }
    // metodo BTN registrarme
    public void BTMregistrarme () {
        driver.findElement(BTNregistrar).click();
    }
    // obtiene el textos de bienvenida de la pagina
    public String  getTituloInicio() {
        return  driver.findElement(TituloResgistro).getText();
    }
    // Metodo que comprueba si el ingreso fue correcto para ello compara el titulo de bienvenida
    public  void ComprobarIgreso () throws InterruptedException {
        expectecResult = "Hola,Franciscos!";
        actalresult = getTituloInicio();
        Assert.assertEquals(actalresult, expectecResult, "Escenario Fallido");
        Thread.sleep(3000);

    }

        // metodo que implementa los demás metodos para enviar los datos del formulario
    public void EnviardatosForm(String email, String nombre, String apellido, String documento, String celular,
                                String Telfijo, String password, String passwordRepit) throws InterruptedException {
        this.clicMicuenta();
        this.clicRegistrarme();
        this.llenarCorreo(email);
        this.llenarNombre(nombre);
        this.llenarApellido(apellido);
        this.SeleTipoDocument();
        this.llenarNunDocumento(documento);
        this.llenarcelular(celular);
        this.llenaTelefonoFijo(Telfijo);
        this.llenaContrasena(password);
        this.llenaContrasenaConfir(passwordRepit);
        this.marcaCheck();
        this.BTMregistrarme();
    }
}
