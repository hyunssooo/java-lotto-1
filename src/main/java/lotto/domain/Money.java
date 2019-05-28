package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int insertMoney) {
        validMoney(insertMoney);
        this.money = insertMoney;
    }

    private void validMoney(int insertMoney) {
        checkMinimumMoney(insertMoney);
        checkUnit(insertMoney);
    }

    private void checkMinimumMoney(int insertMoney) {
        if (insertMoney < LOTTO_PRICE) {
            throw new InvalidMoneyException("최소 금액은 " + LOTTO_PRICE + "원 입니다.");
        }
    }

    private void checkUnit(int insertMoney) {
        if (insertMoney % LOTTO_PRICE != 0) {
            throw new InvalidMoneyException("금액이 " + LOTTO_PRICE + "원 단위가 아닙니다.");
        }
    }
}
