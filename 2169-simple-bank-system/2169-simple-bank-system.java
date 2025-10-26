class Bank {

    long[] bal;

    public Bank(long[] balance) {
        bal = balance;
    }

    public boolean transfer(int a1, int a2, long amt) {
        if (a1 > bal.length || a2 > bal.length || bal[a1 - 1] < amt) return false;
        bal[a1 - 1] -= amt;
        bal[a2 - 1] += amt;
        return true;
    }

    public boolean deposit(int a, long amt) {
        if (a > bal.length) return false;
        bal[a - 1] += amt;
        return true;
    }

    public boolean withdraw(int a, long amt) {
        if (a > bal.length || bal[a - 1] < amt) return false;
        bal[a - 1] -= amt;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */