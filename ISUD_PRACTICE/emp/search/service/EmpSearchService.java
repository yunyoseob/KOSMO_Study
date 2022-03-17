package a.b.c.emp.search.service;

import java.util.ArrayList;

import a.b.c.emp.search.vo.EmpSearchVO;

public interface EmpSearchService {

	// ��ü �˻�
	public ArrayList<EmpSearchVO> empSelectAll();
	// ��� �˻�
	public ArrayList<EmpSearchVO> empSelectEmpno(EmpSearchVO evo);
	
	// �̸� �˻� LIKE
	public ArrayList<EmpSearchVO> empSelectEname(EmpSearchVO evo);
	// ��� �̸� �˻�
	public ArrayList<EmpSearchVO> empSelectEmpnoEname(EmpSearchVO evo);
	// ��å �˻� LIKE 
	public ArrayList<EmpSearchVO> empSelectJob(EmpSearchVO evo);
	// ��¥ �˻�
	public ArrayList<EmpSearchVO> empSelectHiredate(EmpSearchVO evo);
}
