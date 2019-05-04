package com.practicespring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class FileFortuneService implements FortuneService {
	
	private String fileName = "C://Users//jasmi//OneDrive//Desktop//"
			+ "Spring//spring-demo-practice//src//fortune-data.txt";
	
	private List<String> theFortunes;
	
	//create a random number generator
	
	private Random myRandom = new Random();
	
	@PostConstruct
	private void loadTheFortuneFiles() {
		
		File theFile = new File(fileName);
		
		System.out.println("Reading fortunes from file" +theFile);
		System.out.println("File exists" +theFile.exists());
		
		// initialize the array
		
		theFortunes = new ArrayList<String>();
		
		// read fortunes from the file
		try(BufferedReader br = new BufferedReader(new FileReader(theFile))){
			
			String tempLine;
			while((tempLine = br.readLine())!=null) {
				theFortunes.add(tempLine);
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public String getFortune() {
		
		int index = myRandom.nextInt(theFortunes.size());

		String tempFortune = theFortunes.get(index);

		return tempFortune;
	}

}
