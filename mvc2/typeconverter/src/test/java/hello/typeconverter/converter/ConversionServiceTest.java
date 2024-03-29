package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {
    @Test
    void conversionTest(){
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());


        Assertions.assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        Assertions.assertThat(conversionService.convert(10, String.class)).isEqualTo("10");

        IpPort stringToIpPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(stringToIpPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        String ipPortToString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        Assertions.assertThat(ipPortToString).isEqualTo("127.0.0.1:8080");
    }
}
