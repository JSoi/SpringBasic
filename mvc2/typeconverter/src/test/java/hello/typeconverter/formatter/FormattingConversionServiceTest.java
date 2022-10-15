package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {
    @Test
    void formattingConversionService(){
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        // 컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // 포매터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        IpPort convert = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(convert).isEqualTo(new IpPort("127.0.0.1", 8080));

        Long formatLong = conversionService.convert("1,000", Long.class);
        Assertions.assertThat(formatLong).isEqualTo(1000L);

        String formatString = conversionService.convert(1000, String.class);
        Assertions.assertThat(formatString).isEqualTo("1,000");

    }
}
