package a.b.c.com.emp.service;

import java.util.List;

import a.b.c.com.emp.vo.SpringEmpVO;

public interface SpringEmpService {

	public int springEmpInsert(SpringEmpVO evo);
	public List springEmpSelectAll();
	public List springEmpSelect(SpringEmpVO evo);
	public int springEmpUpdate(SpringEmpVO evo);
}
