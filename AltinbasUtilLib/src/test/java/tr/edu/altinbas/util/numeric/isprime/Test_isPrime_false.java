package tr.edu.altinbas.util.numeric.isprime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tr.edu.altinbas.util.numeric.NumberUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class Test_isPrime_false {
    private static class DataInfo {
        long number;
        boolean result;

        DataInfo(long number, boolean result)
        {
            this.number = number;
            this.result = result;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> createDataInfo() throws IOException
    {
        return Files.newBufferedReader(Path.of("isprime_false.txt"))
                .lines()
                .map(s -> new DataInfo(Long.parseLong(s), false)).collect(Collectors.toList());
    }

    private final DataInfo m_dataInfo;

    public Test_isPrime_false(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void test_isPrime()
    {
        Assert.assertEquals(m_dataInfo.result, NumberUtil.isPrime(m_dataInfo.number));
    }
}
