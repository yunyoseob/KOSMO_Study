package a.b.c.t6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.common.OracleConnProperty;
import a.b.c.t6.sql.T6QueryMap_A;
import a.b.c.t6.vo.T6VO;

//A : Actual Practice
public class T6DAO_AImpl implements T6DAO_A{
	// ��ü ��ȸ
	@Override
	public ArrayList<T6VO> t6SelectAll(){
		System.out.println("T6DAO_AImpl :: t6SelectAll() ����");
		
		// ��ȸ�ÿ��� Connection, PreparedStatement, ResultSet�� ���
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		ArrayList<T6VO> aList=null;
		T6VO _tvo =null;
		
		try {
			conn=OracleConnProperty.getConnection();
			String sql = T6QueryMap_A.getT6SelectAll();
			pstmt=conn.prepareStatement(sql);
			System.out.println("��ü ��ȸ >>> : \n "+sql);
			rsRs=pstmt.executeQuery();
			
			if(rsRs!=null){
				aList=new ArrayList<T6VO>();
				
				while(rsRs.next()){
					_tvo=new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(6));
					
					aList.add(_tvo);
				}
			}else{
				System.out.println("��ü ��ȸ ����� �����ϴ�. ::: "+rsRs);
			}
						
		}catch(Exception e){
			System.out.println("T6DAO_AImpl :: t6SelectAll() �� error  >>> "+e.getMessage());
		}
		
		if (aList==null){
			System.out.println("T6DAO_AImpl :: t6SelectAll() :: return�� aList >>> : "+aList);
		}
	  return aList;	
	};
	
	// �̸� ��ȸ
	@Override
	public ArrayList<T6VO> t6SelectName(T6VO tvo){
		System.out.println("T6DAO_AImpl :: t6SelectName(T6VO tvo) ����");
		
		T6VO.printlnmethod(tvo);
		// �� ���Դ��� Ȯ���ϱ�
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		T6VO _tvo=null;
		ArrayList<T6VO> aList=null;
		
		try {
			conn=OracleConnProperty.getConnection();
			String sql=T6QueryMap_A.getT6SelectName();
			pstmt=conn.prepareStatement(sql);
			System.out.println("�̸� ��ȸ >>> \n "+sql);
			
			pstmt.clearParameters();
			pstmt.setString(1,  tvo.getT2());
			rsRs=pstmt.executeQuery();
			
			if(rsRs!=null){
				aList=new ArrayList<T6VO>();
				while(rsRs.next()){
					_tvo=new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));
					aList.add(_tvo);
				}
			}else{
				System.out.println("�̸� ��ȸ ����� �����ϴ�. rsRs >>> : "+rsRs);
			}
			
			
		}catch(Exception e){
			System.out.println("T6DAO_AImpl :: t6SelectName(T6VO tvo) �� error  >>> "+e.getMessage());
		}
		
		if (aList==null){
			System.out.println("T6DAO_AImpl :: t6SelectName(T6VO tvo) :: return�� aList >>> : "+aList);
		}
		
		return aList;
	};
	
	// ��¥ ��ȸ
	@Override
	public ArrayList<T6VO> t6SelectDate(T6VO tvo){
		System.out.println("T6DAO_AImpl :: t6SelectDate(T6VO tvo) ����");
		T6VO.printlnmethod(tvo);
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		ArrayList<T6VO> aList=null;
		T6VO _tvo=null;
		
		try {
			conn=OracleConnProperty.getConnection();
			
			String sql=T6QueryMap_A.getT6SelectDate();
			pstmt=conn.prepareStatement(sql);
			System.out.println("��¥ ��ȸ >>> : \n"+sql);
			
			pstmt.clearParameters();
			pstmt.setString(1, tvo.getFromdate());
			pstmt.setString(2, tvo.getTodate());
			
			rsRs=pstmt.executeQuery();
			
			if(rsRs!=null){
				aList= new ArrayList<T6VO> ();
				while(rsRs.next()){
					_tvo=new T6VO();
					_tvo.setT1(rsRs.getString(1));
					_tvo.setT2(rsRs.getString(2));
					_tvo.setT3(rsRs.getString(3));
					_tvo.setT4(rsRs.getString(4));
					_tvo.setT5(rsRs.getString(5));
					_tvo.setT6(rsRs.getString(6));
					aList.add(_tvo);
				}
			}else{
				System.out.println("��¥ ��ȸ ����� �����ϴ�. rsRs >>> : "+rsRs);
			}
			
		}catch(Exception e){
			System.out.println("T6DAOImpl :: t6SelectDate(T6VO tvo) ��  ������ >>> : "+e.getMessage());
			
		}
		
		if (aList==null){
			System.out.println("T6DAO_AImpl :: t6SelectDate(T6VO tvo) :: return�� aList >>> : "+aList);
		}
		
		return aList;
	}

	
	
	public boolean t6Insert(T6VO tvo){};
	public boolean t6Update(T6VO tvo){};
	public boolean t6Delete(T6VO tvo){};

}
