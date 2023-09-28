package tr.edu.altinbas.util.numeric.getprime;

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
public class Test_getPrime {
    private static class DataInfo {
        int number;
        int result;

        DataInfo(int number, int result)
        {
            this.number = number;
            this.result = result;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> createDataInfo() throws IOException
    {
        return Files.newBufferedReader(Path.of("getprime.txt"))
                .lines()
                .map(s -> s.split("[ \t]+"))
                .map(si -> new DataInfo(Integer.parseInt(si[0]), Integer.parseInt(si[1])))
                .collect(Collectors.toList());
    }

    private final DataInfo m_dataInfo;

    public Test_getPrime(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void test_getPrime()
    {
        Assert.assertEquals(m_dataInfo.result, NumberUtil.getPrime(m_dataInfo.number));
    }

}
