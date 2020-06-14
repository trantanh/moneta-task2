package cz.trantanh.moneta.controller;

import cz.trantanh.moneta.service.MonetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tran Tuan Anh, tran.t.anh@email.cz
 */
@RestController
public class MonetaControler {

    @Autowired
    private MonetaService monetaService;

    @GetMapping("/moneta")
    public int calculateNumber(@RequestParam(value = "numbers") String numbers) {
        List<Integer> numberList = new ArrayList<>();
        for (char n : numbers.toCharArray()) {
            int convertNumber = Character.getNumericValue(n);
            numberList.add(convertNumber);
        }
        return monetaService.calculateNumbers(numberList);
    }
}
