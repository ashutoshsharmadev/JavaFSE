-- initial table
-- SQL> SELECT * FROM Customers;

-- CUSTOMERID
-- ----------
-- CUSTOMERNAME
-- --------------------------------------------------------------------------------
--        AGE    BALANCE ISVIP
-- ---------- ---------- -----
--          1
-- John Smith
--         65      12000 FALSE

--          2
-- Alice Brown
--         45       8000 FALSE

--          3
-- Robert Davis
--         70      15000 FALSE

-- SQL> SELECT * FROM Loans;

--     LOANID CUSTOMERID INTERESTRATE DUEDATE
-- ---------- ---------- ------------ ---------
--        101          1          8.5 14-JUL-26
--        102          2            9 03-AUG-26
--        103          3          7.5 09-JUL-26


-- 1
DECLARE
BEGIN
    FOR cust IN (
        SELECT CustomerID
        FROM Customers
        WHERE Age > 60
    ) LOOP

        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = cust.CustomerID;

    END LOOP;

    COMMIT;
END;
/
-- output
--     LOANID CUSTOMERID INTERESTRATE DUEDATE
-- ---------- ---------- ------------ ---------
--        101          1          7.5 14-JUL-26
--        102          2            9 03-AUG-26
--        103          3          6.5 09-JUL-26


-- 2
DECLARE
BEGIN
    FOR cust IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    ) LOOP

        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = cust.CustomerID;

    END LOOP;

    COMMIT;
END;
/
-- output
-- --------------------------------------------------------------------------------
--        AGE    BALANCE ISVIP
-- ---------- ---------- -----
--          1
-- John Smith
--         65      12000 TRUE

--          2
-- Alice Brown
--         45       8000 FALSE

--          3
-- Robert Davis
--         70      15000 TRUE

-- 3
BEGIN
  2      FOR loan_rec IN (
  3          SELECT LoanID, DueDate
  4          FROM Loans
  5          WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
  6      ) LOOP
  7
  8          DBMS_OUTPUT.PUT_LINE(
  9              'Reminder: Loan ' || loan_rec.LoanID ||
 10              ' is due on ' || loan_rec.DueDate
 11          );
 12
 13      END LOOP;
 14  END;
 15  /
--  output
-- Reminder: Loan 101 is due on 14-JUL-26
-- Reminder: Loan 103 is due on 09-JUL-26

-- PL/SQL procedure successfully completed.