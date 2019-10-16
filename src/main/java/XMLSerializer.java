import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLSerializer {
    public void serializeToXML(Employee employee[], String location) throws IOException, FolderCantBeCreatedException, ClassNotFoundException {
        File file = new File(location);
        FileOutputStream fileOutputStream = null;
        if(file.exists())
            fileOutputStream = new FileOutputStream(location+"/first.xml");
        else
        {
            boolean isCreated = file.mkdirs();
            if(isCreated){
                fileOutputStream = new FileOutputStream(location+"/first.xml");
            }
            else
                throw new FolderCantBeCreatedException("Exception in "+ Class.forName("XMLSerializer").getName());
        }

        XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream);
        xmlEncoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        xmlEncoder.writeObject(employee);
        xmlEncoder.close();
        fileOutputStream.close();
    }
}