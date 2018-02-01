package zzu.edu.rbw.mongo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.SimpleIdGenerator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class TestSpringUtil {

    @Test
    public void testSpringId() {
        System.out.println(new SimpleIdGenerator().generateId().toString().replace("-", ""));
    }

    /**
     * ID生成器
     */
    @Test
    public void testSpringBeanUtil9() {
        BeanUtils.copyProperties(null, null);
    }

    /**
     * 文件系统拷贝
     */
    @Test
    public void testSpringFileSystemCopy() {
        String srcStr = "F:\\images";
        String destStr = "F:\\MyDrivers";
        Path src = Paths.get(srcStr);
        Path dest = Paths.get(destStr);
        try {
            long start = System.currentTimeMillis();
            FileSystemUtils.copyRecursively(src, dest);
            long end = System.currentTimeMillis();
            log.info("All File Copy Complete! it cost {}", (end - start));
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Oops Sth Wrong!");
        }
    }
}
