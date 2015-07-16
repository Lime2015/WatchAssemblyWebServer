package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.AssemblymanDao;
import vo.Assemblyman;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Component
public class AssemblymanService {

	private AssemblymanDao dao;

	@Autowired
	public void setDao(AssemblymanDao dao) {
		this.dao = dao;
	}


	// ////////////////////////////////////////////////////////////////
	

	public void selectList(HttpServletResponse response) {
		String result;
		List<Assemblyman> list = dao.selectList();
		Gson gson = new GsonBuilder().create();

		result = gson.toJson(list, new TypeToken<List<Assemblyman>>(){}.getType());

		try {
		    response.setCharacterEncoding("UTF8"); // this line solves the problem
		    response.setContentType("application/json");
			PrintWriter writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
