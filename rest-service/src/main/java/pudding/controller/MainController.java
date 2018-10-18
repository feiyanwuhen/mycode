package pudding.controller;

import java.util.List;

import pudding.model.Question;
import pudding.model.TestPaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pudding.dao.QuestionRepository;
import pudding.dao.TestRepository;

@RestController
public class MainController {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	TestRepository testRepository;
	
	@GetMapping("/questionList")
	public Iterable<Question> getAllQuestion(){
		return questionRepository.findAll();
	}
	
	@GetMapping("/questionByTestNo")
	public Iterable<Question> getQuestionByTestNo(@RequestParam("testNum")int testNum){
		return questionRepository.findByTestNo(testNum);
	}
	
	@GetMapping("/testByCategoryId")
	public Iterable<TestPaper> getTestListByCategoryId(@RequestParam("categoryId")int categoryId){
		return testRepository.findByCategoryId(categoryId);
	}
	
	@PostMapping("/submitTest")
	public String test(@RequestParam("answers") String[] userAnswer,@RequestParam("testNum")int testNum) {
		if(userAnswer!=null && userAnswer.length>0){
			List<Question> answers = questionRepository.findByTestNo(testNum);
			if(answers ==null || answers.size() ==0){
				return "试卷不存在";
			}
			int totalCount = answers.size();
			int j=0;
			for(int i=0;i<answers.size();i++){
				if(answers.get(i).getAnswer().equals(userAnswer[i])){
					j++;
				}
			}
			if(j < totalCount/4){return "您答对了"+j + "道题，距离合格还有一大段距离哟";}
			else if(j< totalCount%0.6) {return "您答对了" + j +"道题，再努力一下就合格了";}
			else {return "您答对了" + j + "道题，恭喜您及格了";}
			
		}
		return "你的答案不完整";
	}

//	@GetMapping("/questionPage")
//	public String questionPage(@RequestParam(name="testNum",required=true,defaultValue="1")int testNum,Model model){
//		model.addAttribute("testNum", testNum);
//		return "questionPage";
//	}
}
