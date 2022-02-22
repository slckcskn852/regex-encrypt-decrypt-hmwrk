/*
 * Made by Selcuk Coskun and Korhan Aladag
 * Date of final modification: 18.01.2021
 * MATH321
 * Regular expressions assignment
 * 
 */

package automataRegex;

import java.nio.file.*;

import java.io.FileOutputStream;
import java.util.regex.*;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class assignment 
{ 
  public static String readFileAsString(String fileName)throws Exception 
  { 
    String data = ""; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  } 
  
  public static String fakeinfo(String data) {
	  Pattern pattern = Pattern.compile("\\((.*?)\\)");
	  Matcher m = pattern.matcher(data);
	  		if(m.find()){
	  			data = m.replaceAll("FAKE INFO");
	  		}
		
			return data;
	}
  
  public static String aDegree(String data) {
	  Pattern pattern = Pattern.compile("^,");
	  Pattern pattern2 = Pattern.compile("^,,");
	  Matcher m = pattern.matcher(data);
	  Matcher m2 = pattern2.matcher(data);

	  		if(m.find()){
	  			data = m.replaceAll("MILITARY INFO: ");
	  		}
	  		if(m2.find()) {
	  			data = m2.replaceAll("PANDEMIC INFO: ");
	  		}
	  		
		
			return data;
	}
  
  public static String firstsecondthird(String data) {
	    data = data.replace("1st", "tenth");
	    data = data.replace("2nd", "ninth");
	    data = data.replace("3rd", "eighth");

	    Pattern pat = Pattern.compile("(\\d+)th");
	    Matcher m = pat.matcher(data);

	    StringBuffer sb = new StringBuffer();
	    while (m.find()) {
	        String replacement = getNumberReplacement(m.group(1));
	        if (replacement != null) {
	            m.appendReplacement(sb, replacement);
	        }
	    }
	    m.appendTail(sb);

	    return sb.toString();
	}

	private static String getNumberReplacement(String number) {
	    switch (Integer.parseInt(number)) {
	        case 4:
	            return "seventh";
	        case 5:
	            return "sixth";
	        case 6:
	            return "fifth";
	        case 7:
	            return "fourth";
	        case 8:
	            return "third";
	        case 9:
	            return "second";
	        case 10:
	            return "first";
	        default:
	            return null;
	    }
	}
  
  public static String ay(String data) {
	  data = data.replaceAll("ocak", "I");
	  data = data.replaceAll("subat", "we");
	  data = data.replaceAll("aralik", "they");
	  data = data.replaceAll("ekim", "you");
	  data = data.replaceAll("eylul", "it");
	  
			return data;
	}
  
  public static String direction(String data) {
	


	  data = data.replaceAll("htron", "west");
	  data = data.replaceAll("htuos", "east");
	  data = data.replaceAll("tsew", "north");
	  data = data.replaceAll("tsae", "south");
	  

			return data;
}
	public static String meet(String data) {

		data = data.replaceAll("have met","will meet");
		data = data.replaceAll("havemet","going to meet");

		return data;
	}
	
  
  public static void main(String[] args) throws Exception 
  { 
	  try {
	      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

	    } catch (Exception e) { System.err.println("Error: " + e.getMessage()); }
	  JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
      chooser.setFileFilter(filter);
      chooser.setAcceptAllFileFilterUsed(false);
      
      int returnVal = chooser.showOpenDialog(null);
      if(returnVal == JFileChooser.APPROVE_OPTION) {
          System.out.println("You chose to open this file: " +
                  chooser.getSelectedFile().getName());
          String data = readFileAsString(chooser.getSelectedFile().getAbsolutePath());
          //Our decrypted output as CFG
        //  String  grammar[][] = {{"S", "AX", "BB"}, {"A", "SA", "BB"}, {"B", "m", "i", "l","t","r","y","n","f","w","e","u","s","h","d","c","a","o"}, {"X", "SA","military", "info", "i","will","meet","you","west","on","tenth","of","december"}};
    data = aDegree(data);
    data = ay(data);
    data = meet(data);
    data = direction(data);
    data = firstsecondthird(data);        
	data = fakeinfo(data);
    System.out.println(data);
    FileOutputStream fos = new FileOutputStream(chooser.getSelectedFile()+" output.txt");
    fos.write(data.getBytes());
    fos.flush();
    fos.close();
  } 
} 
}