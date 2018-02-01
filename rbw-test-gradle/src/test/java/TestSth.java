import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestSth {

    @Test
    public void junitOne() {
        String str = "jjj";
        Optional<String> stringOptional = Optional.of(str);
        Assert.assertNotNull(stringOptional.isPresent());
    }

    @Test
    public void junitTwo() {
        ArrayList<String> list = Lists.newArrayList();

    }
}
