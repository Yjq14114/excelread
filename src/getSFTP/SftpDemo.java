package getSFTP;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 佳琦 on 2016/2/26.
 */
public class SftpDemo {
    public void getftp() throws Exception{

        String downloadPath ="/upload/transPhoto";
  	/*连接sftp获得手机端巡检图片*/
        ChannelSftp sftp = null;
        String userName = "tmn";
        String host = "10.168.68.143";
        int port = 22;
        String password = "Tmn123!";
        String a = "-rw-rw-r--    1 tmn      tmn         25894 Nov 20 14:57 ";
        try {
            JSch jsch = new JSch();
            jsch.getSession(userName,host,port);
            Session sshSession = jsch.getSession(userName,host,port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            System.out.println("连接sftp成功!!!!!!!");
            List<Map<String,Object>> list = sftp.ls("/home/tmn/app/lctx/websystem/netmaintain/NetMaintainupload");
            for(int i=0;i<list.size();i++){
                String listName = list.get(i).toString();
                if(listName.indexOf(".jpg")!=-1){
                    String photoName = listName.substring(a.length(),listName.indexOf(".jpg")+4);
                    sftp.cd("/home/tmn/app/lctx/websystem/netmaintain/NetMaintainupload");
                    File jpgFile = new File(downloadPath+photoName);
//  				File parent = jpgFile.getParentFile();
//  				if(!parent.exists()&&parent!=null){
//  					try {
//  						parent.mkdirs();
//  					} catch (Exception e) {
//  						e.printStackTrace();
//  					}
//  				}
//  				if(!jpgFile.exists()){
//  					try {
//  						jpgFile.createNewFile();
//  					} catch (Exception e) {
//  						e.printStackTrace();
//  					}
//  				}
                    sftp.get(photoName,new FileOutputStream(jpgFile));
                    System.out.println("路径"+downloadPath+"图片"+photoName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        SftpDemo demo = new SftpDemo();
        demo.getftp();
    }
}
