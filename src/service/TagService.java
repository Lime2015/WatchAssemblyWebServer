package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import mapper.AssemblymanMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import repository.TagDao;
import result.CheckTagResult;
import vo.Assemblyman;

@Component
public class TagService {

	private TagDao dao;

	@Autowired
	public void setDao(TagDao dao) {
		this.dao = dao;
	}

	// ////////////////////////////////////////////////////////////////
	
	public void checkTag(HttpServletResponse response) {
		String result;
		CheckTagResult rs = new CheckTagResult();
		
		rs.setAssemblymanTag(dao.checkAssemblymanTag());
		rs.setBillTag(dao.checkBillTag());
		rs.setCommitteeMeetingTag(dao.checkCommitteeMeetingTag());
		rs.setGeneralMeetingTag(dao.checkGeneralMeetingTag());
		rs.setPartyHistoryTag(dao.checkPartyHistoryTag());
		rs.setVoteTag(dao.checkVoteTag());		
		
		Gson gson = new GsonBuilder().create();

		result = gson.toJson(rs, new TypeToken<CheckTagResult>(){}.getType());

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
