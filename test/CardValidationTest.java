import org.testng.annotations.Test;
import response.Response;
import validator.CardType;
import validator.CardValidator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardValidationTest {
    CardValidator cardValidator = new CardValidator();
//    @BeforeEach
//    void setUp(){
//        cardValidator = new CardValidator();
//    }
    @Test
    void test_that_card_is_invalid(){
        long number = 1328899430567L;
        Response response = cardValidator.validate(number);
        assertEquals(response.getMessage(),"invalid number");
        assertEquals(response.getType(),"invalid card");
    }
    @Test
    void test_that_count_is_thirteen(){
        long number = 1328899430567L;
        assertEquals(13,cardValidator.countNumber(number));
    }
    @Test
    void test_that_card_number_can_be_added_to_array(){
        long number = 1234567891123l;
        int [] actual = cardValidator.addNumberToArray(number);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1, 2, 3},actual);
    }
    @Test
    void test_that_card_checks_card_type(){
        long number = 1234567891123l;
        int [] actual = cardValidator.addNumberToArray(number);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1, 2, 3},actual);
        var cardType = cardValidator.checkCardType(actual);
        assertEquals(cardType,CardType.NONE);

    }
    @Test
    void test_that_second_digit_of_the_array_can_be_doubled_and_summed(){
        long number = 4388576018402626l;
        int [] actual = cardValidator.addNumberToArray(number);
        assertArrayEquals(new int[]{4, 3, 8, 8, 5, 7, 6, 0, 1, 8, 4, 0, 2,6,2,6},actual);
        int total = cardValidator.doubleAndAddSecondDigit(actual);
        assertEquals(37,total);

    }
    @Test
    void test_that_numbers_at_odd_places_can_be_summed_and_its_equal_to_38(){
        long number = 4388576018402626l;
        int [] actual = cardValidator.addNumberToArray(number);
        assertArrayEquals(new int[]{4, 3, 8, 8, 5, 7, 6, 0, 1, 8, 4, 0, 2,6,2,6},actual);
        int total = cardValidator.sumNumbersAtOddPlaces(actual);
        assertEquals(38,total);
    }
    @Test
    void test_that_card_is_not_valid(){
        long number = 4388576018402626l;
        int [] actual = cardValidator.addNumberToArray(number);
        assertArrayEquals(new int[]{4, 3, 8, 8, 5, 7, 6, 0, 1, 8, 4, 0, 2,6,2,6},actual);
        int oddTotal = cardValidator.sumNumbersAtOddPlaces(actual);
        int evenTotal = cardValidator.doubleAndAddSecondDigit(actual);
        assertEquals("card is not valid",cardValidator.validateCard(oddTotal,evenTotal));
    }
    @Test
    void test_that_card_is_valid(){
        long number = 4388576018410707l;
        int [] actual = cardValidator.addNumberToArray(number);
        int oddTotal = cardValidator.sumNumbersAtOddPlaces(actual);
        int evenTotal = cardValidator.doubleAndAddSecondDigit(actual);
        assertEquals("card is valid",cardValidator.validateCard(oddTotal,evenTotal));

    }

}
