package a.b.c.emp.search.service;

import java.util.ArrayList;

import a.b.c.emp.search.dao.EmpSearchDAO;
import a.b.c.emp.search.dao.EmpSearchDAOImpl;
import a.b.c.emp.search.vo.EmpSearchVO;

public class EmpSearchServiceImpl implements EmpSearchService {

	// ��ü �˻� 
	// ������̼�
	@Override
	public ArrayList<EmpSearchVO> empSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectAll() �Լ� ���� >>> : ");
		/*
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList = esdao.empSelectAll();		
		return aList;
		*/
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();			
		return esdao.empSelectAll();
	}

	// ��� �˻�
	@Override
	public ArrayList<EmpSearchVO> empSelectEmpno(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectEmpno() �Լ� ���� >>> : ");
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList= esdao.empSelectEmpno(evo);
		
		return aList;
	}

	// �̸� �˻� LIKE
	@Override
	public ArrayList<EmpSearchVO> empSelectEname(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectEname() �Լ� ���� >>> : ");
		System.out.println("EmpSearchServiceImpl.empSelectEname() evo.getEname() >>> : " + evo.getEname());
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList= esdao.empSelectEname(evo);
		
		return aList;
	}

	// ��� �̸� �˻�
	@Override
	public ArrayList<EmpSearchVO> empSelectEmpnoEname(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectEmpnoEname() �Լ� ���� >>> : ");
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList= esdao.empSelectEmpnoEname(evo);
		
		return aList;
	}

	// ��ä �˻� LIKE
	@Override
	public ArrayList<EmpSearchVO> empSelectJob(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectJob() �Լ� ���� >>> : ");
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList= esdao.empSelectJob(evo);
		
		return aList;

	}

	// ��¥ �˻�
	@Override
	public ArrayList<EmpSearchVO> empSelectHiredate(EmpSearchVO evo) {
		// TODO Auto-generated method stub
		System.out.println("EmpSearchServiceImpl.empSelectHiredate() �Լ� ���� >>> : ");
		
		EmpSearchDAO esdao = new EmpSearchDAOImpl();
		ArrayList<EmpSearchVO> aList= esdao.empSelectHiredate(evo);
		
		return aList;

	}
}
