import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        String path = "src/";
        String filename = "desert.jpg";
        String newFileName = "my-copied-picture.jpg";

        File oldFile = new File( path, filename );
        File newFile = new File( path, newFileName );

        try(FileInputStream inputStream = new FileInputStream( oldFile )){
            try(FileOutputStream outputStream = new FileOutputStream( newFile )){
                int currentByte = inputStream.read();
                while( currentByte != -1 ){
                    outputStream.write( currentByte );
                    currentByte = inputStream.read();
                }

            }catch( IOException exception ){
                exception.getMessage();
            }
            finally{
                System.out.println( "Copied file!" );
            }
        }catch( IOException exception ){
            exception.getMessage();
        }
    }
}