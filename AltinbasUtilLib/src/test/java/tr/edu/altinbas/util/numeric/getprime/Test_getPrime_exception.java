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
public class Test_getPrime_exception {
    private static class DataInfo {
        int number;

        DataInfo(int number)
        {
            this.number = number;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> createDataInfo() throws IOException
    {
        return Files.newBufferedReader(Path.of("getprime_exception.txt"))
                .lines()
                .map(line -> new DataInfo(Integer.parseInt(line)))
                .collect(Collectors.toList());
    }

    private final DataInfo m_dataInfo;

    public Test_getPrime_exception(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void test_getPrime()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> NumberUtil.getPrime(m_dataInfo.number));
    }
}
