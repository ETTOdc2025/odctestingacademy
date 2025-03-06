package com.PracticeAutomation.po;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PageObject {
	protected WebDriver driver;
	   public Logger log;
	   protected WebDriverWait wait;
	 
	   Actions action;
	    public PageObject(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        log = Logger.getLogger(org.openqa.selenium.bidi.log.Log.class.getName());
		    log.setLevel(Level.INFO);
		    // wait=new WebDriverWait(driver, Duration.ofSeconds(20) );
	        action=new Actions(driver);
	  
	    }
	    
	    public void takeScreenShot(String FileName)
		 {
			   TakesScreenshot screenshot = (TakesScreenshot) driver;
	            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
	            // Définir l'emplacement de sauvegarde
	            
	            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	       	 FileName = FileName+ "_" + timeStamp + ".jpg";
	            File destinationFile = new File(FileName);
	           
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
	    
	    public void takeScreenShot(String fileName, WebElement element) {
	        // Définir le chemin du dossier de stockage des captures d'écran
	        String baseFolderPath = System.getProperty("user.home") + "/imprimeEcran"  +"/Screenshots"+"/WardKhlifi";
	        String screenshotFolderPath = baseFolderPath ;
	        File baseDirectory = new File(baseFolderPath);
	        File screenshotDirectory = new File(screenshotFolderPath);
	        // Vérifier si les dossiers existent, sinon les créer
	        if (!baseDirectory.exists()) {
	            if (baseDirectory.mkdirs()) {
	                System.out.println(":coche_blanche: Dossier créé avec succès : " + baseFolderPath);
	            } else {
	                System.err.println(":x: Erreur : Impossible de créer le dossier principal !");
	                return;
	            }
	        }
	        if (!screenshotDirectory.exists()) {
	            if (screenshotDirectory.mkdirs()) {
	                System.out.println(":coche_blanche: Dossier Screenshots créé avec succès : " + screenshotFolderPath);
	            } else {
	                System.err.println(":x: Erreur : Impossible de créer le dossier Screenshots !");
	                return;
	            }
	        }
	        // Capturer la capture d'écran
	        TakesScreenshot screenshot = (TakesScreenshot) element;
	        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
	        // Ajouter un horodatage dynamique
	        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	        String fullFilePath = screenshotFolderPath + "/" + fileName + "_" + timeStamp + ".jpg";
	        // Définir l'emplacement de sauvegarde
	        File destinationFile = new File(fullFilePath);
	        System.out.println(":appareil_photo_avec_flash: Capture d'écran enregistrée : " + destinationFile.getAbsolutePath());
	        // Copier le fichier source vers la destination
	        try {
	            FileUtils.copyFile(sourceFile, destinationFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
}

		public PageObject() {
			super();
			// TODO Auto-generated constructor stub
		}
}

