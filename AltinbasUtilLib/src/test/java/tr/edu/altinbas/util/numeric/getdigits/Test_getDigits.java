package tr.edu.altinbas.util.numeric.getdigits;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tr.edu.altinbas.util.numeric.NumberUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class Test_getDigits {
    private static class DataInfo {
        long number;
        int [] digits;

        DataInfo(long number, int count)
        {
            this.number = number;
            digits = new int[count];
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> createDataInfo() throws IOException
    {
        var br = Files.newBufferedReader(Path.of("getdigtstestdata.txt"));
        String line;

        var list = new ArrayList<DataInfo>();

        while ((line = br.readLine()) != null) {
            String [] lineInfo = line.split("[ \t]+");

            var di = new DataInfo(Integer.parseInt(lineInfo[0]), lineInfo.length - 1);

            for (int i = 1; i < lineInfo.length; ++i)
                di.digits[i - 1] = Integer.parseInt(lineInfo[i]);

            list.add(di);
        }

        return list;
    }

    private final DataInfo m_dataInfo;

    public Test_getDigits(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void test_getDigits()
    {
        var expected = m_dataInfo.digits;
        var actual = NumberUtil.getDigits(m_dataInfo.number);

        Assert.assertArrayEquals(expected, actual);
    }
}
