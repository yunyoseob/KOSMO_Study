package a.b.c.t6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.common.KosmoConnProperty;
import a.b.c.t6.sql.T6QueryMap;
import a.b.c.t6.vo.T6VO;

public class T6DAOImpl implements T6DAO {

	// ��ü ��ȸ
	@Override
	public ArrayList<T6VO> t6SelectAll() {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6SelectAll >>> : ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<T6VO> aList = null;		
		T6VO _tvo = null; 

		try {
			conn = KosmoConnProperty.getConnection();
			String sql = T6QueryMap.getT6SelectAll();
			pstmt = conn.prepareStatement(sql);
			System.out.println("��ü ��ȸ >>> : \n" + sql);
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<T6VO> ();

				while (rsRs.next()) {
					
					_tvo = new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));
					 
					aList.add(_tvo);					
				}
				
			}else {
				System.out.println("T6DAOImpl :: ��ü��ȸ ����� ���� ������ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("T6DAOImpl ::  ��ü��ȸ�� ������  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// �̸� ��ȸ
	@Override
	public ArrayList<T6VO> t6SelectName(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6SelectName >>> : ");
		T6VO.printlnT6VO(tvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<T6VO> aList = null;		
		T6VO _tvo = null; 

		try {
			conn = KosmoConnProperty.getConnection();
			
			String sql = T6QueryMap.getT6SelectName();
			pstmt = conn.prepareStatement(sql);
			System.out.println("�̸� ��ȸ >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, tvo.getT2());
			
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<T6VO> ();
				while (rsRs.next()) {					
					_tvo = new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));					 
					aList.add(_tvo);					
				}
				
			}else {
				System.out.println("T6DAOImpl :: �̸���ȸ ����� ���� ������ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("T6DAOImpl ::  �̸���ȸ�� ������  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// ��¥ �˻�
	@Override
	public ArrayList<T6VO> t6SelectDate(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6SelectDate >>> : ");
		T6VO.printlnT6VO(tvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<T6VO> aList = null;		
		T6VO _tvo = null; 

		try {
			conn = KosmoConnProperty.getConnection();
			
			String sql = T6QueryMap.getT6SelectDate();
			pstmt = conn.prepareStatement(sql);
			System.out.println("��¥ ��ȸ >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, tvo.getFromdate());
			pstmt.setString(2, tvo.getTodate());
			
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				aList = new ArrayList<T6VO> ();
				while (rsRs.next()) {					
					_tvo = new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));					 
					aList.add(_tvo);					
				}
				
			}else {
				System.out.println("T6DAOImpl :: �̸���ȸ ����� ���� ������ >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("T6DAOImpl ::  �̸���ȸ�� ������  >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// �Է�
	/*
	JDBC �� �̿��ؼ� �����ͺ��̽��� �Է�,  ����, ����, ��ȸ
	
	sqlplus
	---------------
	��ȸ : SELECT : DQL 
	�Է�, ����, ���� : INSERT, UPDATE, DELETE : DML : TRANSACTION : COMMIT, ROLLBACK
		DML  �������� �����͸� ���̺� �Է��ϸ� 
		1. �޸𸮿� ����.
		2. �޸𸮿� ����� ������ Ȯ�� �ϰ� 
		   ������ ������ COMMIT,  ���������� ROLLBACK 
		3. COMMIT ���� ���Ͽ� �� ���Ŀ��� ROLLBACK ���� �ʴ´�.
	
	splplus ���� �ϴ� ���� �ƴϰ� 
	jdbc ����̹��� �̿��ؼ� �ڹ� ���α׷����� �����ϴ� �� 
	
	�ڹ����α׷� - jdbc ����̹� - ����Ŭ �����ͺ��̽� 
	
	1. Connection
	2. PreparedStatement �������� �����ͺ��̽��� ����
	3. ResultSet, int ���̺��̽����� ����� ����� ���α׷����� ���� �޾ƾ� �Ѵ�.
	
	SELECT
		���̺��� ��ȸ�� ROW(����)�� ���α׷����� ���� �ȴ�.
		Connection 
		PreparedStatement
		ResultSet
		executQuery() 
	
	INSERT, UPDATE, DELETE 
		���̺� �ݿ��� ����� �Ǽ��� ���޵ȴ�. 
		Connection 
		PreparedStatement
		int 
		executUpdate()
		
		jdbc ����̹����� ���� ���ش�. (Oracle ���� jdbc ����� �����ڰ� �����ش�.)
		jdbc ����̹��� �̿��ؼ� 
		����Ŭ �����ͺ��̽� ���̺� �����͸� �Է��ϸ� 
		�ּ� 1���� �ڵ����� Ŀ���� ���ش�. <-- ���� ���� ???
		
		Ŀ���� ��� ��Ʈ�� �ϴ°� : jdbc ����̹����� ��Ȱ�� �ϰ� : ����Ŭ �������� ��û�� �Ѵ�. 
		�����ڰ� �� �� �ִ� ����
		Connection �������̽� setAutoCommit(), getAutCommit() �ΰ��� �Լ��� ������ 
		jdbc ����̹����� ��û�� �ϸ� 
		jdbc ����̹��� ����Ŭ ����(��Ƽ������)���� ��û�� �Ѵ�.
		��û�� ���� ����Ŭ ����(��Ƽ������)�� ���� �� ���̺��� ���¸� ���� 
		��û�� ������ ���� �Ѵ�. 
		
		Connection �������̽��� �̿��ؼ� 
			�ڹ����α׷� - jdbc ����̹� - ����Ŭ �����ͺ��̽� �� ����Ǹ�
		Connection.setAutoCommit() true �� ���°� �ȴ�.
		setAutoCommit �� true �� ���¿��� ���� 1�� �� �ڵ����� Ŀ���� �Ѵ�. 		 
	*/	
	@Override
	public boolean t6Insert(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6Insert >>> : tvo " + tvo);
		T6VO.printlnT6VO(tvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try  {
			// conn = KosmoConnProperty.getConnection(); ������Ʈ��Ʈ ������ �����Ǹ�
			// �� ���¿��� Ŀ�ؼ��� �ϳ� ������ �ȴ�.
			// Ŀ�׼��� ������ �Ǹ鼭 setAutoCommit() true �� ���°� �ȴ�.
			// ���� 1���� �ڵ� Ŀ���̴�. <-- �ڵ� Ŀ���� ��û�Ѵ�. 1. jdbc ����̹�, 2. ����Ŭ ���� 
			conn = KosmoConnProperty.getConnection();			
			
			String sql = T6QueryMap.getT6Insert();
			pstmt = conn.prepareStatement(sql);
				System.out.println("�Է��ϱ� >>> : \n" + sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, tvo.getT1());
			pstmt.setString(2, tvo.getT2());
			pstmt.setString(3, tvo.getT3());
			
			nCnt = pstmt.executeUpdate();
//			boolean b = !conn.getAutoCommit();
//			System.out.println("b >>> : " + b);
//			if (b) conn.commit(); // <-- �� ���°��� Ŀ���� �� ���� �ƴϰ� Ŀ���� ��û�� �ߴ�. 1. jdbc ����̹����� 
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " �� ��� �Ǿ��� ");			
			if (nCnt > 0) { bool = true;}
			
//			KosmoConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("������ >>> : " + e.getMessage());
		}finally {
			KosmoConnProperty.conClose(conn, pstmt);
		}
		
		return bool;
	}

	@Override
	public boolean t6Update(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6Update >>> : tvo " + tvo);
		T6VO.printlnT6VO(tvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try  {
			conn = KosmoConnProperty.getConnection();			
			String sql = T6QueryMap.getT6Update();
			pstmt = conn.prepareStatement(sql);
			System.out.println("�����ϱ� >>> : \n" + sql);
			
			pstmt.clearParameters();			
			pstmt.setString(1, tvo.getT2()); // place holder 1 :: A.T2 = ?
			pstmt.setString(2, tvo.getT3()); // place holder 2 :: A.T3 = ?
			pstmt.setString(3, tvo.getT1()); // place holder 3 :: A.T1 = ?
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");			
			if (nCnt > 0) { bool = true;}
			
			KosmoConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("������ >>> : " + e.getMessage());
		}finally {
			KosmoConnProperty.conClose(conn, pstmt);
		}
		
		return bool;	
	}

	// ����
	@Override
	public boolean t6Delete(T6VO tvo) {
		// TODO Auto-generated method stub
		System.out.println("T6DAOImpl.t6Delete >>> : tvo " + tvo);
		T6VO.printlnT6VO(tvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try  {
			conn = KosmoConnProperty.getConnection();
			
			String sql = T6QueryMap.getT6Delete();
			pstmt = conn.prepareStatement(sql);
			System.out.println("�����ϱ� >>> : \n" + sql);
			
			pstmt.clearParameters();						
			pstmt.setString(1, tvo.getT1()); // place holder 1 :: A.T1 = ?
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");			
			if (nCnt > 0) { bool = true;}
			
			KosmoConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("������ >>> : " + e.getMessage());
		}finally {
			KosmoConnProperty.conClose(conn, pstmt);
		}
		
		return bool;	
	}
}
