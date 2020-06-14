package cz.trantanh.moneta;

import cz.trantanh.moneta.service.MonetaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class MonetaApplicationTests {

    @Autowired
    private MonetaService monetaService;

    @Test
    void countNumberTest() {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(4);
        numberList.add(3);
        numberList.add(2);
        numberList.add(5);
        numberList.add(6);
        numberList.add(7);
        numberList.add(9);
        numberList.add(1);
        int result = monetaService.calculateNumbers(numberList);
        assertThat(result).isEqualTo(11331545);
    }
}
