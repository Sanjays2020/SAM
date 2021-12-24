package newprojectfirst;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class FileSort {   //folder file list

    public void filesSort(String dirPath)
    {
        Scanner sc = new Scanner( System.in );
      
        File folder = new File(dirPath);
        if(folder.isDirectory())
        {
            File[] fileList = folder.listFiles();

            Arrays.sort(fileList);

            System.out.println("\nTotal number of items present in the directory: " + fileList.length );


           
            for(File file:fileList)
            {
                System.out.println(file.getName());
            }

        }   
    }
}



public class sam {
	

	public static void main(String[] args) {
		
		// Creation of Folder
		
		  System.out.println("Enter the path where you want to create a folder: ");  
	      Scanner sc = new Scanner(System.in);  
	      String path = sc.next();  
	      //Using Scanner class to get the folder name from the user  
	      System.out.println("Enter the name of the main Directory "); 
	      String folder = sc.next();;
	      path = path+folder;  
	      
		  File f1 = new File(path);        
	      //Creating a folder using mkdir() method  
	 
		  if (!f1.exists()){
			    f1.mkdirs();
			}
		  
	      if(f1.isDirectory()){  
	         System.out.println("Folder is created successfully .\n\n");  
	      }else{  
	         System.out.println("Error Found ! \n\n"); 
	         
	       }
	      
	      
	      //
	      System.out.println("Welcome to the Application Fuctionality . \n");
	      int  inputCase;
	      FileSort filesort = new FileSort();
	      int terminateflag = 0;
	      
	      do {                      //level 1 option
	    	  System.out.println(" 1. Retrive files from main Folder in asscending order");
	    	  System.out.println("2. File Operations");
	    	  System.out.println("3. Terminate the program sucessful");
	    	  System.out.println("Choose Option :");
	    	  inputCase = sc.nextInt();
	    	  
	    	  switch(inputCase) {
	    	  
	    	  case 1: // Retrive all files in main Folder in asscending order .
	    		  filesort.filesSort(path);
	    		  break;
	    		  
	    	  case 2: // File Operations
	    		  System.out.println("File Operations \n");
	    		  Fileoperation obj = new Fileoperation();
	    		  terminateflag = obj.fileoperations(path);
	    		  break;
	    		  
	    	  case 3:  // Terminate The Applications .
	    		  break;
	    		  
	    	  default :
	    		  System.out.println("Enter inputCase correctly and retry ....");
	    	  
	    	  }
	    	  
	    	  if(terminateflag == 1)
	    		  inputCase = 3;
	    		  
	    	  
	      } while(inputCase != 3);
	      
	      
	      System.out.println("Application sucessfully Terminated !!");
	         

      }
}

class Fileoperation{
	int fileoperations(String path) {
		int inputCase = 0;
		Scanner sc = new Scanner(System.in);
		File file = new File("");
		String fileName ;
		do {                   //level 2 option
			System.out.println("1. Add file");
			System.out.println("2. Delete file");
			System.out.println("3. Display Files start with same name .");
			System.out.println("4. Return to previous menu :");
			System.out.println("5. Terminate the Application");
			System.out.println("6. Choose Option :");
			inputCase = sc.nextInt();
			switch(inputCase) {
			case 1: //Creation of File in the given folder.
				System.out.println("Enter file name to create :");
				fileName = sc.next();
				file = new File(path, fileName);
				 try {
					if(file.createNewFile()) {
						System.out.println("File created Sucessful .");
					}
					else
						System.out.println("File created Unsucessful ");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2: // Deletion of File from the given folder.
				System.out.println("Enter file name to delete :");
			    fileName = sc.next();
				file = new File(path, fileName);
				if(file.delete())
		        {
		            System.out.println("File deleted successfully "+ file.getName());
		        }
		        else
		        {
		            System.out.println("Failed to delete the file");
		        }
				
				break;
			case 3: // Display the Files with given name in the given folder.
				System.out.println("Enter file name to Display :");
			    String filname = sc.next();
				File folder = new File(path);
				File[] filelist = folder.listFiles();
				ArrayList <String> list = new ArrayList<String>();
				for(File f:filelist) {
					list.add(f.getName());
				}
				System.out.println("Files with file Name start with :" + filname );
				for(String l:list) {
					if(l.contains(filname))
						System.out.println(l);
				}
			
				break;
				
			case 4: // Return to Previous Menu
				inputCase = 5;
				break;
			case 5:  // Terminate the application .
				return 1;
				
			default :
				System.out.println(" Enter correct inputCase and retry ..... \n");
				break;
			}
			
		}while(inputCase != 5) ;
		
		return 0;
	}
	
}


