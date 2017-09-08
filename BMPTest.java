//Rohit
import java.io.*;
import java.math.BigInteger;

	public class BMPTest {
	    public static void main(String [] args) {

	        // The name of the file to open.
	        String fileName = "Tiger.BMP";

	        try {
	            // Use this for reading the data.
	            byte[] buffer = new byte[1000];

	            FileInputStream inputStream = 
	                new FileInputStream(fileName);

	            // read fills buffer with data and returns
	            // the number of bytes read (which of course
	            // may be less than the buffer size, but
	            // it will never be more).
	            int total = 0;
	            int nRead = 0;
	      
	      /*      while((nRead = inputStream.read(buffer)) != -1) {
	                // Convert to String so we can display it.
	                // Of course you wouldn't want to do this with
	                // a 'real' binary file.
	                System.out.println(new String(buffer));
	                total += nRead;
	            }  */
	            
	            byte[] bmpHeader = new byte[14];
	            byte[] buffer2 =new byte[2];
	            byte[] buffer4 =new byte[4];
	            nRead=inputStream.read(bmpHeader);
	            total=nRead;
	            
	            if(nRead==14){
	            	int i,b=0;
	            	
	            	for(i=0;i<2;i++)
	            		buffer2[i]=bmpHeader[b++];
	            	buffer4[3]=bmpHeader[b++];
	            	buffer4[2]=bmpHeader[b++];
	            	buffer4[1]=bmpHeader[b++];
	            	buffer4[0]=bmpHeader[b++];
	            	
	            	System.out.println(new String(buffer2));
	            	System.out.println("Size of BMP file in bytes: "+new BigInteger(buffer4).intValue());
	            	
	            }
	            
	            byte[] bmpInfoHeader = new byte[40];
	            byte[] buffer5=new byte[4];
	            byte[] buffer6=new byte[4];
	            byte[] buffer7=new byte[4];
	            byte[] buffer8=new byte[2];
	            byte[] buffer9=new byte[2];
	            nRead=inputStream.read(bmpInfoHeader);
	            total=nRead;
	            total+=nRead;
	            if(nRead==40){
	            	int i,b=0;
	            	for(i=0;i<4;i++)
	            		buffer5[i]=bmpInfoHeader[b++];
	            	buffer6[3]=bmpInfoHeader[b++];
	            	buffer6[2]=bmpInfoHeader[b++];
	            	buffer6[1]=bmpInfoHeader[b++];
	            	buffer6[0]=bmpInfoHeader[b++];
	            	
	            	buffer7[3]=bmpInfoHeader[b++];
	            	buffer7[2]=bmpInfoHeader[b++];
	            	buffer7[1]=bmpInfoHeader[b++];
	            	buffer7[0]=bmpInfoHeader[b++];
	            	
	            	b=b+2;
	            	
	            	buffer8[1]=bmpInfoHeader[b++];
	            	buffer8[0]=bmpInfoHeader[b++];
	            	
	            	System.out.println("Bitmap width in pixels: "+new BigInteger(buffer6).intValue()); 
	            	System.out.println("Bitmap height in pixels: "+new BigInteger(buffer7).intValue());
	            	System.out.println("Number of bits per pixel: "+new BigInteger(buffer8).intValue()); 
	            }

	            // Always close files.
	            inputStream.close();        

	            System.out.println("Read " + total + " bytes");
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
	    }
	}