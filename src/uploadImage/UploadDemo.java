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

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\tmp\\1.jpg");
        UploadDemo demo = new UploadDemo();
        String path = "D:\\tmp\\demo";
        String filename = "1.jpg";
        demo.copyFile(file,path,filename);
    }
}
