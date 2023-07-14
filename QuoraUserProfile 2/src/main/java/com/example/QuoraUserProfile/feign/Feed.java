package com.example.QuoraUserProfile.feign;

import com.example.QuoraUserProfile.dto.QuestionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@FeignClient(value="fiegnDemo",url="http://localhost:8093")
public interface Feed {

    @RequestMapping("/post/feedquestion")
    public List<QuestionDto> feedQuestion(@RequestParam("userId") List<String> userId);

}
