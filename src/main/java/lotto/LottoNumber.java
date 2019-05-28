package lotto;

public class LottoNumber {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validLottoNumber(number);
        this.number = number;
    }

    private void validLottoNumber(int number) {
        if (MINIMUM_LOTTO_NUMBER > number || number > MAXIMUM_LOTTO_NUMBER) {
            throw new LottoNumberException("로또 넘버는 1~45사이의 값을 가집니다.");
        }
    }
}
