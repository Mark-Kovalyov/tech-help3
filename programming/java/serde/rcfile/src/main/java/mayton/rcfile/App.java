package mayton.rcfile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.io.RCFile;
import org.apache.hadoop.hive.serde2.columnar.BytesRefArrayWritable;
import org.apache.hadoop.hive.serde2.columnar.BytesRefWritable;
import org.apache.hadoop.io.VIntWritable;
import org.apache.hadoop.io.Writable;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());

        String userDir = System.getProperty("user.dir");
        Path currentDirPath = new Path(userDir);
        FileSystem currentDirPathFileSystem = currentDirPath.getFileSystem(conf);

        RCFile.Writer writer = new RCFile.Writer(currentDirPathFileSystem, conf, new Path("demo"));
        BytesRefArrayWritable w = new BytesRefArrayWritable(1000);

        w.set(0, new BytesRefWritable(10));

        writer.append(w);
        writer.close();
    }
}
