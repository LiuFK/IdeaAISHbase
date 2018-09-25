package UDPdata;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by liufukai on 2018/9/25.
 */
public class Send {
    public static void main(String[] args) throws Exception{
        String path="/Volumes/Elements/AISdata/nanjin/part-00000";
        FileInputStream fis=new FileInputStream(path);
        InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
        BufferedReader br=new BufferedReader(isr);
        String line="";
        while((line=br.readLine())!=null) {
            Thread.sleep(1000);
            DatagramSocket socket=new DatagramSocket();
            byte[] buf=line.getBytes();
            System.out.println(line);
            //将数据打包
            DatagramPacket packet=new DatagramPacket(buf, buf.length,InetAddress.getByName("10.138.97.15"),8083);
            socket.send(packet);
            socket.close();
        }
        br.close();
        isr.close();
        fis.close();
    }
}
