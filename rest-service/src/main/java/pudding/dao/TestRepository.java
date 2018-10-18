package pudding.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pudding.model.TestPaper;

public interface TestRepository extends CrudRepository<TestPaper, Integer>{
	List<TestPaper> findByCategoryId(int categoryId);

}
