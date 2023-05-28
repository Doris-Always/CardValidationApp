package validator;

import response.Response;

public class CardValidator {
    public int countNumber(long number) {
        int count = 0;
        while (number > 0){
            number = number / 10;
            count++;
        }
        return count;
    }

    public int[] addNumberToArray(long number) {
        int[] numArray = new int[countNumber(number)];
        int index = 1;
        while (number > 0){
            numArray[numArray.length - index] = (int) (number % 10);
            number = number / 10;
            index++;
        }

        return numArray;
    }

    public Enum<CardType> checkCardType(int [] numberArr) {

        if (numberArr[0] == 4){
           return CardType.VISA_CARD;
        }else if (numberArr[0] == 5){
            return CardType.MASTER_CARD;
        }else if(numberArr[0] == 6){
            return CardType.DISCOVER_CARD;
        } else if (numberArr[0] ==3 && numberArr[1]==7) {
            return CardType.AMERICAN_EXPRESS_CARD;
        }
        return CardType.NONE;
    }

    public static void main(String[] args) {

    }

    public int doubleAndAddSecondDigit(int[] numberArr) {
        int index = 2;
        int sum = 0;
        for(int i = numberArr.length -index; i >= 0;i-=2){

            int doubledNum = numberArr[i] * 2;
            if (doubledNum > 9){
                int remainder = (doubledNum % 10) + 1;
                sum += remainder;
                continue;
            }
            sum += doubledNum;

        }
        return sum;
    }

    public int sumNumbersAtOddPlaces(int[] numberArr) {
        int index = 1;
        int sum = 0;
        for(int i = numberArr.length -index; i >= 0;i-=2){
            sum+=numberArr[i];
        }
        return sum;
    }

    public String validateCard(int oddTotal, int evenTotal) {
        int sumTotal = oddTotal + evenTotal;
        if (sumTotal % 10 == 0){
            return "card is valid";
        }
        return "card is not valid";
    }
}
