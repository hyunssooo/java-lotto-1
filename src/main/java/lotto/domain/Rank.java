package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000), // 2등
    THIRD(5, 1_500_000), // 3등
    FOURTH(4, 50_000), // 4등
    FIFTH(3, 5_000), // 5등
    MISS(0, 0);

    private static final int MINIMUM_MATCH_COUNT = 3;

    private int countOfMatch;
    private int reward;

    Rank(int countOfMatch, int reward) {
        this.countOfMatch = countOfMatch;
        this.reward = reward;
    }

    public Rank valueOf(int countOfMatch, boolean matchBonusNumber) {
        if (countOfMatch < MINIMUM_MATCH_COUNT) {
            return MISS;
        }
        if (countOfMatch == 5 && matchBonusNumber) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.countOfMatch == countOfMatch && !matchBonusNumber) {
                return rank;
            }
        }
        throw new InvalidRankException("유효하지 않은 당첨");
    }
}
