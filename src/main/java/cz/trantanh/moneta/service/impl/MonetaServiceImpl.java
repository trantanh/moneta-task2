package cz.trantanh.moneta.service.impl;

import cz.trantanh.moneta.service.MonetaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service used for calculate numbers by task 2
 * @author Tran Tuan Anh, tran.t.anh@email.cz
 */
@Service
public class MonetaServiceImpl implements MonetaService {

    @Override
    public int calculateNumbers(List<Integer> numbers) {
        changePosition(numbers);
        List<Integer> result = multiply(numbers);
        List<Integer> list = removeNumber(result);
        return diveAndRoundDown(list);
    }

    private void changePosition(List<Integer> numbers) {
        for (int i = numbers.size() - 2; i > 0; i--) {
            if (numbers.get(i) <= 3) {
                int tmp = numbers.get(i);
                int changeNumber = numbers.get(i + 1);
                numbers.set(i, changeNumber);
                numbers.set(i + 1, tmp);
                i++;
            }
        }
    }

    /**
     * If find in List number 8 or 9 multiply by 2
     * @param numbers
     * @return
     */
    private List<Integer> multiply(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (number != 8 && number != 9) {
                result.add(number);
            }
            if (number == 8 || number == 9) {
                int currentNumber = number * 2;
                result.add(currentNumber);
            }
        }
        return result;
    }

    /**
     * Remove from List number 7
     * @param numbers
     * @return
     */
    public List<Integer> removeNumber(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (number != 7) {
                result.add(number);
            }
        }
        return result;
    }


    public int diveAndRoundDown(List<Integer> numbers) {
        int totalEven = findTotalEven(numbers);
        int number = joinNumbers(numbers);
        return result(number, totalEven);
    }

    private int result(double numbers, double totalEven) {
        double result = numbers / totalEven;
        return (int) Math.floor(result);
    }

    private int findTotalEven(List<Integer> numbers) {
        int counter = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                counter += 1;
            }
        }
        return counter;
    }

    private int joinNumbers(List<Integer> numbers) {
        StringBuilder numberText = new StringBuilder();
        for (int number : numbers) {
            numberText.append(number);
        }
        return Integer.parseInt(numberText.toString());
    }
}
