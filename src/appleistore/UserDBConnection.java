
package appleistore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import appleistore.DBConnection;
import java.io.File;
import java.io.PrintWriter;

public class UserDBConnection extends User{
    
    @Override
    public void addUserDetails() {
        
        String userInfo = getUserID()+","+ getfName()+","+
                             getlName()+","+ getUsertype()+","+
                             getNIC()+","+ getDob()+","+
                             getEmail()+","+ getUsername()+","+
                             getPassword();

      String FILEPATH = "E:\\iStore\\userDBconnection.txt";
      FileWriter filewriter = null;
      BufferedWriter bufferedwriter = null;
        try 
        {
            filewriter = new FileWriter(FILEPATH, true );
            bufferedwriter = new BufferedWriter(filewriter);
            
            bufferedwriter.write(userInfo);
            bufferedwriter.newLine();
            bufferedwriter.close();
            filewriter.close();
            
            JOptionPane.showMessageDialog(null, "Successfully writer in the file");
        } 
        catch (Exception e) 
        {
            System.out.println("An error occoured saving values"+e);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    validate username and password
//     public Manager authenticateUserLogin (String Eusername, String Epassword)throws IOException 
//    {
//        boolean found=true;
//        String [] words = null;
//        Manager obj=null;
//        String FindLine;
//        String FILEPATH = "E:\\iStore\\userDBconnection.txt";
//        String result = null;
//        
//        try 
//        {
//
//            obj = new Manager();
//            FileReader fr = new FileReader(FILEPATH);
//            BufferedReader bufferedreader = new BufferedReader(fr);
//            outerLoop:
//            while((FindLine=bufferedreader.readLine())!=null)
//            {
//                words=FindLine.split(",");
//                for(String word: words) {
//                    System.out.println("amma");
//                    if(word.equals(Eusername)&& word.equals(Epassword))
//                    {
//                       found=true;
//                       obj.setUsertype(words[3]);
//                       obj.setUsernameLogin(words[7]);
//                       obj.setPasswordLogin(words[8]);
//                     
//                       }
//                if (found==true){
//                    JOptionPane.showMessageDialog(null,"Successfull Login!");
//                    break outerLoop;
//                   
//                   
//                }
//                else if(found==false){
//                    JOptionPane.showMessageDialog(null,"Wrong username or Password!");
//                        
//                        }}
//            } 
//              fr.close();
//              bufferedreader.close();      
//            }
//         catch (Exception e) 
//        {
//            System.out.println("An error occoured saving values"+e);
//        }
//        
//
//        return obj;
//    }        
//     
    
    
public Manager authenticateUserLogin(String Eusername, String Epassword)  {
    boolean found=true;
    String[] words = null;
    Manager obj = null;
    String FindLine;
    String FILEPATH = "E:\\iStore\\userDBconnection.txt";
    String result = null;

    try {
        obj = new Manager();
        FileReader fr = new FileReader(FILEPATH);
        BufferedReader bufferedreader = new BufferedReader(fr);
        outerloop:
        while ((FindLine = bufferedreader.readLine()) != null) {
            words = FindLine.split(",");
            for (String word : words) {
                if (words[7].equals(Eusername) && words[8].equals(Epassword)) {
                    found = true;
                    
                    if(found==true && word.equals(Eusername) || word.equals(Epassword) ){
                    System.out.println(found);
                    obj.setUsertype(words[3]);
                    System.out.println(words[3]);
                    obj.setUsernameLogin(words[7]);
                    obj.setPasswordLogin(words[8]);
                    break outerloop; 
                }}
                
                    
                else{
                    found=false;
                }
            }
        }

        fr.close();
        bufferedreader.close();

        if (found==true) {
            JOptionPane.showMessageDialog(null, "Successful Login!");
        } 
        else {
            JOptionPane.showMessageDialog(null, "Wrong username or password!");
        }
    } catch (Exception e) {
        System.out.println("An error occurred while saving values: " + e);
    }

    return obj;
}

//delete item from the text file
     public void deleteUserAccount(int deleteLine){

        String tempFile = "tempUser.txt";
        String filepath = "E:\\iStore\\userDBConnection.txt";
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
         
         
         
         
         
         
     //used poly
     public Manager searchUser(String ID, String NIC){
         boolean found=true;
        String [] words = null;
        Manager obj1=null;
        String file="E:\\iStore\\userDBConnection.txt";
        String FindLine1;
        try 
        {   obj1 = new Manager();
        
            FileReader fr1 = new FileReader(file);
            BufferedReader br1 = new BufferedReader(fr1);

            outerLoop:
            while((FindLine1=br1.readLine())!=null)
            {
                words=FindLine1.split(",");
                for(String word: words) {
                    if(word.equals(ID))
                    {
                    found=true;
                    
                    obj1.setUserID(words[0]);
                    obj1.setfName(words[1]);
                    obj1.setlName(words[2]);
                    obj1.setUsertype(words[3]);
                    obj1.setNIC(words[4]);
                    obj1.setDob(words[5]);
                    obj1.setEmail(words[6]);
                    obj1.setUsername(words[7]);
                    obj1.setPassword(words[8]);
                    
                    
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
     
     
     
     
     //used poly
      public Manager searchUser(String userType)
    {   boolean found=true;
        String [] words = null;
        Manager obj1=null;
        String file="E:\\iStore\\userDBConnection.txt";
        String FindLine1;
        try 
        {   obj1 = new Manager();
        
            FileReader fr1 = new FileReader(file);
            BufferedReader br1 = new BufferedReader(fr1);

            outerLoop:
            while((FindLine1=br1.readLine())!=null)
            {
                words=FindLine1.split(",");
                for(String word: words) {
                    if(word.equals(userType))
                    {
                    found=true;
                    foundUserTypeFromTextFile(FindLine1);//call write into text file method
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
     
     //write found user into seperate text file  
      void foundUserTypeFromTextFile(String FindLine1) 
    {   
        String file1= "E:\\iStore\\foundUser.txt";
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

      // Update useracoounts
    public Manager updateUserAccounts(String ID) {
        boolean found1=true;
        String [] words = null;
        Manager obj1=null;
        String FindLine2;
        try 
        {
//            String oldfile="E:\\iStore\\Item.txt";
            File oldfile = new File("E:\\iStore\\userDBConnection.txt");
            File newfile = new File("E:\\iStore\\tempUser.txt");
           
            FileReader fr1 = new FileReader(oldfile);
            BufferedReader br1 = new BufferedReader(fr1);
            
            while((FindLine2=br1.readLine())!=null)
            {
                words=FindLine2.split(",");
                for(String word: words) {
                if(word.equals(ID)){
                found1=true;

                String newRecord=words[0]+","+words[1]+","+words[2]+","+words[3]+","+words[4];
             
                try{
                    br1 =new BufferedReader(new FileReader(oldfile));
                PrintWriter pw = new PrintWriter(new FileWriter(newfile));
                
                String linefound;
                while((linefound=br1.readLine())!=null){
                    if(!linefound.equals(ID)){
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
            System.out.println("An error occoured saving values"+e);
         }
    return obj1;  
}}
    
   
    
    
    
    
 
    

