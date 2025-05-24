package com.effectivejava.practice.enumstype.stategy;

/**
 * We need force to choose overtime pay strategy each
 * time we add enum constant for each day
 */
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY(Pay.WEEKDAY), SUNDAY(Pay.WEEKDAY);

    private final Pay pay;

    PayrollDay(Pay pay) {
        this.pay = pay;
    }

    PayrollDay() {
        this(Pay.WEEKDAY);
    }

    public enum Pay {
        WEEKEND {
            @Override
            public int overtimePay(int minsWorked, int payRate) {
                return minsWorked - MINS_PER_SHIFT <= 0 ? 0 : (minsWorked - MINS_PER_SHIFT)*(payRate/2);
            }
        },
        WEEKDAY {
            @Override
            public int overtimePay(int minsWorked, int payRate) {
                return minsWorked*payRate;
            }
        };
        private static final int MINS_PER_SHIFT = 8 * 60;

        public abstract int overtimePay(int minsWorked, int payRate);

        int pay(int minsWorked, int payRate) {
            return minsWorked*payRate + this.overtimePay(minsWorked, payRate);
        }
    }

}
