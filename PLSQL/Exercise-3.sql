-- Scenario 1

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Account
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;
END;
/



-- Scenario 2 
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_DepartmentID IN Employees.DepartmentID%TYPE,
    p_BonusPercent IN Number
)
IS
BEGIN
    UPDATE Employees
    SET Salaty = Salary + (Salary * p_BonusPercent / 100)
    WHERE DepartmentID = p_DepartmentID

    COMMIT;
END;
/


-- Scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_FromAccount IN Accounts.AccountID%TYPE,
    p_ToAccount   IN Accounts.AccountID%TYPE,
    p_Amount      IN Number
)
IS
    v_Balance Accounts.Balance%Type;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    IF v_Balance >= p_Amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful.');

    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
    END IF;

END;
/