package a.b.c.test.emp.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.test.dept.vo.DeptVO;
import a.b.c.test.emp.service.EmpService;
import a.b.c.test.emp.vo.EmpVO;

@Controller
public class EmpController {
	Logger logger = LogManager.getLogger(EmpController.class);
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private EmpService empService;
	
	@RequestMapping(value="empSelect", method=RequestMethod.GET)
	public String empSelect(EmpVO evo, Model model) {
		logger.info("EmpController empSelect 함수 진입 >>> : ");
		
		// 서비스 호출
		List<EmpVO> listAll = empService.empSelect(evo);		
		if (listAll.size() > 0) { 
			logger.info("EmpController empSelect listAll.size() >>> : " + listAll.size());
			
			for (int i=0; i < listAll.size(); i++) {
				EmpVO _evo = listAll.get(i);
				
				logger.info("_evo.getEmpno() >>> : " + _evo.getEmpno());				
				logger.info("_dvo.getDname() >>> : " + _evo.getDvo().getDname());
			}
			model.addAttribute("listAll", listAll);
			return "test/empSelect";
		}		
		return "test/empSelect";
	}

}
