package uploadImage;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * Created by 佳琦 on 2016/2/25.
 */
public class UploadDemo {
    public void  copyFile(File file,String copyPath,String fileName) throws Exception{
        try {
            File savefile = new File(new File(copyPath),fileName);
            FileUtils.copyFile(file, savefile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
