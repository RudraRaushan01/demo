import java.io.*;
public class ThrowIo {
        public static void readFile() throws IOException {
            FileReader fr = new FileReader("abc.txt");
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());
            br.close();
            }
       public static void main(String[] args) {
            try{
                readFile();
            }
            catch(IOException e) {
                System.out.println("File not found: " + e.getMessage());
            }
           
        }
    }
        
    

