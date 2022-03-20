package a.b.c.t6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import a.b.c.common.OracleConnProperty;
import a.b.c.t6.sql.T6QueryMap;
import a.b.c.t6.vo.T6VO;


public class T6DAOImpl implements T6DAO{
	// Select
	/*
	 * 1. ���� ����� �ִ��� Ȯ��
	 * 2. ���� ����� ������ ArrayList �ν��Ͻ��ϱ�
	 * 3. ResultSet�� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� ��������
	 * 4. ������ ���ڵ� VO ���
	 * 5. VO�� ArrayList�� ���
	 * 
	 * */
	
	@Override
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("\n T6DAOImpl :: t6SelectAll() :: ����");
		
		// �������� �ʱ�ȭ
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		// ArrayList<T6VO> �ʱ�ȭ
		ArrayList<T6VO> aList=null;
		T6VO tvo=null;
		
		try{
			// Ŀ�ؼ� ����
			conn=OracleConnProperty.getConnection();
			// DB�����ϱ�
			
			// ������ �޾ƿ���
			String sql= T6QueryMap.getT6SelectAll();
			// ������ �Է�
			pstmt=conn.prepareStatement(sql);
			// ������ ���
			System.out.println("��ü �˻� >>> : \n"+sql);
			
			
			// ���� ��� �ޱ�
			rsRs=pstmt.executeQuery();
			
			// 1
			if(rsRs!=null){
				//2 ArrayList �ν��Ͻ� �ϱ�
				aList = new ArrayList<T6VO>();
				//3
				while(rsRs.next()){
					// 4
					tvo=new T6VO();
					tvo.setT1(rsRs.getString(1));
					tvo.setT2(rsRs.getString(2));
					tvo.setT3(rsRs.getString(3));
					tvo.setT4(rsRs.getString(4));
					tvo.setT5(rsRs.getString(5));
					tvo.setT6(rsRs.getString(6));
					// T6VO setting �Ϸ�
					
					// 5
					aList.add(tvo);
				}		
				OracleConnProperty.conClose(conn, pstmt, rsRs);
			}else {
				boolean rbool= rsRs == null;
				System.out.println("rsRs == null >>> : "+rbool);
				System.out.println("rsRs >>> : "+rsRs);
			}		
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6SelectAll() :: error >>> : "+e.getMessage());
		}
		
		// aList�� null�̰ų� aList.size()�� 0�� ��� ���
		if (aList==null || aList.size()==0){
			System.out.println("T6DAOImpl :: t6SelectAll() :: Return �Ǵ� aList >>> : "+aList);
			System.out.println("T6DAOImpl :: t6SelectAll() :: Return �Ǵ� aList.size() >>> : "+aList.size());
		}
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e1){}
			// OracleConnProperty.conClose(conn, pstmt, rsRs);
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e2){}
			}
		if (rsRs!=null){
			try{rsRs.close(); rsRs=null;}catch(Exception e3){}
			}
		// ArrayList �����ϱ�
		return aList;
	}; // t6SelectAll()
	
	
	@Override
	public ArrayList<T6VO> t6SelectName(T6VO tvo){
		System.out.println("\n T6DAOImpl :: t6SelectName(T6VO tvo) :: ����");
		System.out.println("tvo.getT2 :: (ȸ���̸�) >>> "+tvo.getT2());
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		ArrayList<T6VO> aList=null;
		T6VO _tvo=null;
		
		try{
			// Ŀ�ؼ� ����
			conn=OracleConnProperty.getConnection();
			// DB�����ϱ�
			
			// ������ �޾ƿ���
			String sql= T6QueryMap.getT6SelectName();
			
			// ������ �Է�
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, tvo.getT2());  // place holder 1 :: ȸ���̸�
			System.out.println("��ü �˻� >>> : \n"+sql);
			// ������ ���
			
			// ���� ��� �ޱ�
			// System.out.println("����üũ1 ���");
			rsRs=pstmt.executeQuery(); // error ������ Ȯ���غ���
			// System.out.println("����üũ2 ���");
			pstmt.clearParameters();
			// System.out.println("����üũ3 ���");
			
			// 1
			if(rsRs!=null){
				//2 ArrayList �ν��Ͻ� �ϱ�
				aList = new ArrayList<T6VO>();
				//3
				while(rsRs.next()){
					// 4
					_tvo=new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));
					// T6VO setting �Ϸ�
					
					// 5
					aList.add(_tvo);
				}
				OracleConnProperty.conClose(conn, pstmt, rsRs);
			}else {
				boolean rbool= rsRs == null;
				System.out.println("rsRs == null >>> : "+rbool);
				System.out.println("rsRs >>> : "+rsRs);
			}		
		}catch(Exception e){
			System.out.println("T6DAOImpl :: getT6SelectName() :: error >>> : "+e.getMessage());
		}
		
		// aList�� null�̰ų� aList.size()�� 0�� ��� ���
		if (aList==null || aList.size()==0){
			System.out.println("T6DAOImpl :: t6SelectName() :: Return �Ǵ� aList >>> : "+aList);
			System.out.println("T6DAOImpl :: t6SelectName() :: Return �Ǵ� aList.size() >>> : "+aList.size());
		}
		
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e1){}
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e2){}
			}
		if (rsRs!=null){
			try{rsRs.close(); rsRs=null;}catch(Exception e3){}
			}
		
		// ArrayList �����ϱ�
		return aList;
	};
	
	
	@Override
	public ArrayList<T6VO> t6SelectDate(T6VO tvo){
		System.out.println("\n T6DAOImpl :: t6SelectDate(T6VO tvo) :: ����");
		System.out.println("tvo.getFromdate() :: (�Ի���) >>> "+tvo.getFromdate());
		System.out.println("tvo.getTodate() :: (�Ի���) >>> "+tvo.getTodate());

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		ArrayList<T6VO> aList=null;
		T6VO _tvo=null;
		
		try{
			// Ŀ�ؼ� ����
			conn=OracleConnProperty.getConnection();
			// DB�����ϱ�
			
			// ������ �޾ƿ���
			String sql= T6QueryMap.getT6SelectDate();
			
			// ������ �Է�
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, tvo.getFromdate()); // place holder 1 :: �Ի��� :: fromdate
			pstmt.setString(2, tvo.getTodate());  // place holder 2 :: �Ի���  ::  todate
			System.out.println("��¥ ��ȸ >>> : \n"+sql);
			// ������ ���
			
			// ���� ��� �ޱ�
			// System.out.println("����üũ1 ���");
			rsRs=pstmt.executeQuery(); // error ������ Ȯ���غ���
			// System.out.println("����üũ2 ���");
			pstmt.clearParameters();
			// System.out.println("����üũ3 ���");
			
			// 1
			if(rsRs!=null){
				//2 ArrayList �ν��Ͻ� �ϱ�
				aList = new ArrayList<T6VO>();
				//3
				while(rsRs.next()){
					// 4
					_tvo=new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));
					// T6VO setting �Ϸ�
					
					// 5
					aList.add(_tvo);
				}
				OracleConnProperty.conClose(conn, pstmt, rsRs);
			}else {
				boolean rbool= rsRs == null;
				System.out.println("rsRs == null >>> : "+rbool);
				System.out.println("rsRs >>> : "+rsRs);
			}		
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6SelectDate(T6VO tvo) :: error >>> : "+e.getMessage());
		}
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e1){}
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e2){}
			}
		if (rsRs!=null){
			try{rsRs.close(); rsRs=null;}catch(Exception e3){}
			}
		
		return aList;
	};
	
	
	// Insert
	@Override
	public boolean t6Insert(T6VO tvo){
		System.out.println("\n T6DAOImpl :: t6Insert(T6VO tvo) :: ����");
		System.out.println("tvo.getT1() >>> "+tvo.getT1());
		System.out.println("tvo.getT2() >>> "+tvo.getT2());
		System.out.println("tvo.getT3() >>> "+tvo.getT3());
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn=OracleConnProperty.getConnection();
			// ������ �Է�
			String sql=T6QueryMap.getT6Insert();
			pstmt=conn.prepareStatement(sql);
			// pstmt.setString(1, ???); ȸ����ȣ�� ������ ���󰡾� �ϴµ�
			// T6 + YYYYMMDD + 0001 �������� INSERT�� �Ǿ� �Ѵ�.
			System.out.println("INSERT :: sql >>> \n"+sql);
		
			pstmt.setString(1, tvo.getT1()); // place holder :: 1 :: ȸ����ȣ
			pstmt.setString(2, tvo.getT2()); // place holder :: 2 :: ȸ���̸�
			pstmt.setString(3, tvo.getT3()); // place holder :: 3 :: ȸ������
			
			nCnt=pstmt.executeUpdate();
			
			OracleConnProperty.conClose(conn, pstmt);
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6Insert(T6VO tvo) :: error >>> : "+e.getMessage());
		}
		
		if(nCnt!=0){
			bool=true;
			}
		else{
			System.out.println("T6DAOImpl :: t6Insert(T6VO tvo) :: return ���� nCnt >>> : "+nCnt);
		}
		
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e1){}
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e2){}
			}
		
		return bool;
	};
	
	
	// Update
	@Override
	public boolean t6Update(T6VO tvo){
		System.out.println("\n T6DAOImpl :: t6Update(T6VO tvo) :: ����");
		System.out.println("tvo.getT1() >>> "+tvo.getT1());
		System.out.println("tvo.getT2() >>> "+tvo.getT2());
		System.out.println("tvo.getT3() >>> "+tvo.getT3());
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;

		try {
			conn=OracleConnProperty.getConnection();
			// ������ �Է�
			String sql=T6QueryMap.getT6Update();
			pstmt=conn.prepareStatement(sql);
			
			System.out.println("UPDATE :: sql >>> \n"+sql);
					
			pstmt.setString(1, tvo.getT2()); // place holder :: 1 :: ȸ���̸�
			pstmt.setString(2, tvo.getT3()); // place holder :: 2 :: ȸ������
			pstmt.setString(3, tvo.getT1()); // place holder :: 3 :: ȸ����ȣ
			
			// UPDATE TEST_T6 SET T2=?, T3=?, T6=SYSDATE WHERE T4='Y' AND T1=?
			
			nCnt=pstmt.executeUpdate();
			OracleConnProperty.conClose(conn, pstmt);
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6Update(T6VO tvo) :: error >>> : "+e.getMessage());
		}
		
		if(nCnt!=0){
			bool=true;
			}
		else{
			System.out.println("T6DAOImpl :: t6Update(T6VO tvo) :: return ���� nCnt >>> : "+nCnt);
		}
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e1){}
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e2){}
		}
		
		return bool;
	};
	

	// Delete
	@Override
	public boolean t6Delete(T6VO tvo){
		System.out.println("\n T6DAOImpl :: t6Delete(T6VO tvo) :: ����");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int nCnt=0;
		boolean bool=false;
		
		try {
			conn=OracleConnProperty.getConnection();
			// ������ �Է�
			String sql=T6QueryMap.getT6Delete();
			pstmt=conn.prepareStatement(sql);
			
			System.out.println("DELETE :: sql >>> \n"+sql);
					
			pstmt.setString(1, tvo.getT1()); // place holder :: 1 :: ȸ���̸�		
			
			// UPDATE TEST_T6 SET T2=?, T3=?, T6=SYSDATE WHERE T4='Y' AND T1=?
			
			nCnt=pstmt.executeUpdate();
			OracleConnProperty.conClose(conn, pstmt);
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6Delete(T6VO tvo) :: error >>> : "+e.getMessage());
		}
		
		if(nCnt!=0){
			bool=true;
			}
		else{
			System.out.println("T6DAOImpl :: t6Delete(T6VO tvo) :: return ���� nCnt >>> : "+nCnt);
		}
		
		if (conn!=null){
			try{conn.close(); conn=null;}catch(Exception e){}
			}
		if (pstmt!=null){
			try{pstmt.close(); pstmt=null;}catch(Exception e){}
			}
		
		return bool;
	};

} // T6DAOImpl
