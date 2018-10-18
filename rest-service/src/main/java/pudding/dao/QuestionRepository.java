package pudding.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pudding.model.Question;

public interface QuestionRepository extends CrudRepository<Question,Integer>{
	 
	List<Question> findByTestNo(int testNo);
	
}
