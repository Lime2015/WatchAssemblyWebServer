package controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.AssemblymanService;
import service.MemberInfoService;
import vo.MemberInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class AssemblymanController {

	private AssemblymanService service;

	@Autowired
	public void setService(AssemblymanService service) {
		this.service = service;
	}

	// //////////////////////////////////////////////////////////////

	// check MemberInfo
	@RequestMapping(value = "requestAssemblyman.do")
	public void requestAssemblyman(HttpServletResponse response) {
		service.selectList(response);
	}
}
