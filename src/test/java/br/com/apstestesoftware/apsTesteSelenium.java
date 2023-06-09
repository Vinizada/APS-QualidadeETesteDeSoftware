package br.com.apstestesoftware;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class apsTesteSelenium {
	private WebDriver driver;

	@Before
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\workspaceFaculdade\\testesoftware\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("C:\\workspaceFaculdade\\testesoftware\\front\\trabalho2-1.html");

		Thread.sleep(5000);
	}

	@Test
	public void testValidarNome() {

		WebElement nomeInput = driver.findElement(By.id("nome"));
		WebElement salvarButton = driver.findElement(By.id("botao_somar"));

		// Teste de campo nome em branco
		nomeInput.sendKeys("");
		salvarButton.click();

		WebElement resultadoDiv = driver.findElement(By.id("resultado"));
		String resultado = resultadoDiv.getText();
		assertEquals("Preencha o campo nome", resultado);
	}

	@Test
	public void testValidarEndereco() {

		WebElement nomeInput = driver.findElement(By.id("nome"));
		WebElement enderecoInput = driver.findElement(By.id("endereco"));
		WebElement salvarButton = driver.findElement(By.id("botao_somar"));

		// Preenche o campo nome
		nomeInput.sendKeys("John Doe");

		// Teste de campo endereço em branco
		enderecoInput.sendKeys("");
		salvarButton.click();

		WebElement resultadoDiv = driver.findElement(By.id("resultado"));
		String resultado = resultadoDiv.getText();
		assertEquals("Preencha o campo endereco", resultado);
	}

	@Test
	public void testValidarSexo() {

		WebElement nomeInput = driver.findElement(By.id("nome"));
		WebElement enderecoInput = driver.findElement(By.id("endereco"));
		WebElement sexoSelect = driver.findElement(By.id("sexo"));
		WebElement salvarButton = driver.findElement(By.id("botao_somar"));

		// Preenche os campos nome e endereço
		nomeInput.sendKeys("John Doe");
		enderecoInput.sendKeys("Rua Exemplo");

		// Teste de seleção do valor "..."
		sexoSelect.sendKeys("...");
		salvarButton.click();

		WebElement resultadoDiv = driver.findElement(By.id("resultado"));
		String resultado = resultadoDiv.getText();
		assertEquals("Selecione um valor para o campo sexo", resultado);
	}

	@Test
	public void testValidarIdade() {

		WebElement nomeInput = driver.findElement(By.id("nome"));
		WebElement enderecoInput = driver.findElement(By.id("endereco"));
		WebElement sexoSelect = driver.findElement(By.id("sexo"));
		WebElement idadeInput = driver.findElement(By.id("idade"));
		WebElement salvarButton = driver.findElement(By.id("botao_somar"));

		// Preenche os campos nome, endereço e sexo
		nomeInput.sendKeys("John Doe");
		enderecoInput.sendKeys("Rua Exemplo");
		sexoSelect.sendKeys("m");

		// Teste de campo idade em branco
		idadeInput.sendKeys("");
		salvarButton.click();

		WebElement resultadoDiv = driver.findElement(By.id("resultado"));
		String resultado = resultadoDiv.getText();
		assertEquals("Preencha o campo idade, somente com numeros", resultado);
	}

	@Test
	public void testValidarTituloPagina() {

		String tituloPagina = driver.getTitle();
		assertEquals("Trabalho 2-1", tituloPagina);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}