package tr.edu.altinbas.util.numeric.factorial;

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
public class Test_factorial {
    private static class DataInfo {
        int number;
        long result;

        DataInfo(int number, long result)
        {
            this.number = number;
            this.result = result;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> createDataInfo() throws IOException
    {
        return Files.newBufferedReader(Path.of("factorial.txt"))
                .lines()
                .map(s -> s.split("[ \t]+"))
                .map(si -> new DataInfo(Integer.parseInt(si[0]), Long.parseLong(si[1])))
                .collect(Collectors.toList());
    }

    private final DataInfo m_dataInfo;

    public Test_factorial(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void test_factorial()
    {
        Assert.assertEquals(m_dataInfo.result, NumberUtil.factorial(m_dataInfo.number));
    }
}
