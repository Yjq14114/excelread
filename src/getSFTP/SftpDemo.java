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
import java.util.Vector;

/**
 * Created by 佳琦 on 2016/2/26.
 */
public class SftpDemo {
    public void getftp() throws Exception{

        String downloadPath ="/upload/transPhoto";
  	/*连接sftp获得手机端巡检图片*/
        ChannelSftp sftp = null;
        String userName = "用户名";
        String host = "服务器地址";
        int port = 22;
        String password = "密码";
        String a = "-rw-rw-r--    1 tmn      tmn         25894 Nov 20 14:57 ";
        FileOutputStream f = null;
        Session sshSession =null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(userName,host,port);
            sshSession = jsch.getSession(userName,host,port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            System.out.println("连接sftp成功!!!!!!!");
            String dwonFile = "999117-20160203111806.jpg";
            String sftpPath = "/home/tmn/app/lctx/websystem/netmaintain/NetMaintain/upload/transPhoto";
            String localPath = "D:\\tmp\\demo\\1.jpg";
            File file = new File(localPath);
            sftp.cd(sftpPath);
            f = new FileOutputStream(file);
            sftp.get(dwonFile,f);
            System.out.println("下载完毕");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            f.close();
            sftp.quit();
            if(sftp!=null){
                sftp.disconnect();
            }
            if(sshSession!=null){
                sshSession.disconnect();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        SftpDemo demo = new SftpDemo();
        demo.getftp();
    }
}
