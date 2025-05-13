
package appleistore;
import javax.swing.JOptionPane;
import java.io.*;
import java.nio.charset.Charset;
import java.io.File;

public class DBConnection {
    String FILEPATH = "E:\\iStore\\Item.txt";
    //add item into text file 
    void itemAddToDatabase(String Record) 
    {   FileWriter filewriter = null;
    
        BufferedWriter bufferedwriter = null;
        try 
        { 
            filewriter = new FileWriter(FILEPATH, true );
            bufferedwriter = new BufferedWriter(filewriter);
            
            bufferedwriter.write(Record);
            bufferedwriter.newLine();
            bufferedwriter.close();
            filewriter.close();
            
            JOptionPane.showMessageDialog(null, "Successfully writer in the file");    
        } 
        catch (Exception e) 
        {
            System.out.println("An error occoured saving values"+e);
        }
    }

    // Update item class
    public Item updateItem(String ITCode) throws IOException{
        
        boolean found1=true;
        String [] words = null;
        Item obj1=null;
        String FindLine2;
        try 
        {
//            String oldfile="E:\\iStore\\Item.txt";
            File oldfile = new File("E:\\iStore\\Item.txt");
            File newfile = new File("E:\\iStore\\temp.txt");
           
            FileReader fr1 = new FileReader(oldfile);
            BufferedReader br1 = new BufferedReader(fr1);
            
            while((FindLine2=br1.readLine())!=null)
            {
                words=FindLine2.split(",");
                for(String word: words) {
                if(word.equals(ITCode)){
                found1=true;

                String newRecord=words[0]+","+words[1]+","+words[2]+","+words[3]+","+words[4];
             
                try{
                    br1 =new BufferedReader(new FileReader(oldfile));
                PrintWriter pw = new PrintWriter(new FileWriter(newfile));
                
                String linefound;
                while((linefound=br1.readLine())!=null){
                    if(!linefound.equals(ITCode)){
                        pw.write(linefound);
                        pw.write("\n");   
                    }
                    else{
                        pw.write(newRecord);
                        pw.write("\n");}}
                pw.flush();
                br1.close();
                pw.close();
                
                //Delete the original file
                if(!oldfile.delete()){
                    System.out.println("Could not delete file");}
                
                //rename the new file to the filename the original file had
                if(!newfile.renameTo(oldfile)){
                    JOptionPane.showMessageDialog(null, "Item Details Updated!!!");
                }
                 else{
                    JOptionPane.showMessageDialog(null, "Could not Updated!!!");}
                }
                catch (Exception e) {System.out.println("An error occoured saving values"+e);}}
            else{
                 found1=false;}}} 
        fr1.close();
        br1.close();}
        catch (Exception e) 
        {
            System.out.println("An error occoured saving values"+e);}
         return obj1;}
    
  //search item code and item name
  //used poly  
  
    public Item searchItemFromFile (String ICode, String IName)throws IOException 
    {   boolean found=true;
        String [] words = null;
        Item obj=null;
        String FindLine;
        try 
        {
            FileReader fr = new FileReader(FILEPATH);
            BufferedReader bufferedreader = new BufferedReader(fr);
            outerLoop:
            while((FindLine=bufferedreader.readLine())!=null)
            {
                words=FindLine.split(",");
                for(String word: words) {
                    if(word.equals(ICode)||word.equals(IName))
                    {

                       found=true;
                       if (found=true && (word.equals(ICode)||word.equals(IName))){
            
                       obj = new Item();
                       obj.setItemCode(words[0]);
                       obj.setItemName(words[1]);
                       System.out.println(words[1]);
                       obj.setItemCategory(words[2]);
                       obj.setItemPrice(Float.valueOf(words[3]));
                       obj.setItemQty(Integer.valueOf(words[4]));
                       
                       break outerLoop;
                    }}
                    else
                    {
                       found=false; 
                    }
                }
            }
                if(found){
                    JOptionPane.showMessageDialog(null,"Value is in the list");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Value is Not in the list");  
                }
              fr.close();
              bufferedreader.close();}
         catch (Exception e) 
        {
            System.out.println("An error occoured saving values"+e);
        }
      return obj;
    }

    public Item searchItemFromFile(String ICategory)throws IOException 
    {   boolean found=true;
        String [] words = null;
        Item obj1=null;
        String file="E:\\iStore\\Item.txt";
        String FindLine1;
        try 
        {   obj1 = new Item();
        
            FileReader fr1 = new FileReader(file);
            BufferedReader br1 = new BufferedReader(fr1);

            outerLoop:
            while((FindLine1=br1.readLine())!=null)
            {
                words=FindLine1.split(",");
                for(String word: words) {
                    if(word.equals(ICategory))
                    {
                    found=true;
                    categoryToTextFile(FindLine1);//call write into text file method
                    break outerLoop;
                    }
                    else{
                    found=false;}}
            }
                if(found){
                    JOptionPane.showMessageDialog(null,"Value is in the list");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Value is Not in the list");  
                }
              fr1.close();
              br1.close();
        }
         catch (Exception e) 
        {
            System.out.println("An error occoured saving values"+e);
        }
      return obj1;
    }

    //write category data into seperate text file for filter category 
      void categoryToTextFile(String FindLine1) 
    {   
        String file1= "E:\\iStore\\ItemCategory.txt";
        FileWriter filewriter4 = null;
        BufferedWriter bufferedwriter4 = null;
        try 
        {
            filewriter4 = new FileWriter(file1, true );
            bufferedwriter4 = new BufferedWriter(filewriter4);
            
            bufferedwriter4.write(FindLine1);
            bufferedwriter4.newLine();
            bufferedwriter4.close();
            filewriter4.close();
        } 
        catch (Exception e) 
        {
            System.out.println("An error occoured saving values"+e);
        }
    } 
      
      //delete item from the text file
      public void removeRecord(int deleteLine) {
        
        String tempFile = "temp.txt";
        String filepath = "E:\\iStore\\Item.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        
        int line=0;
        String currentLine;
        
        try {
            FileWriter fw=new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            
            while((currentLine = br.readLine()) !=null)
            {
            
                line++;
                if(deleteLine !=line)
                {
                pw.println(currentLine);
                }
            
            }
            
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            
            oldFile.delete();
            File dump= new File(filepath);
            newFile.renameTo(dump);
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
}
