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
            String dwonFile = "528256-20150122132607.jpg";
            String sftpPath = "/home/tmn/app/lctx/websystem/netmaintain/NetMaintainupload/transPhoto";
            String localPath = "D:\\tmp\\demo\\1.jpg";
            File file = new File(localPath);
            sftp.cd(sftpPath);
            sftp.get(dwonFile,new FileOutputStream(file));
            System.out.println("下载完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        SftpDemo demo = new SftpDemo();
        demo.getftp();
    }
}
