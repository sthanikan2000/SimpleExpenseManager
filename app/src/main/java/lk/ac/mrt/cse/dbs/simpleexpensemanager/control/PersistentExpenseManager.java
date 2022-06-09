package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import android.content.Context;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentTransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;

public class PersistentExpenseManager extends ExpenseManager{
    Context context;

    public PersistentExpenseManager(Context context) {
        this.context = context;
        setup();
    }

    @Override
    public void setup() {
        TransactionDAO PersistentTransactionDAO = new PersistentTransactionDAO(this.context);
        setTransactionsDAO(PersistentTransactionDAO);

        AccountDAO PersistentAccountDAO = new PersistentAccountDAO(this.context);
        setAccountsDAO(PersistentAccountDAO);

        // dummy data
        Account dummyAcct1 = new Account("200635E", "NSB", "Sivatheepan Thanikan", 10000.0);
        Account dummyAcct2 = new Account("200240M", "BOC", "Raveendra Jathushan", 80000.0);
        getAccountsDAO().addAccount(dummyAcct1);
        getAccountsDAO().addAccount(dummyAcct2);

        /*** End ***/
    }
}