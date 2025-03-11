package com.example.practiceautomation.po;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	protected WebDriver driver;
	public Logger log;
	protected WebDriverWait wait;

	Actions action;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log = Logger.getLogger(Log.class.getName());
		log.setLevel(Level.INFO);
		// wait=new WebDriverWait(driver, Duration.ofSeconds(20) );
		action = new Actions(driver);
	}
	
	
	
	
	
	/*public void takeScreenShot(String fileName)
	
	 {	
		  TakesScreenshot screenshot = (TakesScreenshot) driver;
          File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
         
          // Définir l'emplacement de sauvegarde
          File destinationFile = new File(fileName);
         
          System.out.println("Capture d'écran enregistrée : " + destinationFile.getAbsolutePath());
          // Copier le fichier source vers la destination
          try {
				FileUtils.copyFile(sourceFile, destinationFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	
	
	
	public void takeScreenShot(WebElement element,String fileName)
	
	 {	
		   String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		   fileName = fileName+ "_" + timeStamp + ".jpg";
		
		   TakesScreenshot screenshot = (TakesScreenshot) element;
           File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
          
           // Définir l'emplacement de sauvegarde
           File destinationFile = new File(fileName);
          
           System.out.println("Capture d'écran enregistrée : " + destinationFile.getAbsolutePath());
           // Copier le fichier source vers la destination
           try {
				FileUtils.copyFile(sourceFile, destinationFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	
	
	*/
	
	public void takeScreenShotByFolder(WebElement element, String fileName) {
	    // Définir le dossier de destination
	    String folderPath = "C:\\Users\\Orange\\eclipse-workspace\\KR\\imprimeEcran";
	    File directory = new File(folderPath);

	    // Vérifier si le dossier existe, sinon le créer
	    if (!directory.exists()) {
	        if (directory.mkdirs()) {
	            System.out.println("Dossier créé avec succès : " + folderPath);
	        } else {
	            System.out.println("Erreur : Impossible de créer le dossier !");
	            return; // Arrêter l'exécution si le dossier ne peut pas être créé
	        }
	    }

	    // Ajouter la date et l'heure au nom du fichier (format : yyyy-MM-dd_HH-mm-ss)
	    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	    String fullFileName = folderPath + "\\" + fileName + "_" + timeStamp + ".jpg"; 

	    // Capture d'écran du WebElement
	    File sourceFile = element.getScreenshotAs(OutputType.FILE);
	    
	    // Définir l'emplacement de sauvegarde dans le dossier
	    File destinationFile = new File(fullFileName);

	    System.out.println("Capture d'écran enregistrée : " + destinationFile.getAbsolutePath());

	    // Copier le fichier source vers la destination
	    try {
	        FileUtils.copyFile(sourceFile, destinationFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public void JavaScriptExecutor(WebElement element)
	 {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	 }
	
	
	public Select getSelect(WebElement element) {
    	return new Select(element);
    }
	
	
	public void perform(WebElement element)
	 {
		 //Focus
		 action.moveToElement(element).click().perform();
	 }
	
	

	
	




}
