package a.b.c.emp.search.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.common.OracleConnProperty;
import a.b.c.emp.search.sql.EmpSearchQueryMap;
import a.b.c.emp.search.vo.EmpSearchVO;

public class EmpSearchDAOImpl implements EmpSearchDAO {

	// ��ü �˻� ---------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectAll() >>> : ���� ���� ");
		
		//
		Connection conn = null;
		//
		PreparedStatement pstmt = null;
		//
		ResultSet rsRs = null;
		//
		ArrayList<EmpSearchVO> aList = null;
		// 
		EmpSearchVO esvo = null;
		
		
		try {
			// Ŀ�ؼ� ����
			conn = OracleConnProperty.getConnection();
			
			// ������ ����
			String sql = EmpSearchQueryMap.getEmpSelectAll();
			pstmt = conn.prepareStatement(sql);
			System.out.println("��ü �˻� >>> : \n" + sql);
			
			// ���� ��� �ް�
			rsRs = pstmt.executeQuery();
			
			// ���� ����� dao ���� service �� �����ϱ� 
			/*
			1. ���� ����� �ִ��� Ȯ�� 
			2. ���� ����� ������ ArrayList �ν��Ͻ� �ϱ� 
			3. ����Ʈ�¿� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� �������� 
			4. ������ ���ڵ� VO ��� 
			5. VO �� ArrayList�� ��� 
			*/		
			// 1. ���� ����� �ִ��� Ȯ�� 
			if (rsRs !=null) {
				// 2. ���� ����� ������ ArrayList �ν��Ͻ� �ϱ� 
				aList = new ArrayList<EmpSearchVO>();
				
				// 3. ����Ʈ�¿� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� �������� 
				while (rsRs.next()) {
					
					// 4. ������ ���ڵ� VO ��� 
					esvo = new EmpSearchVO();
					esvo.setEmpno(rsRs.getString(1));
					esvo.setEname(rsRs.getString(2));
					esvo.setJob(rsRs.getString(3));
					esvo.setMgr(rsRs.getString(4));
					esvo.setHiredate(rsRs.getString(5));
					esvo.setSal(rsRs.getString(6));
					esvo.setComm(rsRs.getString(7));
					esvo.setDeptno(rsRs.getString(8));
					
					// 5. VO �� ArrayList�� ��� 
					aList.add(esvo);
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: ��ü �˻� ����� ���� ������ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: DAO :: ��ü �˻��� ������ >>> :  " + e.getMessage());
		}
		
		// ArrayList �����ϱ� 
		return aList;
	}

	// ��� �˻� ---------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectEmpno(EmpSearchVO evo) {		
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectEmpno() >>> : ���� ���� ");
		System.out.println("evo.getEmpno() >>> : " + evo.getEmpno()); // 7934

		// �������� ���� �� default value initialization �⺻������ �ʱ�ȭ�ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<EmpSearchVO> aList = null;		
		EmpSearchVO _evo = null; // 7934	MILLER	CLERK	1982-01-23	10  ���� VO 
		
		/*
		Ŀ�ؼ�
		������ ����
		���ǰ�� �޾ƿ��� 
		*/
		try {
			// Ŀ�ؼ�
			conn = OracleConnProperty.getConnection();
			
			// ������ ����
			String sql = EmpSearchQueryMap.getEmpSelectEmpno();
			pstmt = conn.prepareStatement(sql);
			System.out.println("��� �˻� >>> : \n" + sql);
			
			pstmt.clearParameters();
//			sb.append(" WHERE    A.EMPNO = ?					\n"); // place holder 1
			pstmt.setString(1, evo.getEmpno()); // place holder 1  7934
			
			// ���ǰ�� �޾ƿ��� 
			rsRs = pstmt.executeQuery();
			// 7934	MILLER	CLERK	1982-01-23	10
			
			// ���� ����� dao ���� service �� �����ϱ� 
			/*
			1. ���� ����� �ִ��� Ȯ�� 
			2. ���� ����� ������ ArrayList �ν��Ͻ� �ϱ� 
			3. ����Ʈ�¿� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� �������� 
			4. ������ ���ڵ� VO ��� 
			5. VO �� ArrayList�� ��� 
			*/		
			
			// 1. ���� ����� �ִ��� Ȯ�� 
			if (rsRs !=null) {
				// 2. ���� ����� ������ ArrayList �ν��Ͻ� �ϱ� 
				aList = new ArrayList<EmpSearchVO>();
				
				// 3. ����Ʈ�¿� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� �������� 
				while (rsRs.next()) {
					// 4. ������ ���ڵ� VO ��� 
					
					_evo = new EmpSearchVO();
					// 7934	MILLER	CLERK	1982-01-23	10
					_evo.setEmpno(rsRs.getString(1));
					_evo.setEname(rsRs.getString(2));
					_evo.setJob(rsRs.getString(3));
					_evo.setHiredate(rsRs.getString(4));
					_evo.setDeptno(rsRs.getString(5));
					
					// 5. VO �� ArrayList�� ��� 
					aList.add(_evo);					
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: ��� �˻� ����� ���� ������ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: ��� �˻��� ������  >>> : " + e.getMessage());
		}
		// ArrayList �����ϱ� 
		return aList;
	}

	// �̸� �˻� LIKE ---------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectEname(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectEname() >>> : ���� ���� ");
		System.out.println("evo.getEname() >>> : " + evo.getEname()); 

		// �������� ���� �� default value initialization �⺻������ �ʱ�ȭ�ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<EmpSearchVO> aList = null;		
		EmpSearchVO _evo = null; 

		try {
			conn = OracleConnProperty.getConnection();
			String sql = EmpSearchQueryMap.empSelectEname();
			pstmt = conn.prepareStatement(sql);
			System.out.println("�̸� �˻� >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, evo.getEname()); // place holder 1 

			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<EmpSearchVO>();

				while (rsRs.next()) {
					
					_evo = new EmpSearchVO();
					_evo.setEmpno(rsRs.getString(1));
					_evo.setEname(rsRs.getString(2));
					_evo.setJob(rsRs.getString(3));
					_evo.setHiredate(rsRs.getString(4));
					_evo.setDeptno(rsRs.getString(5));
					 
					aList.add(_evo);					
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: �̸� �˻� ����� ���� ������ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: �̸� �˻��� ������  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// ��� �̸� �˻� ---------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectEmpnoEname(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectEmpnoEname() >>> : ���� ���� ");
		System.out.println("evo.getEmpno() >>> : " + evo.getEmpno()); 
		System.out.println("evo.getEname() >>> : " + evo.getEname()); 

		// �������� ���� �� default value initialization �⺻������ �ʱ�ȭ�ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<EmpSearchVO> aList = null;		
		EmpSearchVO _evo = null; 

		try {
			conn = OracleConnProperty.getConnection();
			String sql = EmpSearchQueryMap.empSelectEmpnoEname();
			pstmt = conn.prepareStatement(sql);
			System.out.println("��� �̸� �˻� >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, evo.getEmpno()); // place holder 1  
			pstmt.setString(2, evo.getEname()); // place holder 2  

			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<EmpSearchVO>();

				while (rsRs.next()) {
					
					_evo = new EmpSearchVO();
					_evo.setEmpno(rsRs.getString(1));
					_evo.setEname(rsRs.getString(2));
					_evo.setJob(rsRs.getString(3));
					_evo.setHiredate(rsRs.getString(4));
					_evo.setDeptno(rsRs.getString(5));
					 
					aList.add(_evo);					
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: ��� �̸� �˻� ����� ���� ������ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: ��� �̸� �˻��� ������  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// ��ä �˻� LIKE --------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectJob(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectJob() >>> : ���� ���� ");
		System.out.println("evo.getJob() >>> : " + evo.getJob()); 

		// �������� ���� �� default value initialization �⺻������ �ʱ�ȭ�ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<EmpSearchVO> aList = null;		
		EmpSearchVO _evo = null; 

		try {
			conn = OracleConnProperty.getConnection();
			String sql = EmpSearchQueryMap.empSelectJob();
			pstmt = conn.prepareStatement(sql);
			System.out.println("��å �˻� >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, evo.getJob()); // place holder 1  

			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<EmpSearchVO>();

				while (rsRs.next()) {
					
					_evo = new EmpSearchVO();
					_evo.setEmpno(rsRs.getString(1));
					_evo.setEname(rsRs.getString(2));
					_evo.setJob(rsRs.getString(3));
					_evo.setHiredate(rsRs.getString(4));
					_evo.setDeptno(rsRs.getString(5));
					 
					aList.add(_evo);					
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: ��å �˻� ����� ���� ������ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: ��å �˻��� ������  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// ��¥ �˻� ---------------------------------------------------------------------------
	@Override
	public ArrayList<EmpSearchVO> empSelectHiredate(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchDAOImpl.empSelectHiredate() >>> : ���� ���� ");
		System.out.println("evo.getFromdate() >>> : " + evo.getFromdate()); 
		System.out.println("evo.getTodate() >>> : " + evo.getTodate()); 

		// �������� ���� �� default value initialization �⺻������ �ʱ�ȭ�ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<EmpSearchVO> aList = null;		
		EmpSearchVO _evo = null; 

		try {
			conn = OracleConnProperty.getConnection();
			String sql = EmpSearchQueryMap.empSelectHiredate();
			pstmt = conn.prepareStatement(sql);
			System.out.println("��¥ �˻� >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, evo.getFromdate());  // place holder 1 
			pstmt.setString(2, evo.getTodate()); 	// place holder 2  

			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<EmpSearchVO>();

				while (rsRs.next()) {
					
					_evo = new EmpSearchVO();
					_evo.setEmpno(rsRs.getString(1));
					_evo.setEname(rsRs.getString(2));
					_evo.setJob(rsRs.getString(3));
					_evo.setHiredate(rsRs.getString(4));
					_evo.setDeptno(rsRs.getString(5));
					 
					aList.add(_evo);					
				}
				
			}else {
				System.out.println("EmpSearchDAOImpl :: ���� �˻� ����� ���� ������ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("EmpSearchDAOImpl :: ���� �˻��� ������  >>> : " + e.getMessage());
		}
		
		return aList;
	}
	
}












