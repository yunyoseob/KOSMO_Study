package a.b.c.test.dept.dao;

import java.util.List;

import a.b.c.test.dept.vo.DeptVO;

public interface DeptDAO {

	public List<DeptVO> deptSelect(DeptVO dvo);
}
