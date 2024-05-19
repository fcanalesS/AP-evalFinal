package com.platinum.StepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	private WebDriver driver;
	
	@Given("Un usuario va a la página de login")
	public void un_usuario_va_a_la_página_de_login() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Abre el navegador");
		System.setProperty("webdriver.chrome.driver", "D:\\Estudio\\Eclipse\\CtaCorriente\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window();
		driver.get("http://localhost:8080/CtaCorriente/login.jsp");
	}
	
	@When("El usuario ingresa el nombre de usuario {string} y la contraseña {string}")
	public void el_usuario_ingresa_el_nombre_de_usuario_y_la_contraseña(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Se ingresan las credenciales de usuario");
		System.out.println("Usuario:" + string);
		System.out.println("Password:" + string2);
		
		WebElement txtUsername = driver.findElement(By.id("username"));
		WebElement txtPassword = driver.findElement(By.id("password"));
		
		txtUsername.sendKeys(string);
		txtPassword.sendKeys(string2);
		
		WebElement botonIngresar = driver.findElement(By.id("btnIngresar"));
		
		botonIngresar.click();
	}
	
	@Then("El usuario debería poder acceder exitosamente")
	public void el_usuario_debería_poder_acceder_exitosamente() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Cta.Corriente", driver.getTitle());
	}
	
	@Then ("El usuario no debería poder acceder")
	public void el_usuario_no_debería_poder_acceder_exitosamente() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement mensajeError = driver.findElement(By.id("mensajeError"));
		assertEquals("Usuario no existe o no está registrado", mensajeError.getText());
	}
	
	
}
