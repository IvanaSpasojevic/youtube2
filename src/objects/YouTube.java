package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import constants.Constante;

public class YouTube {

	public static void song1 (WebDriver driver, String song) {
		
		
		driver.get(Constante.URL);
		
		driver.findElement(By.id(Constante.YT_ID)).sendKeys(song);
		
		driver.findElement(By.id(Constante.SEARCH_ID)).click();
		
		driver.findElement(By.linkText(Constante.SONG1_LINK)).click();
		
		
	}
	
	
	public static void songsList(WebDriver driver, String song, String link) {
		
		driver.get(Constante.URL);
		
		
		
		driver.findElement(By.id(Constante.YT_ID)).sendKeys(song);
		
		driver.findElement(By.id(Constante.SEARCH_ID)).click();
		
		driver.findElement(By.linkText(link)).click();
		
	
	}
	
}
