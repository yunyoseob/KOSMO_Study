SELECT HIREDATE FROM EMP;

-- �Ի����� ���� ������ 5���� ���Ͻÿ� 
-- �����ʹ� �� ������ Ȯ�� �ؾ� �Ѵ�. �Ǽ� �� ������ ����üŷ �Ѵ�.
-- �Ǽ��� ������ ��ǥ���� ������ Ÿ�� �����ؼ� Ȯ�� �ؾ� �Ѵ�. 

-- 1. �Ի��� ���� Ȯ�� �ϴ� �� : 14�� �̴ϱ�
SELECT HIREDATE FROM EMP;

SELECT HIREDATE FROM EMP ORDER BY HIREDATE ASC;

SELECT HIREDATE FROM EMP WHERE ROWNUM <= 5;

-- ���������� �ڽ� ���� �ζ��� �� ���������� 
-- �Ի��� ���� ������ ��Ʈ�� �����Ѵ�.
-- ���� �θ� �������� 5���� ���Ѵ�.
SELECT A.HIREDATE 
FROM
    -- �ζ��� �� �������� 
    (SELECT HIREDATE FROM EMP ORDER BY HIREDATE ASC) A
WHERE ROWNUM <= 5;

/*
SELECT 
    SELECT * FROM DUAL;
FROM 
    SELECT * FROM DUAL;
WHERE 
    SELECT * FROM DUAL;
*/
