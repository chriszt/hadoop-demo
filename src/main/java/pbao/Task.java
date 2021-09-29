package pbao;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Task {

    private FileSystem fs;

    public void init() {
        Configuration cfg = new Configuration();
        cfg.set("dfs.replication", "2");
        String user = "yl";
        try {
            fs = FileSystem.get(new URI("hdfs://srv1:8020"), cfg, user);
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mkdir() {
        boolean isOK = false;
        try {
            isOK = fs.mkdirs(new Path("/xiyou/shuiliandong2"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(isOK);
    }

    public void upload() {
        String srcPath = "/home/yl/proj/hadoop-demo/sunwukong2.txt";
        String dstPath = "hdfs://srv1:8020/xiyou/huaguoshan";
        try {
            fs.copyFromLocalFile(false, true, new Path(srcPath), new Path(dstPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
