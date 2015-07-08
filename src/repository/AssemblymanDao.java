package repository;


import java.util.List;

import mapper.AssemblymanMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import vo.Assemblyman;

public class AssemblymanDao {
	private SqlSessionTemplate session;

	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	//////////////////////////////////////////////////////
		
	public List<Assemblyman> selectList(){
		AssemblymanMapper mapper = session.getMapper(AssemblymanMapper.class);
		return mapper.selectList();
	}

}
