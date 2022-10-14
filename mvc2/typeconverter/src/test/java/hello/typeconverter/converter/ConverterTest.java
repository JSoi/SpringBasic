package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterTest {
    @Test
    void stringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    void integerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        Assertions.assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        String convert = converter.convert(ipPort);
        Assertions.assertThat(convert).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void IpPortToString() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        IpPort convert = converter.convert("127.0.0.1:8080");
        Assertions.assertThat(convert).isEqualTo(new IpPort("127.0.0.1", 8080));
    }
}
