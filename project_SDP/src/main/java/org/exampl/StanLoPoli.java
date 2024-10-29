package org.exampl;

public class StanLoPoli implements LoanPolicy {
    @Override
    public int getLoanDuration() {
        return 14;
    }
}
