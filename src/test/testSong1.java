package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constante;
import objects.YouTube;

public class testSong1 {

public static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\spaso\\Desktop\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
	}
	
	/*@Test
	public void song1() {
		
		YouTube.song1(driver, "just a little bit julian taylor band");
		
		String currentURL = driver.getCurrentUrl();
		String expectedURL = Constante.SONG_URL;
		
		Assert.assertEquals(currentURL, expectedURL);

	} */
	
	@Test
	public void songsList() {
		
		File f = new File("songs.xlsx");
		
		try {
		InputStream is = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(is);
		Sheet sheet = wb.getSheetAt(0); 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		SoftAssert sa = new SoftAssert();
		
		for(int i = 0; i < 3; i++) {
			
		Row row = sheet.getRow(i);
			
		Cell cell0 = row.getCell(0);
		Cell cell1 = row.getCell(1);
		Cell cell2 = row.getCell(2);
		
		String song = cell0.toString();
		String link = cell1.toString();
		String expected = cell2.toString();
		
		YouTube.songsList(driver, song, link);
		
		String currenturl = driver.getCurrentUrl();
		
		sa.assertEquals(currenturl, expected);
		
		}
		
		sa.assertAll();
		wb.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

	
	
}
